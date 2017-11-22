package util

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration


/**
 * @author young
 */
object SessionFactory {
    private val ourSessionFactory: SessionFactory

    init {
        val configuration = Configuration()
        configuration.configure()
        ourSessionFactory = configuration.buildSessionFactory()
    }

    fun getSession(): Session = ourSessionFactory.openSession()

}




