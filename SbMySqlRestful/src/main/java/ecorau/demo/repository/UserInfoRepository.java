package ecorau.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecorau.demo.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
