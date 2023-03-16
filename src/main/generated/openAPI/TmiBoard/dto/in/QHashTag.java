package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHashTag is a Querydsl query type for HashTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHashTag extends EntityPathBase<HashTag> {

    private static final long serialVersionUID = 438765516L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHashTag hashTag = new QHashTag("hashTag");

    public final StringPath hashTagData = createString("hashTagData");

    public final NumberPath<Long> tagId = createNumber("tagId", Long.class);

    public final QTmiCard tmiCard;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QHashTag(String variable) {
        this(HashTag.class, forVariable(variable), INITS);
    }

    public QHashTag(Path<? extends HashTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHashTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHashTag(PathMetadata metadata, PathInits inits) {
        this(HashTag.class, metadata, inits);
    }

    public QHashTag(Class<? extends HashTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tmiCard = inits.isInitialized("tmiCard") ? new QTmiCard(forProperty("tmiCard"), inits.get("tmiCard")) : null;
    }

}

