package openAPI.TmiBoard.dto.in;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import openAPI.TmiBoard.contract.UserStatus;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "kakaousers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KakaoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_name")
    private String userName;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    /*@OneToOne(mappedBy = "kakaoUser")
    private MyBoard myBoard;
    */

    public void updateStatus(UserStatus status) {
        this.userStatus = status;
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
