package openAPI.TmiBoard.dto.in;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.contract.UserStatus;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "kakaousers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KakaoUser {

    @Id
    @Column(name = "kakao_id")
    private Long userId;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_name")
    private String userName;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @OneToOne(mappedBy = "kakaoUser")
    private Myboard myBoard;

    public void changeMyboard(Myboard myboard) {
        this.myBoard = myboard;
    }

    public void updateStatus(UserStatus status) {
        this.userStatus = status;
    }

    public MyboardStatus getMyboardStatus() {
        if(myBoard == null)
            return MyboardStatus.N;
        else
            return myBoard.getMyboardStatus();
    }

    @Builder
    public KakaoUser(Long userId, String userEmail, String userName, UserStatus userStatus) {//}, String role) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userStatus = userStatus;
        //this.role = role;
    }
}
