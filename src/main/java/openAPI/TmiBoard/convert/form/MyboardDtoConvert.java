package openAPI.TmiBoard.convert.form;

import openAPI.TmiBoard.convert.MapStructConfig;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface MyboardDtoConvert {

    MyboardDto convert(Myboard source);
}
