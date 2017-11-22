/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package dao

import domain.Files
import java.io.Serializable

/**
 * Created by young on 2017/11/5.
 */
interface FileDao {
    fun uploadFile(file: Files): Int

    fun downLoadFile(id: Serializable): Files

    fun getAllFiles(uid: String): MutableList<Files>

    fun deleteFile(id: Serializable)

    fun getFile(id: Serializable): Files

    fun getOwnerFile(uid: String): MutableList<Files>
}