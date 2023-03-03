package openAPI.TmiBoard.dto.in;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tmicard")
public class TmiCard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;
    @Column(name = "card_emoji")
    private String cardEmoji;
    @Column(name = "card_color")
    private String cardColor;
    @Column(name = "card_title")
    private String title;
    private String comments;
    @Column(name = "hash_tag")
    private String hashTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kakao_id")
    private KakaoUser kakaoUser;


    public TmiCard getMainData() {
        TmiCard card = TmiCard.builder()
                .cardColor(getCardColor())
                .cardEmoji(getCardEmoji())
                .title(getTitle())
                .build();

        return card;
    }

    public TmiCard() {}

    @Builder
    public TmiCard(KakaoUser kakaoUser, Long cardId, String cardEmoji, String cardColor, String title, String comments, String hashTag) {
        this.kakaoUser = kakaoUser;
        this.cardId = cardId;
        this.cardEmoji = cardEmoji;
        this.cardColor = cardColor;
        this.title = title;
        this.comments = comments;
        this.hashTag = hashTag;
    }
}
