package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.HashTag;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.repository.hashTag.HashTagRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardCustomRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HashTagService {

    private final TmiCardCustomRepository tmiCardRepository;
    private final HashTagRepository hashTagRespository;
    private final KakaoUserRepository repository;

    public String saveList(Long cardId, List<String> hashTagList, Long userId) {
        TmiCard card = tmiCardRepository.findByCardId(cardId);

        hashTagRespository.save(card, hashTagList, userId);

        return "success............";
    }

    public List<String> getRandomList(Long userId) {
        List<String> resultList = hashTagRespository.getRandomList(userId);

        return resultList;
    }

    public List<HashTag> getHashTagList(Long cardId, Long userId) {
        List<HashTag> resultList = hashTagRespository.findList(cardId, userId);

        return resultList;
    }

    public void hashTagDelete(Long cardId, Long userId) {
        //1. 해당 유저의 카드 아이디 찾기 (?)
        List<HashTag> result = hashTagRespository.findList(cardId, userId);

        hashTagRespository.deleteList(result);
    }
}
