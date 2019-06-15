package ecorau.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "log_time_sheet")
public class Logtimesheet {
	@EmbeddedId
	private LogtimesheetPK logtimesheetpk;

	@Column(name = "role")
	private String role;

	@Column(name = "type")
	private String type;

	@Column(name = "hours")
	private int hours;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private Date date;

	public LogtimesheetPK getLongtimesheetpk() {
		return logtimesheetpk;
	}

	public void setLongtimesheetpk(LogtimesheetPK logtimesheetpk) {
		this.logtimesheetpk = logtimesheetpk;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Logtimesheet() {
		super();
	}

	public Logtimesheet(LogtimesheetPK logtimesheetpk, String role, String type, int hours, String description,
			Date date) {
		super();
		this.logtimesheetpk = logtimesheetpk;
		this.role = role;
		this.type = type;
		this.hours = hours;
		this.description = description;
		this.date = date;
	}

}
