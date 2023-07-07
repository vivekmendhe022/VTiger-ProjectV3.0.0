package Campaigns;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.campaigns.CampaignsPage;
import object.repository.campaigns.CampaingsInfoPage;
import object.repository.campaigns.CreateNewCampaignPage;

public class CreateCampaignsTest extends BaseClass {

	@Test
	public void createCampaignsTest() {
		String CAMPNAME = "Mac Book Pro";
		String ASSIGNTO = "user";

		HomePage hp = new HomePage(d);
		hp.hoverOnMore(d);
		hp.clickOnCampaingsLinkText();

		CampaignsPage cp = new CampaignsPage(d);
		cp.clickOnCreateCampaignsLookUpIcon();

		CreateNewCampaignPage cnc = new CreateNewCampaignPage(d);
		cnc.createNewCampaignPage(CAMPNAME, ASSIGNTO);

		CampaingsInfoPage cip = new CampaingsInfoPage(d);
		String headerInfo = cip.getCampaingsHeaderInfo();
		if (headerInfo.contains(CAMPNAME)) {
			System.out.println("Pass");
		} else {
			System.out.println("Failed");
		}
		Assert.assertTrue(headerInfo.contains(CAMPNAME));
		Reporter.log("Campaings created.",true);

	}

}
