package openAPI.TmiBoard.repository.tmiCard;

import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;

import java.util.Optional;

public interface TmiCardLikeCustomRepository {

    TmiCardInteract countInteract(Long cardId);

    Optional<TmiCardLike> findByUserAndCard(Long userId, Long cardId);
}
