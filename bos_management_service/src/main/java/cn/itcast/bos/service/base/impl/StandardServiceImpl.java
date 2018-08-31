package cn.itcast.bos.service.base.impl;

import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.StandardService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author congzi
 * @Description: 收派标准
 * @create 2018-08-27
 * @Version 1.0
 */
@Service
@Transactional
public class StandardServiceImpl implements StandardService{

    @Autowired
    private StandardDao standardDao;

    @Override
    public void save(Standard standard) {
        standardDao.save(standard);
    }

    @Override
    public Page<Standard> pageQuery(Pageable pageable) {
        return standardDao.findAll(pageable);
    }

    @Override
    public List<Standard> findAll()  {

        List<Standard> list = standardDao.findAll();

        return list;
    }
}
