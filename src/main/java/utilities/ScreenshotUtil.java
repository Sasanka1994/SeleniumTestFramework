package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String screenshotDirectory) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path screenshotPath = Paths.get(screenshotDirectory, generateScreenshotFilename());

        try {
            Files.createDirectories(screenshotPath.getParent());
            Files.copy(screenshot.toPath(), screenshotPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + screenshotPath, e);
        }
    }

    private static String generateScreenshotFilename() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS");
        return "screenshot-" + dateFormat.format(new Date()) + ".png";
    }

}
