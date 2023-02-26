package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTmiCard is a Querydsl query type for TmiCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTmiCard extends EntityPathBase<TmiCard> {

    private static final long serialVersionUID = -1462866848L;

    public static final QTmiCard tmiCard = new QTmiCard("tmiCard");

    public final StringPath cardColor = createString("cardColor");

    public final StringPath cardEmoji = createString("cardEmoji");

    public final NumberPath<Long> cardId = createNumber("cardId", Long.class);

    public final StringPath comments = createString("comments");

    public final StringPath hashTag = createString("hashTag");

    public final NumberPath<Long> kakaoUser_id = createNumber("kakaoUser_id", Long.class);

    public final StringPath title = createString("title");

    public QTmiCard(String variable) {
        super(TmiCard.class, forVariable(variable));
    }

    public QTmiCard(Path<? extends TmiCard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTmiCard(PathMetadata metadata) {
        super(TmiCard.class, metadata);
    }

}

