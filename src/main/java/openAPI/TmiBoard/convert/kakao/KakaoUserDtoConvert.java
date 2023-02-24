package openAPI.TmiBoard.convert.kakao;

import openAPI.TmiBoard.convert.MapStructConfig;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.out.KakaoUserDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface KakaoUserDtoConvert {

    KakaoUserDto convert(KakaoUser source);
}
