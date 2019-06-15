package ecorau.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ecorau.demo.entities.UserRest;
import ecorau.demo.service.JwtService;
import ecorau.demo.service.UserRestService;

@RestController
@RequestMapping("/ecorau")
public class UserRestController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserRestService userrestService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(HttpServletRequest request, @RequestBody UserRest userrest) {
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if (userrestService.checkLogin(userrest)) {
				result = jwtService.generateTokenLogin(userrest.getUsername());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong userId and password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception ex) {
			result = "Server Error";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}
