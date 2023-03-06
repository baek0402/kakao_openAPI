package openAPI.TmiBoard.repository.tmiCard;

import openAPI.TmiBoard.dto.in.TmiCard;

import java.util.List;

public interface TmiCardCustomRepository {

    List<TmiCard> findByUserId(Long userId);
    TmiCard findByCardId(Long cardId);
    TmiCard findByKakaoId(Long userId);
    TmiCard findCardByKakaoId(Long userId, Long cardId);
}
