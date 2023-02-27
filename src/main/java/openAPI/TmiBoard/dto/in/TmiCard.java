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
    @Column(name = "card_color")
    private String cardColor;
    @Column(name = "card_title")
    private String title;
    private String comments;
    @Column(name = "hash_tag")
    private String hashTag;


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

    public TmiCard() {}

    @Builder
    public TmiCard(Long kakaoUser_id, String cardEmoji, String cardColor, String title, String comments, String hashTag) {
        this.kakaoUser_id = kakaoUser_id;
        this.cardEmoji = cardEmoji;
        this.cardColor = cardColor;
        this.title = title;
        this.comments = comments;
        this.hashTag = hashTag;
    }
}
