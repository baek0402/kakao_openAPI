package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Getter;
import openAPI.TmiBoard.contract.BirthStatus;
import openAPI.TmiBoard.contract.MyboardStatus;

@Getter
public class MyboardDto {

    private Long boardId;
    private Long userId;
    //1
    private String name;
    private String mbti;
    private String birth;
    private String myboardComments;
    private String emoji;
    private BirthStatus birthStatus;

    //2
    private String url1;
    private String url1Type;
    private String url2;
    private String url2Type;
    private String url3;
    private String url3Type;
    private MyboardStatus myboardStatus;

    public String setBirthRule(String birth) {
        String year = birth.substring(0, 2);
        String month = birth.substring(2, 4);
        String day = birth.substring(4, 6);

        this.birth = year + "." + month + "." + day;
        return birth;
    }

    @Builder
    public MyboardDto(Long boardId, Long userId, String name, String mbti, String birth, String myboardComments, String emoji, BirthStatus birthStatus, String url1, String url1Type, String url2, String url2Type, String url3, String url3Type, MyboardStatus myboardStatus) {
        this.boardId = boardId;
        this.userId = userId;
        this.name = name;
        this.mbti = mbti;
        this.birth = birth;
        this.myboardComments = myboardComments;
        this.emoji = emoji;
        this.birthStatus = birthStatus;
        this.url1 = url1;
        this.url1Type = url1Type;
        this.url2 = url2;
        this.url2Type = url2Type;
        this.url3 = url3;
        this.url3Type = url3Type;
        this.myboardStatus = myboardStatus;
    }
}
