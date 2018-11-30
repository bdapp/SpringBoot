package me.bello.chapter0401.service;

import me.bello.chapter0401.bean.User;
import me.bello.chapter0401.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 保存对象
     * @param user
     * @return
     */
    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    /**d
     * 根据ID删除对象
     * @param id
     */
    @Transactional
    public void delte(int id){
        userRepository.deleteById(id);
    }


    /**
     * 查询所有数据
     * @return
     */
    @Transactional
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }


    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Transactional
    public User getById(int id){
        Optional<User> op = userRepository.findById(id);
        return op.get();
    }


    /**
     * 修改用户对象数据，自动更新到数据库
     * @param user
     */
    @Transactional
    public void update(User user){
        user.setUsername("1111");
        user.setLoginName("33333");
        userRepository.save(user);
    }

}
