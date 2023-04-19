package openAPI.TmiBoard.convert.form;

import javax.annotation.processing.Generated;
import openAPI.TmiBoard.contract.BirthStatus;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.convert.SupportValidation;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:10:59+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MyboardDtoConvertImpl implements MyboardDtoConvert {

    @Override
    public MyboardDto convert(Myboard source) {
        if ( source == null ) {
            return null;
        }

        Long boardId = null;
        Long userId = null;
        String name = null;
        String mbti = null;
        String birth = null;
        String myboardComments = null;
        String emoji = null;
        BirthStatus birthStatus = null;
        String url1 = null;
        String url1Type = null;
        String url2 = null;
        String url2Type = null;
        String url3 = null;
        String url3Type = null;
        MyboardStatus myboardStatus = null;

        MyboardDto myboardDto = new MyboardDto( boardId, userId, name, mbti, birth, myboardComments, emoji, birthStatus, url1, url1Type, url2, url2Type, url3, url3Type, myboardStatus );

        return myboardDto;
    }
}
