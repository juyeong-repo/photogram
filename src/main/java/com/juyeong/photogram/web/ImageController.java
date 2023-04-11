package com.juyeong.photogram.web;

import com.juyeong.photogram.config.auth.PrincipalDetails;
import com.juyeong.photogram.handler.ex.CustomValidationApiException;
import com.juyeong.photogram.handler.ex.CustomValidationException;
import com.juyeong.photogram.service.ImageService;
import com.juyeong.photogram.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping( {"/", "/image/story"})
    public String story() {
        return "image/story";
    }

    //인기게시물
    @GetMapping("image/popular")
    public String popular() {
        return "image/popular";
    }

    @GetMapping( "/image/upload")
    public String upload() {
        return "image/upload";
    }


    @PostMapping("/image")
    public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        //어떤 정보를 받아야할까 -> 파일을 받아야하므로 -> dto 만들자
        //로그인되어있는 유저 정보가 있어야 한다 -> principalDetails
        //서비스 호출 -> 리턴하면 어디로 보내야하나? 업로드 .. 후에 자기 피드메인으로 보내자

        if (imageUploadDto.getFile().isEmpty()) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }


        imageService.uploadFile(imageUploadDto, principalDetails);
        return "redirect:/user/" + principalDetails.getUser().getId();
    }

}
