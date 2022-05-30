package org.springbuilder.businesslogic

class ConsoleAnnouncer extends Announcer {
  override def announce(message: String): Unit = println(message)
}
