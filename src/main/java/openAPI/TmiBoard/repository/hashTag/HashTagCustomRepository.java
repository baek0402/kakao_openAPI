package openAPI.TmiBoard.repository.hashTag;

import openAPI.TmiBoard.dto.in.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagCustomRepository extends JpaRepository<HashTag, Long> {
}
