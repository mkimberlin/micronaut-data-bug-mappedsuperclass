package demo

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.model.naming.NamingStrategies
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "responsekeys")
class ResponseKey {
    @Id
    @Column(name = "responsekey")
    @AutoPopulated
    var responseKey: UUID? = null

    @Column(name = "issuedon")
    @DateCreated
    var issuedOn: LocalDateTime? = null

    @Column(name = "used")
    var isUsed = false

    constructor() {}
    constructor(responseKey: UUID?, issuedOn: LocalDateTime?, used: Boolean) {
        this.responseKey = responseKey
        this.issuedOn = issuedOn
        isUsed = used
    }
}