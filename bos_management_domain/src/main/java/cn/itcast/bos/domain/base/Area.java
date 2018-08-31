package cn.itcast.bos.domain.base;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author congzi
 * @Description:地域信息实体类,主要包含 省市区
 * @create 2018-08-25
 * @Version 1.0
 */
@Entity
@Table(name = "T_AREA")
public class Area    {

    @Id
    @Column(name = "C_ID")
    private String id;
    @Column(name = "C_PROVINCE")
    private String province; // 省
    @Column(name = "C_CITY")
    private String city; // 城市
    @Column(name = "C_DISTRICT")
    private String district; // 区域
    @Column(name = "C_POSTCODE")
    private String postcode; // 邮编
    @Column(name = "C_CITYCODE")
    private String citycode; // 城市编码
    @Column(name = "C_SHORTCODE")
    private String shortcode; // 简码

    //区域与分区
    @OneToMany(mappedBy = "area")
    private Set<SubArea> subAreas = new HashSet<>();


    public String getName(){
        return province + city + district;
    }

    public Area() {
    }

    public Area(String id, String province, String city, String district, String postcode) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
    }

    public Area(String id, String province, String city, String district, String postcode, String citycode, String shortcode, Set<SubArea> subAreas) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        this.citycode = citycode;
        this.shortcode = shortcode;
        this.subAreas = subAreas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Set<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(Set<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", postcode='" + postcode + '\'' +
                ", citycode='" + citycode + '\'' +
                ", shortcode='" + shortcode + '\'' +
                ", subAreas=" + subAreas +
                '}';
    }
}
