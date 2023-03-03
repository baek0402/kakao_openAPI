package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Getter;
import openAPI.TmiBoard.contract.BirthStatus;

@Getter
public class MyboardDto {

    //1
    private String name;
    private String mbti;
    private String birth;
    private String myboardComments;
    private String emoji;
    private BirthStatus birthStatus;

    //2
    private String url1;
    private String url2;
    private String url3;

    @Builder
    public MyboardDto(String name, String mbti, String birth, String myboardComments, String emoji, BirthStatus birthStatus, String url1, String url2, String url3) {
        this.name = name;
        this.mbti = mbti;
        this.birth = birth;
        this.myboardComments = myboardComments;
        this.emoji = emoji;
        this.birthStatus = birthStatus;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
    }
}
