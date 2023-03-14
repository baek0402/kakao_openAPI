package openAPI.TmiBoard.convert.kakao;

import javax.annotation.processing.Generated;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.contract.UserStatus;
import openAPI.TmiBoard.convert.SupportValidation;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-14T22:37:18+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class KakaoUserDtoConvertImpl implements KakaoUserDtoConvert {

    @Override
    public KakaoUserDto convert(KakaoUser source) {
        if ( source == null ) {
            return null;
        }

        MyboardStatus myboardStatus = null;

        myboardStatus = source.getMyboardStatus();

        Long userId = null;
        String userEmail = null;
        String userName = null;
        UserStatus userStatus = null;

        KakaoUserDto kakaoUserDto = new KakaoUserDto( userId, userEmail, userName, userStatus, myboardStatus );

        return kakaoUserDto;
    }
}
