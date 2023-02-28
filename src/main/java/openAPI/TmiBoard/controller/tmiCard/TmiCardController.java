package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import openAPI.TmiBoard.dto.out.TmiCardRequestBody;
import openAPI.TmiBoard.repository.kakao.KakaoCustomRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.service.main.TmiCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TmiCardController {

    private final TmiCardService tmicardService;

    //create
    @PostMapping("/create/tmicard")
    public ResponseEntity createTmicard(@RequestBody TmiCardRequestBody requestBody) {
        //jwt랑 같이 넘겨..
        //KakaoUser name = kakaoCustomRepository.findByUserName("백연정");
        TmiCardDto card = tmicardService.createTmicard(requestBody);

        return ResponseEntity.ok(card);
    }

    //list all
    @GetMapping("/tmiCardList")
    public List<TmiCardDto> cardList() {
        //jwt를 통한 유저 id
        List<TmiCardDto> searchAll = tmicardService.getCardList(1L);

        if(searchAll.isEmpty())
            searchAll = new ArrayList<>();

        return searchAll;
    }

    //view detail
    @GetMapping("/view/tmicard/{cardId}")
    public TmiCardDto cardDetail(@PathVariable Long cardId) {
        //jwt를 통한 userId와 해당 user의 해당 tmicard number을 조회

        TmiCardDto search = tmicardService.getCardDetail(cardId);

        return search;
    }

    //view random hashTag
}
