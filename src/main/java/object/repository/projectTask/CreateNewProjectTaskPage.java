package object.repository.projectTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewProjectTaskPage extends WebDriverUtility {

	@FindBy(name = "projecttaskname")
	private WebElement TaskNameTextField;

	@FindBy(name = "projecttaskpriority")
	private WebElement PriorityDropDownList;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement RelatedToLookUpImg;

	@FindBy(name = "enddate")
	private WebElement EndDateTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(name = "search_text")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	public CreateNewProjectTaskPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getTaskNameTextField() {
		return TaskNameTextField;
	}

	public WebElement getPriorityDropDownList() {
		return PriorityDropDownList;
	}

	public WebElement getRelatedToLookUpImg() {
		return RelatedToLookUpImg;
	}

	public WebElement getEndDateTextField() {
		return EndDateTextField;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void createNewProjectTask(WebDriver d, String TASKNAME, String PRIORITY, String RELATEDTO, String ENDDATE) {
		TaskNameTextField.sendKeys(TASKNAME);
		handleDropDown(PriorityDropDownList, PRIORITY);

		RelatedToLookUpImg.click();
		switchToWindow(d, "Project");
		SearchTextField.sendKeys(RELATEDTO);
		SearchBtn.click();
		d.findElement(By.xpath("//a[.='" + RELATEDTO + "']")).click();
		switchToWindow(d, "ProjectTask");

		EndDateTextField.sendKeys(ENDDATE);
		SaveBtn.click();
	}
}
