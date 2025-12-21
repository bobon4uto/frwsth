package frwsth

import scala.scalajs.js
import scala.scalajs.js.annotation._

import org.scalajs.dom._
import org.scalajs.dom
import scala.util.Random
type Ctx2D = dom.CanvasRenderingContext2D

lazy val c = document.getElementById("game-canvas").asInstanceOf[html.Canvas];
lazy val crect = c.getBoundingClientRect();

def rec(x:Int,y:Int,xl:Int,yl:Int) :Rectangle= new Rectangle(new Point(x,y),new Point(xl,yl))
def poi(x:Int,y:Int) :Point = new Point (x,y)
var pl :Point = new Point(1,1)
var fgs : List [Figure] = List(
          new Rectangle(new Point(0, 0), new Point(c.width, c.height), "black",1),
          rec(50,100,200,100)
        )

object TrueMain {
  @main def main(): Unit =
    document.addEventListener(
      "DOMContentLoaded",
      _ => {
        c.init()

        c.draw(fgs);

        EventHandler.replaceMoveInput(EventHandler.nop);
        EventHandler.replacePressInput(EventHandler.collis);
        window.setInterval(()=>{Logic.loop()}, 100);
      }
    )
}
object Logic {
  def loop() = {
    fgs = for {f<-fgs} yield { f }
    c.clear()
    c.draw(fgs)
    c.draw(List(new Circle(pl, 10, "green", 3)))
  }
}
implicit class CanvasEx(can: html.Canvas) {
  def init() = {
    println(can)
    val w = 300
    c.width = w
    c.height = w
  }
  def clear() = {
    val ctx = c.getContext("2d").asInstanceOf[Ctx2D]
    ctx.clearRect(0, 0, c.width, c.height)
  }
  def draw(figs: List[Figure]) = {
    val ctx = c.getContext("2d").asInstanceOf[Ctx2D]
    figs.foreach(f => f.draw(ctx))
  }
}

object EventHandler {
  def replacePressInput(f: Point => Unit) = {
    c.addEventListener(
      "touchstart",
      (ev: dom.TouchEvent) => {
        for { e <- ev.touches } yield f(
          new Point(
            (e.clientX - c.getBoundingClientRect().left).toInt,
            (e.clientY - c.getBoundingClientRect().top).toInt
          )
        )
      }
    );
    c.onmousedown = { (e: dom.MouseEvent) =>
      f(
        new Point(
          (e.clientX - c.getBoundingClientRect().left).toInt,
          (e.clientY - c.getBoundingClientRect().top).toInt
        )
      )
    }
  }
  def replaceMoveInput(f: Point => Unit) = {
    c.addEventListener(
      "touchmove",
      (ev: dom.TouchEvent) => {
        for { e <- ev.touches } yield f(
          new Point(
            (e.clientX - c.getBoundingClientRect().left).toInt,
            (e.clientY - c.getBoundingClientRect().top).toInt
          )
        )
      }
    );
    c.onmousemove = { (e: dom.MouseEvent) =>
      f(
        new Point(
          (e.clientX - c.getBoundingClientRect().left).toInt,
          (e.clientY - c.getBoundingClientRect().top).toInt
        )
      )
    }
  }
  def nop(p:Point) = {}
  def collis(p:Point) = { 
    if (p.x>50 && p.x <250 && p.y> 100&& p.y<200){ 
      replaceMoveInput(draw)
      replacePressInput(addrandom)
      fgs = List (
        rec(0,0,300,300),
        Circle(poi(50,50),10),
        Circle(poi(90,100),50, "yellow", 30),
        Circle(poi(190,150),100, "magenta", 50),
        rec(10,10,10,10),
        )
    }
    draw(p)
  }
  def ri(n:Int):Int=Random.nextInt(n)
  def ria():Int=Random.nextInt()
  def randomColor():String = "#" + ria().toHexString
  def randomFigure(p:Point):Figure = {
    Random.nextInt(4) match  {
      case 0 => Circle(p, ri(100),randomColor(),ri(100) )
      case 1 => {
        val p1 = poi(p.x+ri(100),p.y+ri(100)); 
        val p2 = poi(p.x-ri(100),p.y-ri(100)); 
        val p3 = poi(p.x+ri(100),p.y-ri(100)); 
        Triangle(p1,p2,p3,randomColor(),ri(100) )}
      case 2 => {
        val dx = poi(ri(100),ri(100)); 
        val dy = poi(ri(100),ri(100)); 
        Rectangle(new Point(p.x-dx.x,p.y-dy.x),Point(p.x+dx.y,p.y+dy.y),randomColor(),ri(100))}
      case 3 => {
        val dx = poi(ri(100),ri(100)); 
        val dy = poi(ri(100),ri(100)); 
        Square(new Point(p.x-dx.x,p.y-dy.x),Point(p.x+dx.y,p.y+dy.y),randomColor(),ri(100))}
    }
  }
  def addrandom(p:Point) = {
    
    fgs = fgs :+ randomFigure(p) 
  }
  def draw(p: Point) = {
    c.clear()
    c.draw(fgs)
    pl = p
    c.draw(
      List(
        new Circle(p, 10, "green", 3)
      )
    )
  }
}
