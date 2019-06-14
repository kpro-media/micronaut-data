package io.micronaut.data.jdbc.annotation;

import io.micronaut.context.annotation.AliasFor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.operations.JdbcRepositoryOperations;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.model.query.builder.sql.SqlQueryBuilder;

import java.lang.annotation.*;

/**
 * Stereotype repository that configures a {@link Repository} as a {@link JdbcRepository} using
 * raw SQL encoding and {@link JdbcRepositoryOperations} as the runtime engine.
 *
 * @author graemerocher
 * @since 1.0.0
 */
@Repository(
    queryBuilder = SqlQueryBuilder.class,
    operations = JdbcRepositoryOperations.class,
    implicitQueries = false
)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Documented
public @interface JdbcRepository {
    /**
     * @return The dialect to use.
     */
    @AliasFor(annotation = Repository.class, member = "dialect")
    Dialect dialect() default Dialect.ANSI;

    /**
     * @return The dialect to use.
     */
    @AliasFor(annotation = Repository.class, member = "dialect")
    @AliasFor(annotation = JdbcRepository.class, member = "dialect")
    String dialectName() default "ANSI";
}
