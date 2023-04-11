package com.juyeong.photogram.domain.user;

import com.juyeong.photogram.domain.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
     // JPA - 자바로 데이터를 DB에 영구적으로 저장할 수 있는 API 제공
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI, sequence
    private int id;
    @Column(length = 20 , unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;
    private String website;
    private String bio;
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl;
    private String role;

    //mappedBy 연관관계의 주인이 아니다. 그러니 테이블에 컬럼 만들지말라고 말해주는 것.
    //유저 셀릭트 할 때 해당 유저아이디로 등록된 이미지 모두를 가져오라는 뜻
    // fetch = FetchType.LAZY가 디폴트. 유저를 셀렉트할 때 해당 유저아이디로 등록된 image 갸져오지마 -> getImages 함수의 이미지들이 호출될 때 가져와
    // eager 전략은 유저를 셀렉트할 때 userID로 등록된 image뜰을 전부 join 해서 가져오기
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Image> images;

    private LocalDateTime createDate;

    @PrePersist 
    public void createDate () {
        this.createDate = LocalDateTime.now();
    }



}
