package cn.itcast.bos.service.base.impl;

import cn.itcast.bos.dao.CourierDao;
import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.CourierService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-28
 * @Version 1.0
 */
@Service
@Transactional
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierDao courierDao;

    @Override
    public void save(Courier courier) {
        courierDao.save(courier);
    }

    @Override
    public Page<Courier> pageQuery(Courier courier, Pageable pageable) {

        //快递员编号
        final String courierNum = courier.getCourierNum();
        final String company = courier.getCompany();
        final String type = courier.getType();
        final Standard standard = courier.getStandard();

        //创建条件查询对象
        Specification<Courier> specification = new Specification<Courier>() {

            @Override
            public Predicate toPredicate
                    (Root<Courier> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<>();

                if(StringUtils.isNotBlank(courierNum)){
                    Predicate p1 = criteriaBuilder.equal(root.get("courierNum").as(String.class), courierNum);
                    list.add(p1);
                }

                if(StringUtils.isNotBlank(company)){
                    Predicate p2 = criteriaBuilder.like(root.get("company").as(String.class),company);
                    list.add(p2);
                }

                if(StringUtils.isNotBlank(type)){
                    Predicate p3 =criteriaBuilder.equal(root.get("type").as(String.class),type);
                    list.add(p3);
                }

                //快递员与收派标准
                if(standard != null && StringUtils.isNotBlank(standard.getName())){

                    Join<Object, Object> join = root.join("standard", JoinType.INNER);
                    Predicate p4 =criteriaBuilder.equal(join.get("name").as(String.class),standard.getName());
                    list.add(p4);
                }

                if(list!=null && list.size()==0){
                    return null;
                }

                Predicate[] predicates = new Predicate[list.size()];

                predicates = list.toArray(predicates);

                return criteriaBuilder.and(predicates);
            }
        };

        return courierDao.findAll(specification,pageable);
    }

    @Override
    public void deleteBantch(String ids) {

        if(StringUtils.isNotBlank(ids)){
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                int anInt = Integer.parseInt(id);
                courierDao.logicDele(anInt);
            }
            
        }

    }
}
