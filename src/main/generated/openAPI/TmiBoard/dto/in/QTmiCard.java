package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTmiCard is a Querydsl query type for TmiCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTmiCard extends EntityPathBase<TmiCard> {

    private static final long serialVersionUID = -1462866848L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTmiCard tmiCard = new QTmiCard("tmiCard");

    public final StringPath cardColor = createString("cardColor");

    public final StringPath cardEmoji = createString("cardEmoji");

    public final NumberPath<Long> cardId = createNumber("cardId", Long.class);

    public final StringPath comments = createString("comments");

    public final StringPath hashTag = createString("hashTag");

    public final QKakaoUser kakaoUser;

    public final StringPath title = createString("title");

    public QTmiCard(String variable) {
        this(TmiCard.class, forVariable(variable), INITS);
    }

    public QTmiCard(Path<? extends TmiCard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTmiCard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTmiCard(PathMetadata metadata, PathInits inits) {
        this(TmiCard.class, metadata, inits);
    }

    public QTmiCard(Class<? extends TmiCard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.kakaoUser = inits.isInitialized("kakaoUser") ? new QKakaoUser(forProperty("kakaoUser"), inits.get("kakaoUser")) : null;
    }

}

