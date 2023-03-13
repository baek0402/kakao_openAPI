package openAPI.TmiBoard.repository.hashTag;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.HashTag;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.QHashTag;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HashTagRepositoryImpl implements HashTagRepository{

    private final JPAQueryFactory queryFactory;
    private final HashTagCustomRepository hashTagCustomRepository;
    private final KakaoUserRepository kakaoUserRepository;

    @Override
    public void save(List<String> hashTagList, KakaoUser kakaoUser) {
        HashTag hashTag = new HashTag();

        for (String value : hashTagList) {
            hashTag.setKakaoUser(kakaoUser);
            hashTag.setHashTagData(value);

            hashTagCustomRepository.save(hashTag);
        }
    }

    public HashTag findByKakaoId(Long userId) {
        QHashTag qHashTag = QHashTag.hashTag;

        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qHashTag.kakaoUser.userId.eq(userId));
        return  queryFactory.selectFrom(qHashTag)
                                .where(condition)
                                .fetchOne();
    }
}
