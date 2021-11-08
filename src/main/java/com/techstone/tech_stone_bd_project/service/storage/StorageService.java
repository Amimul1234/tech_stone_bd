package com.techstone.tech_stone_bd_project.service.storage;

import com.techstone.tech_stone_bd_project.common.CommonResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Amimul Ehsan
 * @Created at 11/8/21
 * @Project tech_stone_bd_project
 */

public interface StorageService {
    CommonResponse uploadMultipartImage( String folder, MultipartFile multipartFile );

    String uploadEncodedImage( String image );

    byte[] downloadFile( String fileName );

    String deleteFile( String fileName );
}
