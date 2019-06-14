package ecorau.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.entities.UserInfo;
import ecorau.demo.repository.UserInfoReponsitory;
import ecorau.demo.repository.UserRepository;
import ecorau.demo.service.ServiceResult.Status;

@Service
public class UserInfoService {
	@Autowired
	UserInfoReponsitory userinforeponsitory;
	@Autowired
	UserRepository userreponsitory;

	public ServiceResult findAllUserInfo() {
		ServiceResult resul = new ServiceResult();
		resul.setData(userinforeponsitory.findAll());
		return resul;
	}

	public ServiceResult findByIdUserInfo(int id) {
		ServiceResult resul = new ServiceResult();
		UserInfo userinfo = userinforeponsitory.findById(id).orElse(null);
		resul.setData(userinfo);
		return resul;
	}

	public ServiceResult createUserInfo(UserInfo userinfo) {
		ServiceResult resul = new ServiceResult();
		resul.setData(userinforeponsitory.save(userinfo));
		return resul;
	}

	public ServiceResult updateUserInfo(UserInfo userinfo) {
		ServiceResult result = new ServiceResult();
		if (!userinforeponsitory.findById(userinfo.getUser_id()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("User-Info Not Found");
		} else {
			result.setData(userinforeponsitory.save(userinfo));
		}
		return result;
	}

	public ServiceResult deleteUserInfo(int id) {
		ServiceResult result = new ServiceResult();
		UserInfo userinfo = userinforeponsitory.findById(id).orElse(null);
		if (userinfo == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("User-Info Not Found");
		} else {
			userinforeponsitory.delete(userinfo);
			result.setMessage("success");
		}
		return result;
	}
}
