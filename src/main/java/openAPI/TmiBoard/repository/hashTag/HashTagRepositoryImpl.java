package openAPI.TmiBoard.repository.hashTag;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.MathExpressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.HashTag;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.QHashTag;
import openAPI.TmiBoard.dto.in.TmiCard;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class HashTagRepositoryImpl implements HashTagRepository{

    private final JPAQueryFactory queryFactory;
    private final HashTagCustomRepository hashTagRepository;
    private final KakaoUserRepository kakaoUserRepository;

    @Override
    public void save(TmiCard card, List<String> hashTagList, Long userId) {
        //Long userId = kakaoUser.getUserId();

        for (String hashTag : hashTagList) {
            HashTag entity = new HashTag();
            entity.setHashTagData(hashTag);
            entity.setTmiCard(card);
            entity.setUserId(userId);
            hashTagRepository.save(entity);
        }
    }

    public HashTag findByKakaoId(Long userId) {
        QHashTag qHashTag = QHashTag.hashTag;

        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qHashTag.userId.eq(userId));
        return  queryFactory.selectFrom(qHashTag)
                                .where(condition)
                                .fetchOne();
    }

    public List<String> getRandomList(Long userId) {
        QHashTag qHashTag = QHashTag.hashTag;

        return queryFactory.select(qHashTag.hashTagData)
                .from(qHashTag)
                .where(qHashTag.userId.eq(userId))
                .orderBy(Expressions.stringTemplate("function('rand')").asc())
                .limit(5)
                .fetch();
    }

    public List<HashTag> findList(Long cardId) {
        QHashTag qHashTag = QHashTag.hashTag;

        return queryFactory.select(qHashTag)
                .from(qHashTag)
                .where(qHashTag.tmiCard.cardId.eq(cardId))
                .fetch();
    }

    public void deleteList(List<HashTag> hashTagList) {
        hashTagRepository.deleteAll(hashTagList);
    }
}
