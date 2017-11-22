package domain

import org.hibernate.annotations.GenericGenerator
import util.Md5Util
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * Created by young on 2017/10/24.
 */
@Entity
@Table(name = "user")
class User : Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var uid: Int = 0

    lateinit var username: String
    lateinit var nickname: String
    var password: String = ""
        set(password) {
            field = Md5Util.getText(password)
        }

    @Transient
    var rePassword: String = ""
        set(value) {
            field = Md5Util.getText(value)
        }
    var age: Int = 18
    lateinit var sex: String
    lateinit var birthday: Date
    lateinit var province: String
    lateinit var city: String
    lateinit var area: String
    lateinit var email: String
    lateinit var tel: String

    @OneToMany(targetEntity = SignInfo::class)
    lateinit var signInfoSet: Set<SignInfo>

    @OneToMany(targetEntity = Files::class)
    lateinit var fileSet: Set<Files>

    @OneToMany(targetEntity = Group::class)
    lateinit var groupSet: Set<Group>



}

