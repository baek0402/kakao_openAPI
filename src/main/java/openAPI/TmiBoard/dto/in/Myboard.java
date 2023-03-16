package openAPI.TmiBoard.dto.in;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import openAPI.TmiBoard.contract.BirthStatus;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;

import javax.persistence.*;

@Entity
@Data
@Table(name = "myboard")
@NoArgsConstructor
public class Myboard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myboard_id")
    private Long myboardId;

    @Column(name = "myboard_emoji")
    private String emoji;
    @Column(name = "myboard_name")
    private String name;
    @Column(name = "myboard_birth")
    private String birth;
    @Enumerated(EnumType.STRING)
    @Column(name = "birth_status")
    private BirthStatus birthStatus;
    @Column(name = "myboard_mbti")
    private String mbti;
    @Column(name = "myboard_comments")
    private String myboardComments;

    @Column(name = "myboard_url1")
    private String url1;
    @Column(name = "myboard_ur1_type")
    private String url1Type;
    @Column(name = "myboard_url2")
    private String url2;
    @Column(name = "myboard_ur2_type")
    private String url2Type;
    @Column(name = "myboard_url3")
    private String url3;
    @Column(name = "myboard_ur3_type")
    private String url3Type;

    @Enumerated(EnumType.STRING)
    @Column(name = "myboard_status")
    private MyboardStatus myboardStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kakao_id")
    private KakaoUser kakaoUser;
    public void setKakaoUser(KakaoUser kakaoUser) {
        this.kakaoUser = kakaoUser;
        kakaoUser.changeMyboard(this);
    }

    public void updateMyboardStatus(MyboardStatus status) {
        this.myboardStatus = status;
    }

    @Builder
    public Myboard(Long myboardId, String emoji, String name, String birth, BirthStatus birthStatus, String mbti, String myboardComments, String url1, String url1Type, String url2, String url2Type, String url3, String url3Type, MyboardStatus myboardStatus) {
        this.myboardId = myboardId;
        this.emoji = emoji;
        this.name = name;
        this.birth = birth;
        this.birthStatus = birthStatus;
        this.mbti = mbti;
        this.myboardComments = myboardComments;
        this.url1 = url1;
        this.url1Type = url1Type;
        this.url2 = url2;
        this.url2Type = url2Type;
        this.url3 = url3;
        this.url3Type = url3Type;
        this.myboardStatus = myboardStatus;
    }
}
