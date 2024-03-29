package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Getter;
import openAPI.TmiBoard.contract.BirthStatus;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.contract.UserStatus;

@Getter
public class KakaoUserDto {

    private Long userId;
    private String userEmail;
    private String userName;
    private UserStatus userStatus;
    private MyboardStatus myboardStatus;

    @Builder
    public KakaoUserDto(Long userId, String userEmail, String userName, UserStatus userStatus, MyboardStatus myboardStatus) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userStatus = userStatus;
        this.myboardStatus = myboardStatus;
    }
}
