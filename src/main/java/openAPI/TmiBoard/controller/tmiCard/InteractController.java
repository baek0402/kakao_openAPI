package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import openAPI.TmiBoard.dto.out.TmiCardInteractDto;
import openAPI.TmiBoard.dto.out.TmiCardLikeDto;
import openAPI.TmiBoard.service.interact.InteractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmicard/interact")
public class InteractController {

    private final InteractService interactService;

    /**
     *  1. 사용자가 하트를 누르면 3개의 상호작용이 나타난다
     *  (이때 상호작용 별 count 데이터를 보내주면 되나? / 혹은 tmicard detail에서 보내줘야하나?)
     *  2. 해당 상호작용을 누르면 카드 아이디, 상호작용 정보를 보낸다
     */
    //우선 count 하는 api 따로 작성해두겠음!
    @GetMapping
    public TmiCardInteractDto viewCount() {
        TmiCardInteractDto result = interactService.getCount();

        return result;
    }


    // .../tmicard/interact?cardId=1&likeStatus=laugh
    @PostMapping
    public ResponseEntity interacting(@RequestBody TmiCardLikeDto tmiCardLikeDto) {
        //1. 해당 tmiCard가 본인것이라면 return

        //2. 아니면 상호작용 추가
        interactService.likeCard(tmiCardLikeDto);

        return ResponseEntity.ok("success");
    }

    @DeleteMapping
    public ResponseEntity delete() {
        TmiCardLikeDto result = interactService.delete();
        return ResponseEntity.ok(result);
    }
}
