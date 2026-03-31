package com.example.ccinfom.model;

import java.time.LocalDate;

public class AssetActivity {

    private Integer activityid;

    private Integer assetid;
    private Integer homeownerid;
    private Integer orno;

    private LocalDate activity_date;
    private String description;

    private LocalDate sched_start;
    private LocalDate sched_end;

    private LocalDate actual_start;
    private LocalDate actual_end;

    private String status; // S, O, C, D

    public Integer getActivityid() { return activityid; }
    public void setActivityid(Integer activityid) { this.activityid = activityid; }

    public Integer getAssetid() { return assetid; }
    public void setAssetid(Integer assetid) { this.assetid = assetid; }

    public Integer getHomeownerid() { return homeownerid; }
    public void setHomeownerid(Integer homeownerid) { this.homeownerid = homeownerid; }

    public Integer getOrno() { return orno; }
    public void setOrno(Integer orno) { this.orno = orno; }

    public LocalDate getActivity_date() { return activity_date; }
    public void setActivity_date(LocalDate activity_date) { this.activity_date = activity_date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getSched_start() { return sched_start; }
    public void setSched_start(LocalDate sched_start) { this.sched_start = sched_start; }

    public LocalDate getSched_end() { return sched_end; }
    public void setSched_end(LocalDate sched_end) { this.sched_end = sched_end; }

    public LocalDate getActual_start() { return actual_start; }
    public void setActual_start(LocalDate actual_start) { this.actual_start = actual_start; }

    public LocalDate getActual_end() { return actual_end; }
    public void setActual_end(LocalDate actual_end) { this.actual_end = actual_end; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}