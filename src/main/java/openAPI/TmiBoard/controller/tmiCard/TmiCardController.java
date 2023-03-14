package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.out.ResponseDto;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import openAPI.TmiBoard.dto.out.TmiCardRequestBody;
import openAPI.TmiBoard.exception.BaseException;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import openAPI.TmiBoard.service.main.TmiCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static openAPI.TmiBoard.exception.BaseResponseStatus.NO_EXIST_TMICARD;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmicard")
public class TmiCardController {

    private final TmiCardService tmicardService;
    private final KakaoUserRepository kakaoUserRepository;
    private final TmiCardRepository tmiCardRepository;

    //create
    @PostMapping("/create")
    public ResponseDto<TmiCardDto> createTmicard(@RequestBody TmiCardRequestBody requestBody) {
        //jwt랑 같이 넘겨..
        //try {
            KakaoUser user = kakaoUserRepository.findById(requestBody.getUserId());
            TmiCardDto card = tmicardService.createTmicard(requestBody, user);

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
            //KakaoUser user = kakaoUserRepository.findById(userId);
            List<TmiCardDto> searchAll = tmicardService.getCardList(userId);

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

        //해당 user의 해당 card id에 대한것을 변경해야지..
        TmiCard card = tmiCardRepository.findCardByKakaoId(requestBody.getUserId(), cardId);

        TmiCardDto changed = tmicardService.cardUpdate(card, requestBody);

        return changed;
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseDto<TmiCardDto> cardDelete(@PathVariable Long cardId) {
        try {
            Long userId = 1L;//
            TmiCardDto result = tmicardService.cardDelete(cardId, userId);

            return new ResponseDto<>(result);
        } catch (BaseException e) {

            return new ResponseDto<>(NO_EXIST_TMICARD);
        }
    }
}
