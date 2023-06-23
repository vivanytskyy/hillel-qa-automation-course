package com.gmail.ivanytskyy.vitaliy.wd.homework15;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class FileDownloadTest extends BaseTest{
    private static final String FILE_NAME = "some-file.txt";

    @Test(description = "Download the file and add several lines to its", groups = {"download"}, priority = 10)
    public void fileDownloadTest() throws InterruptedException, IOException {
        String path = new File("target" + File.separator + "downloads" + File.separator + FILE_NAME)
                .getAbsolutePath();
        openApp().openFileDownloadPage().downloadFile();
        Assert.assertTrue(waitForFileDownloaded(path));
        File file = new File(path);
        List<String> oldLines = Files.readAllLines(file.toPath());
        List<String> newLines = List.of(
                "test text 1-st line",
                "test text 2-st line");
        List<String> resultLine = Files.readAllLines(
                Files.write(file.toPath(), newLines, StandardOpenOption.APPEND));
        Assert.assertTrue(resultLine.contains(oldLines.get(0)));
        Assert.assertTrue(resultLine.contains(newLines.get(0)));
        Assert.assertTrue(resultLine.contains(newLines.get(1)));
    }
}