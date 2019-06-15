package ecorau.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecorau.demo.entities.Logtimesheet;
import ecorau.demo.entities.LogtimesheetPK;

public interface LogtimesheetRepository extends JpaRepository<Logtimesheet, LogtimesheetPK> {

}
