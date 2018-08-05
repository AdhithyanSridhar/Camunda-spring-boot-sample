package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class WebappExampleProcessApplication {

	/*
	 * Goto http://localhost:8080/ for camunda home page. Login credentials are,
	 * admin/admin. Task loanApproval will also be assigned to admin at the start of
	 * the program.
	 * 
	 * Use camunda modeler to model/edit the bpmn file.
	 * 
	 * https://docs.camunda.org/get-started/spring-boot/
	 * 
	 * Also, check the rest api exposed by camunda API. Implementation on the
	 * microservices side should also be checked.
	 */
	@Autowired
	private RuntimeService runtimeService;

	public static void main(String... args) {
		SpringApplication.run(WebappExampleProcessApplication.class, args);
	}

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		runtimeService.startProcessInstanceByKey("loanApproval");
	}
}