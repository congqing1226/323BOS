package cn.itcast.bos.dao.test;

import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.domain.base.Standard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-25
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StandardDaoTest {

    @Autowired
    private StandardDao standardDao;

    @Test
    public void test1(){

        List<Standard> list = standardDao.findAll();

        System.out.println(list);
    }

    @Test
    public void test2(){

        Standard standard = new Standard();
        standard.setId(1);
        standard.setName("标准01");

        standardDao.save(standard);
    }

    @Test
    public void test3(){
        Standard standard = new Standard();
        standard.setId(2);
        standard.setName("标准02");
        standard.setOperator("001号");
        standardDao.save(standard);
    }

    @Test
    public void testDelete(){
        standardDao.delete(1);
    }

    @Test
    public void findByoperatingTime(){
        List<Standard> byOperator = standardDao.findByOperator("001号");

        System.out.println(byOperator);

    }

    @Test
    public void findByQueryName(){

        List<Standard> list = standardDao.queryByName("标准02");
        System.out.println(list);
    }

    @Test
    public void queryNativeByName(){

        List<Standard> list = standardDao.queryNativeByName("标准02");
        System.out.println(list);
    }

    @Test
    public void updateName(){

      standardDao.updateName("标准01",2);
    }



}
