package openAPI.TmiBoard.repository.kakao;

import openAPI.TmiBoard.dto.in.KakaoUser;

public interface KakaoCustomRepository {

    KakaoUser findByEmail(String userEmail);
    KakaoUser findByUserName(String userName);
}
