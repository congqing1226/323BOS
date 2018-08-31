package cn.itcast.bos.domain.base;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author congzi
 * @Description: 定区
 * @create 2018-08-25
 * @Version 1.0
 */
@Entity
@Table(name = "T_FIXED_AREA")
public class FixedArea {

    @Id
    @Column(name = "C_ID")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String id; // 主键
    @Column(name = "C_FIXED_AREA_NAME")
    private String fixedAreaName; // 定区名称
    @Column(name = "C_FIXED_AREA_LEADER")
    private String fixedAreaLeader;// 定区负责人
    @Column(name = "C_TELEPHONE")
    private String telephone;// 联系电话
    @Column(name = "C_COMPANY")
    private String company; // 所属单位

    //TIMESTAMP 在页面端取值：2016-09-28 15:52:32:000
    @Column(name = "C_OPERATING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operatingTime;// 操作时间
    @Column(name = "C_OPERATOR")
    private String operator; // 操作员
    @Column(name = "C_OPERATING_COMPANY")
    private String operatingCompany; // 操作单位

    //定区 一方，分区 多方
    @OneToMany(mappedBy = "fixedArea")
    private Set<SubArea> subAreas = new HashSet<>();


    //快递员与分区为多对多关系
    @ManyToMany
    @JoinTable(name = "T_FIXEDAREA_COURIER",
        joinColumns = {@JoinColumn(name = "C_FIXED_AREA_ID",referencedColumnName = "C_ID")},
            inverseJoinColumns = {@JoinColumn(name="C_COURIER_ID",referencedColumnName = "C_ID")}
    )
    private Set<Courier> couriers = new HashSet<Courier>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFixedAreaName() {
        return fixedAreaName;
    }

    public void setFixedAreaName(String fixedAreaName) {
        this.fixedAreaName = fixedAreaName;
    }

    public String getFixedAreaLeader() {
        return fixedAreaLeader;
    }

    public void setFixedAreaLeader(String fixedAreaLeader) {
        this.fixedAreaLeader = fixedAreaLeader;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public Set<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setSubAreas(Set<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    public Set<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(Set<Courier> couriers) {
        this.couriers = couriers;
    }
}
