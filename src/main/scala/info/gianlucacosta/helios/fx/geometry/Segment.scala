package info.gianlucacosta.helios.fx.geometry

import scalafx.geometry.Point2D
import scalafx.scene.shape.Line

case class Segment(startPoint: Point2D, endPoint: Point2D) {
  /**
   * Returns the middle point of the segment containing the given two points.
   */
  lazy val center: Point2D =
    new Point2D(
      (startPoint.x + endPoint.x) / 2,
      (startPoint.y + endPoint.y) / 2
    )
}
