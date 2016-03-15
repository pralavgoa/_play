package controllers

import play.api._
import play.api.mvc._

import anorm._
import play.api.db._
import play.api.Play.current

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready. Pralav Dessai."))
  }

  def home = Action { 
    Ok(views.html.home("Hello world"+selectTableAccess))
  }

  def d3 = Action {
    Ok(views.html.d3())
  }
  
  def d3_playground = Action {
    Ok(views.html.d3_playground())
  }

  def d3_binary = Action {
    Ok(views.html.d3_binary())
  }

  def dashboard = Action {
    Ok(views.html.dashboard())
  }

  def selectTableAccess =  {
    var tableAccessEntriesAsString = ""
    // access "default" database
    DB.withConnection {implicit connection =>
    // do whatever you need with the connection
    val selectTableAccessEntries = SQL("SELECT * FROM TABLE_ACCESS")
    val tableAccessEntries = selectTableAccessEntries().map(row=>
      row[String]("C_NAME") -> row[String]("C_FULLNAME")
    ).toList
    tableAccessEntriesAsString = tableAccessEntries.toString
    }
    tableAccessEntriesAsString
  }
}
