package com.juyeong.photogram.domain.user;

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
    private LocalDateTime createDate;

    @PrePersist 
    public void createDate () {
        this.createDate = LocalDateTime.now();
    }



}
