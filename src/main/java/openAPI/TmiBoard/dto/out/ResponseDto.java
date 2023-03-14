package openAPI.TmiBoard.dto.out;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.exception.BaseResponseStatus;

import static openAPI.TmiBoard.exception.BaseResponseStatus.SUCCESS;

@Data
@RequiredArgsConstructor
public class ResponseDto<T> {

    private T result;
    private final Boolean isSuccess;
    private final String message;

    public ResponseDto(T result) {
        this.isSuccess = SUCCESS.isSuccess();
        this.message = SUCCESS.getMessage();
        this.result = result;
    }

    public ResponseDto(BaseResponseStatus status) {
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
    }


}
