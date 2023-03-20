package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTmiCardLike is a Querydsl query type for TmiCardLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTmiCardLike extends EntityPathBase<TmiCardLike> {

    private static final long serialVersionUID = -1994039273L;

    public static final QTmiCardLike tmiCardLike = new QTmiCardLike("tmiCardLike");

    public final NumberPath<Long> cardId = createNumber("cardId", Long.class);

    public final NumberPath<Long> likeId = createNumber("likeId", Long.class);

    public final EnumPath<openAPI.TmiBoard.contract.Interact> likeStatus = createEnum("likeStatus", openAPI.TmiBoard.contract.Interact.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QTmiCardLike(String variable) {
        super(TmiCardLike.class, forVariable(variable));
    }

    public QTmiCardLike(Path<? extends TmiCardLike> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTmiCardLike(PathMetadata metadata) {
        super(TmiCardLike.class, metadata);
    }

}

