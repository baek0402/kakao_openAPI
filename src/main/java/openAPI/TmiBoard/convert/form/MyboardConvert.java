package openAPI.TmiBoard.convert.form;

import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyboardConvert {

    public MyboardDto convert(Myboard source) {
        return MyboardDto.builder()
                .name(source.getName())
                .emoji(source.getEmoji())
                .birth(source.getBirth())
                .birthStatus(source.getBirthStatus())
                .mbti(source.getMbti())
                .myboardComments(source.getMyboardComments())
                .url1(source.getUrl1())
                .url1Type(source.getUrl1Type())
                .url2(source.getUrl2())
                .url2Type(source.getUrl2Type())
                .url3(source.getUrl3())
                .url3Type(source.getUrl3Type())
                .myboardStatus(source.getMyboardStatus())
                .build();
    }
}
