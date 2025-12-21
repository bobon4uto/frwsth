package frwsth

import scala.scalajs.js
import scala.scalajs.js.annotation._

import org.scalajs.dom._
import org.scalajs.dom

type Ctx2D = dom.CanvasRenderingContext2D

lazy val c = document.getElementById("game-canvas").asInstanceOf[html.Canvas];
lazy val crect= c.getBoundingClientRect();
object TrueMain {
  @main def main(): Unit =
    document.addEventListener(
      "DOMContentLoaded",
      _ => {
        c.init()

        val fgs = List(
          new Triangle(new Point(100,100), new Point(400,400),new Point(200,400)),
          new Square(new Point(100,100), new Point(300,300)),
          new Circle(new Point(300,300),100),
          )
        c.draw(fgs)

        c.onmousemove = {
    (e: dom.MouseEvent) =>
      c.draw(List(
        new Circle(new Point((e.clientX - c.getBoundingClientRect().left).toInt ,(e.clientY - c.getBoundingClientRect().top).toInt), 5,"blue",2)
        ))
  }

      }
    )
}
implicit class CanvasEx(can: html.Canvas) {
  def init() = {
    println(can)
    val w = 600
    c.width = w
    c.height = w
  }
  def draw(figs: List[Figure]) = {
    val ctx = c.getContext("2d").asInstanceOf[Ctx2D]
    figs.foreach(f => f.draw(ctx))
  }
}

@JSExportTopLevel("EventHandler")
object EventHandler {
  @JSExport
  def main(pre: html.Pre, c: html.Canvas): Unit =
    pre.onmousemove = { (e: dom.MouseEvent) => {} }
  @JSExport
  def nmain(e: dom.Event): Unit =
    println(e);
}
