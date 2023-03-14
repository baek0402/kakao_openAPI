package openAPI.TmiBoard.dto.in;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyboard is a Querydsl query type for Myboard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyboard extends EntityPathBase<Myboard> {

    private static final long serialVersionUID = 1252937946L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyboard myboard = new QMyboard("myboard");

    public final StringPath birth = createString("birth");

    public final EnumPath<openAPI.TmiBoard.contract.BirthStatus> birthStatus = createEnum("birthStatus", openAPI.TmiBoard.contract.BirthStatus.class);

    public final StringPath emoji = createString("emoji");

    public final QKakaoUser kakaoUser;

    public final StringPath mbti = createString("mbti");

    public final StringPath myboardComments = createString("myboardComments");

    public final NumberPath<Long> myboardId = createNumber("myboardId", Long.class);

    public final EnumPath<openAPI.TmiBoard.contract.MyboardStatus> myboardStatus = createEnum("myboardStatus", openAPI.TmiBoard.contract.MyboardStatus.class);

    public final StringPath name = createString("name");

    public final StringPath url1 = createString("url1");

    public final StringPath url2 = createString("url2");

    public final StringPath url3 = createString("url3");

    public QMyboard(String variable) {
        this(Myboard.class, forVariable(variable), INITS);
    }

    public QMyboard(Path<? extends Myboard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyboard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyboard(PathMetadata metadata, PathInits inits) {
        this(Myboard.class, metadata, inits);
    }

    public QMyboard(Class<? extends Myboard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.kakaoUser = inits.isInitialized("kakaoUser") ? new QKakaoUser(forProperty("kakaoUser"), inits.get("kakaoUser")) : null;
    }

}

