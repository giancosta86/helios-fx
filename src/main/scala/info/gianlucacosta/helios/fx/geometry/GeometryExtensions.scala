package info.gianlucacosta.helios.fx.geometry

import scala.language.implicitConversions
import scalafx.geometry.{Bounds, Point2D}
import scalafx.scene.input.MouseEvent

object GeometryExtensions {
  implicit def convertBounds(bounds: Bounds): BoundsExtensions =
    new BoundsExtensions(bounds)

  implicit def convertMouseEvent(mouseEvent: MouseEvent): MouseEventExtensions =
    new MouseEventExtensions(mouseEvent)

  implicit def convertPoint2D(source: Point2D): Point2DExtensions =
    new Point2DExtensions(new Point2D(source.x, source.y))
}