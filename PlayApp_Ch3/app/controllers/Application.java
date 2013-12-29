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

	public static class SampleForm {
		public String input;
		public String pass;
		public boolean check;
		public String radio;
		public String sel;
		public String area;
		public Date date;
		
		@Override
		public String toString() {
			return "SampleForm [input=" + input + ", pass=" + pass + ", check="
					+ check + ", radio=" + radio + ", sel=" + sel + ", area="
					+ area + ", date=" + date + "]";
		}
	}
	
	public static Result index() {
		SampleForm sf = new SampleForm();
		sf.radio = "windows";
		sf.check = true;
		sf.input = "default value";
		sf.sel = "uk";
		Form<SampleForm> form = new Form(SampleForm.class).fill(sf);
		return ok(index.render("please set form.", form));
		/*
		String method = request().method();
		if ("GET".equals(method)) {
			return ok(index.render("please type :"));
		} else {
			Map<String, String[]> form = request().body().asFormUrlEncoded();
			String[] input = form.get("input");
			return ok(index.render("posted : " + input[0]));
		}
		*/
	}
	
	public static Result send() {
		Form<SampleForm> f = new Form(SampleForm.class).bindFromRequest();
		if (!f.hasErrors()) {
			return ok(index.render(f.get().toString(), f));
		} else {
			return badRequest(index.render("SEND ERROR", f));
		}
	}

}
