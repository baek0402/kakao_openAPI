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
    date = "2023-04-19T17:10:59+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TmiCardDtoConvertImpl implements TmiCardDtoConvert {

    @Override
    public TmiCardDto convert(TmiCard source) {
        if ( source == null ) {
            return null;
        }

        Long cardId = null;
        String cardEmoji = null;
        String cardColor = null;
        String title = null;
        String comments = null;
        String selectedInteract = null;

        TmiCardDto tmiCardDto = new TmiCardDto( cardId, cardEmoji, cardColor, title, comments, selectedInteract );

        return tmiCardDto;
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
