package cn.itcast.bos.service.base;

import cn.itcast.bos.domain.base.Courier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-28
 * @Version 1.0
 */
public interface CourierService {
    void save(Courier courier);

    Page<Courier> pageQuery(Courier courier, Pageable pageable);

    void deleteBantch(String ids);
}
