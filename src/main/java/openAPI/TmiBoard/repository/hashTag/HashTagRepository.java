package openAPI.TmiBoard.repository.hashTag;

import openAPI.TmiBoard.dto.in.HashTag;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.TmiCard;

import java.util.List;

public interface HashTagRepository {

    void save(TmiCard card, List<String> hashTagList, Long userId);
    HashTag findByKakaoId(Long userId);
    List<String> getRandomList(Long userId);

    List<HashTag> findList(Long cardId);

    void deleteList(List<HashTag> hashTagList);
}
