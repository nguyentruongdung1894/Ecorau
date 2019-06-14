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

import ecorau.demo.entities.User;
import ecorau.demo.service.ServiceResult;
import ecorau.demo.service.UserService;

@RestController
@RequestMapping("/ecorau")
public class UserController {

	@Autowired
	private UserService customerService;

	/* ---------------- GET ALL User ------------------------ */
	@GetMapping("/get-all-user")
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(customerService.findAllUser(), HttpStatus.OK);
	}

	/* ---------------- GET User BY ID ------------------------ */
	@GetMapping("/get-user-by-id/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
		return new ResponseEntity<ServiceResult>(customerService.findByIdUser(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW User ------------------------ */
	@PostMapping("/create-user/{id}")
	public ResponseEntity<ServiceResult> create(@RequestBody User user,@PathVariable int id) {
		return new ResponseEntity<ServiceResult>(customerService.createUser(user,id), HttpStatus.OK);
	}

	/* ---------------- UPDATE User ------------------------ */
	@PutMapping("/update-user")
	public ResponseEntity<ServiceResult> update(@RequestBody User user) {
		return new ResponseEntity<ServiceResult>(customerService.updateUser(user), HttpStatus.OK);
	}

	/* ---------------- DELETE User ------------------------ */
	@DeleteMapping("/delete-user")
	public ResponseEntity<ServiceResult> delete(@RequestBody DeleteUserRequest request) {
		return new ResponseEntity<ServiceResult>(customerService.deleteUser(request.getId()), HttpStatus.OK);
	}

}
