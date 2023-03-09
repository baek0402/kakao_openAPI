package openAPI.TmiBoard.repository.myboard;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.dto.in.Myboard;
import openAPI.TmiBoard.dto.in.QMyboard;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyboardRepositoryImpl implements MyboardRepository{

    private final JPAQueryFactory queryFactory;
    private final MyboardCustomRepository myboardCustomRepository;

    public void save(Myboard myboard) {
        myboardCustomRepository.save(myboard);
    }

    public Myboard updateMyboard(Myboard myboard, Myboard newBoard) {
        myboard = Myboard.builder()
                .myboardId(newBoard.getMyboardId())
                .name(newBoard.getName())
                .emoji(newBoard.getEmoji())
                .birth(newBoard.getBirth())
                .birthStatus(newBoard.getBirthStatus())
                .mbti(newBoard.getMbti())
                .myboardComments(newBoard.getMyboardComments())
                .url1(newBoard.getUrl1())
                .url2(newBoard.getUrl2())
                .url3(newBoard.getUrl3())
                .build();

        myboardCustomRepository.save(myboard);

        return myboard;
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
