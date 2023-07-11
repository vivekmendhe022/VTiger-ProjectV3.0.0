package Opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.opportunities.OpportunitiesPage;

public class AdvanceSearchOpprtunityTest extends BaseClass {

	@Test
	public void searchAdvanceOpprtunityTest() {

		String CSOURCE = "Campaign Source";
		String CAMPNAME = "354Mac Book Pro";
		String OPPNAME = "395Bill Gate";

		HomePage hp = new HomePage(d);
		hp.clickOnOpportunitiesLink();

		OpportunitiesPage op = new OpportunitiesPage(d);
		op.verifyCampaingsAddedToOpportunity(d, CSOURCE, CAMPNAME);
		System.out.println("Verify page.s.");

//		d.findElement(By.id("fval0")).sendKeys(CAMPNAME);
//		d.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();

		WebElement OpportunityNameLinkText = d.findElement(By.xpath("(//a[.='" + OPPNAME + "'])[2]"));
		String OppHeader = OpportunityNameLinkText.getText();
		System.out.println(OppHeader);
		if (OppHeader.equalsIgnoreCase(OPPNAME)) {
			System.out.println("Verify");
		} else {
			System.out.println("Failed");
		}
		Assert.assertTrue(OppHeader.equalsIgnoreCase(OPPNAME));
	}
}
