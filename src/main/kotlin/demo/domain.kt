package demo

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @Column(name = "baseid")
    @AutoPopulated
    var id: UUID? = null

    @Column(name = "issuedon")
    @DateCreated
    var issuedOn: LocalDateTime? = null

    @Column(name = "used")
    var used = false

    @DateUpdated
    var ut: Long? = null

    var nt: String? = null

}

@Table(name = "admin")
@Entity
class User
//{
//}
    : BaseEntity() {
/*
    @Id
    @GeneratedValue
    var id: Long? = null
*/

    var name: String = ""

    var phone: String = ""

    var password: String = ""
}


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
