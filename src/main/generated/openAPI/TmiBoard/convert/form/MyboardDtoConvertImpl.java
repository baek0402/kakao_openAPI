package openAPI.TmiBoard.convert.form;

import javax.annotation.processing.Generated;
import openAPI.TmiBoard.convert.SupportValidation;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-26T20:41:43+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MyboardDtoConvertImpl implements MyboardDtoConvert {

    @Override
    public MyboardDto convert(Myboard source) {
        if ( source == null ) {
            return null;
        }

        MyboardDto.MyboardDtoBuilder myboardDto = MyboardDto.builder();

        myboardDto.name( source.getName() );
        myboardDto.mbti( source.getMbti() );
        myboardDto.birth( source.getBirth() );
        myboardDto.myboardComments( source.getMyboardComments() );
        myboardDto.emoji( source.getEmoji() );
        myboardDto.birthStatus( source.getBirthStatus() );
        myboardDto.url1( source.getUrl1() );
        myboardDto.url2( source.getUrl2() );
        myboardDto.url3( source.getUrl3() );

        return myboardDto.build();
    }
}
