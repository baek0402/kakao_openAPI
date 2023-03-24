package openAPI.TmiBoard.repository.tmiCard;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.contract.Interact;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.QTmiCardLike;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TmiCardLikeRepositoryImpl implements TmiCardLikeRepository{

    private Interact interact;
    private final JPAQueryFactory jpaQueryFactory;
    private final TmiCardLikeCustomRepository tmiCardLikeRepository;

    public Optional<TmiCardLike> findByUserAndCard(Long userId, Long cardId) {
        QTmiCardLike qTmiCardLike = QTmiCardLike.tmiCardLike;

        return Optional.ofNullable(jpaQueryFactory.selectFrom(qTmiCardLike)
                .where(qTmiCardLike.userId.eq(userId).and(qTmiCardLike.cardId.eq(cardId)))
                .fetchOne());
    }

    @Override
    public void save(TmiCardLike tmiCardLike) {
        tmiCardLikeRepository.save(tmiCardLike);
    }

    @Override
    public void delete(TmiCardLike tmiCardLike) {
        tmiCardLikeRepository.delete(tmiCardLike);
    }

    public TmiCardInteract countInteract(Long cardId) {
        QTmiCardLike qTmiCardLike = QTmiCardLike.tmiCardLike;

        TmiCardInteract result = new TmiCardInteract();

        /* 코드 최적화는 어떻게 해야하지? */
        result.setCount_great(
            jpaQueryFactory.selectFrom(qTmiCardLike)
                    .where(qTmiCardLike.likeStatus.eq(Interact.GREAT).and(qTmiCardLike.cardId.eq(cardId)))
                    .fetch()
                    .size()
        );

        result.setCount_heart(
                jpaQueryFactory.selectFrom(qTmiCardLike)
                        .where(qTmiCardLike.likeStatus.eq(Interact.HEART).and(qTmiCardLike.cardId.eq(cardId)))
                        .fetch().size()
        );

        result.setCount_clap(
                jpaQueryFactory.selectFrom(qTmiCardLike)
                        .where(qTmiCardLike.likeStatus.eq(Interact.CLAP).and(qTmiCardLike.cardId.eq(cardId)))
                        .fetch().size()
        );

        return result;
    }

    public List<TmiCardLike> findLikeList(Long cardId) {
        QTmiCardLike qTmiCardLike = QTmiCardLike.tmiCardLike;

        return jpaQueryFactory.selectFrom(qTmiCardLike)
                .where(qTmiCardLike.cardId.eq(cardId))
                .fetch();
    }

    public void deleteAll(List<TmiCardLike> resultList) {
        tmiCardLikeRepository.deleteAll(resultList);
    }
}
