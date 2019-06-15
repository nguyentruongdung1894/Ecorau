package ecorau.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecorau.demo.entities.Project;
import ecorau.demo.repository.ProjectRepository;
import ecorau.demo.service.ServiceResult.Status;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	public ServiceResult findAllProject() {
		ServiceResult resul = new ServiceResult();
		resul.setData(projectRepository.findAll());
		return resul;
	}

	public ServiceResult findByIdProject(int id) {
		ServiceResult resul = new ServiceResult();
		Project project = projectRepository.findById(id).orElse(null);
		resul.setData(project);
		return resul;
	}

	public ServiceResult createProject(Project project) {
		ServiceResult resul = new ServiceResult();
		resul.setData(projectRepository.save(project));
		return resul;
	}

	public ServiceResult updateProject(Project project) {
		ServiceResult result = new ServiceResult();
		if (!projectRepository.findById(project.getProject_id()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("Project Not Found");
		} else {
			result.setData(projectRepository.save(project));
		}
		return result;
	}

	public ServiceResult deleteProject(int id) {
		ServiceResult result = new ServiceResult();
		Project project = projectRepository.findById(id).orElse(null);
		if (project == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Project Not Found");
		} else {
			projectRepository.delete(project);
			result.setMessage("success");
		}
		return result;
	}
}
