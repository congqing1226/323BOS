package cn.itcast.bos.action.base;

import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.service.base.CourierService;
import cn.itcast.bos.service.base.StandardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.io.IOException;
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
@Results({@Result(name="list",type="redirect",location="/pages/base/courier.jsp")})
public class CourierAction extends ActionSupport implements ModelDriven<Courier> {

    private Courier courier = new Courier();

    @Override
    public Courier getModel() {
        return courier;
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
    private CourierService courierService;

    @Action("courierAction_save")
    public String save(){

        courierService.save(courier);

        return "list";
    }

    /**
     * 分页条件查询
     * @return
     * @throws IOException
     */
    @Action("courierAction_pageQuery")
    public String pageQuery() throws IOException {

        Pageable pageable = new PageRequest(page-1,rows);

        Page<Courier> page = courierService.pageQuery(courier,pageable);

        Map<String,Object> map = new HashMap<>();
        map.put("total",page.getTotalElements());
        map.put("rows",page.getContent());

        //创建JsonConfig 排除定区集合属性，避免 nosession
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[]{"fixedAreas"});

        String json = JSONObject.fromObject(map, config).toString();

        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return NONE;
    }

    private String ids;

    public void setIds(String ids) {
        this.ids = ids;
    }

    @Action("courierAction_deleteBantch")
    public String deleteBantch(){
        courierService.deleteBantch(ids);
        return "list";
    }



}
