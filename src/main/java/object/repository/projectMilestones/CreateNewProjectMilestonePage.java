package object.repository.projectMilestones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class CreateNewProjectMilestonePage extends WebDriverUtility {

	@FindBy(name = "projectmilestonename")
	private WebElement MilestoneNameTextField;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement RelatedToLookUpImg;

	@FindBy(name = "projectmilestonedate")
	private WebElement ProjectMilestoneDateTextField; // input: yyyy-mm-dd

	@FindBy(name = "projectmilestonetype")
	private WebElement ProjectMilestoneTypeDropDownList;

	@FindBy(name = "description")
	private WebElement DescriptionTextarea;

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement SearchTextField;

	@FindBy(name = "search")
	private WebElement SearchBtn;

	@FindBy(xpath = "//input[contains(@class,'crmbutton small save')]")
	private WebElement SaveBtn;

	public CreateNewProjectMilestonePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewProjectMilestone(WebDriver d, String MILESTONENAME, String PROJECTNAME, String MILESTONEDATE,
			String MILESTONETYPE, String DESCRIPTION) throws InterruptedException {
		MilestoneNameTextField.sendKeys(MILESTONENAME);

		
		RelatedToLookUpImg.click();
		Thread.sleep(3000);
		switchToWindow(d, "Project");
		SearchTextField.sendKeys(PROJECTNAME);
		SearchBtn.click();
		d.findElement(By.xpath("//a[normalize-space()='" + PROJECTNAME + "']")).click();
		switchToWindow(d, "ProjectMilestone");

		ProjectMilestoneDateTextField.sendKeys(MILESTONEDATE);
		handleDropDown(ProjectMilestoneTypeDropDownList, MILESTONETYPE);
		DescriptionTextarea.sendKeys(DESCRIPTION);

		SaveBtn.click();
	}

}
