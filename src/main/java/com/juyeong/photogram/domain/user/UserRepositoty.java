package com.juyeong.photogram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Integer> {
    // 어노테이션 지정할 필요없이 ioc 됨 (extends)



}
