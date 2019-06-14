package ecorau.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.entities.User;
import ecorau.demo.repository.UserRepository;
import ecorau.demo.service.ServiceResult.Status;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public ServiceResult findAllUser() {
		ServiceResult result = new ServiceResult();
		result.setData(userRepo.findAll());
		return result;
	}

	public ServiceResult findByIdUser(int id) {
		ServiceResult result = new ServiceResult();
		User user = userRepo.findById(id).orElse(null);// tra ve gia tri neu khac enpty nguoc lai thy throw NoSuchElementException
		result.setData(user);
		return result;
	}

	public ServiceResult createUser(User user) {
		ServiceResult result = new ServiceResult();
		result.setData(userRepo.save(user));
		return result;
	}

	public ServiceResult updateUser(User user) {
		ServiceResult result = new ServiceResult();
		if (!userRepo.findById(user.getId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("User Not Found");
		} else {
			result.setData(userRepo.save(user));
		}
		return result;
	}

	public ServiceResult deleteUser(int id) {
		ServiceResult result = new ServiceResult();
		User user = userRepo.findById(id).orElse(null);
		if (user == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("User Not Found");
		} else {
			userRepo.delete(user);
			result.setMessage("success");
		}
		return result;
	}
}
