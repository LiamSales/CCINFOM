package com.example.ccinfom.model;

import java.time.LocalDate;

public class Asset {

    private Integer assetid;

    private String name;
    private String description;

    private LocalDate acq_date;
    private boolean forrent;

    private float value;

    private String type;   // P, E, F, O
    private String status; // W, DE, FR, FD, DI

    private String location;
    private String location_mapx;
    private String location_mapy;

    public Integer getAssetid() { return assetid; }
    public void setAssetid(Integer assetid) { this.assetid = assetid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getAcq_date() { return acq_date; }
    public void setAcq_date(LocalDate acq_date) { this.acq_date = acq_date; }

    public boolean isForrent() { return forrent; }
    public void setForrent(boolean forrent) { this.forrent = forrent; }

    public float getValue() { return value; }
    public void setValue(float value) { this.value = value; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getLocation_mapx() { return location_mapx; }
    public void setLocation_mapx(String location_mapx) { this.location_mapx = location_mapx; }

    public String getLocation_mapy() { return location_mapy; }
    public void setLocation_mapy(String location_mapy) { this.location_mapy = location_mapy; }
}