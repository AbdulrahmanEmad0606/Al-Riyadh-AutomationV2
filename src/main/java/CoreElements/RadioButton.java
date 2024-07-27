package CoreElements;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

/**
 * This class represents a RadioButton element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides a method to click the RadioButton.
 */
public class RadioButton extends ClickableElements{
    /**
     * Constructor for the RadioButton class.
     * It sets the locator for the RadioButton element.
     * @param radioBtn The locator for the RadioButton element.
     */
    public RadioButton(By radioBtn){
        this.setLocator(radioBtn);
    }
    @SneakyThrows
    public void radioBtnClick() {
        waitElement(locator);
        find(locator).click();
        try {
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(
                    ".\\TestData\\ScreenShots\\" + getClass().getSimpleName() + "\\" + new Throwable().getStackTrace()[0].getMethodName() + "_" + getCurrentDate() + ".png"));
        } catch (Exception ignored) {
        }
    }
}