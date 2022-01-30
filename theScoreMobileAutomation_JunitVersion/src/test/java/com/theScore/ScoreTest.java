package com.theScore;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ScoreTest {
    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //we can specify capability name with MobileCapabilityType class
        //we also have AndroidMobileCapabilityType that is used to specify Android specific capabilities
        caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/mm/Documents/theScore.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(url, caps);
    }

    @Test
    public void score1Test() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("Appium is running");
        //on login page, click getStarted
        driver.findElement(By.id("com.fivemobile.thescore:id/action_button_text")).click();
        Thread.sleep(5000);
        //click continue to main page
        driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
        //click
        Thread.sleep(2000);
        driver.findElement(By.id("com.fivemobile.thescore:id/btn_disallow")).click();
        //click add tabs of favorite
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='NBA']")).click();
        //parameterize RECOMMENDED,NHL, NFL, MLB....
        //select first option
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")).click();
        Thread.sleep(3000);

        //click continue button
        driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
        Thread.sleep(3000);
        //click newly added favorite team icon
        driver.findElement(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")).click();
        Thread.sleep(2000);
        //validate the page and team name
        MobileElement teamName = driver.findElement(By.id("com.fivemobile.thescore:id/team_name"));
        String team = teamName.getText();
        Assertions.assertEquals("Boston Celtics",team);

        //click PLAYER STATS
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Player Stats\"]")).click();


        //validate the page by name of the player
        MobileElement bestPlayer = driver.findElement(By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"));
        String actual = bestPlayer.getText();
        String expected = "Jayson Tatum";
        Assertions.assertEquals(expected, actual);

        //navigate back to previous page
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

    }
    @AfterEach
    public void teardown(){
        driver.closeApp();
        driver = null;

    }


}
