package object.repository.projectTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectTaskInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ProjectTaskInfo;

	public ProjectTaskInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public String getProjectTaskHeader() {
		return ProjectTaskInfo.getText();
	}
}

