package openAPI.TmiBoard.service.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import openAPI.TmiBoard.contract.UserStatus;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoCreateService {

    private final KakaoUserRepository kakaoUserRepository;

    public KakaoUser createKakaoUser(KakaoUser userInfo) {
        Optional<KakaoUser> user = Optional.ofNullable(kakaoUserRepository.findByEmail(userInfo.getUserEmail()));
        userInfo.updateStatus(UserStatus.JOIN);

        if(user.isEmpty()) {
            kakaoUserRepository.save(userInfo);
        }

        return userInfo;
    }
}
