package openAPI.TmiBoard.dto.in;

import lombok.Getter;
import lombok.Setter;
import openAPI.TmiBoard.contract.Interact;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "tmicard_like")
@Getter @Setter
public class TmiCardLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;
    @Enumerated(EnumType.STRING)
    @Column(name = "like_status")
    private Interact likeStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private KakaoUser kakaoUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tmicard_id")
    private TmiCard tmiCard;


}
