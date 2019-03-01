package hack

import scala.collection.mutable.ListBuffer
import scala.io.StdIn._
import scala.util._
import scala.io.Source

object Form {
  def formFill(): Array[Boolean] = {
    println(getClass.getResource(""))
    println("Заполните анкету: введите 1, если вы приветствуете это во взаимоотношениях/итересуетесь этим или 0, если нет")
    val items = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("form.txt")).getLines()
    val vect = ListBuffer[Boolean]()
    items.foreach(subject => {
      println(subject)
      val inp = readLine()
      vect += {Try(inp.toInt) match {
        case Success(value) if value > 0 => true
        case _ => false
      }}
    })
    vect.toArray
  }
}
