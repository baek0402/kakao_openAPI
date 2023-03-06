package openAPI.TmiBoard.repository.myboard;

import openAPI.TmiBoard.dto.in.Myboard;

public interface MyboardRepository {

    void save(Myboard myboard);
    Myboard findByKakaoId(Long userId);

    Myboard updateMyboard(Myboard myboard, Myboard newBoard);


}
