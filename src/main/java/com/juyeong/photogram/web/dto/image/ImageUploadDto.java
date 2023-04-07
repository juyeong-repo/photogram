package com.juyeong.photogram.web.dto.image;

import com.juyeong.photogram.domain.image.Image;
import com.juyeong.photogram.domain.user.User;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageUploadDto {
    // 파일, 캡션을 받을 것 -> jsp form 태그 통해

    private MultipartFile file;
    private String caption;

    public Image toEntity(String imageFileName, User user) {
        return Image.builder()
                .caption(caption)
                .postImageUrl(imageFileName)
                .user(user)
                .build();
    }

}

