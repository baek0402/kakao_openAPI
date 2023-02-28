package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKakaoUser is a Querydsl query type for KakaoUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKakaoUser extends EntityPathBase<KakaoUser> {

    private static final long serialVersionUID = 933563214L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QKakaoUser kakaoUser = new QKakaoUser("kakaoUser");

    public final QMyboard myBoard;

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath userEmail = createString("userEmail");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public final EnumPath<openAPI.TmiBoard.contract.UserStatus> userStatus = createEnum("userStatus", openAPI.TmiBoard.contract.UserStatus.class);

    public QKakaoUser(String variable) {
        this(KakaoUser.class, forVariable(variable), INITS);
    }

    public QKakaoUser(Path<? extends KakaoUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QKakaoUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QKakaoUser(PathMetadata metadata, PathInits inits) {
        this(KakaoUser.class, metadata, inits);
    }

    public QKakaoUser(Class<? extends KakaoUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.myBoard = inits.isInitialized("myBoard") ? new QMyboard(forProperty("myBoard"), inits.get("myBoard")) : null;
    }

}

