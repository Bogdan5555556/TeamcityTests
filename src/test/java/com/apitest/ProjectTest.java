package com.apitest;

import com.apitest.config.AppConfig;
import com.apitest.dataModel.Project;
import com.apitest.dataModel.Project.ParentProject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.apitest.dataModel.Project.ParentProject.ROOT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProjectTest extends BaseTCAPITest{

    @Test
    @DisplayName("Create project under root")
    public void createProjectUnderRoot() {
        Project project = createBaseProjectUnderRoot();
        ResponseEntity<Project> response = restService.postForObject(endpoints.getRootEndpoint(), headers, project,Project.class, endpoints.getProjectEndpoint("addProject"));
        assertThat("There is wrong response status! ", response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat("Response body doesn't have incorrect project name", response.getBody().getName(), equalTo(project.getName()));
    }

    @Step("Prepare base project")
    @Attachment(value = "Project body", type = "text/json")
    private Project createBaseProjectUnderRoot(){
        ParentProject parentProject = new ParentProject(ROOT);
        return Project.builder()
                .name(generateRandomString())
                .id(generateRandomString())
                .copyAllAssociatedSettings(true)
                .parentProject(parentProject)
                .build();
    }
}
