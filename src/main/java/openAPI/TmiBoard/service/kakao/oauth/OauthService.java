package openAPI.TmiBoard.service.kakao.oauth;

import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.KakaoOauth;

public interface OauthService {

    KakaoOauth getUserToken(String code);
    KakaoUser getUserInfo(String accessToken);
}
