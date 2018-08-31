package cn.itcast.bos.service.base.impl;

import cn.itcast.bos.dao.SubAreaDao;
import cn.itcast.bos.domain.base.SubArea;
import cn.itcast.bos.service.base.SubAreaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-31
 * @Version 1.0
 */
@Service
@Transactional
public class SubAreaServiceImpl implements SubAreaService {

    @Autowired
    private SubAreaDao subAreaDao;

    @Override
    public void save(SubArea model) {

        model.setId(UUID.randomUUID().toString());
        subAreaDao.save(model);
    }

    @Override
    public Page<SubArea> pageQuery(Pageable pageable) {
        return subAreaDao.findAll(pageable);
    }

    @Override
    public List<SubArea> findByFixedAreaIsNull() {

        return subAreaDao.findByFixedAreaIsNull();
    }

}
