package openAPI.TmiBoard.controller.kakao;

import com.fasterxml.jackson.core.JsonParser;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.dto.out.AccessTokenDto;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import openAPI.TmiBoard.dto.out.ResponseDto;
import openAPI.TmiBoard.dto.out.ResultDto;
import openAPI.TmiBoard.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import openAPI.TmiBoard.service.kakao.KakaoUserService;

@RestController
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoUserService kakaoUserService;
    private final JwtService jwtService;

    //@GetMapping("/users/login/kakao")
    @PostMapping("/users/kakao")
    public ResponseDto<ResultDto> KakaoLogin(@RequestParam String token) {
//        System.out.println("카카오로그인" +  accessTokenDto.getToken());
//        //여기까지 OAuth을 통해 토큰, 유저정보 및 회원가입(DB저장) 진행
//        String code = accessTokenDto.getToken();
        KakaoUserDto user = kakaoUserService.login(token);

        //JWT (로그인)
        String jwt = jwtService.createJwt(user);

        /**
         * // 생성된 id pw 기반으로 Provider에게 Authentication 객체를 넘겨주며 인증 요청
         * Jwt + Spring Security
         * Authentication authToken = new UsernamePasswordAuthenticationToken(email, password);
         * return authenticationManager.authenticate(authToken);
         */

        ResultDto resultObject = new ResultDto(jwt, user.getUserId(), user.getUserName(), user.getMyboardStatus());
        //ResponseDto<ResultDto> responseDTO =
        //responseDTO.setResult(resultObject);

        return new ResponseDto<>(resultObject);

    }
}
