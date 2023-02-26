package openAPI.TmiBoard.repository.myboard;

import openAPI.TmiBoard.dto.in.Myboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyboaradRepository extends JpaRepository<Myboard, Long> {

    Optional<Myboard> findById(Long id);
}
