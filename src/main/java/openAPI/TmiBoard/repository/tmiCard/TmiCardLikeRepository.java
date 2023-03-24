package openAPI.TmiBoard.repository.tmiCard;

import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TmiCardLikeRepository {

    void save(TmiCardLike tmiCardLike);
    void delete(TmiCardLike tmiCardLike);
    TmiCardInteract countInteract(Long cardId);
    Optional<TmiCardLike> findByUserAndCard(Long userId, Long cardId);
    List<TmiCardLike> findLikeList(Long cardId);
    void deleteAll(List<TmiCardLike> resultList);
}
