package openAPI.TmiBoard.service.interact;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.contract.Interact;
import openAPI.TmiBoard.dto.in.KakaoUser;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import openAPI.TmiBoard.dto.out.ResponseDto;
import openAPI.TmiBoard.dto.out.TmiCardInteractDto;
import openAPI.TmiBoard.dto.out.TmiCardLikeDto;
import openAPI.TmiBoard.repository.tmiCard.TmiCardCustomRepository;
import openAPI.TmiBoard.repository.tmiCard.TmiCardLikeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InteractService {

    private final TmiCardLikeRepository tmiCardLikeRepository;

    public String likeCard(TmiCardLikeDto tmiCardLikeDto) {

        //이미 상호작용 되어있으면 취소..?
        //해당 트미카드의 like 저장소에 카카오유저 아이디가 있으면!
        if(tmiCardLikeRepository.findByUserAndCard(tmiCardLikeDto.getUserId(), tmiCardLikeDto.getCardId()).isPresent()) {
            String msg = delete(tmiCardLikeDto.getUserId(), tmiCardLikeDto.getCardId());

            return msg;
        }

        TmiCardLike likeStatus = new TmiCardLike();
        likeStatus.setLikeStatus(tmiCardLikeDto.getLikeStatus());
        likeStatus.setUserId(tmiCardLikeDto.getUserId());
        likeStatus.setCardId(tmiCardLikeDto.getCardId());

        //아무 상태가 아니라면 상호작용하기
        tmiCardLikeRepository.save(likeStatus);

        return tmiCardLikeDto.getLikeStatus() + " 상호작용을 눌렀습니다";
    }

    public String delete(Long userId, Long cardId) {
        Optional<TmiCardLike> result = tmiCardLikeRepository.findByUserAndCard(userId, cardId);

        tmiCardLikeRepository.delete(result.get());
        return "상호작용 취소했습니다";
    }

    public TmiCardInteractDto getCount(Long cardId) {
        TmiCardInteract result = tmiCardLikeRepository.countInteract(cardId);

        return new TmiCardInteractDto(result.getCount_clap(), result.getCount_great(), result.getCount_heart());
    }
}
