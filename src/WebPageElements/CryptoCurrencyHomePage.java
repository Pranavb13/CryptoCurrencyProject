package WebPageElements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericClass.BaseClass;
import GenericClass.CommonWebFunctions;

public class CryptoCurrencyHomePage extends BaseClass{

	//WebDriver driver = BaseClass.browserDriver.get("Driver");
	BaseClass baseclass = new BaseClass();
	CommonWebFunctions commonwebfunction = new CommonWebFunctions();
	
	
	public String navigateToTop100CurrenciesTab() {
		String elemetxt = "";
		try {
				commonwebfunction.click(baseclass.readProperty("cryptocurrenciesTab", "coinmarket.properties"));
				commonwebfunction.click(baseclass.readProperty("top100Option", "coinmarket.properties"));
				commonwebfunction.waitForElementToLoad();
				elemetxt = commonwebfunction.getTextOfElement(baseclass.readProperty("verifyTab", "coinmarket.properties"));
			} catch (Exception e) {
				commonwebfunction.takeErrorScreenshot();
				e.printStackTrace();
			}
		return elemetxt;
	}
	
	public String navigateToFullListCurrenciesTab(){
		String elemetxt = "";
		try {
		
			commonwebfunction.click(baseclass.readProperty("cryptocurrenciesTab", "coinmarket.properties"));		
			commonwebfunction.click(baseclass.readProperty("fullViewOoption", "coinmarket.properties"));
			commonwebfunction.waitForElementToLoad();
		    elemetxt = commonwebfunction.getTextOfElement(baseclass.readProperty("verifyallcryptocurrencyTab", "coinmarket.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
	return elemetxt;
	}
	
	public String navigateToSpotExchangeCurrenciesTab() {
		String elemetxt = "";
		try {
				commonwebfunction.click(baseclass.readProperty("exchangeTab", "coinmarket.properties"));		
				commonwebfunction.click(baseclass.readProperty("spotExchangesOption", "coinmarket.properties"));
				commonwebfunction.waitForElementToLoad();
		        elemetxt =commonwebfunction.getTextOfElement(baseclass.readProperty("verifyTab", "coinmarket.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
	return elemetxt;
	}
	
	public String navigateToDerivativesExchangeCurrenciesTab() {
		String elemetxt = "";
		try {
			commonwebfunction.click(baseclass.readProperty("exchangeTab", "coinmarket.properties"));		
			commonwebfunction.click(baseclass.readProperty("derivativesExchanges", "coinmarket.properties"));
			commonwebfunction.waitForElementToLoad();
			elemetxt = commonwebfunction.getTextOfElement(baseclass.readProperty("verifyTab", "coinmarket.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
	return elemetxt;
	}
	
	public String navigateToWatchlistCurrenciesTab() {
		String watchlistmsg = "";
		try {
			commonwebfunction.click(baseclass.readProperty("watchListTab", "coinmarket.properties"));		
			commonwebfunction.waitForElementToLoad();
			watchlistmsg =  commonwebfunction.getTextOfElement(baseclass.readProperty("verifywatchlistTab", "coinmarket.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
	return watchlistmsg;
		
	}
	
	
	public String getDefaultSelectedCurrency() {
		String elemetxt = "";
		try {
			elemetxt = commonwebfunction.getTextOfElement(baseclass.readProperty("selectedCurrency", "coinmarket.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
	return elemetxt;
	}
	
	public String changeCurrencyTo(String currencyCode){
		String elemetxt = "";
		try {
			commonwebfunction.click(baseclass.readProperty("currecnyPickerDropDown", "coinmarket.properties"));
			commonwebfunction.click(baseclass.readProperty("selectCurrency", "coinmarket.properties").replace("$value", currencyCode.toLowerCase()));
			elemetxt = commonwebfunction.getTextOfElement(baseclass.readProperty("selectedCurrency", "coinmarket.properties"));
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
	return elemetxt;
	}
	
	public String getThemeBeforeToggle() {
		String themeBeforeToggle = "";
		try {
			themeBeforeToggle = commonwebfunction.getAttributeValue(baseclass.readProperty("verifytheme", "coinmarket.properties"), "class");
			themeBeforeToggle = themeBeforeToggle.substring(themeBeforeToggle.lastIndexOf('-'));
			System.out.println("theme - "+themeBeforeToggle);
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return themeBeforeToggle;
	}
	
	public String getThemeAfterToggle() {
		String themeAfterToggle = "";
		try {
			commonwebfunction.click(baseclass.readProperty("toggleTheme", "coinmarket.properties"));
			themeAfterToggle = commonwebfunction.getAttributeValue(baseclass.readProperty("verifytheme", "coinmarket.properties"), "class");
			themeAfterToggle = themeAfterToggle.substring(themeAfterToggle.lastIndexOf('-'));
			System.out.println("theme after- "+themeAfterToggle);
		} catch (Exception e) {
			commonwebfunction.takeErrorScreenshot();
			e.printStackTrace();
		}
		return themeAfterToggle;
	}
	
	public void closeBrowser() {
		commonwebfunction.closeBrowser();
	}
	
}
