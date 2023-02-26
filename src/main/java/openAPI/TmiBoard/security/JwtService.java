package openAPI.TmiBoard.security;

import com.nimbusds.oauth2.sdk.auth.Secret;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import openAPI.TmiBoard.secret.SecretConfig;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    public String createJwt(KakaoUserDto kakaoUser) {
        Long userIdx = kakaoUser.getUserId();

        Date now = new Date();
        return Jwts.builder()
                    .setHeaderParam("type","jwt")
                    .claim("userIdx", userIdx)
                    .setIssuedAt(now)
                    .setExpiration(new Date(System.currentTimeMillis()+1*(1000*60*60*24*365)))
                    .signWith(SignatureAlgorithm.HS256, SecretConfig.JWT_SECRET_KEY) //Secret.JWT_SECRET_KEY)
                    .compact();
    }
}
