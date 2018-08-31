package cn.itcast.bos.service.base;

import cn.itcast.bos.domain.base.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-30
 * @Version 1.0
 */
public interface AreaService {
    void save( List<Area> list);

    Page<Area> pageQuery(Pageable pageable);

    List<Area> findAll();
}
