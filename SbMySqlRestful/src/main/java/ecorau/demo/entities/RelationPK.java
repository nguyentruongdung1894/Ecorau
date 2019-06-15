package ecorau.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RelationPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private int user_id;

	@Column(name = "project_id")
	private int project_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public RelationPK(int user_id, int project_id) {
		super();
		this.user_id = user_id;
		this.project_id = project_id;
	}

	public RelationPK() {
		super();
	}

}
