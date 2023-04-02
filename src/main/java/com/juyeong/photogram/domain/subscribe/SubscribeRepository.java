package com.juyeong.photogram.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

    // 네이티브쿼리 쓰면 훨씬 쉬워지니까 그렇게 하자



}
