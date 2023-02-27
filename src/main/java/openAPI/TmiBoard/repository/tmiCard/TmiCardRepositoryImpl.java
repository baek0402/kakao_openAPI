package openAPI.TmiBoard.repository.tmiCard;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.QTmiCard;
import openAPI.TmiBoard.dto.in.TmiCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TmiCardRepositoryImpl implements TmiCardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<TmiCard> findByUserId(Long userId) {
        QTmiCard qTmiCard = QTmiCard.tmiCard;
        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qTmiCard.kakaoUser_id.eq(userId));

        return jpaQueryFactory.selectFrom(qTmiCard).where(condition).fetch();
    }

    @Override
    public TmiCard findByCardId(Long cardId) {
        QTmiCard qTmiCard = QTmiCard.tmiCard;
        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qTmiCard.cardId.eq(cardId));

        return jpaQueryFactory.selectFrom(qTmiCard).where(condition).fetchOne();
    }
}
