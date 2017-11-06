package ge.gngapps.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("tasks")
	public List<Task> getTasks() {
		return taskService.getTasks();
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/createTask" )
	public List<Task> createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateStatus/{id}")
	public List<Task> updateStatus( @PathVariable int id) {
		return taskService.updateStatus(id);
	} 
	
	@RequestMapping(method = RequestMethod.PUT, value = "/editTask")
	public List<Task> editTask( @RequestBody Task task ) {
		return taskService.editTask(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteTask/{id}")
	public List<Task> deleteTask( @PathVariable int id ) {
		return taskService.deleteTask(id);
	}
	
}
