package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTmiCardLike is a Querydsl query type for TmiCardLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTmiCardLike extends EntityPathBase<TmiCardLike> {

    private static final long serialVersionUID = -1994039273L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTmiCardLike tmiCardLike = new QTmiCardLike("tmiCardLike");

    public final QKakaoUser kakaoUser;

    public final NumberPath<Long> likeId = createNumber("likeId", Long.class);

    public final EnumPath<openAPI.TmiBoard.contract.Interact> likeStatus = createEnum("likeStatus", openAPI.TmiBoard.contract.Interact.class);

    public final QTmiCard tmiCard;

    public QTmiCardLike(String variable) {
        this(TmiCardLike.class, forVariable(variable), INITS);
    }

    public QTmiCardLike(Path<? extends TmiCardLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTmiCardLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTmiCardLike(PathMetadata metadata, PathInits inits) {
        this(TmiCardLike.class, metadata, inits);
    }

    public QTmiCardLike(Class<? extends TmiCardLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.kakaoUser = inits.isInitialized("kakaoUser") ? new QKakaoUser(forProperty("kakaoUser"), inits.get("kakaoUser")) : null;
        this.tmiCard = inits.isInitialized("tmiCard") ? new QTmiCard(forProperty("tmiCard"), inits.get("tmiCard")) : null;
    }

}

