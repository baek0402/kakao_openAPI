package openAPI.TmiBoard.convert.kakao;

import javax.annotation.processing.Generated;
import openAPI.TmiBoard.convert.SupportValidation;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T16:41:17+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class KakaoUserDtoConvertImpl implements KakaoUserDtoConvert {

    @Override
    public KakaoUserDto convert(KakaoUser source) {
        if ( source == null ) {
            return null;
        }

        KakaoUserDto.KakaoUserDtoBuilder kakaoUserDto = KakaoUserDto.builder();

        kakaoUserDto.userId( source.getUserId() );
        kakaoUserDto.userEmail( source.getUserEmail() );
        kakaoUserDto.userName( source.getUserName() );
        kakaoUserDto.userStatus( source.getUserStatus() );

        return kakaoUserDto.build();
    }
}
