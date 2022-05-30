package org.springbuilder.infrastructure

import java.util
import scala.collection.mutable
import org.reflections.Reflections
import scala.language.postfixOps

class ScalaConfig(packageToScan: String, ifc2ImplClass: mutable.HashMap[Class[_], Class[_]]) extends Config {
  val scanner = new Reflections(packageToScan)

  def getImplClass[T](ifc: Class[T]): Class[T] =
    if (ifc2ImplClass.contains(ifc)) ifc2ImplClass.getOrElse(ifc, sys.error(s"unexpected key: $ifc")).asInstanceOf[Class[T]]
    else {
      val classes: util.Set[Class[Comparable[T]]] = scanner.getSubTypesOf(ifc).asInstanceOf[util.Set[Class[Comparable[T]]]]
      if (classes.size != 1) throw new RuntimeException(ifc + " has 0 or more than 1 impl, please update your config")
      classes.iterator.next.asInstanceOf[Class[T]]
    }

}
