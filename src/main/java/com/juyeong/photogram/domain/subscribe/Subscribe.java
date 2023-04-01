package com.juyeong.photogram.domain.subscribe;


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
@Table(
        uniqueConstraints = {
        @UniqueConstraint(
                name = "subscribe_uk" ,
                columnNames = {"fromUserId", "toUserId"}
                ) }

)
// 하나만 걸거면 @Table 안써도 됨.. 두개 복합으로 걸거라 @Table 사용
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 중간테이블
    @JoinColumn(name="fromUserId")
    @ManyToOne
    private User fromUser; //구독하는 애

    @JoinColumn(name="toUserId")
    @ManyToOne
    private User toUser; //구독받는 애

    private LocalDateTime createDate;


    @PrePersist
    public void createDate () {
        this.createDate = LocalDateTime.now();
    }







}
