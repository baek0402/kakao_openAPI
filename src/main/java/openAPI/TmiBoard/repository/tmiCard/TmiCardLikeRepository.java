package openAPI.TmiBoard.repository.tmiCard;

import openAPI.TmiBoard.dto.in.TmiCardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmiCardLikeRepository extends JpaRepository<TmiCardLike, Long>, TmiCardLikeCustomRepository {
}
