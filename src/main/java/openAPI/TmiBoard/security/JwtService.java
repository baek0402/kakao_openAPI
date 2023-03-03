package openAPI.TmiBoard.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.exception.BaseException;
import openAPI.TmiBoard.secret.SecretConfig;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static openAPI.TmiBoard.exception.BaseResponseStatus.EMPTY_JWT;
import static openAPI.TmiBoard.exception.BaseResponseStatus.INVALID_JWT;

@Service
@RequiredArgsConstructor
public class JwtService {

    public String createJwt(KakaoUserDto kakaoUser) {
        Long userIdx = kakaoUser.getUserId();

        return Jwts.builder()
                    .setHeaderParam("type","jwt")
                    .claim("userIdx", userIdx)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis()+1*(1000*60*60*24*365)))
                    .signWith(SignatureAlgorithm.HS256, SecretConfig.JWT_SECRET_KEY) //Secret.JWT_SECRET_KEY)
                    .compact();
    }

    public Long getUserIdx() throws BaseException {

        //1. JWT 추출
        String accessToken = getJwt();
        if(accessToken == null || accessToken.length() == 0){
            throw new BaseException(EMPTY_JWT);
        }

        // 2. JWT parsing
        Jws<Claims> claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(SecretConfig.JWT_SECRET_KEY)
                    .parseClaimsJws(accessToken);
        } catch (Exception ignored) {
            throw new BaseException(INVALID_JWT);
        }

        // 3. userIdx 추출
        return claims.getBody().get("userIdx", Long.class);
    }

    public String getJwt(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }
}
