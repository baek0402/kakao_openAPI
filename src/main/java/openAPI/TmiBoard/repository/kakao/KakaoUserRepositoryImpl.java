package openAPI.TmiBoard.repository.kakao;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.QKakaoUser;
import org.springframework.stereotype.Repository;

@Repository
public class KakaoUserRepositoryImpl implements KakaoUserRepository{

    private final JPAQueryFactory queryFactory;
    private final KakaoCustomRepository kakaoCustomRepository;

    public KakaoUserRepositoryImpl(JPAQueryFactory queryFactory, KakaoCustomRepository kakaoCustomRepository) {
        this.queryFactory = queryFactory;
        this.kakaoCustomRepository = kakaoCustomRepository;
    }

    public void save(KakaoUser kakaoUser) {
        kakaoCustomRepository.save(kakaoUser);
    }

    public KakaoUser findById(Long userId) {
        QKakaoUser qKakaoUser = QKakaoUser.kakaoUser;

        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qKakaoUser.userId.eq(userId));
        return  queryFactory.selectFrom(qKakaoUser)
                .where(condition)
                .fetchOne();
    }

    public KakaoUser findByEmail(String userEmail) {
        QKakaoUser qKakaoUser = QKakaoUser.kakaoUser;

        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qKakaoUser.userEmail.eq(userEmail));
        return  queryFactory.selectFrom(qKakaoUser)
                .where(condition)
                .fetchOne();
    }

    public KakaoUser findByUserName(String userName) {
        QKakaoUser qKakaoUser = QKakaoUser.kakaoUser;

        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qKakaoUser.userName.eq(userName));
        return  queryFactory.selectFrom(qKakaoUser)
                .where(condition)
                .fetchOne();
    }


}
