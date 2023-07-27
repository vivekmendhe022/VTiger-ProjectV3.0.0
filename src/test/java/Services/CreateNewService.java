package Services;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

import object.repository.HomePage;
import object.repository.service.CreateNewServicePage;
import object.repository.service.ServiceInfoPage;
import object.repository.service.ServicePage;

public class CreateNewService extends BaseClass {

	@Test
	public void createNewServices() {

		String SERVICENAME = "Maintenance";

		HomePage hp = new HomePage(d);
		hp.clickOnServicesLinkText(d);

		ServicePage sp = new ServicePage(d);
		sp.clickOnServiceImgLookUpIcon();

		CreateNewServicePage cnsp = new CreateNewServicePage(d);
		cnsp.createNewService(SERVICENAME);

		ServiceInfoPage sip = new ServiceInfoPage(d);
		String header = sip.serviceInfoHeader();
		Assert.assertTrue(header.contains(SERVICENAME));
	}
}
