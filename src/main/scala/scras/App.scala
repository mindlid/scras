package scras

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.{Fragment, ReactElement}
import slinky.web.html._

import scala.scalajs.js

@react class App extends StatelessComponent {
  type Props = Unit

  private val iconNames = Seq("currency_exchange", "face")
  private val iconsMappedReact =
    iconNames.map(iconName => MaterialIcon(iconName, color = "red"))
  private val iconsArrayReact: Seq[ReactElement] = Seq(
    MaterialIcon("face", color = "red"),
    MaterialIcon("currency_exchange")
  )

  def render() = {
    Fragment()(
      div(
        style := js.Dynamic.literal(display = "flex", justifyContent = "center")
      )(
        h1(className := "App-title")("Slink/Scala.js native material-icons")
      ),
      div(
        className := "App",
        style := js.Dynamic
          .literal(display = "flex", flexDirection = "column", fontSize = 36)
      )(
        MaterialIcon("face", color = "red"),
        MaterialIcon("whatsapp", color = "green"),
        MaterialIcon("currency_exchange"),
        MaterialIcon("verified", "64px", "brown")
      )
    )
  }
}

@react object MaterialIcon {
  case class Props(
      iconName: String,
      fontSize: String = "inherit",
      color: String = "inherit"
  )
  val component = FunctionalComponent[Props] { props =>
    {
      val spanStyle = js.Dynamic.literal(
        fontSize = props.fontSize,
        color = props.color
      )
      span(
        className := "material-icons",
        style := spanStyle
      )(props.iconName)
    }
  }
}
