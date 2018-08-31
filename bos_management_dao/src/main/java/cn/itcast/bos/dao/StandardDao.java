package cn.itcast.bos.dao;

import cn.itcast.bos.domain.base.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-25
 * @Version 1.0
 */
public interface StandardDao extends JpaRepository<Standard,Integer> {

    public List<Standard> findByOperator(String  operatingTime);

    @Query(value = "from Standard where name = ?")
    public List<Standard> queryByName(String name);

    @Query(nativeQuery = true,value = "select * from T_STANDARD where C_NAME = ?")
    public List<Standard> queryNativeByName(String name);

    @Transactional
    @Query(nativeQuery = true,value = "update T_STANDARD set C_NAME = ?1 where C_ID = ?2")
    @Modifying
    public void updateName(String name,int id);
}
