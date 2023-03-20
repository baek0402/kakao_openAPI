package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.*;
import openAPI.TmiBoard.dto.out.ResponseDto;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import openAPI.TmiBoard.dto.out.TmiCardInteractDto;
import openAPI.TmiBoard.dto.out.TmiCardRequestBody;
import openAPI.TmiBoard.exception.BaseException;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardLikeRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import openAPI.TmiBoard.security.JwtService;
import openAPI.TmiBoard.service.interact.InteractService;
import openAPI.TmiBoard.service.main.HashTagService;
import openAPI.TmiBoard.service.main.TmiCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static openAPI.TmiBoard.exception.BaseResponseStatus.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tmicard")
public class TmiCardController {

    private final JwtService jwtService;
    private final TmiCardService tmicardService;
    private final HashTagService hashTagService;
    private final InteractService interactService;
    private final KakaoUserRepository kakaoUserRepository;
    private final TmiCardRepository tmiCardRepository;
    private final TmiCardLikeRepository tmiCardLikeRepository;

    //create
    @PostMapping("/create")
    public ResponseDto<TmiCardDto> createTmicard(@RequestBody TmiCardRequestBody requestBody) {
        //jwt랑 같이 넘겨..
        //try {
            KakaoUser user = kakaoUserRepository.findById(requestBody.getUserId());

            //1. tmi카드 저장
            TmiCardDto card = tmicardService.createTmicard(requestBody, user);

            //2. 해쉬태그 리스트 저장
            List<String> hashTagList = requestBody.getHashTagList();
            Long cardId = card.getCardId();

            String message = hashTagService.saveList(cardId, hashTagList, requestBody.getUserId());

            return new ResponseDto<>(card);
        //} catch (BaseException e) {

        //    return new ResponseDto<>()
        //}
    }

    //list all
    @GetMapping("/list/{userId}")
    public ResponseDto<List<TmiCardDto>> cardList(@PathVariable Long userId) {
        try {
            //jwt를 통한 유저 id
            Long userIdxByJwt = jwtService.getUserIdx();
            /*
            if(!userIdxByJwt.equals(userId) {
                return new ResponseDto<>(INVALID_JWT);
            }
            */


            List<TmiCardDto> searchAll = tmicardService.getCardList(userId);
            System.out.println(searchAll);

            //hashTagList 테이블에서 cardId에 해당하는 해시태그 데이터만 추출하는 과정
            searchAll.stream().forEach(dto -> {
                List<HashTag> result = hashTagService.getHashTagList(dto.getCardId(), userId);
                List<String> resultList = result.stream()
                        .map(HashTag::getHashTagData)
                        .collect(Collectors.toList());
                dto.setHashTagList(resultList);
            });

            //해당되는 트미보드 별로 상호작용 수 불러오기
            searchAll = searchAll.stream()
                    .map(card -> {
                        card.setGreatCount(tmiCardLikeRepository.countInteract(card.getCardId()).getCount_great());
                        card.setHeartCount(tmiCardLikeRepository.countInteract(card.getCardId()).getCount_heart());
                        card.setClapCount(tmiCardLikeRepository.countInteract(card.getCardId()).getCount_clap());
                    return card; })
                    .collect(Collectors.toList());

            if(!userIdxByJwt.equals(userId)) //로그인한 유저가 본인이 아닐 경우!
            {
                searchAll.stream().forEach(dto -> {
                    if(tmiCardLikeRepository.findByUserAndCard(userIdxByJwt, dto.getCardId()).isPresent()) {
                        String result = (tmiCardLikeRepository.findByUserAndCard(userIdxByJwt, dto.getCardId())).get().getLikeStatus().toString();
                        dto.setSelectedInteract(result);
                    }
                    else {
                        dto.setSelectedInteract("N");
                    }
                });


            }
            else {
                searchAll = searchAll.stream()
                        .map(card -> {card.setSelectedInteract("N");
                            return card; })
                        .collect(Collectors.toList());
            }


                return new ResponseDto<>(searchAll);
        } catch (BaseException e) {
            return new ResponseDto<>(NO_EXIST_TMICARD);
        }
    }

    //view detail
    @GetMapping("/view/{cardId}")
    public ResponseDto<TmiCardDto> cardDetail(@PathVariable Long cardId) {
        try {
            //jwt를 통한 userId와 해당 user의 해당 tmicard number을 조회

            TmiCardDto search = tmicardService.getCardDetail(cardId);

            return new ResponseDto<>(search);
        } catch (BaseException e) {
            return new ResponseDto<>(NO_EXIST_TMICARD);
        }
    }

    @PutMapping("/update/{cardId}")
    public TmiCardDto cardUpdate(@PathVariable Long cardId,
                                @RequestBody TmiCardRequestBody requestBody) {

        //1. 해시태그 수정 (해당 카드에 대한 해시태그 전체 삭제 후 다시 전체 넣기)
        hashTagService.hashTagDelete(cardId, requestBody.getUserId());
        //생성
        List<String> hashTagList = requestBody.getHashTagList();
        String message = hashTagService.saveList(cardId, hashTagList, requestBody.getUserId());

        //2. 트미카드 수정
        TmiCard originCard = tmiCardRepository.findCardByKakaoId(requestBody.getUserId(), cardId);

        TmiCardDto changed = tmicardService.cardUpdate(originCard, requestBody);

        return changed ;
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseDto<TmiCardDto> cardDelete(@PathVariable Long cardId,
                                              @RequestParam Long userId) {
        try {
            // 1. 해시태그 삭제
            hashTagService.hashTagDelete(cardId, userId);

            // 2. 카드 삭제
            tmicardService.cardDelete(cardId, userId);

            return new ResponseDto<>(SUCCESS);

        } catch (BaseException e) {

            return new ResponseDto<>(NO_EXIST_TMICARD);
        }
    }
}
