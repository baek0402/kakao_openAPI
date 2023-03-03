package openAPI.TmiBoard.convert.form;

import openAPI.TmiBoard.convert.MapStructConfig;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface MyboardDtoConvert {

    //@Mapping(source = "kakaoUser", target = "userId")
    MyboardDto convert(Myboard source);
}
