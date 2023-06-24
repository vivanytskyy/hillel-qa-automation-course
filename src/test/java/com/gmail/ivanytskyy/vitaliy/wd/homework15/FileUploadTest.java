package com.gmail.ivanytskyy.vitaliy.wd.homework15;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/06/2023
 */
public class FileUploadTest extends BaseTest{
    private static final String FILE_NAME = "some-file.txt";
    private static final String SUCCESS_UPLOAD_MESSAGE = "File Uploaded!";

    @Test(description = "Test upload a file", dependsOnGroups = {"download"}, priority = 10)
    public void fileUploadTest(){
        String absolutePath = new File("target" + File.separator + "downloads" + File.separator + FILE_NAME)
                .getAbsolutePath();
        String resultMessage = openApp()
                .openFileUploadPage()
                .selectFile(absolutePath)
                .uploadFile(FILE_NAME)
                .getSuccessUploadMessage();
        Assert.assertEquals(resultMessage, SUCCESS_UPLOAD_MESSAGE);
    }
}