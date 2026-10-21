package info.gianlucacosta.helios.fx.scene

import java.io.OutputStream
import javafx.embed.swing.SwingFXUtils
import scalafx.scene.input.MouseEvent

import javax.imageio.ImageIO
import scala.language.implicitConversions
import scalafx.scene.{Node, SnapshotParameters}
import scalafx.Includes._

/**
  * Generic FX node extensions
  *
  * @param node
  */
class NodeExtensions private[fx](node: Node) {
  /**
    * Exports the node as an image.
    *
    * @param targetStream The target stream
    * @param format       The image format, as a string. Defaults to <i>png</i>
    */
  def exportAsImage(targetStream: OutputStream, format: String = "png"): Unit = {
    val snapshotImage =
      node.snapshot(
        new SnapshotParameters(),
        null
      )

    ImageIO.write(
      SwingFXUtils.fromFXImage(snapshotImage, null),
      format,
      targetStream
    )
  }

  /**
   * Consumes mouse events, so that they won't bubble up to parent nodes.
   */
  def consumeMouseEvents(): Unit = {
    node.handleEvent(MouseEvent.Any) {
      (mouseEvent: MouseEvent) => {
        mouseEvent.consume()
      }
    }
  }
}
