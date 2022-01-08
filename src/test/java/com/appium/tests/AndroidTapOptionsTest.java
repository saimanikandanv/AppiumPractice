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
public class AndroidTapOptionsTest extends BaseTest {

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

}
