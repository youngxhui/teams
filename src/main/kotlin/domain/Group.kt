package domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Created by young on 2017/11/18.
 */
@Entity
@Table(name = "groups")
class Group {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var gid: Int = 0

    lateinit var groupName: String

    lateinit var adminId: String


    @ManyToOne(targetEntity = User::class)
    @JoinColumn(name = "uid")
    lateinit var user: User
    // 经度
    var lng: Double = 0.0
    // 纬度
    var lat: Double = 0.0
    // 定位误差
    var locError: Int = 1

    var note: String = "组长很懒，什么都没写"

    var summary: String = "组长很懒，什么都没写"

    @OneToMany(targetEntity = Page::class)
    lateinit var pageSet: Set<Page>
}