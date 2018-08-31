package cn.itcast.bos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.bos.domain.base.Courier;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CourierDao extends JpaRepository<Courier, Integer>,JpaSpecificationExecutor<Courier> {
    @Transactional
    @Query("update Courier set deltag = '1' where id = ?")
    @Modifying
    public void logicDele(int id);
}
