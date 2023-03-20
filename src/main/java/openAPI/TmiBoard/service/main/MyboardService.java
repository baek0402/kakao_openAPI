package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.contract.MyboardStatus;
import openAPI.TmiBoard.convert.form.MyboardConvert;
import openAPI.TmiBoard.convert.form.MyboardDtoConvert;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.out.MyboardDto;
import openAPI.TmiBoard.dto.out.MyboardRequestBody;
import openAPI.TmiBoard.exception.BaseException;
import openAPI.TmiBoard.exception.BaseResponseStatus;
import openAPI.TmiBoard.repository.kakao.KakaoCustomRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.myboard.MyboardRepository;
import openAPI.TmiBoard.repository.myboard.MyboardRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static openAPI.TmiBoard.contract.MyboardStatus.*;
import static openAPI.TmiBoard.exception.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
public class MyboardService{

    private final MyboardRepository myboaradRepository;
    private final MyboardConvert myboardDtoConvert;
    private final MyboardRepository myboardRepository;
    private final KakaoUserRepository kakaoUserRepository;

    @Transactional
    public MyboardDto createMyboard(MyboardRequestBody requestBody, Long userId) throws BaseException {
        Myboard checkBoard = myboardRepository.findByKakaoId(userId);
        if (checkBoard != null) {
            throw new BaseException(ALREADY_EXIST_BOARD);
        }

        KakaoUser user = kakaoUserRepository.findById(userId);
        //카카오 유저의 정보와 Myboard 새 객체와 함께 저장하기
        Myboard board = Myboard.builder()
                .name(requestBody.getName())
                .emoji(requestBody.getEmoji())
                .birth(requestBody.getBirth())
                .birthStatus(requestBody.getBirthStatus())
                .mbti(requestBody.getMbti())
                .myboardComments(requestBody.getMyboardComments())
                .url1(requestBody.getUrl1())
                .url1Type(requestBody.getUrl1Type())
                .url2(requestBody.getUrl2())
                .url2Type(requestBody.getUrl2Type())
                .url3(requestBody.getUrl3())
                .url3Type(requestBody.getUrl3Type())
                .myboardStatus(Y)
                .build();
        board.setKakaoUser(user);

        myboaradRepository.save(board);

        return myboardDtoConvert.convert(board);
    }

    public MyboardDto getMyboard(Long userId) throws BaseException {
        Myboard result = myboaradRepository.findByKakaoId(userId);
        //result.setMyboardId(result.getMyboardId());

        if(result == null)
            throw new BaseException(NO_EXIST_BOARD);
        //이게 맞나?

        return myboardDtoConvert.convert(result);
        //modelMapper.map(result.get(), MyboardDto.class);
    }

    public MyboardDto updateMyboard(Myboard newMyboard, Long userId) throws BaseException {
        Myboard result = myboaradRepository.findByKakaoId(userId);
        if(result == null) throw new BaseException(NO_EXIST_BOARD);

        newMyboard.setMyboardId(result.getMyboardId());
        newMyboard.setKakaoUser(result.getKakaoUser());
        Myboard changedResult = myboaradRepository.updateMyboard(result, newMyboard);

        return myboardDtoConvert.convert(changedResult);
    }
}
