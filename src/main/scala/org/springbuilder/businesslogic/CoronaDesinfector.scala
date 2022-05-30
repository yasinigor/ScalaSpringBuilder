package org.springbuilder.businesslogic

class CoronaDesinfector {
  val announcer : Announcer = new ConsoleAnnouncer()
  val policeman : Policemen = new PolicemenImpl()

  def start(): Unit = {
    announcer.announce("Начинаем дезинфекцию, все вон!!!")
    policeman.makePeopleLeaveRoom()
    disinfect()
    announcer.announce("Начинаем дезинфекцию, все вон!!!");
  }

  def disinfect() : Unit = {
    println("Читается молитва 'Корона - изыди!' - Молитва прочитана, вирус низвергнут в ад  ");
  }

}
