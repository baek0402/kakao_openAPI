package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.convert.form.MyboardDtoConvert;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import openAPI.TmiBoard.dto.out.MyboardRequestBody;
import openAPI.TmiBoard.repository.myboard.MyboaradRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyboardService {

    private final MyboaradRepository myboaradRepository;
    private final MyboardDtoConvert myboardDtoConvert;

    @Transactional
    public MyboardDto createMyboard(MyboardRequestBody requestBody) {
        //jwt 사용자 인증 후 없으면 저장하기
        Myboard board = Myboard.builder()
                .name(requestBody.getName())
                .emoji(requestBody.getEmoji())
                .birth(requestBody.getBirth())
                .birthStatus(requestBody.getBirthStatus())
                .mbti(requestBody.getMbti())
                .myboardComments(requestBody.getMyboardComments())
                .url1(requestBody.getUrl1())
                .url2(requestBody.getUrl2())
                .url3(requestBody.getUrl3())
                .build();

        myboaradRepository.save(board);

        return myboardDtoConvert.convert(board);
    }

    public MyboardDto getMyboard(Long userId) {
        Optional<Myboard> result = myboaradRepository.findById(userId);
        //이게 맞나?

        return myboardDtoConvert.convert(result.get());
        //modelMapper.map(result.get(), MyboardDto.class);
    }
}
