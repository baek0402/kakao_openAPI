package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Getter;
import openAPI.TmiBoard.contract.Interact;

import java.beans.ConstructorProperties;

@Getter
public class TmiCardLikeDto {

    private Long userId; //kakaoId
    private Long cardId;
    private Interact likeStatus;

    @ConstructorProperties({"userId", "cardId", "likeStatus"})
    @Builder
    public TmiCardLikeDto(Long userId, Long cardId, Interact likeStatus) {
        this.userId = userId;
        this.cardId = cardId;
        this.likeStatus = likeStatus;
    }
}
