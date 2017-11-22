package domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

/**
 * Created by young on 2017/11/20.
 */
@Entity
@Table(name = "pages")
class Page {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var pid: Int = 0

    lateinit var title: String

    @Column(length = Int.MAX_VALUE)
    lateinit var htmlText: String

    @ManyToOne(targetEntity = Group::class)
    @JoinColumn(name = "gid")
    lateinit var group: Group
}