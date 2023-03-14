package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Data;
import openAPI.TmiBoard.contract.MyboardStatus;

@Data
public class ResultDto {

    private String jwt;
    private Long userId;
    private String userName;
    private MyboardStatus myboardStatus;

    @Builder
    public ResultDto(String jwt, Long userId, String userName, MyboardStatus myboardStatus) {
        this.jwt = jwt;
        this.userId = userId;
        this.userName = userName;
        this.myboardStatus = myboardStatus;
    }
}
