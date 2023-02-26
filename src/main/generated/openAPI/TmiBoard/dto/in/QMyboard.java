package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyboard is a Querydsl query type for Myboard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyboard extends EntityPathBase<Myboard> {

    private static final long serialVersionUID = 1252937946L;

    public static final QMyboard myboard = new QMyboard("myboard");

    public final StringPath birth = createString("birth");

    public final EnumPath<openAPI.TmiBoard.contract.BirthStatus> birthStatus = createEnum("birthStatus", openAPI.TmiBoard.contract.BirthStatus.class);

    public final StringPath emoji = createString("emoji");

    public final StringPath mbti = createString("mbti");

    public final StringPath myboardComments = createString("myboardComments");

    public final NumberPath<Long> myboardId = createNumber("myboardId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath url1 = createString("url1");

    public final StringPath url2 = createString("url2");

    public final StringPath url3 = createString("url3");

    public QMyboard(String variable) {
        super(Myboard.class, forVariable(variable));
    }

    public QMyboard(Path<? extends Myboard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyboard(PathMetadata metadata) {
        super(Myboard.class, metadata);
    }

}

