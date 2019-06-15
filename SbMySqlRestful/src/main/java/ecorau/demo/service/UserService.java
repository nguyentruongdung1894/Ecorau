package ecorau.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.entities.Project;
import ecorau.demo.entities.User;
import ecorau.demo.repository.ProjectRepository;
import ecorau.demo.repository.UserRepository;
import ecorau.demo.service.ServiceResult.Status;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProjectRepository projectRepository;

	public ServiceResult findAllUser() {
		ServiceResult result = new ServiceResult();
		result.setData(userRepository.findAll());
		return result;
	}

	public ServiceResult findByIdUser(int id) {
		ServiceResult result = new ServiceResult();
		User user = userRepository.findById(id).orElse(null);// tra ve gia tri neu khac enpty nguoc lai thy throw
		// NoSuchElementException
		result.setData(user);
		return result;
	}

	public ServiceResult createUser(User user, int id) {
		ServiceResult result = new ServiceResult();
		Project pro = projectRepository.findById(id).orElse(null);
		User user1 = new User(user.getRole(), user.getUsername(), user.getPassword(),
				new HashSet<>(Arrays.asList(pro)));
		result.setData(userRepository.save(user1));
		return result;
	}

	public ServiceResult updateUser(User user) {
		ServiceResult result = new ServiceResult();
		if (!userRepository.findById(user.getId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("User Not Found");
		} else {
			result.setData(userRepository.save(user));
		}
		return result;
	}

	public ServiceResult deleteUser(int id) {
		ServiceResult result = new ServiceResult();
		User user = userRepository.findById(id).orElse(null);
		if (user == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("User Not Found");
		} else {
			userRepository.delete(user);
			result.setMessage("success");
		}
		return result;
	}
}
