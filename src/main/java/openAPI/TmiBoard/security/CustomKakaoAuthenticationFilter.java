package openAPI.TmiBoard.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.service.kakao.oauth.KakaoOauthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@RequiredArgsConstructor
public class CustomKakaoAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final KakaoOauthService kakaoOauthService;
    private final KakaoUserRepository kakaoUserRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String authorizedCode = request.getParameter("code");
        KakaoUser userInfo = null;
        //try {
            userInfo = kakaoOauthService.getUserInfo(authorizedCode);
        //} catch (JsonProcessingException e) {
        //    throw new RuntimeException(e);
        //}
        Long oid = userInfo.getUserId();
        String email = userInfo.getUserEmail();
        String password = oid.toString();

        KakaoUser kakaoAccount = kakaoUserRepository.findByEmail(email);//.orElse(null);

        // 생성된 id pw 기반으로 Provider에게 Authentication 객체를 넘겨주며 인증 요청
        Authentication authToken = new UsernamePasswordAuthenticationToken(email, password);
        return authenticationManager.authenticate(authToken);
    }
}
