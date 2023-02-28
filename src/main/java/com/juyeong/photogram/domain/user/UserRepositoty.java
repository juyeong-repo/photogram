package com.juyeong.photogram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Integer> {
    // 어노테이션 지정할 필요없이 ioc 됨 (extends)

    // JPA query creation from method names 간단한 쿼리는 내장되어있으나 내가 직접 만들고 싶을 때 사용
    // 복잡한건 네이티브 쿼리 사용

    User findByUsername(String username);



}
