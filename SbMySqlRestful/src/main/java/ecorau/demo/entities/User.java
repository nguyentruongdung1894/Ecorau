package ecorau.demo.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "role")
	private String role;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "relation", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "project_id") })
	private Set<Project> project;

	public Set<Project> getProducts() {
		return project;
	}

	public void setProducts(Set<Project> project) {
		this.project = project;
	}

	public User() {
		super();
	}

	public User(String role, String username, String password, Set<Project> project) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.project = project;
	}
	
//	@OneToMany(mappedBy = "longtimesheet")
//    private List<Longtimesheet> longtimesheet;
}