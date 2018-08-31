package cn.itcast.bos.action.common;

import cn.itcast.bos.action.base.SubAreaAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author congzi
 * @Description: 参数化泛型类
 * @create 2018-08-31
 * @Version 1.0
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

    protected T model;

    @Override
    public T getModel() {
        return model;
    }

    public static void main(String[] args) {
        SubAreaAction s = new SubAreaAction();
    }

    public BaseAction(){

        try{

            Class clazz = this.getClass();
            Type type = clazz.getGenericSuperclass();

            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArr = parameterizedType.getActualTypeArguments();

            Class c = (Class) typeArr[0];
            model = (T) c.newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //通过属性驱动接收页面提交当前页，每页显示记录数
    protected int page;
    protected int rows;
    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 分页数据转化为JSON
     */
    public void javaToJson(Page<T> page, String[] excluds){

        try{
            Map<String, Object> map = new HashMap<>();
            map.put("total", page.getTotalElements());
            map.put("rows", page.getContent());
            //将实体中 不需要转json属性排除掉(fixedAreas集合属性引起noSession故排除)
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.setExcludes(excluds);

            String json = JSONObject.fromObject(map, jsonConfig).toString();
            System.err.println(json);
            ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
            ServletActionContext.getResponse().getWriter().write(json);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /**
     * 将List集合转为JSON
     */
    public void javaToList(List<T> list, String[] excluds){
       try{
           JsonConfig jsonConfig = new JsonConfig();
           jsonConfig.setExcludes(excluds);
           String json = JSONArray.fromObject(list, jsonConfig).toString();
           System.err.println(json);
           ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
           ServletActionContext.getResponse().getWriter().write(json);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
