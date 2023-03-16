package openAPI.TmiBoard.controller.tmiCard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.HashTag;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.out.HashTagListBody;
import openAPI.TmiBoard.dto.out.ResponseDto;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.service.main.HashTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hashTag")
public class HashTagController {

    //view random hashTag
    // 한 트미카드에 있는 해시태그 '#ㅇㅇㅇ #ㅇㅇㅇ ...'를 프론트 측에서 리스트 형태로 보내온다
    //1. 리스트 형태로 날아온 데이터와 해당 카카오 유저와 매핑하여 저장하기
    //2. 프론트에서 요청하면 해당 데이터베이스에서 랜덤 값 5개 골라서 보내주기

    private final HashTagService hashTagService;

    @PostMapping//random 5 hash tag
    public ResponseDto<List<String>> randomHashTag(@RequestParam Long userId) {
        List<String> randomHashList = hashTagService.getRandomList(userId);

        return new ResponseDto<>(randomHashList);
    }
}
