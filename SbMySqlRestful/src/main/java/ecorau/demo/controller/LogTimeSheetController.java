package ecorau.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecorau.demo.service.LogtimesheetService;
import ecorau.demo.service.ServiceResult;

@RestController
@RequestMapping("/ecorau")
public class LogTimeSheetController {
	@Autowired
	private LogtimesheetService logtimesheetService;

	/* ---------------- GET ALL longtimesheet ------------------------ */
	@GetMapping("/get-all-logtimesheet")
	public ResponseEntity<ServiceResult> findAll() {
		return new ResponseEntity<ServiceResult>(logtimesheetService.findAllLogTimeSheet(), HttpStatus.OK);
	}
}
