package dao

import domain.SignInfo

/**
 * Created by young on 2017/11/9.
 */
interface SignDao {
    fun save(signInfo: SignInfo)
}