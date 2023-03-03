package openAPI.TmiBoard.repository.myboard;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.in.QMyboard;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyboardRepositoryImpl{

    private final JPAQueryFactory queryFactory;
    private final MyboardCustomRepository myboardRepository;

    public void save(Myboard myboard) {
        myboardRepository.save(myboard);
    }

    public Myboard findByKakaoId(Long userId) {
        QMyboard qMyboard = QMyboard.myboard;

        BooleanBuilder condition = new BooleanBuilder();
        condition.and(qMyboard.kakaoUser.userId.eq(userId));

        return queryFactory.selectFrom(qMyboard)
                .where(condition)
                .fetchOne();
    }
}
