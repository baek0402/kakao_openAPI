package openAPI.TmiBoard.dto.out;

import lombok.Data;
import lombok.Getter;
import openAPI.TmiBoard.contract.BirthStatus;

import java.beans.ConstructorProperties;

@Data
public class MyboardRequestBody {

    // jwt user (kakao user id)
    private Long userId;

    //setting
    private String emoji;
    private BirthStatus birthStatus;

    //inform
    private String name;
    private String mbti;
    private String birth;
    private String myboardComments;
    private String url1;
    private String url2;
    private String url3;
}
