package com.techstone.tech_stone_bd_project.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

@Configuration
public class StorageConfig {

    @Value("${app.shopkpr.s3.access-key}")
    private String awsAccessKey;
    @Value("${app.shopkpr.s3.secret-key}")
    private String awsSecretKey;
    @Value("${app.shopkpr.s3.region}")
    private String bucketRegion;

    @Bean
    public AmazonS3 amazonS3Client() {

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(bucketRegion)
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();

    }
}
