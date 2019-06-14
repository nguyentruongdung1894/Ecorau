package ecorau.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecorau.demo.entities.Project;

public interface ProjectReponsitory extends JpaRepository<Project, Integer> {

}
