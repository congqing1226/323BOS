package cn.itcast.bos.action.base;

import cn.itcast.bos.action.common.BaseAction;
import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.service.base.AreaService;
import cn.itcast.bos.utils.PinYin4jUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author congzi
 * @Description:
 * @create 2018-08-30
 * @Version 1.0
 */
@Controller
@Scope("prototype")
@Namespace("/")//<package namespace extends
@ParentPackage("struts-default")
@Results({@Result(name="list",type="redirect",location="/pages/base/area.jsp")})
public class AreaAction extends BaseAction<Area>{

    private Area area = new Area();

    @Override
    public Area getModel() {
        return area;
    }

    @Autowired
    private AreaService areaService;

    //接收文件上传数据
    private File upload;
    // MIME类型
    private String uploadContentType;
    //文件名
    private String uploadFileName;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    @Action("areaAction_importXls")
    public String importXls() throws Exception {

        List<Area> listArea = new ArrayList<>();
        //创建excel对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(upload));
        //获取sheet
        HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
        for (Row cells : sheetAt) {

            if(cells.getRowNum() == 0){
                continue;
            }

            String id = cells.getCell(0).getStringCellValue();
            String province = cells.getCell(1).getStringCellValue();
            String city = cells.getCell(2).getStringCellValue();
            String district = cells.getCell(3).getStringCellValue();
            String postcode = cells.getCell(4).getStringCellValue();

            Area area = new Area(id, province, city, district, postcode);

            //将省市区 截取
            province.substring(0,province.length() - 1);
            city.substring(0,city.length() - 1);
            district.substring(0,district.length() - 1);

            String all = province + city + district;

            //简码
            String[] strArr = PinYin4jUtils.getHeadByString(all);
            String sortCode = StringUtils.join(strArr);
            area.setShortcode(sortCode);

            //城市编码
            String cityCode = PinYin4jUtils.hanziToPinyin(city);
            area.setCitycode(cityCode);

            listArea.add(area);
        }

        areaService.save(listArea);
        hssfWorkbook.close();
        return NONE;
    }


    /**
     * 区域分页查询
     * @return
     */
    @Action("areaAction_pageQuery")
    public String pageQuery(){

        Pageable pageable = new PageRequest(page - 1, rows);

        Page<Area> page =  areaService.pageQuery(pageable);
        this.javaToJson(page,new String[]{"subAreas"});
        return NONE;
    }

    @Action("areaAction_findAll")
    public String findAll(){

        List<Area> list = areaService.findAll();
        javaToList(list,new String[]{"subAreas"});

        return NONE;
    }



}
