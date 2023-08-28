package ProjectMilestones;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.projectMilestones.CreateNewProjectMilestonePage;
import object.repository.projectMilestones.ProjectMileStoneInfoPage;
import object.repository.projectMilestones.ProjectMilestonesPage;

public class CreateNewProjectMilestones extends BaseClass {

	@Test
	public void createNewProjectMilestones() throws InterruptedException {

		String MILESTONENAME = "Project1";
		String PROJECTNAME = "Time";
		String MILESTONEDATE = "2023-10-10"; // input: yyyy-mm-dd
		String MILESTONETYPE = "administrative";
		String DESCRIPTION = "Yes! Today we achive milestone.";

		HomePage hp = new HomePage(d);
		hp.clickOnProjectMilestonesLinkText(d);

		ProjectMilestonesPage pmp = new ProjectMilestonesPage(d);
		pmp.clickOnCreateProjectMilestoneLookUpImg();

		CreateNewProjectMilestonePage cnpmp = new CreateNewProjectMilestonePage(d);
		cnpmp.createNewProjectMilestone(d, MILESTONENAME, PROJECTNAME, MILESTONEDATE, MILESTONETYPE, DESCRIPTION);

		ProjectMileStoneInfoPage pmip = new ProjectMileStoneInfoPage(d);
		String mileStoneHeader = pmip.getProjectMileStoneHeaderText();
		Assert.assertTrue(mileStoneHeader.contains(MILESTONENAME));

	}
}
