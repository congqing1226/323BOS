package cn.itcast.bos.action.base;

import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.StandardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-27
 * @Version 1.0
 */

@Controller
@Scope("prototype")
@Namespace("/")//<package namespace extends
@ParentPackage("struts-default")
@Results({@Result(name="list",type="redirect",location="/pages/base/standard.jsp")})
public class StandardAction extends ActionSupport implements ModelDriven<Standard> {

    private Standard standard = new Standard();

    @Override
    public Standard getModel() {
        return standard;
    }

    //当前页
    private int page;

    //每页显示条数
    private int rows;

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }


    @Autowired
    private StandardService standardService;

    @Action("standarAction_save")
    public String save(){

        standardService.save(standard);

        return "list";
    }

    @Action("standardAction_pageQuery")
    public String pageQuery(){
        try{

            Pageable pageable = new PageRequest(page - 1, rows);
            Page<Standard> page = standardService.pageQuery(pageable);

            Map<String,Object> map = new HashMap<>();
            map.put("total",page.getTotalElements());
            map.put("rows",page.getContent());
            String json = JSONObject.fromObject(map).toString();

            ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
            ServletActionContext.getResponse().getWriter().write(json);

        }catch (Exception e){
            e.printStackTrace();
        }
        return NONE;
    }

    @Action("standard_findAll")
    public String findAll() throws Exception{
        List<Standard> list = standardService.findAll();

        String string = JSONArray.fromObject(list).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(string);

        return NONE;

    }





}
