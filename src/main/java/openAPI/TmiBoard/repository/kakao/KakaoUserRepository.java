package openAPI.TmiBoard.repository.kakao;

import openAPI.TmiBoard.dto.in.KakaoUser;

public interface KakaoUserRepository {

    void save(KakaoUser kakaoUser);
    KakaoUser findById(Long userId);
    KakaoUser findByEmail(String userEmail);
    KakaoUser findByUserName(String userName);
}
