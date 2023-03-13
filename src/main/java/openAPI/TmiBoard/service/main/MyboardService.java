package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.convert.form.MyboardConvert;
import openAPI.TmiBoard.convert.form.MyboardDtoConvert;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import openAPI.TmiBoard.dto.out.MyboardRequestBody;
import openAPI.TmiBoard.repository.kakao.KakaoCustomRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.myboard.MyboardRepository;
import openAPI.TmiBoard.repository.myboard.MyboardRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyboardService {

    private final MyboardRepository myboaradRepository;
    private final MyboardConvert myboardDtoConvert;
    private final KakaoUserRepository kakaoUserRepository;

    @Transactional
    public MyboardDto createMyboard(MyboardRequestBody requestBody, KakaoUser kakaoUser) {
        //해당 카카오 유저의 정보와 Myboard 새 객체와 함께 저장하기
        Myboard board = new Myboard();
        board = Myboard.builder()
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
        board.setKakaoUser(kakaoUser);

        myboaradRepository.save(board);

        return myboardDtoConvert.convert(board);
    }

    public MyboardDto getMyboard(Long userId) {
        Myboard result = myboaradRepository.findByKakaoId(userId);
        //이게 맞나?

        return myboardDtoConvert.convert(result);
        //modelMapper.map(result.get(), MyboardDto.class);
    }

    public MyboardDto updateMyboard(MyboardRequestBody requestBody) {
        Myboard result = myboaradRepository.findByKakaoId(requestBody.getUserId());
        Myboard newResult = Myboard.builder()
                .myboardId(result.getMyboardId())
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

        return myboardDtoConvert.convert(myboaradRepository.updateMyboard(result, newResult));
    }
}
