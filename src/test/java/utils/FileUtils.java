package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

@UtilityClass
public class FileUtils {

    public static boolean isFileDownloaded(String fileName, int timeoutSeconds) {
        String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
        File file = Paths.get(downloadPath, fileName).toFile();

        return AqualityServices.getConditionalWait().waitFor(
                () -> file.exists() && file.length() > 0,
                Duration.ofSeconds(timeoutSeconds)
        );
    }
}

