package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.convert.form.TmiCardDtoConvert;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.dto.out.TmiCardDto;
import openAPI.TmiBoard.dto.out.TmiCardRequestBody;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TmiCardService {

    private final TmiCardRepository tmiCardRepository;

    private final TmiCardDtoConvert tmiCardDtoConvert;

    @Transactional
    public TmiCardDto createTmicard(TmiCardRequestBody requestBody, Long userId) {
        TmiCard tmicard = TmiCard.builder()
                .userId(userId)
                .cardEmoji(requestBody.getCardEmoji())
                .cardColor(requestBody.getCardColor())
                .title(requestBody.getTitle())
                .hashTag(requestBody.getHashTag())
                .comments(requestBody.getComments())
                .build();

        tmiCardRepository.save(tmicard);

        return tmiCardDtoConvert.convert(tmicard);
    }

    public List<TmiCardDto> getCardList(Long userId) {
        List<TmiCard> search = tmiCardRepository.findByUserId(userId);

        List<TmiCard> result = search.stream()
                .map(TmiCard::getMainData)
                .collect(Collectors.toList());

        return new ArrayList<>();//tmiCardDtoConvert.convert(result);
    }
}