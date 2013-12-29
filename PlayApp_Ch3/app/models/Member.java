package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Member extends Model {

	@Id
	public Long id;
	@Required(message = "必須項目")
	public String name;
	@Required(message = "メールアドレスを記入してください")
	public String mail;
	
	public String tel;
	
	@OneToMany(cascade = CascadeType.ALL)
	public List<Message> messages = new ArrayList<Message>();
	
	@Override
	public String toString() {
		String ids = "{id=";
		for (Message m : messages) {
			ids += " " + m.id;
		}
		ids += "}";
		return "Member [id=" + id + ", message=" + ids + ", name=" + name + ", mail=" + mail
				+ ", tel=" + tel + "]";
	}

	public static Finder<Long, Member> find = new Finder<Long, Member>(Long.class, Member.class);

	public static Member findByNmae(String input) {
		return Member.find.where().eq("name", input).findList().get(0);
	}

}
