package com.inkubator.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "department", catalog = "user_management", uniqueConstraints
        = @UniqueConstraint(columnNames = "dep_code"))
public class Department implements Serializable {

    private long id;
    private Integer version;
    private String departmentCode;
    private String departmentName;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
//    private Set<Position> positions;

    public Department(long id) {
        this.id = id;
    }

    public Department() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Version
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "dep_code", unique = true, length = 45)
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Column(name = "dep_name", length = 45)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Column(name = "created_by", length = 45)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "updated_by", length = 45)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", length = 19)
    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

//    @OneToMany(cascade = {MERGE,PERSIST,REFRESH}, fetch = FetchType.LAZY, mappedBy = "department")
//    public Set<Position> getPositions() {
//        return positions;
//    }
//
//    public void setPositions(Set<Position> positions) {
//        this.positions = positions;
//    }
}
