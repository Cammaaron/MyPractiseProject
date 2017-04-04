package revature.revatureHibernateExample.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE_ID")
public class Cave implements Serializable{

	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(name="CAVEID_SEQ", sequenceName="CAVEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAVEID_SEQ")
	public int id;
	
	@Column(name="CAVE_TYPE")
	public String caveType;
	
	@Column(name="SQ_FOOTAGE")
	public Double sqFootage;
	@Override
	public String toString() {
		StringBuilder bearString = new StringBuilder();
		bearString.append("[");
		this.bears.forEach(b->bearString.append(b.getId() + ", "));
		bearString.append("]");
		
		return "Cave [id=" + id + ", caveType=" + caveType + ", sqFootage=" + sqFootage + "]" + "bears = " + bearString ;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="cave_id")
	Set<Bear> bears;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaveType() {
		return caveType;
	}
	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}
	public Double getSqFootage() {
		return sqFootage;
	}
	public void setSqFootage(Double sqFootage) {
		this.sqFootage = sqFootage;
	}
	
	public Cave(){
		
	}
	public Set<Bear> getBears() {
		return bears;
	}
	public void setBears(Set<Bear> bears) {
		this.bears = bears;
	}
	public Cave(int id, String caveType, Double sqFootage, Set<Bear> bears) {
		super();
		this.id = id;
		this.caveType = caveType;
		this.sqFootage = sqFootage;
		this.bears = bears;
	}

	
	
	
}
