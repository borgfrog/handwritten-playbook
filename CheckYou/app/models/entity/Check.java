package models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import models.services.Check.CheckService;
import models.services.Check.CheckModelService;
import play.data.format.Formats.DateTime;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "checks")
public class Check extends Model {

	@Id
	public Long id;
	@Required
	public String name;
	@Required
	public String result;
	@DateTime(pattern="yyyy/mm/dd")
	public Date created;
	@DateTime(pattern="yyyy/mm/dd")
	public Date modified;

	@Transient
	private CheckService checkService = new CheckService();
	@Transient
	private CheckModelService checkModelService = new CheckModelService();
	
	/** *
	 * Empty constructor.
	 */
	public Check() {
		super();
	}
	
	/**
	 * @param id
	 */
	public Check(Long id) {
		this.id = id;
	}

	/**
	 * @param name
	 */
	public Check(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 * @param result
	 */
	public Check(String name, String result) {
		this.name = name;
		this.result = result;
		this.created = new Date();
		this.modified = new Date();
	}





	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}
	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}
