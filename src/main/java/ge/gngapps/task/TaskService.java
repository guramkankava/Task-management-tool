package ge.gngapps.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
//	private List<Task> tasks = new ArrayList<Task>( Arrays.asList( new Task( 1, "name1", "description1", "done", new Date(), new Date() ),
//			new Task( 2, "name2", "description2", "not done", new Date(), new Date() )
//			));
	
	public List<Task> getTasks () {
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}

	public List<Task> createTask( Task task ) {
		task.setTimeAdded(new Date());
		taskRepository.save(task);
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}

	public List<Task> updateStatus( int id ) {
		Task task = taskRepository.findOne(id);
		task.setStatus("Done");
		task.setTimeFinished(new Date());
		taskRepository.save(task);
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}

	public List<Task> editTask( Task task ) {
		taskRepository.save(task);
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}

	public List<Task> deleteTask( int id ) {
		taskRepository.delete(id);
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
}
