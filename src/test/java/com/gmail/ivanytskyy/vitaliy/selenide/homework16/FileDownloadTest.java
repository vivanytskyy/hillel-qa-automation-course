package com.gmail.ivanytskyy.vitaliy.selenide.homework16;

import com.gmail.ivanytskyy.vitaliy.utils.TestProperties;
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
 * @date 25/06/2023
 */
public class FileDownloadTest extends BaseTest{

    @Test(description = "Download the file and add several lines to its", groups = {"download"}, priority = 10)
    public void fileDownloadTest() throws IOException {
        File file = openApp().openFileDownloadPage().downloadFile();
        TestProperties.getInstance().setProperty("path_to_file_hw16", file.getAbsolutePath());
        List<String> newLines = List.of(
                "\r\n",
                "test text 1-st line",
                "test text 2-st line");
        List<String> resultLines = Files.readAllLines(
                Files.write(file.toPath(), newLines, StandardOpenOption.APPEND));
        Assert.assertTrue(resultLines.contains(newLines.get(1)));
        Assert.assertTrue(resultLines.contains(newLines.get(2)));
    }
}