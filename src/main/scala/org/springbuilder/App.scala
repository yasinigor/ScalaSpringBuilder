package org.springbuilder

import org.springbuilder.businesslogic.CoronaDesinfector

/**
 * @author ${igor.yasin}
 */
object App {
  
  def main(args : Array[String]) {
    val coronaDisinfector :CoronaDesinfector = new CoronaDesinfector();
    coronaDisinfector.start()
  }

}
