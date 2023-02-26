package openAPI.TmiBoard.dto.in;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "tmicard")
public class TmiCard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;
    @Column(name = "card_emoji")
    private String cardEmoji;
    @Column(name = "card_title")
    private String title;
    @Column(name = "hash_tag")
    private String hashTag;
    private String comments;
    @Column(name = "card_color")
    private String cardColor;

    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private KakaoUser kakaoUser;*/
    @Column(name = "user_id")
    private Long kakaoUser_id;

    public TmiCard getMainData() {
        TmiCard card = TmiCard.builder()
                .cardColor(getCardColor())
                .cardEmoji(getCardEmoji())
                .title(getTitle())
                .build();

        return card;
    }
    public TmiCard() { }
    @Builder
    public TmiCard(Long userId, String cardEmoji, String title, String hashTag, String comments, String cardColor) {
        this.kakaoUser_id = userId;
        this.cardEmoji = cardEmoji;
        this.title = title;
        this.hashTag = hashTag;
        this.comments = comments;
        this.cardColor = cardColor;
    }
}
