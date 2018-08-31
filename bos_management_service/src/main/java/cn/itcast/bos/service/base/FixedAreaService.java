package cn.itcast.bos.service.base;

import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.domain.base.SubArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; /**
 * @author congzi
 * @Description:
 * @create 2018-08-31
 * @Version 1.0
 */
public interface FixedAreaService {

    Page<FixedArea> pageQuery(Pageable pageable);

    void save(FixedArea model, String[] subAreaId);
}
