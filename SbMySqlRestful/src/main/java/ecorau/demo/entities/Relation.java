package ecorau.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "relation")
public class Relation {
	@EmbeddedId
	private RelationPK relationpk;

	public RelationPK getRelationpk() {
		return relationpk;
	}

	public void setRelationpk(RelationPK relationpk) {
		this.relationpk = relationpk;
	}

	public Relation(RelationPK relationpk) {
		super();
		this.relationpk = relationpk;
	}

	public Relation() {
		super();
	}

}
