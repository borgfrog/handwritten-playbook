package controllers;

import play.*;
import play.data.*;
import play.data.validation.Constraints.Required;
import static play.data.Form.*;
import play.mvc.*;
import views.html.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static Result index(final String msg, final int id) {
		//return ok("<html><body><h1>Hi!</h1><p>This is test.</p></body></html>").as("text/xml");
		//return ok(index.render("テンプレートテスト"));
		//String msg = request().getQueryString("msg");
		return ok(index.render("Query(msg) - " + msg + ", (id) - " + id));
	}
	
}
