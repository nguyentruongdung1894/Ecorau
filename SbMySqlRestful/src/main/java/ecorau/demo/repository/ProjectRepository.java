package ecorau.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecorau.demo.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
