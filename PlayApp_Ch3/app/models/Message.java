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
	@Required(message = "必須項目")
	public String message;
	@CreatedTimestamp
	public Date postdate;
	@ManyToOne(cascade = CascadeType.ALL)
	public Member member;

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name /* + ", mail=" + mail */
				+ ", member:<" + member.name + ", " + member.mail + ">"
				+ ", message=" + message + ", postdate=" + postdate + "]";
	}
	
	public static Message findByNmae(String input) {
		return Message.find.where().eq("name", input).findList().get(0);
	}
}
