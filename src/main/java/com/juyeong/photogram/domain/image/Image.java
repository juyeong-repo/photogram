package com.juyeong.photogram.domain.image;


import com.juyeong.photogram.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption; // 사진 밑에 글

    private String postImageUrl; // 사진을 전송받아서 서버 특정 폴더에 저장 -> 디비에 저장된 경로를 insert

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; //유저가 1 이미지가 N -> 이미지 입장에서 manyToOne
    private LocalDateTime createDate;

    @PrePersist
    public void createDate () {
        this.createDate = LocalDateTime.now();
    }


    //좋아요 , 댓글 필드 필요


}
