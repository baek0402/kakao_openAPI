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
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<TmiCardDto> getCardList(Long userId) {
        List<TmiCard> search = tmiCardRepository.findByUserId(userId);

        List<TmiCard> result = search.stream()
                .map(TmiCard::getMainData)
                .collect(Collectors.toList());

        return tmiCardDtoConvert.convertList(result);
    }

    public TmiCardDto getCardDetail(Long cardId) {
        // Long cardId = 1L;
        TmiCard tmicard = tmiCardRepository.findByCardId(cardId);

        return TmiCardDto.builder()
                .cardId(tmicard.getCardId())
                .cardEmoji(tmicard.getCardEmoji())
                .cardColor(tmicard.getCardColor())
                .title(tmicard.getTitle())
                .hashTag(tmicard.getHashTag())
                .comments(tmicard.getComments())
                .build();
        //tmiCardDtoConvert.convert(result);
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
        return TmiCardDto.builder()
                .cardId(card.getCardId())
                .cardEmoji(card.getCardEmoji())
                .cardColor(card.getCardColor())
                .title(card.getTitle())
                .hashTag(card.getHashTag())
                .comments(card.getComments())
                .build();
        //tmiCardDtoConvert.convert(result);

    }

    @Transactional
    public void cardDelete(Long cardId, Long userId) {
        TmiCard result = tmiCardRepository.findCardByKakaoId(userId, cardId);

        try {
            tmiCardRepository.delete(result);
        } catch (IllegalAccessError e) {
            log.info("delete fail", e);
        }
    }
}