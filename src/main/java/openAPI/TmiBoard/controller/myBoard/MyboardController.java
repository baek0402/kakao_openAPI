package openAPI.TmiBoard.controller.myBoard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import openAPI.TmiBoard.dto.out.MyboardRequestBody;
import openAPI.TmiBoard.repository.kakao.KakaoCustomRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepositoryImpl;
import openAPI.TmiBoard.repository.myboard.MyboardRepository;
import openAPI.TmiBoard.security.JwtService;
import openAPI.TmiBoard.service.main.MyboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MyboardController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MyboardService myboardService;
    private final JwtService jwtService;
    private final KakaoUserRepository kakaoUserRepository;
    private final MyboardRepository myboardRepository;


    @PostMapping("/create/myboard")
    public ResponseEntity creaetMyboard(@RequestBody MyboardRequestBody myboardRequestBody) {//jwt 유효성 검증을하고
       /*
        try{
            // 로그인 유저의 접근인지 확인
            Long userIdxByJwt = jwtService.getUserIdx();
            if (myboardRequestBody.getUserId() != userIdxByJwt) {
                return ResponseEntity.ok("not invalid user");
            }

            //궁금점 : 여기서의 userIdxByJwt는 jwt내에서 생성된 userId인가효..? encoding을 통해 찾아낸 kakao user Id 인가요..?
            Optional<KakaoUser> user = repository.findById(myboardRequestBody.getUserId());
            MyboardDto resultDto = myboardService.createMyboard(myboardRequestBody, user.get());

            return ResponseEntity.ok(resultDto);
        } catch (BaseException exception) {
            logger.warn("#37. " + exception.getStatus().getMessage());

            return ResponseEntity.ok(exception.getStatus());
        }
       */

        //1. 프론트에서 던져준 json data 안에 있는 userId와 jwt로 받아온 userId를 비교하기
        //2. 로그인 유저의 접근이 확인이 되면, 해당 카카오 유저 정보를 db에서 가져오기
        KakaoUser user = kakaoUserRepository.findById(myboardRequestBody.getUserId());
        MyboardDto resultDto = myboardService.createMyboard(myboardRequestBody, user);
        //여기서 이제 위에 찾은 kakaoUser(user.get()) 을 같이 던져주면 됩니다 ~!

        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/myboard")
    public MyboardDto myboardView() {
        Long userId = 2653788098L;//jwt를 통한 userId
        MyboardDto myboard = myboardService.getMyboard(userId);

        return myboard;
    }

    @PutMapping("/myboard")
    public MyboardDto myboardUpdate(@RequestBody MyboardRequestBody myboardRequestBody) {
        //수정하려는 kakaoUser의 myboard를 가져와서 해당 내용을 새로운 정보로 바꾸기

        MyboardDto myboard = myboardService.updateMyboard(myboardRequestBody);

        return myboard;
    }

}
