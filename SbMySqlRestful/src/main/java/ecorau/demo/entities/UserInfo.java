package ecorau.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {
	@Id
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "job")
	private String job;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "user_id")
	private User user;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
