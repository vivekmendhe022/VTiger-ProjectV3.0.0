package object.repository.projectMilestones;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectMilestonesPage {

	@FindBy(xpath = "//img[@title='Create Project Milestone...']")
	private WebElement CreateProjectMilestoneLookUpImg;

	public ProjectMilestonesPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void clickOnCreateProjectMilestoneLookUpImg() {
		CreateProjectMilestoneLookUpImg.click();
	}
	
}
