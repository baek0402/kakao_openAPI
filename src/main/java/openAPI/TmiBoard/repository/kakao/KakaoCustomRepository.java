package openAPI.TmiBoard.repository.kakao;

import openAPI.TmiBoard.dto.in.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoCustomRepository extends JpaRepository<KakaoUser, Long> {

}
