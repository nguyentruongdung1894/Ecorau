package ecorau.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecorau.demo.entities.Relation;
import ecorau.demo.entities.RelationPK;

public interface RelationRepository extends JpaRepository<Relation, RelationPK> {

}
