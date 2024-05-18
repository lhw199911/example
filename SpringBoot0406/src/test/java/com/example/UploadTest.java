package com.example;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/05/06/21:08
 * @Description:
 */

@SpringBootTest
public class UploadTest {

    @Test
    public void testUpload() {
        MinioClient client = MinioClient.builder().endpoint("http://192.168.80.121:9000").credentials("ROOTNAME", "CHANGEME123").build();

        File file = new File("C:/Users/lhw19/Desktop/素材/pic/1.jpg");
        try {
            InputStream fileInput = new FileInputStream(file);
            PutObjectArgs icon = PutObjectArgs.builder()
                    .contentType("image/jpeg")
                    .object("1.jpg")
                    .bucket("icon")
                    .stream(fileInput, file.length(), -1)
                    .build();
            client.putObject(icon);
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException |
                 XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

}
