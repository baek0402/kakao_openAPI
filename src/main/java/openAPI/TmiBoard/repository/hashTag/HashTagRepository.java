package openAPI.TmiBoard.repository.hashTag;

import openAPI.TmiBoard.dto.in.HashTag;
import openAPI.TmiBoard.dto.in.KakaoUser;

import java.util.List;

public interface HashTagRepository {

    void save(List<String> hashTagList, KakaoUser user);
    HashTag findByKakaoId(Long userId);
}
