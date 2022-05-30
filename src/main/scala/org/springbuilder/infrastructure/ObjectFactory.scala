package org.springbuilder.infrastructure

import org.springbuilder.businesslogic.{Announcer, ConsoleAnnouncer, Policemen, PolicemenImpl}

import scala.collection.mutable.HashMap

object ObjectFactory {
  val ifc2implclass = new HashMap[Class[_], Class[_]](){
    put(classOf[Policemen],classOf[PolicemenImpl])
    put(classOf[Announcer], classOf[ConsoleAnnouncer])
  }
  val config = new ScalaConfig("ru.home", ifc2implclass)

  def createObject[T]( implClass : Class[T]) : T = {
    var impl = implClass
    if (implClass.isInterface) {
      impl = config.getImplClass(implClass)
    }
    val c = impl.getDeclaredConstructor().newInstance()
    c
  }
}
