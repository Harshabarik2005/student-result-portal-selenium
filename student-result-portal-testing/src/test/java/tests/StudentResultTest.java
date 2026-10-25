package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentResultTest {

    @Test
    public void testValidStudentSearch() {

        WebDriver driver = new ChromeDriver();

        try {
            // Open the student result portal
            driver.get(
                "http://127.0.0.1:5500/student-result-portal/index.html"
            );

            // Find the USN input and enter a valid student USN
            WebElement usnInput = driver.findElement(By.id("usn"));
            usnInput.sendKeys("1BI23CS001");

            // Click the Search button
            driver.findElement(By.id("search-btn")).click();

            // Verify that the result is displayed
            WebElement resultSection =
                driver.findElement(By.id("result-section"));

            Assert.assertTrue(
                resultSection.isDisplayed(),
                "Student result should be displayed"
            );

            // Verify that the correct student is shown
            WebElement resultDetails =
                driver.findElement(By.id("result-details"));

            Assert.assertTrue(
                resultDetails.getText().contains("Rahul Sharma"),
                "The result should belong to Rahul Sharma"
            );

        } finally {
            // Always close the browser
            driver.quit();
        }
    }


@Test
public void testInvalidStudentSearch() {

    WebDriver driver = new ChromeDriver();

    try {
        // Open the student result portal
        driver.get(
            "http://127.0.0.1:5500/student-result-portal/index.html"
        );

        // Enter a USN that does not exist
        driver.findElement(By.id("usn"))
              .sendKeys("1BI23CS999");

        // Click Search
        driver.findElement(By.id("search-btn")).click();

        // Verify the error message
        WebElement message = driver.findElement(By.id("message"));

        Assert.assertEquals(
            message.getText(),
            "No result found for this USN.",
            "An invalid USN should display the correct error message"
        );

        // Verify that no result section is displayed
        WebElement resultSection =
            driver.findElement(By.id("result-section"));

        Assert.assertFalse(
            resultSection.isDisplayed(),
            "Student result should remain hidden for an invalid USN"
        );

    } finally {
        driver.quit();
    }
}

@Test
public void testEmptyStudentSearch() {

    WebDriver driver = new ChromeDriver();

    try {
        driver.get(
            "http://127.0.0.1:5500/student-result-portal/index.html"
        );

        // Leave the USN input empty and click Search
        driver.findElement(By.id("search-btn")).click();

        // Verify the validation message
        WebElement message = driver.findElement(By.id("message"));

        Assert.assertEquals(
            message.getText(),
            "Please enter your USN.",
            "An empty USN should display a validation message"
        );

        // Verify that no result is displayed
        WebElement resultSection =
            driver.findElement(By.id("result-section"));

        Assert.assertFalse(
            resultSection.isDisplayed(),
            "Student result should remain hidden for an empty USN"
        );

    } finally {
        driver.quit();
    }
}


}
