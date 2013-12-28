package models;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.annotation.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;
import play.libs.F.Tuple;
import scala.collection.mutable.Stack;

@Entity
public class Message extends Model {
	
	public static Finder<Long, Message> find = new Finder<Long, Message>(Long.class, Message.class);

	@Id
	public Long id;
	@Required(message = "必須項目")
	public String name;
	@Email(message = "メールアドレスを記入してください")
	public String mail;
	//@Pattern(message = "半角英数字のみ", value="[a-zA-Z]+")
	@Required(message = "必須項目")
	@ValidateWith(value = IsUrl.class, message = "http:// で始まるメッセージ")
	public String message;
	@CreatedTimestamp
	public Date postdate;

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", mail=" + mail
				+ ", message=" + message + ", postdate=" + postdate + "]";
	}
	
	public static class IsUrl extends Validator<String> {
		@Override
		public Tuple<String, Object[]> getErrorMessageKey() {
			return new Tuple<String, Object[]>("error.invalid", new String[]{});
		}
		@Override
		public boolean isValid(String s) {
			return s.toLowerCase().startsWith("http://");
		}
	}
}
