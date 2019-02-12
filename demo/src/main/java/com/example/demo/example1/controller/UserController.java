package com.example.demo.example1.controller;

import com.example.demo.example1.Repository.UserPagingAndSortingRepository;
import com.example.demo.example1.Repository.UserRepository;
import com.example.demo.example1.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 〈〉
 *
 * @author 二中回音哥
 * @create 2019/1/19
 * @since 1.0.0
 */
@RestController
@RequestMapping("api")
@Api(value = "UserController相关的api",tags = {"用户controller"})
public class UserController {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    /**
     *
     * @param user
     */
    @ApiOperation(value = "添加一个用户",notes = "添加某个用户到数据库")
    @PostMapping("/add")

    public void addUser(@RequestBody @ApiParam(name = "用户对象",value = "json格式",required = true) User user){
        userRepository.save(user);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户",notes ="查询到所有用户" )
    @PostMapping("/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询指定用户",notes ="查询到单个用户" )
    @PostMapping("/info/{id}")
    public Optional<User> findOne(@PathVariable Long id) {

        return userRepository.findById(id);
    }

    /**
     *
     * @param id
     */
    @ApiOperation(value = "根据id删除用户",notes ="删除指定用户" )
    @PostMapping("/deleteById")
    public void deletById(@RequestParam Long id) {
        userRepository.deleteById(id);

    }

    /**
     *
     * @param user
     */
    @ApiOperation(value = "修改用户信息", notes = "根据该url修改用户信息")
    @PostMapping("/updateUser/{id}")
    public void updateById(@PathVariable Long id,
                           @RequestBody User user) {
        User one = userRepository.getOne(id);
        user.setId(id);
        BeanUtils.copyProperties(user, one);
        userRepository.save(user);
    }


    /**
     *分页
     * @return
     */
    @ApiOperation(value = "用户信息分页",notes ="通过该url实现用户信息分页" )
    @PostMapping("/userPage")
    public Page<User> getAllUserPage(){
        return userPagingAndSortingRepository.findAll(new PageRequest(2, 5));
    }

    /**
     * 排序
     * @return
     */
    @ApiOperation(value = "排序查询方法",notes ="排序查询方法" )
    @PostMapping("/sort")
    public Iterable<User> getAllUserWithSort(){
        return userPagingAndSortingRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name")));
    }


}
