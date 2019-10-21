package com.jtrack.model;
// Generated 25/06/2013 8:28:57 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JobStatus generated by hbm2java
 */
@Entity
@Table(name="JOB_STATUS"
    ,schema="JTRACK"
)
public class JobStatus  implements java.io.Serializable {


     private String jobStatus;
     private String jobStatusDesc;
     private Boolean active;
     private Date dateCrt;
     private String userCrt;
     private Date dateMod;
     private String userMod;
     
     private Users userCrtObj;
     private Users userModObj;

    public JobStatus() {
    }
	
    public JobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    
    public JobStatus(String jobStatus, String jobStatusDesc, Boolean active, Date dateCrt, String userCrt, Date dateMod, String userMod) {
       this.jobStatus = jobStatus;
       this.jobStatusDesc = jobStatusDesc;
       this.active = active;
       this.dateCrt = dateCrt;
       this.userCrt = userCrt;
       this.dateMod = dateMod;
       this.userMod = userMod;
    }
   
    @Id 
    @Column(name="JOB_STATUS", unique=true, nullable=false, length=20)
    public String getJobStatus() {
        return this.jobStatus;
    }
    
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    
    @Column(name="JOB_STATUS_DESC", length=250)
    public String getJobStatusDesc() {
        return this.jobStatusDesc;
    }
    
    public void setJobStatusDesc(String jobStatusDesc) {
        this.jobStatusDesc = jobStatusDesc;
    }
    
    @Column(name="ACTIVE", precision=1, scale=0)
    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_CRT")
    public Date getDateCrt() {
        return this.dateCrt;
    }
    
    public void setDateCrt(Date dateCrt) {
        this.dateCrt = dateCrt;
    }
    
    @Column(name="USER_CRT", length=100)
    public String getUserCrt() {
        return this.userCrt;
    }
    
    public void setUserCrt(String userCrt) {
        this.userCrt = userCrt;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATE_MOD")
    public Date getDateMod() {
        return this.dateMod;
    }
    
    public void setDateMod(Date dateMod) {
        this.dateMod = dateMod;
    }
    
    @Column(name="USER_MOD", length=100)
    public String getUserMod() {
        return this.userMod;
    }
    
    public void setUserMod(String userMod) {
        this.userMod = userMod;
    }
    
    @ManyToOne(fetch=FetchType.EAGER, optional=true)
    @JoinColumn(name = "USER_CRT", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Users getUserCrtObj() {
        return userCrtObj;
    }

    public void setUserCrtObj(Users userCrtObj) {
        this.userCrtObj = userCrtObj;
    }
    
    @ManyToOne(fetch=FetchType.EAGER, optional=true)
    @JoinColumn(name = "USER_MOD", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Users getUserModObj() {
        return userModObj;
    }

    public void setUserModObj(Users userModObj) {
        this.userModObj = userModObj;
    }
}

