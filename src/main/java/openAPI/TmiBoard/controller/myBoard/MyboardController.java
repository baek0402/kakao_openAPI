package openAPI.TmiBoard.controller.myBoard;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.out.MyboardDto;
import openAPI.TmiBoard.dto.out.MyboardRequestBody;
import openAPI.TmiBoard.service.main.MyboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyboardController {

    private final MyboardService myboardService;

    @GetMapping("/myboard")
    public MyboardDto myboardView() {
        Long userId = 1L;//jwt를 통한 userId
        MyboardDto myboard = myboardService.getMyboard(userId);

        return myboard;
    }
    @PostMapping("/create/myboard")
    public ResponseEntity CreaetMyboard(@RequestBody MyboardRequestBody myboardRequestBody) {
        //jwt 유효성 검증을하고
        //(jwt포함되어있는)유저아이디를 가지고오고
        //myboard랑 이 유저아이디랑 같이 저장하면?

        MyboardDto resultDto = myboardService.createMyboard(myboardRequestBody);
        //일단 카카오아이디를 던져줘야할거같긴한데.. board_id는 null
        return ResponseEntity.ok(resultDto);
    }
}
