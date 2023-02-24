package openAPI.TmiBoard.repository.kakao;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.QKakaoUser;
import org.springframework.stereotype.Repository;

@Repository
public class KakaoUserRepositoryImpl implements KakaoCustomRepository {

    private final JPAQueryFactory queryFactory;

    public KakaoUserRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
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
