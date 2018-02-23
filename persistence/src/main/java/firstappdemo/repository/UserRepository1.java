package firstappdemo.repository;

import firstappdemo.entity.UserEntity;

import java.util.Collection;

public interface UserRepository1 {

    /**
     * 查找所有用户
     * @return findAll();
     */
    Collection<UserEntity> findAll();
}
