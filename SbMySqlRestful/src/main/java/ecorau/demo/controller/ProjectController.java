package ecorau.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecorau.demo.entities.Project;
import ecorau.demo.service.ProjectService;
import ecorau.demo.service.ServiceResult;

@RestController
@RequestMapping("/ecorau")
public class ProjectController {
	@Autowired
	private ProjectService projectservice;

	/* ---------------- GET ALL Project ------------------------ */
	@GetMapping("/get-all-project")
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(projectservice.findAllProject(), HttpStatus.OK);
	}

	/* ---------------- GET Project BY ID ------------------------ */
	@GetMapping("/get-project-by-id/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
		return new ResponseEntity<ServiceResult>(projectservice.findByIdProject(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW Project ------------------------ */
	@PostMapping("/create-project")
	public ResponseEntity<ServiceResult> create(@RequestBody Project project) {
		return new ResponseEntity<ServiceResult>(projectservice.createProject(project), HttpStatus.OK);
	}

	/* ---------------- UPDATE Project ------------------------ */
	@PutMapping("/update-project")
	public ResponseEntity<ServiceResult> update(@RequestBody Project project) {
		return new ResponseEntity<ServiceResult>(projectservice.updateProject(project), HttpStatus.OK);
	}

	/* ---------------- DELETE Project ------------------------ */
	@DeleteMapping("/delete-project")
	public ResponseEntity<ServiceResult> delete(@RequestBody Project project) {
		return new ResponseEntity<ServiceResult>(projectservice.deleteProject(project.getProject_id()), HttpStatus.OK);
	}
}
