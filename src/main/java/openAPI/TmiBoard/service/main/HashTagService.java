package openAPI.TmiBoard.service.main;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.repository.hashTag.HashTagRepository;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HashTagService {

    private final HashTagRepository hashTagRespository;
    private final KakaoUserRepository repository;

    public String saveList(List<String> hashTagList, Long userId) {
        KakaoUser user = repository.findById(userId);

        hashTagRespository.save(hashTagList, user);

        return "success............";
    }
}
