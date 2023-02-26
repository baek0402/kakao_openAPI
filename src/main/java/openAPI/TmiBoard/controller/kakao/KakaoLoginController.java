package openAPI.TmiBoard.controller.kakao;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import openAPI.TmiBoard.security.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import openAPI.TmiBoard.service.kakao.KakaoUserService;

@RestController
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoUserService kakaoUserService;
    private final JwtService jwtService;

    @GetMapping("/users/login/kakao")
    public KakaoUserDto kakaoLogin(@RequestParam String code) {

        //여기까지 OAuth을 통해 토큰, 유저정보 및 회원가입(DB저장) 진행
        KakaoUserDto user = kakaoUserService.login(code);

        //JWT (로그인)
        String jwt = jwtService.createJwt(user);

        /**
         * // 생성된 id pw 기반으로 Provider에게 Authentication 객체를 넘겨주며 인증 요청
         * Jwt + Spring Security
         * Authentication authToken = new UsernamePasswordAuthenticationToken(email, password);
         * return authenticationManager.authenticate(authToken);
         */

        return user;
    }
}
