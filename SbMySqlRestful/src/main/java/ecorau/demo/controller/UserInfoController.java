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

import ecorau.demo.entities.UserInfo;
import ecorau.demo.service.ServiceResult;
import ecorau.demo.service.UserInfoService;

@RestController
@RequestMapping("/ecorau")
public class UserInfoController {
	@Autowired
	UserInfoService userinfoservice;

	/* ---------------- GET ALL UserInfo ------------------------ */
	@GetMapping("/get-all-userinfo")
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(userinfoservice.findAllUserInfo(), HttpStatus.OK);
	}

	/* ---------------- GET UserInfo BY ID ------------------------ */
	@GetMapping("/get-userinfo-by-id/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
		return new ResponseEntity<ServiceResult>(userinfoservice.findByIdUserInfo(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW UserInfo ------------------------ */
	@PostMapping("/create-userinfo")
	public ResponseEntity<ServiceResult> create(@RequestBody UserInfo userinfo) {
		return new ResponseEntity<ServiceResult>(userinfoservice.createUserInfo(userinfo), HttpStatus.OK);
	}

	/* ---------------- UPDATE UserInfo ------------------------ */
	@PutMapping("/update-userinfo")
	public ResponseEntity<ServiceResult> update(@RequestBody UserInfo userinfo) {
		return new ResponseEntity<ServiceResult>(userinfoservice.updateUserInfo(userinfo), HttpStatus.OK);
	}

	/* ---------------- DELETE UserInfo ------------------------ */
	@DeleteMapping("/delete-userinfo")
	public ResponseEntity<ServiceResult> delete(@RequestBody UserInfo userinfo) {
		return new ResponseEntity<ServiceResult>(userinfoservice.deleteUserInfo(userinfo.getUser_id()), HttpStatus.OK);
	}
}
