package cn.itcast.bos.domain.base;

import javax.persistence.*;
import java.util.Date;

/**
 * @author congzi
 * @Description:收派标准
 * @create 2018-08-25
 * @Version 1.0
 */
@Entity
@Table(name = "T_STANDARD")
public class Standard {

    @Id
    @GeneratedValue  //生成主键值，当主键类型是数字类型 ，自动创建默认序列 hibernate_sequence
    @Column(name = "C_ID")
    private Integer id; // 主键
    @Column(name = "C_NAME")
    private String name; // 标准名称
    @Column(name = "C_MIN_WEIGHT")
    private Integer minWeight; // 最小重量
    @Column(name = "C_MAX_WEIGHT")
    private Integer maxWeight; // 最大重量
    @Column(name = "C_MIN_LENGTH")
    private Integer minLength; // 最小长度
    @Column(name = "C_MAX_LENGTH")
    private Integer maxLength; // 最大重量
    @Column(name = "C_OPERATING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operatingTime;// 操作时间
    @Column(name = "C_OPERATOR")
    private String operator; // 操作员
    @Column(name = "C_OPERATING_COMPANY")
    private String operatingCompany; // 操作单位

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Date getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(Date operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatingCompany() {
        return operatingCompany;
    }

    public void setOperatingCompany(String operatingCompany) {
        this.operatingCompany = operatingCompany;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                ", operatingTime=" + operatingTime +
                ", operator='" + operator + '\'' +
                ", operatingCompany='" + operatingCompany + '\'' +
                '}';
    }
}
