package demo

import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue
    var id: Long? = null

    @DateCreated
    var ct: Long? = null

    @AutoPopulated
    var uuid: UUID? = null

    @DateUpdated
    var ut: Long? = null

    var nt: String? = null

}

@Entity
class User : BaseEntity() {
    var name: String = ""

    var phone: String = ""

    var password: String = ""
}
