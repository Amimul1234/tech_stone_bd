package com.techstone.tech_stone_bd_project.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.techstone.tech_stone_bd_project.common.CommonResponse;
import com.techstone.tech_stone_bd_project.utils.HttpReqRespUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    private final AmazonS3 s3Client;
    @Value("${app.shopkpr.s3.bucket-name}")
    private String bucketName;

    public StorageServiceImpl( AmazonS3 s3Client ) {
        this.s3Client = s3Client;
    }

    public CommonResponse uploadMultipartImage( String folder, MultipartFile imageFile ) {

        log.info("StorageService::uploadFile() method call...");

        File imageFileObj = convertMultipartFileToFile(imageFile);

        UUID uuid = UUID.randomUUID();
        String fileNewName = "BackendImages/" + folder + "/" + uuid + imageFile.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileNewName, imageFileObj));

        boolean isSuccessful = imageFileObj.delete();

        if (!isSuccessful)
            log.error("StorageService::uploadFile()... Error deleting file");

        return HttpReqRespUtils.sendResponseToClient(OK, "Image upload successful",
                s3Client.getUrl(bucketName, fileNewName).toString());
    }

    @Override
    public String uploadEncodedImage( String image ) {
        byte[] decodedImage = Base64.getDecoder()
                .decode(image.getBytes(StandardCharsets.UTF_8));

        InputStream fis = new ByteArrayInputStream(decodedImage);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(decodedImage.length);
        metadata.setContentType("image/png");
        metadata.setCacheControl("public, max-age=31536000");

        UUID uuid = UUID.randomUUID();
        String fileNewName = "BackendImages/userImage/" + uuid;

        s3Client.putObject(bucketName, fileNewName, fis, metadata);
        s3Client.setObjectAcl(bucketName, fileNewName, CannedAccessControlList.PublicRead);

        return s3Client.getUrl(bucketName, fileNewName).toString();
    }

    @Override
    public byte[] downloadFile( String fileName ) {
        log.info("StorageService::downloadFile() method call...");
        return new byte[0];
    }

    @Override
    public String deleteFile( String fileName ) {
        log.info("StorageService::deleteFile() method call...");

        fileName = fileName.replace("https://shopkpr.s3.ap-south-1.amazonaws.com/", "");
        s3Client.deleteObject(bucketName, fileName);

        return "File deleted successfully";
    }

    private File convertMultipartFileToFile( MultipartFile file ) {

        log.info("StorageService::convertMultipartFileToFile() method call...");

        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("StorageService::convertMultipartFileToFile()... Error converting multipartFile to file", e);
        }

        return convertedFile;
    }
}
