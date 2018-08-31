package cn.itcast.bos.service.base;

import cn.itcast.bos.domain.base.SubArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-31
 * @Version 1.0
 */
public interface SubAreaService {
    void save(SubArea model);

    Page<SubArea> pageQuery(Pageable pageable);

    List<SubArea> findByFixedAreaIsNull();
}
