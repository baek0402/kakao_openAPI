package openAPI.TmiBoard.convert.form;

import openAPI.TmiBoard.convert.MapStructConfig;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface MyboardDtoConvert {

    //@Mapping(source = "myboardId", target = "boardId")
    MyboardDto convert(Myboard source);
}
