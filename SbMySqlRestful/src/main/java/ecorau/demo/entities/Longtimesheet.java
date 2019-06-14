package ecorau.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "log_time_sheet")
public class Longtimesheet {
	@EmbeddedId
	private LongtimesheetPK longtimesheetpk;

	@ManyToOne
	@MapsId("project_id")
	private Project project;

	@ManyToOne
	@MapsId("user_id")
	private User user;

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

}
