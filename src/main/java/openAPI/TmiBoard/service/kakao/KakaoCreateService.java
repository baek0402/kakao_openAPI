package openAPI.TmiBoard.service.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.contract.UserStatus;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.repository.kakao.KakaoCustomRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoCreateService {

    private final KakaoUserRepository kakaoUserRepository;

    public KakaoUser createKakaoUser(KakaoUser userInfo) {
        KakaoUser user = kakaoUserRepository.findById(userInfo.getUserId());
        userInfo.updateStatus(UserStatus.JOIN);

        if(user == null) {
            kakaoUserRepository.save(userInfo);

            return userInfo;
        }
        else return user;
    }
}
