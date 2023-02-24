package openAPI.TmiBoard.service.kakao;

import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.KakaoOauth;

public interface KakaoService {

    KakaoOauth getUserToken(String code);
    KakaoUser getUserInfo(String accessToken);
}
