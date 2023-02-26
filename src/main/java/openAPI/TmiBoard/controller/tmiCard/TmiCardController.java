package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import openAPI.TmiBoard.dto.out.TmiCardRequestBody;
import openAPI.TmiBoard.repository.kakao.KakaoCustomRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.service.main.TmiCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TmiCardController {

    private final TmiCardService tmicardService;

    //create
    @PostMapping("/create/tmicard")
    public ResponseEntity CreateTmicard(@RequestBody TmiCardRequestBody requestBody) {
        //jwt랑 같이 넘겨..
        //KakaoUser name = kakaoCustomRepository.findByUserName("백연정");
        TmiCardDto card = tmicardService.createTmicard(requestBody, 1L);

        return ResponseEntity.ok(card);
    }

    //list all
    @GetMapping("/tmiCardList")
    public List<TmiCardDto> CardList() {
        //jwt를 통한 유저 id
        List<TmiCardDto> search = tmicardService.getCardList(1L);

        if(search.isEmpty())
            search = new ArrayList<>();

        return search;
    }

    //view detail

}
