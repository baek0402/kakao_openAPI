package openAPI.TmiBoard.dto.out;

import lombok.Getter;
import openAPI.TmiBoard.contract.BirthStatus;

import java.beans.ConstructorProperties;

@Getter
public class MyboardRequestBody {

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
