package cn.itcast.bos.dao;

import cn.itcast.bos.domain.base.SubArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-31
 * @Version 1.0
 */
public interface SubAreaDao extends JpaRepository<SubArea,String> {

    //select t.* ,t.rowid from T_SUB_AREA where t.C_FIXEDAREA_ID is NULL
    List<SubArea> findByFixedAreaIsNull();
}
