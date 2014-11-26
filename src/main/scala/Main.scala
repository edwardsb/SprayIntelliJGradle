import akka.actor.{Props, ActorSystem}
import akka.io.IO
import akka.util.Timeout
import spray.can.Http
import scala.concurrent.duration._
import akka.pattern.ask

/**
 * Created by edwardsb on 11/25/14.
 */
object Main extends App {
//  def main(args: Array[String]) {
//    print("Hello world!")
//  }
  //println("hi")

  implicit val system = ActorSystem("on-spray-can")

  val service = system.actorOf(Props[MyServiceActor], "demo-service")

  implicit val timeout = Timeout(5.seconds)

  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)


}
