import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._
/**
 * Created by edwardsb on 11/26/14.
 */
class MyServiceActor extends Actor with MyService{

  def actorRefFactory = context
  def receive = runRoute(myRoute)

}

trait MyService extends HttpService {

  val myRoute =
  path("") {
    get {
      respondWithMediaType(`text/html`){
        complete {
          <html>hi</html>
        }
      }
    }
  }
}
