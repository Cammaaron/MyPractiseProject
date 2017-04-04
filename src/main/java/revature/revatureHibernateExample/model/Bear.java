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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEAR")
public class Bear implements Serializable{
	@Id
	@Column(name="BEAR_ID")
	@SequenceGenerator(name="BEARID_SEQ", sequenceName="BEARID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEARID_SEQ")
	public int id;
	
@Column(name="BEAR_COLOR")
public String bearColor;

@Column(name="BREED")
public String bearBreed;

@Column(name="HEIGHT")
public Double height;

@Column(name="WEIGHT")
public Double weight;

@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="HONEYPOT_ID")
public HoneyPot HoneyPot;

@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "CAVE_ID", referencedColumnName="CAVE_ID")
public Cave caveId;

@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name="PARENT_CUB", 
	joinColumns = @JoinColumn(name="parent_id"),
	inverseJoinColumns=@JoinColumn(name="CUB_ID"))
private Set<Bear> bearCubs;

public Set<Bear> getBearCubs() {
	return bearCubs;
}

public void setBearCubs(Set<Bear> bearCubs) {
	this.bearCubs = bearCubs;
}

public Bear(){
	
}



public Bear(int id, String bearColor, String bearBreed, Double height, Double weight,
		revature.revatureHibernateExample.model.HoneyPot honeyPot, Cave caveId, Set<Bear> bearCubs) {
	super();
	this.id = id;
	this.bearColor = bearColor;
	this.bearBreed = bearBreed;
	this.height = height;
	this.weight = weight;
	HoneyPot = honeyPot;
	this.caveId = caveId;
	this.bearCubs = bearCubs;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBearColor() {
	return bearColor;
}
public void setBearColor(String bearColor) {
	this.bearColor = bearColor;
}
public String getBearBreed() {
	return bearBreed;
}
public void setBearBreed(String bearBreed) {
	this.bearBreed = bearBreed;
}
public Double getHeight() {
	return height;
}
public void setHeight(Double height) {
	this.height = height;
}
public Double getWeight() {
	return weight;
}
public void setWeight(Double weight) {
	this.weight = weight;
}
public Cave getCaveId() {
	return caveId;
}
public void setCaveId(Cave caveId) {
	this.caveId = caveId;
}

@Override
public String toString() {
	return "Bear [id=" + id + ", bearColor=" + bearColor + ", bearBreed=" + bearBreed + ", height=" + height
			+ ", weight=" + weight + ", HoneyPot=" + HoneyPot + ", caveId=" + caveId + ", bearCubs=" + bearCubs + "]";
}




	
	
}
