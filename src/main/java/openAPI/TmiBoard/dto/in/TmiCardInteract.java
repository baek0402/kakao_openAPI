package openAPI.TmiBoard.dto.in;

import lombok.Data;
import lombok.Getter;
import openAPI.TmiBoard.contract.Interact;

@Data
public class TmiCardInteract {

    private Long likeId;
    private Interact interact;
    private int count_great;
    private int count_heart;
    private int count_clap;
}
