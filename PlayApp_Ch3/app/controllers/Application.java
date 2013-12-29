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
		List<Member> datas2 = Member.find.all();
		return ok(index.render("データベースのサンプル",datas, datas2));
	}

	/*
	 * Message Action
	 */
	public static Result add(){
		Form<Message> f = new Form(Message.class);
		return ok(add.render("投稿フォーム",f));
	}

	public static Result create(){
		Form<Message> f = new Form(Message.class).bindFromRequest();
		if (!f.hasErrors()){
			Message data = f.get();
			data.member = Member.findByNmae(data.name);
			data.save();
			return redirect("/");
		} else {
			return badRequest(add.render("CREATE ERROR", f));
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

	/*
	public static Result setitem(){
		Form<Message> f = new Form(Message.class);
		return ok(item.render("ID番号を入力",f));
	}

	public static Result edit(){
		Form<Message> f = new Form(Message.class).bindFromRequest();
		if (!f.hasErrors()){
			Message obj = f.get();
			Long id = obj.id;
			obj = Message.find.byId(id);
			if (obj != null) {
				f = new Form(Message.class).fill(obj);
				return ok(edit.render("ID = " + id + "の投稿を編集", f));
			}
			return ok(edit.render("Edit Error : " + id + " is not found", f));
		} else {
			return ok(edit.render("EDIT ERROR : Invalid Input", f));
		}
	}

	public static Result update(){
		Form<Message> f = new Form(Message.class).bindFromRequest();
		if (!f.hasErrors()){
			Message data = f.get();
			data.update();
			return redirect("/");
		} else {
			return badRequest(add.render("UPDATE ERROR", f));
		}
	}

	public static Result delete(){
		Form<Message> f = new Form(Message.class);
		return ok(delete.render("削除するID番号を入力",f));
	}

	public static Result remove(){
		Form<Message> f = new Form(Message.class).bindFromRequest();
		if (!f.hasErrors()){
			Message obj = f.get();
			Long id = obj.id;
			obj = Message.find.byId(id);
			if (obj != null) {
				obj.delete();
				return redirect("/");
			}
			return ok(delete.render("Remove Error : " + id + " is not found", f));
		} else {
			return ok(delete.render("REMOVE ERROR : Invalid Input", f));
		}
	}

	public static Result find(){
		Form<FindForm> f = new Form(FindForm.class).bindFromRequest();
		List<Message> dates = null;
		if (!f.hasErrors()){
			String input = f.get().input;
			dates = Message.find.where().ilike("name", "%" + input + "%").orderBy("name")
					 .findPagingList(10).getPage(0).getList();
		}
		return badRequest(find.render("投稿の検索", f, dates));
	}
	 */
}
