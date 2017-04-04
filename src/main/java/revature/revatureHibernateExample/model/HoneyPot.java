package revature.revatureHibernateExample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="HONEY_POT")
public class HoneyPot implements Serializable {

	@Id
	@Column(name="HONEYPOT_ID")
	@SequenceGenerator(name="HONEYPOTID_SEQ", sequenceName="HONEYPOTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HONEYPOTID_SEQ")
	public int id;
	
	@Column(name="HONEY_AMOUNT")
	public Double honeyAmount;
	
	@Column(name="VOLUME")
	public Double volume;
	@Override
	public String toString() {
		return "HoneyPot [id=" + id + ", honeyAmount=" + honeyAmount + ", volume=" + volume + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getHoneyAmount() {
		return honeyAmount;
	}
	public void setHoneyAmount(Double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	public HoneyPot(){
		
	}
	
	public HoneyPot(int id, Double honeyAmount, Double volume) {
		super();
		this.id = id;
		this.honeyAmount = honeyAmount;
		this.volume = volume;
	}
	
	
}
