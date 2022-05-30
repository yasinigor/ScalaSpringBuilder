package org.springbuilder.businesslogic

import org.springbuilder.infrastructure.ObjectFactory


class CoronaDesinfector {
  val announcer : Announcer = ObjectFactory.createObject( classOf[Announcer])
  val policeman : Policemen = ObjectFactory.createObject( classOf[Policemen])

  def start(): Unit = {
    announcer.announce("Начинаем дезинфекцию, все вон!!!")
    policeman.makePeopleLeaveRoom()
    disinfect()
    announcer.announce("Дезинфекция окончена. Можете рискнуть вернуться назад!!!");
  }

  def disinfect() : Unit = {
    println("Читается молитва 'Корона - изыди!' - Молитва прочитана, вирус низвергнут в ад  ");
  }

}
