package cn.itcast.bos.action.base;

import cn.itcast.bos.action.common.BaseAction;
import cn.itcast.bos.domain.base.SubArea;
import cn.itcast.bos.service.base.SubAreaService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-31
 * @Version 1.0
 */

@Controller
@Scope("prototype")
@Namespace("/")//<package namespace extends
@ParentPackage("struts-default")
@Results({@Result(name="list",type="redirect",location="/pages/base/sub_area.jsp")})
public class SubAreaAction extends BaseAction<SubArea> {

    @Autowired
    private SubAreaService subAreaService;

    @Action("subareaAction_save")
    public String save(){
        subAreaService.save(model);
        return "list";
    }


    @Action("subAreaAction_pageQuery")
    public String pageQuery(){

        Pageable pageable = new PageRequest(page - 1,rows);

        Page<SubArea> page = subAreaService.pageQuery(pageable);

        javaToJson(page,new String[]{"subAreas"});

        return NONE;
    }



    /**
     * 查询所有未关联定区的分区数据
     * @return
     */
    @Action("subAreaAction_findAll")
    public String findAll(){

        List<SubArea> list = subAreaService.findByFixedAreaIsNull();

        this.javaToList(list,new String[]{"subAreas"});

        return NONE;
    }
}
