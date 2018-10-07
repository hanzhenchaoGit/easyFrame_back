//package com.frank.boot;
//
//import com.frank.boot.domain.system.ResultData;
//
//import java.util.List;
//
//import org.activiti.engine.ProcessEngine;
//import org.activiti.engine.ProcessEngines;
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.repository.Deployment;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@Transactional
//@Rollback
//@ActiveProfiles("test")
//public class BootApplicationTests {
//    @Autowired
//    private MockMvc mvc;
//    
//    @Autowired
//    private RepositoryService repositoryService;
////    @Test
////    public void testLogin() throws Exception {
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("username","admin1");
////        jsonObject.put("password","123456");
////        mvc.perform(MockMvcRequestBuilders.post("/auth/login",ResultData.class).contentType(MediaType.APPLICATION_JSON).content(jsonObject.toJSONString()));
////    }
////
////    @Test
////    public void testUrl() throws Exception {
////        String resultStr = mvc.perform(MockMvcRequestBuilders.post("/system/getSysSqlConfigByPager",ResultData.class)
////                .param("pageSize", "20")
////                .param("currentPage","1"))         //打印出请求和相应的内容
////                .andReturn().getResponse().getContentAsString();
////        System.out.println(resultStr);
////    }
//	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//
//    @Test
//    public void defalutdeploy(){
//    	Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/MyProcess.bpmn").deploy();
//    	System.out.println("部署ID："+deploy.getId());//1
//		System.out.println("部署名称："+deploy.getName());
//    }
//    @Test
//    public void start(){
//    	String key = "task1";
//    	ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey(key);
//    	System.out.println("流程实例ID:"+pi.getId());//流程实例ID    101
//		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID   helloworld:1:4
//    }
//    /**查询当前人的个人任务*/
//	@Test
//	public void findMyPersonalTask(){
//		String assignee = "王五";
//		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
//						.createTaskQuery()//创建任务查询对象
//						.taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.list();
//		if(list!=null && list.size()>0){
//			for(Task task:list){
//				System.out.println("任务ID:"+task.getId());
//				System.out.println("任务名称:"+task.getName());
//				System.out.println("任务的创建时间:"+task.getCreateTime());
//				System.out.println("任务的办理人:"+task.getAssignee());
//				System.out.println("流程实例ID："+task.getProcessInstanceId());
//				System.out.println("执行对象ID:"+task.getExecutionId());
//				System.out.println("流程定义ID:"+task.getProcessDefinitionId());
//				System.out.println("########################################################");
//			}
//		}
//	}
//	
//	/**完成我的任务*/
//	@Test
//	public void completeMyPersonalTask(){
//		//任务ID
//		String taskId = "302";
//		processEngine.getTaskService()//与正在执行的任务管理相关的Service
//					.complete(taskId);
//		System.out.println("完成任务：任务ID："+taskId);
//	}
//
//    
//}
