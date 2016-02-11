package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready. Pralav Dessai."))
  }

  def home = Action {
    Ok(views.html.home("Hello world"))
  }

  def d3 = Action {
    Ok(views.html.d3())
  }
  
  def d3_playground = Action {
    Ok(views.html.d3_playground())
  }
}
