package openAPI.TmiBoard.repository.tmiCard;

import openAPI.TmiBoard.dto.in.TmiCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TmiCardRepository extends JpaRepository<TmiCard, Long>, TmiCardCustomRepository {

}
