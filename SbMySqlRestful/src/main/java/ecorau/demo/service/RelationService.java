package ecorau.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.repository.RelationRepository;

@Service
public class RelationService {
	@Autowired
	RelationRepository relationRepository;

	public ServiceResult findAllRepository() {
		ServiceResult resul = new ServiceResult();
		resul.setData(relationRepository.findAll());
		return resul;
	}

}
