package openAPI.TmiBoard.service.kakao;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoLoginService {

    private final AuthenticationManager authenticationManager;

    public void forceLogin(KakaoUser kakaoUser) {
        String email = kakaoUser.getUserEmail();
        String password = kakaoUser.getUserId().toString();

        Authentication authToken = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(authToken);
    }
}
