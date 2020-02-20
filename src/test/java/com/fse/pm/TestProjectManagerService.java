/**
 * 
 */
package com.fse.pm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fse.pm.entities.ParentTask;
import com.fse.pm.entities.Project;
import com.fse.pm.entities.Users;
import com.fse.pm.mapper.ParentTaskRequestResponse;
import com.fse.pm.mapper.ProjectRequest;
import com.fse.pm.mapper.ProjectResponse;
import com.fse.pm.mapper.TaskRequestResponse;
import com.fse.pm.mapper.UserRequestResponse;
import com.fse.pm.repositories.IParentTaskRepository;
import com.fse.pm.repositories.IProjectRepository;
import com.fse.pm.repositories.ITaskRepository;
import com.fse.pm.repositories.IUserRepository;
import com.fse.pm.service.impl.ParentTaskServiceImpl;
import com.fse.pm.service.impl.ProjectServiceImpl;
import com.fse.pm.service.impl.TaskServiceImpl;
import com.fse.pm.service.impl.UserServiceImpl;

import junit.framework.TestCase;

/**
 * @author Shiva Karnati
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ProjectmanagerApplication.class)
@ActiveProfiles("test")
public class TestProjectManagerService extends TestCase{
	
	@Value("${local.server.port}")
    private Integer port;
    private String apiUrl;
    private TestRestTemplate testRestTemplate;
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    private IProjectRepository projectRepository;
    
    @Autowired
    private ITaskRepository taskRepository;
    
    @Autowired
    private IParentTaskRepository parentTaskRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Autowired
    private ProjectServiceImpl projectServiceImpl;
    
    @Autowired
    private TaskServiceImpl taskServiceImpl;
    
    @Autowired
    private ParentTaskServiceImpl parentTaskServiceImpl;
    
	@Before
    public void setUp() throws Exception {
        super.setUp();
        apiUrl = "http://localhost:".concat(port.toString()).concat("/projectmanager");
        testRestTemplate = new TestRestTemplate();
    }
	
	@Test
    public void testAddUser() {

        Users users = new Users();
        //users.setUserId(1);
        users.setLastName("FirstNme");
        users.setFirstName("LastNme");
        users.setEmployeeId(125502);
        users.setManager(false);
        ModelMapper modelMapper = new ModelMapper();
		UserRequestResponse userRequestResponse = modelMapper.map(users, UserRequestResponse.class);
        userServiceImpl.createUser(userRequestResponse);
        
        ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/adduser"), userRequestResponse, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        
        ResponseEntity<String> response1 = testRestTemplate.getForEntity(apiUrl.concat("/viewuser/1"), String.class);
        assertThat(response1.getStatusCode(), equalTo(HttpStatus.OK));
    }    
    
    @Test
    public void testUpdateUser() {

        Users users = new Users();
        users.setUserId(2);
        users.setLastName("FirstNme1");
        users.setFirstName("LastNme1");
        users.setEmployeeId(123456);
        users.setManager(false);    
        ModelMapper modelMapper = new ModelMapper();
		UserRequestResponse userRequestResponse = modelMapper.map(users, UserRequestResponse.class);		
        
        userRequestResponse.setFirstName("Shiva");               
        
        ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/updateuser"), userRequestResponse, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }   
    
    @Test
    public void testDeleteUser() {

        Users users = new Users();
        //users.setUserId(3);
        users.setLastName("FirstNme1");
        users.setFirstName("LastNme1");
        users.setEmployeeId(12345);
        users.setManager(false);
        ModelMapper modelMapper = new ModelMapper();
		UserRequestResponse userRequestResponse = modelMapper.map(users, UserRequestResponse.class);
		userRequestResponse = userServiceImpl.createUser(userRequestResponse);	
		userServiceImpl.deleteUser(userRequestResponse.getUserId());		
		Optional<Users> user = userServiceImpl.findUser(userRequestResponse.getUserId());		
		assertEquals(user,Optional.empty());
		//userServiceImpl.createUser(userRequestResponse);        
		
		/*String apiURL1 = apiUrl.concat("/deleteuser/" + users.getUserId());
		System.out.println("Shiva " + apiURL1);
		
        ResponseEntity<String> response = testRestTemplate.getForEntity(apiURL1, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));*/
    }       
    
    @Test
    public void testFindAllUsers() throws Exception {
    	
    	Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        userRepository.save(users);
                
        ResponseEntity<String> response = testRestTemplate.getForEntity(apiUrl.concat("/allusers"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        
        List<Users> userList = convertJsonToUserList(response.getBody());
        assertThat(userList.size(), equalTo(1));
    }
	
	@Test
	public void testFindAllParents() {

		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(1);
		parentTask.setParentTask("ShivaTest");    
		
		ModelMapper modelMapper = new ModelMapper();
		ParentTaskRequestResponse parentTaskRequestResponse = modelMapper.map(parentTask, ParentTaskRequestResponse.class);
		parentTaskServiceImpl.createParent(parentTaskRequestResponse);        
		List<ParentTask> parentList = parentTaskServiceImpl.findAll();
		assertThat(parentList.size(), equalTo(1));        
		
		ResponseEntity<String> response = testRestTemplate.getForEntity(apiUrl.concat("/allparenttask"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    } 
	
	@Test
	public void testAddParentTask() {	
		
		parentTaskRepository.deleteAll();        
        parentTaskRepository.flush();

		ParentTask parentTask = new ParentTask();
		//parentTask.setParentId(1);
		parentTask.setParentTask("ShivaTest");    
		ModelMapper modelMapper = new ModelMapper();  
		ParentTaskRequestResponse parentTaskRequestResponse = parentTaskServiceImpl.createParent(modelMapper.map(parentTask, ParentTaskRequestResponse.class));
		ParentTask parent = parentTaskServiceImpl.findParent(parentTaskRequestResponse.getParentId());
		//System.out.println("Hello" + parent.getParentId());
		assertNotNull(parent);
		String apiURL1 = apiUrl.concat("/viewparenttask/" + parent.getParentId());
		//System.out.println("HelloX " + apiURL1);
		
		ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/addparenttask"), parentTask, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK)); 
        
        ResponseEntity<String> response1 = testRestTemplate.getForEntity(apiURL1, String.class);
        assertThat(response1.getStatusCode(), equalTo(HttpStatus.OK));
    }	
	
	@Test
	public void testCreateProject() {			

		Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        Users savedUser = userRepository.save(users);
        
        ProjectRequest projectReq = new ProjectRequest();        
        projectReq.setProjectDesc("ShivaProject");
        projectReq.setProjectStatus(false);
        projectReq.setProjectPriority(20);
        projectReq.setProjectStartDate(new Date());
        projectReq.setProjectEndDate(new Date());
        projectReq.setUserId(savedUser.getUserId());               
          
        projectServiceImpl.createProject(projectReq);
				
		ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/addproject"), projectReq, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));      
        
    }
	
	@Test
	public void testUpdateProject() {			

		Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        Users savedUser = userRepository.save(users);
        
        Project project = new Project();
        
        project.setProjectDesc("TestProject");
        project.setPriority(3);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setProjectStatus(true);
        project.setPriority(30);
        project.setUser(savedUser);
        Project savedProject = projectRepository.save(project);
        
        ProjectRequest projectReq = new ProjectRequest();        
        projectReq.setProjectDesc("ShivaProject");
        projectReq.setProjectStatus(false);
        projectReq.setProjectPriority(20);
        projectReq.setProjectStartDate(new Date());
        projectReq.setProjectEndDate(new Date());
        projectReq.setUserId(savedUser.getUserId());
        projectReq.setEmployeeId(savedUser.getEmployeeId());
        projectReq.setFirstName(savedUser.getFirstName());
        projectReq.setLastName(savedUser.getLastName());        
        projectReq.setProjectId(savedProject.getProjectId());
				
		ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/updateproject"), projectReq, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        
        Project foundProject = projectServiceImpl.findProject(savedProject.getProjectId());
        
        assertEquals(savedProject.getProjectId(), foundProject.getProjectId());
        
    }
	
	@Test
	public void testFindAllProject() throws Exception {			

		Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        Users savedUser = userRepository.save(users);
        
        Project project = new Project();
        
        project.setProjectDesc("TestProject");
        project.setPriority(3);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setProjectStatus(true);
        project.setPriority(30);
        project.setUser(savedUser);
        projectRepository.save(project);
				
		ResponseEntity<String> response = testRestTemplate.getForEntity(apiUrl.concat("/allproject"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));      
        
        List<ProjectResponse> projectList = convertJsonToProjectList(response.getBody());
	    assertThat(projectList.size(), equalTo(1));
    }
	
	@Test
	public void testCreateTask() {		
		
		ParentTask parentTask = new ParentTask();
		//parentTask.setParentId(1);
		parentTask.setParentTask("ShivaTest");
		ParentTask savedParent = parentTaskRepository.save(parentTask);

		Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        Users savedUser = userRepository.save(users);
        
        Project project = new Project();
        
        project.setProjectDesc("TestProject");
        project.setPriority(3);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setProjectStatus(true);
        project.setPriority(30);
        project.setUser(savedUser);
        Project savedProject = projectRepository.save(project);
        
        TaskRequestResponse task = new TaskRequestResponse();
		task.setEndDate(new Date());
		task.setPriority(3);
		task.setStartDate(new Date());
		task.setTaskStatus(true);
		task.setTaskDesc("Test Task");
		task.setParentId(savedParent.getParentId());
		task.setProjectId(savedProject.getProjectId());
		task.setUserId(savedUser.getUserId());                   
          
        taskServiceImpl.createTask(task);
				
		ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/addtask"), task, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));      
        
    }
	
	@Test
	public void testUpdateTask() {		
		
		ParentTask parentTask = new ParentTask();
		//parentTask.setParentId(1);
		parentTask.setParentTask("ShivaTest");
		ParentTask savedParent = parentTaskRepository.save(parentTask);

		Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        Users savedUser = userRepository.save(users);
        
        Project project = new Project();
        
        project.setProjectDesc("TestProject");
        project.setPriority(3);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setProjectStatus(true);
        project.setPriority(30);
        project.setUser(savedUser);
        Project savedProject = projectRepository.save(project);
        
        TaskRequestResponse task = new TaskRequestResponse();
		task.setEndDate(new Date());
		task.setPriority(3);
		task.setStartDate(new Date());
		task.setTaskStatus(true);
		task.setTaskDesc("TestTask");
		task.setParentId(savedParent.getParentId());
		task.setProjectId(savedProject.getProjectId());
		task.setUserId(savedUser.getUserId());                   
          
        taskServiceImpl.createTask(task);
        
        task.setTaskDesc("TestXTask");
				
		ResponseEntity<String> response = testRestTemplate.postForEntity(apiUrl.concat("/updatetask"), task, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));      
        
    }
	
	@Test
	public void testFindAllTask() throws Exception {		
		
		ParentTask parentTask = new ParentTask();
		//parentTask.setParentId(1);
		parentTask.setParentTask("ShivaTest");
		ParentTask savedParent = parentTaskRepository.save(parentTask);

		Users users = new Users();        
        users.setLastName("FirstNmeUpd");
        users.setFirstName("LastNmeUpd");
        users.setEmployeeId(123456);
        users.setUserId(4);
        users.setManager(false);    
        Users savedUser = userRepository.save(users);
        
        Project project = new Project();
        
        project.setProjectDesc("TestProject");
        project.setPriority(3);
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setProjectStatus(true);
        project.setPriority(30);
        project.setUser(savedUser);
        Project savedProject = projectRepository.save(project);
        
        TaskRequestResponse task = new TaskRequestResponse();
		task.setEndDate(new Date());
		task.setPriority(3);
		task.setStartDate(new Date());
		task.setTaskStatus(true);
		task.setTaskDesc("TestTask");
		task.setParentId(savedParent.getParentId());
		task.setProjectId(savedProject.getProjectId());
		task.setUserId(savedUser.getUserId());                   
          
        taskServiceImpl.createTask(task);
				
		ResponseEntity<String> response = testRestTemplate.getForEntity(apiUrl.concat("/alltask"), String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));   
        
        List<TaskRequestResponse> taskList = convertJsonToTaskList(response.getBody());
	    assertThat(taskList.size(), equalTo(1));
        
    }
	
	private List<Users> convertJsonToUserList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, Users.class));
    }
	
	private List<ProjectResponse> convertJsonToProjectList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, ProjectResponse.class));
    }
	
	private List<TaskRequestResponse> convertJsonToTaskList(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, TaskRequestResponse.class));
    }
	
	 @After
	    public void tearDown() throws Exception {
	        super.tearDown();
	        apiUrl = null;
	        testRestTemplate = null;  
	        taskRepository.deleteAll();        
			taskRepository.flush();
	        projectRepository.deleteAll();        
			projectRepository.flush();
	        userRepository.deleteAll();
	        userRepository.flush();
	        parentTaskRepository.deleteAll();	        
	        parentTaskRepository.flush();
	        
	    }

}
