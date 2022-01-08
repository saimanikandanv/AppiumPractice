package com.appium.tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by Saimanikandan V on 13-11-2021
 */
public class AppiumTests extends BaseTest {

    @Test
    public void appiumTests() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = getCapabilites();
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        driver.findElementById("android:id/button1").click();
    }

    @Test
    public void androidTapOptionsTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = getCapabilites();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        WebElement expandedList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(tapOptions().withElement(element(expandedList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        tapAction.longPress(LongPressOptions.longPressOptions().withElement(element(peopleNames)).withDuration(Duration.ofSeconds(3))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }

    @Test
    public void androidSwipeOptionsTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = getCapabilites();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        WebElement expandedList = driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(tapOptions().withElement(element(expandedList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        WebElement minute15 = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement minute45 = driver.findElementByXPath("//*[@content-desc='45']");
        tapAction.longPress(LongPressOptions.longPressOptions().withElement(element(minute15))
                .withDuration(Duration.ofSeconds(2))).moveTo(element(minute45)).release().perform();

    }

    @Test
    public void scrollingTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = getCapabilites();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"));");
    }

    @Test
    public void dragAndDropTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = getCapabilites();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        TouchAction tAction = new TouchAction(driver);
        WebElement first = driver.findElementsByClassName("android.view.View").get(0);
        WebElement second  = driver.findElementsByClassName("android.view.View").get(1);
        tAction.longPress(element(first))
               .moveTo(element(second)).release().perform();
    }
}
