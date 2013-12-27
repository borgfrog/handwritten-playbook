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

	public static class FindForm {
		@Required
		public String input;
	}

	public static Result index() {
		List<Message> datas = Message.find.all();
		return ok(index.render("データベースのサンプル",datas));
	}

	public static Result add(){
		Form<Message> f = new Form(Message.class);
		return ok(add.render("投稿フォーム",f));
	}

	public static Result create(){
		Form<Message> f = new Form(Message.class).bindFromRequest();
		if (!f.hasErrors()){
			Message data = f.get();
			data.save();
			return redirect("/");
		} else {
			return badRequest(add.render("CREATE ERROR", f));
		}
	}

}
