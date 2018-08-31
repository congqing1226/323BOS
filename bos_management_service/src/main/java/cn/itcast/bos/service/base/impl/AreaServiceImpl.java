package cn.itcast.bos.service.base.impl;

import cn.itcast.bos.dao.AreaDao;
import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.service.base.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-30
 * @Version 1.0
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public void save( List<Area> list) {
        areaDao.save(list);
    }

    @Override
    public Page<Area> pageQuery(Pageable pageable) {
        return areaDao.findAll(pageable);
    }

    @Override
    public List<Area> findAll() {
        return areaDao.findAll();
    }
}
