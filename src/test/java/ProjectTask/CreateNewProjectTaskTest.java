package ProjectTask;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.projectTask.CreateNewProjectTaskPage;
import object.repository.projectTask.ProjectTaskInfoPage;
import object.repository.projectTask.ProjectTaskPage;

public class CreateNewProjectTaskTest extends BaseClass{

	@Test
	public void createNewProjectTaskTest() {
		
		
		String TASKNAME="Write test paln for registration module";
		String PRIORITY="high";
		String RELATEDTO="Time Taker";
		String ENDDATE="2023-09-15"; // yyyy-mm-dd
		
		HomePage hp=new HomePage(d);
		hp.clickOnProjectTaskLinkText(d);
		
		ProjectTaskPage ptp=new ProjectTaskPage(d);
		ptp.clickOnCreateNewProjectTaskLookUpImg();
		
		CreateNewProjectTaskPage cnptp=new CreateNewProjectTaskPage(d);
		cnptp.createNewProjectTask(d, TASKNAME, PRIORITY, RELATEDTO, ENDDATE);
		
		ProjectTaskInfoPage ptip=new ProjectTaskInfoPage(d);
		String projectTaskHeader = ptip.getProjectTaskHeader();		
		Assert.assertTrue(projectTaskHeader.contains(TASKNAME));
	}
}
