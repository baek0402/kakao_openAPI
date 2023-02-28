package openAPI.TmiBoard.service.interact;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.contract.Interact;
import openAPI.TmiBoard.dto.in.TmiCardInteract;
import openAPI.TmiBoard.dto.in.TmiCardLike;
import openAPI.TmiBoard.dto.out.TmiCardInteractDto;
import openAPI.TmiBoard.dto.out.TmiCardLikeDto;
import openAPI.TmiBoard.repository.tmiCard.TmiCardLikeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InteractService {

    private final TmiCardLikeRepository tmiCardLikeRepository;

    public void likeCard(TmiCardLikeDto tmiCardLikeDto) {
        TmiCardLike likeStatus = new TmiCardLike();
        likeStatus.setLikeStatus(tmiCardLikeDto.getLikeStatus());

        //1. 유저 글이
        tmiCardLikeRepository.save(likeStatus);
    }

    public TmiCardLikeDto delete() {

        return new TmiCardLikeDto();
    }

    public TmiCardInteractDto getCount() {
        TmiCardInteract result = tmiCardLikeRepository.countInteract();

        return new TmiCardInteractDto(result.getCount_clap(), result.getCount_great(), result.getCount_heart());
    }
}
