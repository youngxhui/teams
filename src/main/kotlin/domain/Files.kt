
package domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Created by young on 2017/11/5.
 */
@Entity
@Table(name = "files")
class Files {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var fid = 0
    lateinit var name: String
    lateinit var path: String
    lateinit var icon: String
    lateinit var contentType: String

    // 默认文件为公有文件
    var type: Int = 0

    var size: Float = 0f

    @ManyToOne(targetEntity = User::class)
    @JoinColumn(name = "uid")
    lateinit var user: User
}