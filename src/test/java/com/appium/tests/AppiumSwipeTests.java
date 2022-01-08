package com.appium.tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

/**
 * Created by Saimanikandan V on 13-11-2021
 */
public class AppiumSwipeTests extends BaseTest {

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

}
