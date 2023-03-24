package openAPI.TmiBoard.repository.tmiCard;

import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TmiCardLikeCustomRepository extends JpaRepository<TmiCardLike, Long> {

}
