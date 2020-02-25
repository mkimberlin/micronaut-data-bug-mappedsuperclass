package demo

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@JdbcRepository(dialect = Dialect.POSTGRES)
interface ResponseKeyRepository : CrudRepository<ResponseKey, UUID> {
    override fun <S : ResponseKey> saveAll(entities: @Valid @NotNull Iterable<S>): List<S>
    override fun <S : ResponseKey> save(entity: @Valid @NotNull S): S
}
