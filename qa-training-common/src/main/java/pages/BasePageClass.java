package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageClass {
    protected WebDriver driver;
    public BasePageClass(WebDriver driver) {
        this.driver = driver;
    }
    protected WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }
    protected void openPage(String pageUrl){
        driver.get(pageUrl);
    }
    protected boolean waitForUrlChange(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }
    protected boolean waitForUrlChangeWithContains(String url, int timeout){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        String x = driver.getCurrentUrl();
        return x.contains(url);
    }
    protected boolean isWebElementDisplayed(By locator) {
        WebElement element = getWebElement(locator);
        return element.isDisplayed();
    }
    protected WebElement waitForWebElementToBeClickable(By locator, int timeout) {
        WebElement element = getWebElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void clickOnWebElement(By locator){
        WebElement element = getWebElement(locator);
        element.click();
    }
    protected void clickOnWebElement(By locator,int timeout){
        WebElement element = getWebElement(locator);
        waitForWebElementToBeClickable(locator,timeout);
        element.click();
    }
    protected void doubleClickOnWebElement(By locator,int timeout){
        Actions act = new Actions(driver);
        WebElement element = getWebElement(locator);
        waitForWebElementToBeClickable(locator,timeout);
        act.doubleClick(element).perform();
    }
    protected void doubleClickAndType(By locator,int timeout,String text){
        doubleClickOnWebElement(locator,timeout);
        clearAndTypeTextToWebElement(locator,text);
    }
    protected void typeTextToWebElement(By locator, String text){
        WebElement element = getWebElement(locator);
        element.sendKeys(text);
    }
    protected void clearAndTypeTextToWebElement(By locator, String text) {
        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    protected void clearAndTypeTextToWebElement(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    protected void scrollToWebElement(By locator){
        WebElement element = getWebElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    protected void scrollToWebElementJS(By locator) {
        WebElement element = getWebElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected String getAttributeFromWebElement(By locator, String attribute) {
        WebElement element = getWebElement(locator);
        return element.getAttribute(attribute);
    }
    protected String getValueFromWebElement(By locator) {
        return getAttributeFromWebElement(locator, "value");
    }
    protected String getTextFromWebElement(By locator) {
        WebElement element = getWebElement(locator);
        return element.getText();
    }
    protected String getValueFromWebElementJS(By locator) {
        WebElement element = getWebElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return.arguments[0].value", element);
    }
    protected void deselectFromDropdown(By locator){
        Select drpCountry = new Select(getWebElement(locator));
        drpCountry.deselectAll();
    }
    protected void selectFromDropdown(By locator, String value){
        Select drpCountry = new Select(getWebElement(locator));
        deselectFromDropdown(locator);
        drpCountry.selectByVisibleText(value);
    }
    protected void selectFromDropdown(By locator, int index){
        Select drpCountry = new Select(getWebElement(locator));
        drpCountry.selectByIndex(index);
    }
    protected void selectMyltipleFromDropDown(By locator, String array[]){
        Select drpCountry = new Select(getWebElement(locator));
        deselectFromDropdown(locator);
        if (drpCountry.isMultiple())
        {
            for(int i = 0; i < array.length; i++){
                drpCountry.selectByVisibleText(array[i]);
            }
        }
    }
    protected void selectMyltipleFromDropDown(By locator, int array[]){
        Select drpCountry = new Select(getWebElement(locator));
        deselectFromDropdown(locator);
        if (drpCountry.isMultiple())
        {
            for(int i = 0; i < array.length; i++){
                drpCountry.selectByIndex(array[i]);
            }
        }
    }
    protected void dragAndDrop(By sourceLocator,By destinationLocator){
        WebElement pointA = getWebElement(sourceLocator);
        WebElement pointB = getWebElement(destinationLocator);
        Actions action = new Actions(driver);
        action.dragAndDrop(pointA, pointB).build().perform();
    }
    protected void singleCheck(By locator){
        WebElement checkbox = getWebElement(locator);
        checkbox.click();
    }






}
