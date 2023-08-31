package object.repository.projectTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectTaskPage {

	@FindBy(xpath = "//img[@title='Create Project Task...']")
	private WebElement CreateNewProjectTaskLookUpImg;

	public ProjectTaskPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateNewProjectTaskLookUpImg() {
		return CreateNewProjectTaskLookUpImg;
	}

	public void clickOnCreateNewProjectTaskLookUpImg() {
		CreateNewProjectTaskLookUpImg.click();
	}
}
