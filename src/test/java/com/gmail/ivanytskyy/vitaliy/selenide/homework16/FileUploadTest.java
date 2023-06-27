package com.gmail.ivanytskyy.vitaliy.selenide.homework16;

import com.gmail.ivanytskyy.vitaliy.utils.TestProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 25/06/2023
 */
public class FileUploadTest extends BaseTest{
    private static final String SUCCESS_UPLOAD_MESSAGE = "File Uploaded!";

    @Test(description = "Test upload a file",  dependsOnGroups = "download", priority = 10)
    public void fileUploadTest() throws IOException{
        String fileName = TestProperties.getInstance().getProperty("file_name_hw16");
        File file = new File(TestProperties.getInstance().getProperty("path_to_file_hw16"));
        String resultMessage = openApp()
                .openFileUploadPage()
                .selectFile(file.getAbsolutePath(), fileName)
                .uploadFile()
                .getSuccessUploadMessage();
        Assert.assertEquals(resultMessage, SUCCESS_UPLOAD_MESSAGE);
    }
}