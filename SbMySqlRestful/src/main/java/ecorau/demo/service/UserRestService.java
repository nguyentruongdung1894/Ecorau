package ecorau.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.entities.UserRest;
import ecorau.demo.repository.UserRestRepository;

@Service
public class UserRestService {
	@Autowired
	UserRestRepository userrestRepository;

	public List<UserRest> listUser = new ArrayList<UserRest>();

	public List<UserRest> findAll() {
		listUser = userrestRepository.findAll();
		return listUser;
	}

	public UserRest findById(int id) {
		listUser = userrestRepository.findAll();
		for (UserRest user : listUser) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public boolean add(UserRest user) {
		listUser = userrestRepository.findAll();
		for (UserRest userExist : listUser) {
			if (user.getId() == userExist.getId() || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
				return false;
			}
		}
		listUser.add(user);
		return true;
	}

	public void delete(int id) {
		listUser = userrestRepository.findAll();
		listUser.removeIf(user -> user.getId() == id);
	}

	public UserRest loadUserByUsername(String username) {
		listUser = userrestRepository.findAll();
		for (UserRest user : listUser) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public boolean checkLogin(UserRest user) {
		listUser = userrestRepository.findAll();
		for (UserRest userExist : listUser) {
			if (StringUtils.equals(user.getUsername(), userExist.getUsername())
					&& StringUtils.equals(user.getPassword(), userExist.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
