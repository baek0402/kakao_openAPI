package openAPI.TmiBoard.repository.tmiCard;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.contract.Interact;
import openAPI.TmiBoard.dto.in.QTmiCard;
import openAPI.TmiBoard.dto.in.QTmiCardLike;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.out.TmiCardInteractDto;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TmiCardLikeRepositoryImpl implements TmiCardLikeCustomRepository{

    private Interact interact;
    private final JPAQueryFactory jpaQueryFactory;

    public TmiCardInteract countInteract() {
        QTmiCardLike qTmiCardLike = QTmiCardLike.tmiCardLike;

        TmiCardInteract result = new TmiCardInteract();

        /* 코드 최적화는 어떻게 해야하지? */
        result.setCount_great(
            jpaQueryFactory.selectFrom(qTmiCardLike)
                    .where(qTmiCardLike.likeStatus.eq(Interact.GREAT))
                    .fetch().size()
        );

        result.setCount_heart(
                jpaQueryFactory.selectFrom(qTmiCardLike)
                        .where(qTmiCardLike.likeStatus.eq(Interact.HEART))
                        .fetch().size()
        );

        result.setCount_clap(
                jpaQueryFactory.selectFrom(qTmiCardLike)
                        .where(qTmiCardLike.likeStatus.eq(Interact.CLAP))
                        .fetch().size()
        );

        return result;

    }
}
