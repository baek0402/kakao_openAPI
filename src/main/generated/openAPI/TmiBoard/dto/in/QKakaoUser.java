package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKakaoUser is a Querydsl query type for KakaoUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKakaoUser extends EntityPathBase<KakaoUser> {

    private static final long serialVersionUID = 933563214L;

    public static final QKakaoUser kakaoUser = new QKakaoUser("kakaoUser");

    public final StringPath userEmail = createString("userEmail");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public final EnumPath<openAPI.TmiBoard.contract.UserStatus> userStatus = createEnum("userStatus", openAPI.TmiBoard.contract.UserStatus.class);

    public QKakaoUser(String variable) {
        super(KakaoUser.class, forVariable(variable));
    }

    public QKakaoUser(Path<? extends KakaoUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKakaoUser(PathMetadata metadata) {
        super(KakaoUser.class, metadata);
    }

}

