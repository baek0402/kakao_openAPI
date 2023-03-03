package openAPI.TmiBoard.repository.myboard;

import openAPI.TmiBoard.dto.in.Myboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyboardCustomRepository extends JpaRepository<Myboard, Long> {

}
