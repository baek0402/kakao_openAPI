package openAPI.TmiBoard.service.kakao;

import lombok.RequiredArgsConstructor;

import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import openAPI.TmiBoard.dto.in.KakaoUser;
import org.springframework.stereotype.Service;
import openAPI.TmiBoard.dto.in.KakaoOauth;
import openAPI.TmiBoard.service.kakao.oauth.KakaoOauthService;

@Service
@RequiredArgsConstructor
public class KakaoUserService {

    private final KakaoOauthService kakaoOauthService;
    private final KakaoCreateService kakaoCreateService;

    public KakaoUserDto login(String code) {
        MyboardStatus boardStatus = null;

        //1. 사용자 token 가져오기 (accessToken, refreshToken, expiredTime)
        KakaoOauth oauth = kakaoOauthService.getUserToken(code);


        //2. token을 통해 사용자 정보 가져오기 (id, email, name)
        KakaoUser userInfo = kakaoOauthService.getUserInfo(oauth.getAccessToken());

        //3. 사용자 회원가입 (가입여부 확인)
        userInfo = kakaoCreateService.createKakaoUser(userInfo);


        return KakaoUserDto.builder()
                .userId(userInfo.getUserId())
                .userName(userInfo.getUserName())
                .userEmail(userInfo.getUserEmail())
                .userStatus(userInfo.getUserStatus())
                .myboardStatus(userInfo.getMyboardStatus())
                .build();
    }
}
