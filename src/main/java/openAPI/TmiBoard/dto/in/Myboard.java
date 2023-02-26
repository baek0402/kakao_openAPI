package openAPI.TmiBoard.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import openAPI.TmiBoard.contract.BirthStatus;

import javax.persistence.*;

@Entity
@Getter
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
    @Column(name = "myboard_url2")
    private String url2;
    @Column(name = "myboard_url3")
    private String url3;

    @Builder
    public Myboard(Long myboardId, String emoji, String name, String birth, BirthStatus birthStatus, String mbti, String myboardComments, String url1, String url2, String url3) {
        this.myboardId = myboardId;
        this.emoji = emoji;
        this.name = name;
        this.birth = birth;
        this.birthStatus = birthStatus;
        this.mbti = mbti;
        this.myboardComments = myboardComments;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
    }
}
