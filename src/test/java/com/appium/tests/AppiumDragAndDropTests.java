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
public class AppiumDragAndDropTests extends BaseTest {

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
