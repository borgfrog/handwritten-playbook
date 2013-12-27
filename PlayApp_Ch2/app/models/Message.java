package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.annotation.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Message extends Model {
	
	public static Finder<Long, Message> find = new Finder<Long, Message>(Long.class, Message.class);

	@Id
	public Long id;
	@Required
	public String name;
	
	public String mail;
	@Required
	public String message;
	@CreatedTimestamp
	public Date postdate;

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", mail=" + mail
				+ ", message=" + message + ", postdate=" + postdate + "]";
	}
}
