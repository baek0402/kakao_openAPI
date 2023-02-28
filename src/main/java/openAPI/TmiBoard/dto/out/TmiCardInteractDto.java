package openAPI.TmiBoard.dto.out;

import lombok.Builder;
import lombok.Getter;
import openAPI.TmiBoard.contract.Interact;

@Getter
public class TmiCardInteractDto {

    private Long likeId;
    private Interact interact;
    private int count_great;
    private int count_heart;
    private int count_clap;

    @Builder
    public TmiCardInteractDto(int count_great, int count_heart, int count_clap) {
        //this.interact = interact;
        this.count_great = count_great;
        this.count_heart = count_heart;
        this.count_clap = count_clap;
    }
}
