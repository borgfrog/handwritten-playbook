package controllers;

import play.*;
import play.data.*;
import play.data.validation.Constraints.Required;
import static play.data.Form.*;
import play.libs.Json;
import play.mvc.*;
import scala.Tuple12;
import scala.Tuple2;
import views.html.*;

import java.util.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.*;

public class Application extends Controller {
	
	public static Result index() {
		List<Message> msgs = Message.find.all();
		return ok(index.render("please set form.", msgs));
	}

	public static Result ajax() {
		String input = request().body().asFormUrlEncoded().get("input")[0];
		ObjectNode result = Json.newObject();
		if (input == null) {
			result.put("status", "BAD");
			result.put("message", "Can't get sending data...");
			return badRequest(result);
		} else {
			result.put("status", "OK");
			result.put("message", input);
			return ok(result);			
		}
	}
	
	/*
	 * Message Action
	 */
	public static Result add(){
		Form<Message> f = new Form(Message.class);
		List<Member> mems = Member.find.select("name").findList();
		List<Tuple2<String, String>> opts = new ArrayList<Tuple2<String, String>>();
		for (Member mem : mems) {
			opts.add(new Tuple2<String, String>(mem.name, mem.name));
		}
		return ok(add.render("投稿フォーム",f, opts));
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
