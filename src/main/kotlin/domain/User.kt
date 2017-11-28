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

    var username: String = "未填写"
    var nickname: String = UUID.randomUUID().toString().substring(0, 8)

    var password: String = ""
        set(password) {
            field = Md5Util.getText(password)
        }

    var headPicPath: String = "defaultPic.png"

    @Transient
    var rePassword: String = ""
        set(value) {
            field = Md5Util.getText(value)
        }

    var age: Int = 18

    var sex: String = "保密"

    var birthday: Date = Date()
    var province: String = "北京"
    var city: String = "北京"
    var area: String = "北京"

    lateinit var email: String

    var tel: String = "保密"

    @OneToMany(targetEntity = SignInfo::class)
    lateinit var signInfoSet: Set<SignInfo>

    @OneToMany(targetEntity = Files::class)
    lateinit var fileSet: Set<Files>

    @OneToMany(targetEntity = Group::class)
    lateinit var groupSet: Set<Group>

    var faceId = false

}

