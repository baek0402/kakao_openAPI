package openAPI.TmiBoard.convert.form;

import javax.annotation.processing.Generated;
import openAPI.TmiBoard.convert.SupportValidation;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-02T14:21:29+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class MyboardDtoConvertImpl implements MyboardDtoConvert {

    @Override
    public MyboardDto convert(Myboard source) {
        if ( source == null ) {
            return null;
        }

        MyboardDto myboardDto = new MyboardDto();

        return myboardDto;
    }
}
