package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericClass.BaseClass;
import WebPageElements.CryptoCurrencyHomePage;
import junit.framework.Assert;

public class TestCoinMarketApplication {
  
	
    BaseClass baseClass = new BaseClass();
    CryptoCurrencyHomePage cryptoCurrencyHomePage = new CryptoCurrencyHomePage();
    
    
    @SuppressWarnings("deprecation")
	@BeforeTest
    public void launchBrowser() throws IOException, InterruptedException {
    	
	     String baseUrl = baseClass.readProperty("coinMarketURL", "projectProperties.properties");
	     String browserDriver = baseClass.readProperty("chromeDriver", "projectProperties.properties");
	     baseClass.initializeBrowser(browserDriver);
	     baseClass.navigateToURL(baseUrl);
    }
       
    @Test(priority=0)
	public void testCurrencyChange() throws IOException {
		Assert.assertFalse("Currency changed Successfully!!!", cryptoCurrencyHomePage.getDefaultSelectedCurrency().equals(cryptoCurrencyHomePage.changeCurrencyTo("HKD")));
	}
	
	@Test(priority = 1)
	public void testCoinMarketTabs() throws IOException, InterruptedException {
		Assert.assertEquals("Top 100 Cryptocurrencies by Market Capitalization",cryptoCurrencyHomePage.navigateToTop100CurrenciesTab().trim());
		Assert.assertEquals("All Cryptocurrencies",cryptoCurrencyHomePage.navigateToFullListCurrenciesTab().trim());
		Assert.assertEquals("Top Cryptocurrency Spot Exchanges\n" + 
				"CoinMarketCap ranks the top cryptocurrency exchanges based on traffic, liquidity, trading volumes of spot markets.",cryptoCurrencyHomePage.navigateToSpotExchangeCurrenciesTab());
		Assert.assertEquals("Top Cryptocurrency Derivatives Exchanges\n" +
				"CoinMarketCap ranks the top cryptocurrency derivatives exchanges based on trading volumes.",cryptoCurrencyHomePage.navigateToDerivativesExchangeCurrenciesTab().trim());
		Assert.assertEquals("Add your favorite coins and tokens to your watchlist",cryptoCurrencyHomePage.navigateToWatchlistCurrenciesTab().trim());
	}
	
  
	@Test(priority = 2)
	public void testToggleTheme() throws IOException {
		Assert.assertFalse("Theme Toggled Successfully!!!", cryptoCurrencyHomePage.getThemeBeforeToggle().equals(cryptoCurrencyHomePage.getThemeAfterToggle()));
	}
	
	@AfterTest
	public void closeBrowser() {
		cryptoCurrencyHomePage.closeBrowser();
	}
  
}
