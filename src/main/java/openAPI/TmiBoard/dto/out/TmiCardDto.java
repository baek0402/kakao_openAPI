package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import openAPI.TmiBoard.dto.in.TmiCardInteract;

import java.util.List;

@Data
public class TmiCardDto {

    private Long cardId;

    private String cardEmoji;
    private String cardColor;
    private String title;
    private String comments;

    private int greatCount;
    private int clapCount;
    private int heartCount;

    private List<String> hashTagList;

    private String selectedInteract;

    @Builder
    public TmiCardDto(Long cardId, String cardEmoji, String cardColor, String title, String comments, String selectedInteract) {
        this.cardId = cardId;
        this.cardEmoji = cardEmoji;
        this.cardColor = cardColor;
        this.title = title;
        this.comments = comments;
        this.selectedInteract = selectedInteract;
    }
}
