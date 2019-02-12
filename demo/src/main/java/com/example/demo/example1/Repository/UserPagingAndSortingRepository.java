package com.example.demo.example1.Repository;

import com.example.demo.example1.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 〈〉
 *
 * @author 二中回音哥
 * @create 2019/1/20
 * @since 1.0.0
 */
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User,Long> {

}
