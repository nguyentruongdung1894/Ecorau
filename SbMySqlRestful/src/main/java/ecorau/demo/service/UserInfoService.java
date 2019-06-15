package ecorau.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.entities.UserInfo;
import ecorau.demo.repository.UserInfoRepository;
import ecorau.demo.service.ServiceResult.Status;

@Service
public class UserInfoService {
	@Autowired
	UserInfoRepository userinfoRepository;

	public ServiceResult findAllUserInfo() {
		ServiceResult resul = new ServiceResult();
		resul.setData(userinfoRepository.findAll());
		return resul;
	}

	public ServiceResult findByIdUserInfo(int id) {
		ServiceResult resul = new ServiceResult();
		UserInfo userinfo = userinfoRepository.findById(id).orElse(null);
		resul.setData(userinfo);
		return resul;
	}

	public ServiceResult createUserInfo(UserInfo userinfo) {
		ServiceResult resul = new ServiceResult();
		resul.setData(userinfoRepository.save(userinfo));
		return resul;
	}

	public ServiceResult updateUserInfo(UserInfo userinfo) {
		ServiceResult result = new ServiceResult();
		if (!userinfoRepository.findById(userinfo.getUser_id()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("User-Info Not Found");
		} else {
			result.setData(userinfoRepository.save(userinfo));
		}
		return result;
	}

	public ServiceResult deleteUserInfo(int id) {
		ServiceResult result = new ServiceResult();
		UserInfo userinfo = userinfoRepository.findById(id).orElse(null);
		if (userinfo == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("User-Info Not Found");
		} else {
			userinfoRepository.delete(userinfo);
			result.setMessage("success");
		}
		return result;
	}
}
