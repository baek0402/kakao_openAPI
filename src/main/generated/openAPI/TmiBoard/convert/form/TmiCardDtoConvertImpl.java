package openAPI.TmiBoard.convert.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import openAPI.TmiBoard.convert.SupportValidation;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-04T17:07:40+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TmiCardDtoConvertImpl implements TmiCardDtoConvert {

    @Override
    public TmiCardDto convert(TmiCard source) {
        if ( source == null ) {
            return null;
        }

        TmiCardDto.TmiCardDtoBuilder tmiCardDto = TmiCardDto.builder();

        tmiCardDto.cardId( source.getCardId() );
        tmiCardDto.cardEmoji( source.getCardEmoji() );
        tmiCardDto.cardColor( source.getCardColor() );
        tmiCardDto.title( source.getTitle() );
        tmiCardDto.comments( source.getComments() );
        tmiCardDto.hashTag( source.getHashTag() );

        return tmiCardDto.build();
    }

    @Override
    public List<TmiCardDto> convert(List<TmiCard> sources) {
        if ( sources == null ) {
            return null;
        }

        List<TmiCardDto> list = new ArrayList<TmiCardDto>( sources.size() );
        for ( TmiCard tmiCard : sources ) {
            list.add( convert( tmiCard ) );
        }

        return list;
    }
}
