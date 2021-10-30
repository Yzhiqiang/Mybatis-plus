package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class Mpdemo1010ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1l, 2l, 3l));
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void selectByMap()
    {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        List<User> userList = userMapper.selectByMap(map);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void addUser()
    {
        User user = new User();
        user.setName("东方不败111");
        user.setAge(10);
        user.setEmail("ddddd@qq.com");
        int row = userMapper.insert(user);
        System.out.println(row);
    }
    @Test
    void update()
    {
        User user = new User();
        user.setId(1454358028181581825l);
        user.setAge(120);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }


    @Test
    void testOptimistic()
    {
        User user = userMapper.selectById(1454363195828355073l);
        user.setAge(200);
        userMapper.updateById(user);
        System.out.println("-------------------------------");
    }


    //分页查询
    @Test
    public void testPage()
    {
        //1.创建page对象
        //传入两个参数：当前页 和 每记录数
        Page<User> page = new Page<>(1,3);
        //调用mp分页查询过程，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page, null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());   //当前页
        System.out.println(page.getRecords());   //每页数据list集合
        System.out.println(page.getSize());      ///每页显示记录数
        System.out.println(page.getTotal());     //总记录数
        System.out.println(page.getPages());     //总页数
        System.out.println(page.hasNext());      //是否有下一页
        System.out.println(page.hasPrevious());  //是否有上一页

    }

    @Test
    void delete()
    {
        int result = userMapper.deleteById(1454382490293747714l);
        System.out.println(result);
    }

    @Test
    public void testSelectQuery()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //通过QueryWrapper设置条件
        //ge(大于等于). gt（大于） le（小于等于） lt（小于）
        //queryWrapper.ge("age", 30);   //查询年龄大于等于30

        //eq(等于), ne（不等于）
        //queryWrapper.eq("name","Jone");

        //between
        //queryWrapper.between("age",10, 30);

        //like
        queryWrapper.like("name","东方");
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
