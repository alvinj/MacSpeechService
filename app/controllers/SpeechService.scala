package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import utils._

case class TextToSpeak(text: String, voice: Option[String] = Some("Alex"))

object SpeechService extends Controller {
  
    // a mapping for the post data i expect
    val formMapping = mapping(
        "text"  -> nonEmptyText,
        "voice" -> optional(text)
    )(TextToSpeak.apply)(TextToSpeak.unapply)

    // turn the mapping into a form
    val form: Form[TextToSpeak] = Form(formMapping)

    // the method/action the user sends the data to
    def speak = Action { implicit request => 
        form.bindFromRequest.fold(
            errors => {
                // the form did not bind to the post data
                BadRequest("That didn't work")
            },
            postData => {
                // the form data bound, process it
                SpeechServiceUtils.runInThread(speakText(postData.text, postData.voice))
                Ok("Thanks")
            }
        ) 
    }

    private def speakText(sentence: String, voice: Option[String]) {
        voice match {
            case None    => SpeechServiceUtils.speak(sentence, Resources.ALEX_VOICE)
            case Some(v) => SpeechServiceUtils.speak(sentence, v)
        }
    }

}
