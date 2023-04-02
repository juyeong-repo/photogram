package com.juyeong.photogram.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

    // 네이티브쿼리 쓰면 훨씬 쉬워지니까 그렇게 하자
    // m = made by myself

    @Modifying
    @Query(value = "INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery = true)
    int mSubscribe (int fromUserId, int toUserId); //PreparedStatement와 같다 -> 변경된 행의 개수 리턴, 실패시 -1

    @Modifying
    @Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery = true)
    int mUnSubscribe(int fromUserId, int toUserId);
    }



