package openAPI.TmiBoard.dto.out;

import lombok.Getter;

import java.util.List;

@Getter
public class TmiCardRequestBody {

    private Long userId;
    private String cardEmoji;
    private String cardColor;

    private String title;
    private String comments;
    private List<String> hashTagList;
}
