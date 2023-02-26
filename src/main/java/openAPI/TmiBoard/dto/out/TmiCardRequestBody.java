package openAPI.TmiBoard.dto.out;

import lombok.Getter;

@Getter
public class TmiCardRequestBody {

    private String cardEmoji;
    private String cardColor;

    private String title;
    private String comments;
    private String hashTag;
}
