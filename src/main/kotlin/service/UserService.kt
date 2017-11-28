package service

import domain.User
import java.io.File

/**
 * Created by young on 2017/10/27.
 */
interface UserService {
    fun register(user: User): Int
    fun login(user: User): List<User>?
    fun update(user: User, headPic: File, headFileName: String): User
    fun addFace(facePic: String, user: User): Int
    fun getUser(uid: Int): User
    fun faceLogin(facePic: String): User
}