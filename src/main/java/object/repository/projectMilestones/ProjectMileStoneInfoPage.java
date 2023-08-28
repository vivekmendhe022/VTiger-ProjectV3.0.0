package object.repository.projectMilestones;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectMileStoneInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ProjectMileStoneInfoHeader;

	public ProjectMileStoneInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public String getProjectMileStoneHeaderText() {
		return ProjectMileStoneInfoHeader.getText();
	}
}
