package openAPI.TmiBoard.convert.form;

import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TmiCardConvert {

    public TmiCardDto convert(TmiCard source) {
        return TmiCardDto.builder()
                .cardId(source.getCardId())
                .cardEmoji(source.getCardEmoji())
                .cardColor(source.getCardColor())
                .title(source.getTitle())
                .comments(source.getComments())
                .build();
    }

    public List<TmiCardDto> convertList(List<TmiCard> sources) {

        List<TmiCardDto> list = new ArrayList<TmiCardDto>( sources.size() );
        for ( TmiCard tmiCard : sources ) {
            list.add( convert( tmiCard ) );
        }
        return list;
    }
}
