package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import openAPI.TmiBoard.convert.form.TmiCardConvert;
import openAPI.TmiBoard.convert.form.TmiCardDtoConvert;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import openAPI.TmiBoard.dto.out.TmiCardRequestBody;
import openAPI.TmiBoard.exception.BaseException;
import openAPI.TmiBoard.exception.BaseResponseStatus;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static openAPI.TmiBoard.exception.BaseResponseStatus.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TmiCardService {

    private final TmiCardRepository tmiCardRepository;
    private final TmiCardConvert tmiCardDtoConvert;

    @Transactional
    public TmiCardDto createTmicard(TmiCardRequestBody requestBody, KakaoUser user) { //}, Long userId) {
        TmiCard tmicard = TmiCard.builder()
                .cardEmoji(requestBody.getCardEmoji())
                .cardColor(requestBody.getCardColor())
                .title(requestBody.getTitle())
                .hashTag(requestBody.getHashTag())
                .comments(requestBody.getComments())
                .build();
        tmicard.tmiCardSetUser(user);

        tmiCardRepository.save(tmicard);
        tmicard.tmiCardSetCardId(tmicard.getCardId());

        return tmiCardDtoConvert.convert(tmicard);
    }

    public List<TmiCardDto> getCardList(Long userId) throws BaseException{
        List<TmiCard> search = tmiCardRepository.findByUserId(userId);
        if(search.size() == 0)
            throw new BaseException(NO_EXIST_TMICARD);

        List<TmiCard> result = search.stream()
                .map(TmiCard::getMainData)
                .collect(Collectors.toList());

        return tmiCardDtoConvert.convertList(result);
    }

    public TmiCardDto getCardDetail(Long cardId) throws BaseException{
        // Long cardId = 1L;
        TmiCard tmicard = tmiCardRepository.findByCardId(cardId);

        if(tmicard == null) throw new BaseException(NO_EXIST_TMICARD);

        return tmiCardDtoConvert.convert(tmicard);
    }

    public TmiCardDto cardUpdate(TmiCard card, TmiCardRequestBody requestBody) {
        Long cardId = card.getCardId();
        KakaoUser user = card.getKakaoUser();
        card = TmiCard.builder()
                .cardId(cardId)
                .title(requestBody.getTitle())
                .cardEmoji(requestBody.getCardEmoji())
                .cardColor(requestBody.getCardColor())
                .hashTag(requestBody.getHashTag())
                .comments(requestBody.getComments())
                .build();
        card.tmiCardSetUser(user);

        TmiCard result = tmiCardRepository.save(card);
        return tmiCardDtoConvert.convert(result);

    }

    @Transactional
    public TmiCardDto cardDelete(Long cardId, Long userId) throws BaseException{
        TmiCard result = tmiCardRepository.findCardByKakaoId(userId, cardId);

        if(result == null) throw new BaseException(NO_EXIST_TMICARD);
        tmiCardRepository.delete(result);

        return tmiCardDtoConvert.convert(result);
    }
}