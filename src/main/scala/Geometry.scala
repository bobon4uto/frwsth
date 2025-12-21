package frwsth

class Point(xnew: Int, ynew: Int) {
  val x = xnew
  val y = ynew
  def +(add: Point): Point = new Point(x + add.x, y + add.y)
  def +-(add: Int): Point = new Point(x + add, y)
  def ++(add: Int): Point = new Point(x, y + add)
}
trait Figure {
  private val _ps: List[Point] = List()
  private val _color: String = ""
  private val _linew: Int = 0
  def draw(ctx: Ctx2D) = {
    if (this._ps.size == 0) {}
    else {
      ctx.strokeStyle = this._color
      ctx.lineWidth = this._linew
      ctx.beginPath()
      ctx.moveTo(this._ps.last.x, this._ps.last.y)
      for { p <- this._ps } {
        ctx.lineTo(p.x, p.y)
      }
      ctx.stroke();
    }
  }
}
class Rectangle(pos: Point, size: Point, color: String, linew: Int)
    extends Figure {
  private val _ps: List[Point] =
    List(pos, pos +- size.x, pos + size, pos ++ size.y)
  private val _color: String = color
  private val _linew: Int = linew
  def this(pos: Point, size: Point) = this(pos, size, "red", 3)
  override def draw(ctx: Ctx2D) = {
    if (this._ps.size == 0) {}
    else {
      ctx.fillStyle = this._color
      ctx.fillRect(_ps(0).x, _ps(0).y, _ps(2).x - _ps(0).x, _ps(2).y - _ps(0).y);
    }
  }
}
class Square(pos: Point, size: Point, color: String, linew: Int)
    extends Figure {
  private val _ps: List[Point] =
    List(pos, pos +- size.x, pos + size, pos ++ size.y)
  private val _color: String = color
  private val _linew: Int = linew
  def this(pos: Point, size: Point) = this(pos, size, "red", 3)
  override def draw(ctx: Ctx2D) = {
    if (this._ps.size == 0) {}
    else {
      ctx.strokeStyle = this._color
      ctx.lineWidth = this._linew
      ctx.beginPath()
      ctx.moveTo(this._ps.last.x, this._ps.last.y)
      for { p <- this._ps } {
        ctx.lineTo(p.x, p.y)
      }
      ctx.stroke();
    }
  }
  /*
  override def draw(ctx: Ctx2D) = {
    ctx.strokeStyle = this._color
    ctx.lineWidth = this._linew
    ctx.beginPath()
    ctx.moveTo(pos.x, pos.y)
    ctx.lineTo(size.x, pos.y)
    ctx.moveTo(pos.x, pos.y)
    ctx.lineTo(pos.x, size.y)
    ctx.moveTo(size.x, size.y)
    ctx.lineTo(size.x, pos.y)
    ctx.moveTo(size.x, size.y)
    ctx.lineTo(pos.x, size.y)

    ctx.stroke()

  }*/
}
class Triangle(p1: Point, p2: Point, p3: Point, color: String, linew: Int)
    extends Figure {
  private val _ps: List[Point] =
    List(p1, p2, p3)
  private val _color: String = color
  private val _linew: Int = linew
  def this(p1: Point, p2: Point, p3: Point) = this(p1, p2, p3, "blue", 2)
  override def draw(ctx: Ctx2D) = {
    if (this._ps.size == 0) {}
    else {
      ctx.strokeStyle = this._color
      ctx.lineWidth = this._linew
      ctx.beginPath()
      ctx.moveTo(this._ps.last.x, this._ps.last.y)
      for { p <- this._ps } {
        ctx.lineTo(p.x, p.y)
      }
      ctx.stroke();
    }
  }
//    override def draw(ctx: Ctx2D) = {
//      ctx.strokeStyle = this._color
//      ctx.lineWidth = this._linew
//      ctx.beginPath()
//      ctx.moveTo((pos.x + size.x) / 2, pos.y)
//      ctx.lineTo(size.x, size.y)
//      ctx.moveTo((pos.x + size.x) / 2, pos.y)
//      ctx.lineTo(pos.x, size.y)
//      ctx.moveTo(pos.x, size.y)
//      ctx.lineTo(size.x, size.y)
//
//      ctx.stroke()
//
//    }
}
class Circle(pos: Point, size: Int, color: String, linew: Int) extends Figure {
  private val _ps: List[Point] =
    List(pos, new Point(size, size))
  private val _color: String = color
  private val _linew: Int = linew
  def this(pos: Point, size: Int) = this(pos, size, "green", 3)

  override def draw(ctx: Ctx2D) = {
    ctx.strokeStyle = this._color
    ctx.lineWidth = this._linew
    ctx.beginPath();
    ctx.arc(_ps(0).x, _ps(0).y, _ps(1).x, 0, 2 * Math.PI);
    ctx.stroke()

  }
}
var figures: List[Figure] = List()
