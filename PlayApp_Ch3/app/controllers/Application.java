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
	
	public static Result index() {
		List<Message> msgs = Message.find.all();
		return ok(index.render("please set form.", msgs));
	}

	/*
	 * Message Action
	 */
	public static Result add(){
		Form<Message> f = new Form(Message.class);
		List<Member> mems = Member.find.select("name").findList();
		return ok(add.render("投稿フォーム",f, mems));
	}

	public static Result create(){
		Form<Message> f = new Form(Message.class).bindFromRequest();
		if (!f.hasErrors()){
			Message data = f.get();
			data.member = Member.findByNmae(data.name);
			data.save();
			return redirect("/");
		} else {
			return badRequest(add.render("CREATE ERROR", f, null));
		}
	}
	
	/*
	 * Member Action
	 */
	public static Result add2(){
		Form<Member> f = new Form(Member.class);
		return ok(add2.render("投稿フォーム",f));
	}

	public static Result create2(){
		Form<Member> f = new Form(Member.class).bindFromRequest();
		if (!f.hasErrors()){
			Member data = f.get();
			data.save();
			return redirect("/");
		} else {
			return badRequest(add2.render("CREATE ERROR", f));
		}
	}

}
