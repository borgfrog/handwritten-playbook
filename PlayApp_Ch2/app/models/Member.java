package models;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", mail=" + mail
				+ ", tel=" + tel + "]";
	}

	public static Finder<Long, Member> find = new Finder<Long, Member>(Long.class, Member.class);

	public static Member findByNmae(String input) {
		return Member.find.where().eq("name", input).findList().get(0);
	}

}
