package firstappdemo.repository;

import firstappdemo.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link UserEntity}  {@link Repository}
 */

@Repository
public class UserRepository implements UserRepository1 {
    /**
     * 采用内存型的存储方式-->Map
     */

    private final ConcurrentMap<Integer,UserEntity> repository = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator =
            new AtomicInteger();



    /**
     * 保存用户对象
     * @param userEntity {@link UserEntity} 对象
     * @return 如果成功，返回<code>true</code>，否则返回<code>false</code>
     */
    public boolean save(UserEntity userEntity){
        //ID从1开始
        Integer id = idGenerator.incrementAndGet();
        userEntity.setId(id);
        return repository.put(id,userEntity)== null;
    }

    /**
     * 获取所有用户
     * @return 返回所有用户
     */
    @Override
    public Collection<UserEntity> findAll() {
        return repository.values();
    }
}
