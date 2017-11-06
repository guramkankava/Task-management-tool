package ge.gngapps.task;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name; 
	private String description;
	private String status; 
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeAdded;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeFinished;
	
	public Task() {}
	
	public Task(int id, String name, String description, String status, Date timeAdded, Date timeFinished) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.timeAdded = timeAdded;
		this.timeFinished = timeFinished;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTimeAdded() {
		return timeAdded;
	}
	public void setTimeAdded(Date timeAdded) {
		this.timeAdded = timeAdded;
	}
	public Date getTimeFinished() {
		return timeFinished;
	}
	public void setTimeFinished(Date timeFinished) {
		this.timeFinished = timeFinished;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", timeAdded=" + timeAdded + ", timeFinished=" + timeFinished + "]";
	}
	
	
	
	
}
