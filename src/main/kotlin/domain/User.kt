package domain

import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Email
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

//    @Length(min = 2, max = 5, message = "姓名长度不符合要求")
    var username: String = "未填写"
    var nickname: String = UUID.randomUUID().toString().substring(0, 8)

//    @Length(min = 6, max = 18, message = "密码长度不符合要求")
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

//    @DecimalMax(value = "120", message = "您的年龄不符合要求")
    var age: Int = 18

    var sex: String = "保密"

//    @Past
    var birthday: Date = Date()
    var province: String = "北京"
    var city: String = "北京"
    var area: String = "北京"

//    @NotEmpty(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    lateinit var email: String

    var tel: String = "保密"

    @OneToMany(targetEntity = SignInfo::class)
    lateinit var signInfoSet: Set<SignInfo>

    @OneToMany(targetEntity = Files::class)
    lateinit var fileSet: Set<Files>

    @OneToMany(targetEntity = Group::class)
    lateinit var groupSet: Set<Group>


}

