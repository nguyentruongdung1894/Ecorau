package ecorau.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecorau.demo.service.RelationService;
import ecorau.demo.service.ServiceResult;

@RestController
@RequestMapping("/ecorau")
public class RelationController {
	@Autowired
	private RelationService relationService;

	/* ---------------- GET ALL Relation ------------------------ */
	@GetMapping("/get-all-relation")
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(relationService.findAllRepository(), HttpStatus.OK);
	}
}
