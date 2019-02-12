package com.example.demo.example1.Repository;

import com.example.demo.example1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈〉
 *
 * @author 二中回音哥
 * @create 2019/1/19
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
