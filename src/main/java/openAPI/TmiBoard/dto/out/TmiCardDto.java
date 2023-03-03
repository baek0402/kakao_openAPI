package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class TmiCardDto {

    private Long cardId;

    private String cardEmoji;
    private String cardColor;
    private String title;
    private String comments;
    private String hashTag;

    @Builder
    public TmiCardDto(Long cardId, String cardEmoji, String cardColor, String title, String comments, String hashTag) {
        this.cardId = cardId;
        this.cardEmoji = cardEmoji;
        this.cardColor = cardColor;
        this.title = title;
        this.comments = comments;
        this.hashTag = hashTag;
    }
}
