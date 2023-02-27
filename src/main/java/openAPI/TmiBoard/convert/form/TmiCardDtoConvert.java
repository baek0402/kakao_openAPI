package openAPI.TmiBoard.convert.form;

import openAPI.TmiBoard.convert.MapStructConfig;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface TmiCardDtoConvert {

    TmiCardDto convert(TmiCard source);

    List<TmiCardDto> convert(List<TmiCard> sources);
}
