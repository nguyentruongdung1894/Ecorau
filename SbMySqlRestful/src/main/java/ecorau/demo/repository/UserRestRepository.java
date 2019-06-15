package ecorau.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecorau.demo.entities.UserRest;

public interface UserRestRepository extends JpaRepository<UserRest, Integer> {

}
