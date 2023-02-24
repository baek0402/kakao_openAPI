package openAPI.TmiBoard.dto.in;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KakaoOauth {
    private String accessToken;
    private String refreshToken;
    private int refreshValidTime;

    @Builder
    public KakaoOauth(String accessToken, String refreshToken, int refreshValidTime) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.refreshValidTime = refreshValidTime;
    }
}
