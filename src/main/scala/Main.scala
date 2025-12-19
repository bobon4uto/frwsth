package frwsth

import scala.scalajs.js
import scala.scalajs.js.annotation._

import org.scalajs.dom._
import org.scalajs.dom
@main def hello(): Unit =
  println("Hello world!")
def msg = "I was compiled by Scala 3. :)"
@JSExportTopLevel("EventHandler")
object EventHandler{
  @JSExport
def main(pre: html.Pre, c: html.Canvas ) :Unit  = 
  pre.onmousemove = {
    (e: dom.MouseEvent) =>
         Canvas.submain(c)
  }
}
@JSExportTopLevel("TheCanvas")
object Canvas {
  @JSExport
  def submain(c: html.Canvas) = {
    type Ctx2D =
      dom.CanvasRenderingContext2D
    val ctx = c.getContext("2d")
               .asInstanceOf[Ctx2D]
    val w = 300
    c.width = w
    c.height = w

    ctx.strokeStyle = "blue"
    ctx.lineWidth = 3
    ctx.beginPath()
    ctx.moveTo(w/2, 0)
    ctx.lineTo(w/2, w/3)
    ctx.moveTo(w*2/3, 0)
    ctx.lineTo(w*2/3, w/3)
    ctx.moveTo(w, w/2)
    ctx.arc(w/2, w/2, w/2, 0, 2.14)

    ctx.stroke()
  }
  @JSExport
  def main(c: html.Canvas) = {
    type Ctx2D =
      dom.CanvasRenderingContext2D
    val ctx = c.getContext("2d")
               .asInstanceOf[Ctx2D]
    val w = 300
    c.width = w
    c.height = w

    ctx.strokeStyle = "red"
    ctx.lineWidth = 3
    ctx.beginPath()
    ctx.moveTo(w/3, 0)
    ctx.lineTo(w/3, w/3)
    ctx.moveTo(w*2/3, 0)
    ctx.lineTo(w*2/3, w/3)
    ctx.moveTo(w, w/2)
    ctx.arc(w/2, w/2, w/2, 0, 3.14)

    ctx.stroke()
  }
}
@JSExportTopLevel("TheAlert")
object Alert {
  @JSExport
  def main() = {
    import org.scalajs.dom
    dom.window.alert("Hi from Scala-js-dom")
  }
}
