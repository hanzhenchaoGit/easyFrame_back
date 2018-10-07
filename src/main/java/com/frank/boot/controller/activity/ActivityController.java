package com.frank.boot.controller.activity;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.identity.Group;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.utils.UtilMisc;

@RestController
@RequestMapping("/activiti")
public class ActivityController extends BaseController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private IdentityService entityService;
    @Autowired
    HistoryService historyService;

    @GetMapping("test")
    public ResultData demo(){
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/task.bpmn").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        String processId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID："+processId);
        Map<String,Object> map = new HashMap<>();
        map.put("role","admin");
        Task task=taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称："+task.getName());
        taskService.complete(task.getId(),map);
        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第二次执行前，任务名称："+task.getName()+task.getProcessVariables());
        taskService.complete(task.getId());
//        taskService.createTaskQuery().taskCandidateOrAssigned("")
        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("task为null，任务执行完毕："+task);
        return new ResultData();
    }


    @GetMapping("/deploy")
    public String deploy(){
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/zxlc.bpmn").deploy();
//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        return "部署成功 流程id为:" +deployment.getId();
    }

    @GetMapping("/start")
    public String start(@RequestParam String  id){
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(id).singleResult();
        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        Task t = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
//        entityService.createGroupQuery().
//        taskService.addCandidateGroup(t.getId(),);
        return "开启流程成功 实例id:"+pi.getId()+" --- taskId:"+t.getId()+"getAssignee:" +t.getAssignee()+"getCategory:"+t.getCategory()+"getName:"+t.getName()+"getName:"+t.getOwner();
    }
    @GetMapping("/usercomplete")
    public String complete(@RequestParam String id){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateUser(id).list();
        for(Task t: tasks){
            taskService.complete(t.getId());
        }
        return taskService.createTaskQuery().taskCandidateUser(id).list().size()+"";
    }
    @GetMapping("/queryUserTask")
    public String completec(@RequestParam String id){
        List<Task> tasks = taskService.createTaskQuery().taskCandidateUser(id).list();
        return tasks.toString();
    }
    @GetMapping("queryAllTask")
    public String queryAll(){
        List<Task> tasks = taskService.createTaskQuery().list();
        return tasks.toString();
    }
    @GetMapping("/entity")
    public String getUser(){
    	List<Group> userGroup = entityService.createGroupQuery().groupMember("admin1").groupName("role").list();
    	StringBuffer bu = new StringBuffer();
    	for(Group g : userGroup){
    	    bu.append(",");
    		bu.append(g.getType());
    	}
        List<Group> userorgGroup = entityService.createGroupQuery().groupMember("admin1").groupName("org").list();
        bu.append(" org ---");
        for(Group g : userorgGroup){
            bu.append(",");
            bu.append(g.getType());
        }
        org.activiti.engine.impl.form.FormData formData = new org.activiti.engine.impl.form.FormData(null);

    	return bu.toString();
    }
    @GetMapping("/getFlowImage")
    public void getResourceDiagramInputStream(@RequestParam String id) {
        try {
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            // 获取历史流程实例
            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(id).singleResult();

            // 获取流程中已经执行的节点，按照执行先后顺序排序
            List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery().processInstanceId(id).orderByHistoricActivityInstanceId().asc().list();

            // 构造已执行的节点ID集合
            List<String> executedActivityIdList = new ArrayList<String>();
            for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
                executedActivityIdList.add(activityInstance.getActivityId());
            }

            // 获取bpmnModel
            BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());
            // 获取流程已发生流转的线ID集合
            List<String> flowIds = this.getExecutedFlows(bpmnModel, historicActivityInstanceList);

            // 使用默认配置获得流程图表生成器，并生成追踪图片字符流
            ProcessDiagramGenerator processDiagramGenerator = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
            InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", executedActivityIdList, flowIds, "宋体", "微软雅黑", "黑体", null, 2.0);
            OutputStream out = response.getOutputStream();
            int length = 0;
            byte buffer[] = new byte[1024];
            while((length = imageStream.read(buffer)) != -1){
                out.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getExecutedFlows(BpmnModel bpmnModel, List<HistoricActivityInstance> historicActivityInstances) {
        // 流转线ID集合
        List<String> flowIdList = new ArrayList<String>();
        // 全部活动实例
        List<FlowNode> historicFlowNodeList = new LinkedList<FlowNode>();
        // 已完成的历史活动节点
        List<HistoricActivityInstance> finishedActivityInstanceList = new LinkedList<HistoricActivityInstance>();
        for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
            historicFlowNodeList.add((FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstance.getActivityId(), true));
            if (historicActivityInstance.getEndTime() != null) {
                finishedActivityInstanceList.add(historicActivityInstance);
            }
        }

        // 遍历已完成的活动实例，从每个实例的outgoingFlows中找到已执行的
        FlowNode currentFlowNode = null;
        for (HistoricActivityInstance currentActivityInstance : finishedActivityInstanceList) {
            // 获得当前活动对应的节点信息及outgoingFlows信息
            currentFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(currentActivityInstance.getActivityId(), true);
            List<SequenceFlow> sequenceFlowList = currentFlowNode.getOutgoingFlows();

            /**
             * 遍历outgoingFlows并找到已已流转的
             * 满足如下条件认为已已流转：
             * 1.当前节点是并行网关或包含网关，则通过outgoingFlows能够在历史活动中找到的全部节点均为已流转
             * 2.当前节点是以上两种类型之外的，通过outgoingFlows查找到的时间最近的流转节点视为有效流转
             */
            FlowNode targetFlowNode = null;
            if (BpmsActivityTypeEnum.PARALLEL_GATEWAY.getType().equals(currentActivityInstance.getActivityType())
                    || BpmsActivityTypeEnum.INCLUSIVE_GATEWAY.getType().equals(currentActivityInstance.getActivityType())) {
                // 遍历历史活动节点，找到匹配Flow目标节点的
                for (SequenceFlow sequenceFlow : sequenceFlowList) {
                    targetFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(sequenceFlow.getTargetRef(), true);
                    if (historicFlowNodeList.contains(targetFlowNode)) {
                        flowIdList.add(sequenceFlow.getId());
                    }
                }
            } else {
                List<Map<String, String>> tempMapList = new LinkedList<Map<String,String>>();
                // 遍历历史活动节点，找到匹配Flow目标节点的
                for (SequenceFlow sequenceFlow : sequenceFlowList) {
                    for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
                        if (historicActivityInstance.getActivityId().equals(sequenceFlow.getTargetRef())) {
                            tempMapList.add(UtilMisc.toMap("flowId", sequenceFlow.getId(), "activityStartTime", String.valueOf(historicActivityInstance.getStartTime().getTime())));
                        }
                    }
                }

                // 遍历匹配的集合，取得开始时间最早的一个
                long earliestStamp = 0L;
                String flowId = null;
                for (Map<String, String> map : tempMapList) {
                    long activityStartTime = Long.valueOf(map.get("activityStartTime"));
                    if (earliestStamp == 0 || earliestStamp >= activityStartTime) {
                        earliestStamp = activityStartTime;
                        flowId = map.get("flowId");
                    }
                }
                flowIdList.add(flowId);
            }
        }
        return flowIdList;
    }

    public enum BpmsActivityTypeEnum {

        START_EVENT("startEvent", "开始事件"),
        END_EVENT("endEvent", "结束事件"),
        USER_TASK("userTask", "用户任务"),
        EXCLUSIVE_GATEWAY("exclusiveGateway", "排他网关"),
        PARALLEL_GATEWAY("parallelGateway", "并行网关"),
        INCLUSIVE_GATEWAY("inclusiveGateway", "包含网关");

        private String type;
        private String name;

        private BpmsActivityTypeEnum(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    
}
