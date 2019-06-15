package ecorau.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.repository.LogtimesheetRepository;

@Service
public class LogtimesheetService {
	@Autowired
	LogtimesheetRepository logtimesheetRepository;

	public ServiceResult findAllLogTimeSheet() {
		ServiceResult resul = new ServiceResult();
		resul.setData(logtimesheetRepository.findAll());
		return resul;
	}
}
