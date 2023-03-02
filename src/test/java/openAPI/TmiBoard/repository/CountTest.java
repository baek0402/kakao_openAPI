package openAPI.TmiBoard.repository;

import openAPI.TmiBoard.contract.Interact;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import openAPI.TmiBoard.repository.tmiCard.TmiCardLikeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CountTest {

    @Autowired
    TmiCardLikeRepository tmiCardLikeRepository;

    @Test
    public void 개수테스트() {
        TmiCardLike like1 = new TmiCardLike();
        like1.setLikeStatus(Interact.GREAT);

        TmiCardLike like2 = new TmiCardLike();
        like2.setLikeStatus(Interact.GREAT);

        TmiCardLike like = new TmiCardLike();
        like.setLikeStatus(Interact.HEART);

        tmiCardLikeRepository.save(like1);
        tmiCardLikeRepository.save(like2);
        tmiCardLikeRepository.save(like);

        TmiCardInteract count = tmiCardLikeRepository.countInteract();

        System.out.println(count.getCount_great() + " , " + count.getCount_clap() + " , " + count.getCount_heart());
    }

}
