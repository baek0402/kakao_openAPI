package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import openAPI.TmiBoard.dto.out.ResponseDto;
import openAPI.TmiBoard.dto.out.TmiCardInteractDto;
import openAPI.TmiBoard.dto.out.TmiCardLikeDto;
import openAPI.TmiBoard.repository.tmiCard.TmiCardCustomRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import openAPI.TmiBoard.service.interact.InteractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static openAPI.TmiBoard.exception.BaseResponseStatus.SUCCESS;
import static openAPI.TmiBoard.exception.BaseResponseStatus.SUCCESS_BUT_EMPTY;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/tmicard/interact")
public class InteractController {

    private final InteractService interactService;
    private final TmiCardCustomRepository tmiCardRepository;
    /**
     *  1. 사용자가 하트를 누르면 3개의 상호작용이 나타난다
     *  (이때 상호작용 별 count 데이터를 보내주면 되나? / 혹은 tmicard detail에서 보내줘야하나?)
     *  2. 해당 상호작용을 누르면 카드 아이디, 상호작용 정보를 보낸다
     */
    //우선 count 하는 api 따로 작성해두겠음!
    @GetMapping("/tmicard/interact/{cardId}")
    public TmiCardInteractDto viewCount(@PathVariable Long cardId) {

        //카드 id에 대한 viewCount
        TmiCardInteractDto result = interactService.getCount(cardId);

        return result;
    }


    // .../tmicard/interact?cardId=1&likeStatus=laugh
    @PostMapping("/tmicard/interact")
    public ResponseDto<Void> interacting(@RequestBody TmiCardLikeDto tmiCardLikeDto) {

        //1. 해당 tmiCard가 본인것이라면 return
        TmiCard card = tmiCardRepository.findByCardId(tmiCardLikeDto.getCardId());

        if(card.getKakaoUser().getUserId().equals(tmiCardLikeDto.getUserId())) {
            return new ResponseDto<>(SUCCESS_BUT_EMPTY);
            //이렇게 성공을 return 해도되려나..?
        }

       //2. 아니면 상호작용 추가
       String msg = interactService.likeCard(tmiCardLikeDto);

       return new ResponseDto<>(SUCCESS, msg);
    }

    @DeleteMapping
    public ResponseDto<Void> delete(@RequestParam Long userId,
                                 @RequestParam Long cardId) {
        String result = interactService.delete(userId, cardId);
        return new ResponseDto<>(SUCCESS, result);
    }
}
