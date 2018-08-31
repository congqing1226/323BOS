package cn.itcast.bos.service.base.impl;

import cn.itcast.bos.dao.FixedAreaDao;
import cn.itcast.bos.dao.SubAreaDao;
import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.domain.base.SubArea;
import cn.itcast.bos.service.base.FixedAreaService;
import cn.itcast.bos.service.base.SubAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-31
 * @Version 1.0
 */
@Service
@Transactional
public class FixedAreaServiceImpl implements FixedAreaService {

    @Autowired
    private FixedAreaDao fixedAreaDao;

    @Autowired
    private SubAreaDao subAreaDao;

    @Override
    public Page<FixedArea> pageQuery(Pageable pageable) {
        return fixedAreaDao.findAll(pageable);
    }

    @Override
    public void save(FixedArea model, String[] subAreaId) {

        model = fixedAreaDao.save(model);
        for (String id : subAreaId) {
            //先获取持久态对象
            SubArea subArea = subAreaDao.findOne(id);

            //设置 分区与定区关联
            subArea.setFixedArea(model);
        }
    }
}
