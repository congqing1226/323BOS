package cn.itcast.bos.action.base;

import cn.itcast.bos.action.common.BaseAction;
import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.domain.base.SubArea;
import cn.itcast.bos.service.base.FixedAreaService;
import cn.itcast.bos.service.base.SubAreaService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

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
@Results({@Result(name="list",type="redirect",location="/pages/base/fixed_area.jsp")})
public class FixedAreaAction extends BaseAction<FixedArea> {

    @Autowired
    private FixedAreaService fixedAreaService;

    /**
     * 需要进行关联的分区ID
     */
    private String[] subAreaId;

    public void setSubAreaId(String[] subAreaId) {
        this.subAreaId = subAreaId;
    }

    @Action("fixedAreaAction_save")
    public String save(){
        fixedAreaService.save(model,subAreaId);
        return "list";
    }


    @Action("fixedAreaAction_pageQuery")
    public String pageQuery(){

        Pageable pageable = new PageRequest(page - 1,rows);
        Page<FixedArea> page = fixedAreaService.pageQuery(pageable);

        this.javaToJson(page,new String[]{"subAreas","couriers"});

        return NONE;
    }








}
