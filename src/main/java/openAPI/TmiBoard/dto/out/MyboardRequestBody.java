package openAPI.TmiBoard.dto.out;

import lombok.Getter;
import openAPI.TmiBoard.contract.BirthStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;

@Getter
public class MyboardRequestBody {

    //아래 어노테이션이 왜 하나도 적용이 안되지?

    // jwt user (kakao user id)
    @NotNull(message = "유저 아이디가 없습니다.")
    private Long userId;

    //setting
    @NotBlank(message = "이모지를 선택하세요.")
    private String emoji;
    @NotNull(message = "공개여부를 선택하세요.")
    private BirthStatus birthStatus;

    //inform
    @NotBlank(message = "이름을 입력하세요.")
    private String name;
    private String mbti;
    @NotBlank(message = "생일을 입력하세요.")
    private String birth;
    private String myboardComments;
    private String url1;
    private String url1Type;
    private String url2;
    private String url2Type;
    private String url3;
    private String url3Type;

    @ConstructorProperties({
            "userId", "emoji", "birthStatus", "name", "mbti",
            "birth", "myboardComments", "url1", "url1Type",
            "url2", "url2Type", "url3", "url3Type"
    })
    public MyboardRequestBody(Long userId, String emoji, BirthStatus birthStatus, String name, String mbti, String birth, String myboardComments, String url1, String url1Type, String url2, String url2Type, String url3, String url3Type) {
        this.userId = userId;
        this.emoji = emoji;
        this.birthStatus = birthStatus;
        this.name = name;
        this.mbti = mbti;
        this.birth = birth;
        this.myboardComments = myboardComments;
        this.url1 = url1;
        this.url1Type = url1Type;
        this.url2 = url2;
        this.url2Type = url2Type;
        this.url3 = url3;
        this.url3Type = url3Type;
    }
}
