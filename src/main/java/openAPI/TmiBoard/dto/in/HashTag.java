package openAPI.TmiBoard.dto.in;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hashtag")
@Data
@NoArgsConstructor
public class HashTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long tagId;
    @Column(name = "hashtag_data")
    private String hashTagData;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kakao_id")
    private KakaoUser kakaoUser;

    @Builder
    public HashTag(Long tagId, String hashTagData, KakaoUser kakaoUser) {
        this.tagId = tagId;
        this.hashTagData = hashTagData;
        this.kakaoUser = kakaoUser;
    }
}
