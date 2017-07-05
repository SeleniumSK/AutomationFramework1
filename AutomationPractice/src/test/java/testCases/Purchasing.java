package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.PurchasingItem;

public class Purchasing extends BaseClass {
	
	
public void purchasingItem()
{
	
	PurchasingItem purchase = PageFactory.initElements(driver, PurchasingItem.class);
	
	purchase.selectDress();
	
	purchase.SelectingDress();
	
	purchase.VerifyDressPage();
}
}
