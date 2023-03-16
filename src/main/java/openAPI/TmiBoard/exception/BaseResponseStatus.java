package openAPI.TmiBoard.exception;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true,"요청에 성공하였습니다."),

    EMPTY_USER(false, "유저 정보를 찾을 수 없습니다.(DB)"),

    EMPTY_JWT(false,"JWT를 입력해주세요."),
    INVALID_JWT(false,"유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,"권한이 없는 유저의 접근입니다."),

    ALREADY_EXIST_BOARD(false, "이미 마이보드가 존재합니다."),
    NO_EXIST_BOARD(false, "마이보드가 존재하지 않습니다."),

    NO_EXIST_TMICARD(false, "해당 유저의 트미카드가 존재하지 않습니다."),

    DB_EXECUTE_ERROR(false, "데이터베이스 처리 과정에서 오류가 발생했습니다.");


    private final boolean isSuccess;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

}
