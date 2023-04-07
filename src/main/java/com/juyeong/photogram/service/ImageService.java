package com.juyeong.photogram.service;


import com.juyeong.photogram.config.auth.PrincipalDetails;
import com.juyeong.photogram.domain.image.Image;
import com.juyeong.photogram.domain.image.ImageRepository;
import com.juyeong.photogram.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {
    //사진업로드 함수

    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadFolder;


    public void uploadFile(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) {
        UUID uuid = UUID.randomUUID();

        String imageFileName = uuid + "_" +imageUploadDto.getFile().getOriginalFilename();
        System.out.println("이미지 파일 이름 :::::::::::::" + imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);

        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }



        // image 테이블에 저장
        Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser());
        Image imageEntity = imageRepository.save(image);

        System.out.println(imageEntity);

    }
}
