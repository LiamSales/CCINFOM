//all enums must be defined (separate file?)
//replace java obj attribute variable names to match exact case for SQL

package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "hoa_officer")
public class HoaOfficer {

    @EmbeddedId
    private HoaOfficerId id;

    /*
       FK to homeowner
       Uses same homeownerid inside composite key
    */
    @MapsId("homeownerId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "homeownerid")
    private Homeowner homeowner;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "elec_venue", length = 45)
    private String electionVenue;

    @Column(name = "elec_quorum", nullable = false)
    private boolean electionQuorum;

    @Column(name = "elec_witnessname", length = 100)
    private String witnessName;

    @Column(name = "elec_witnessmobile", length = 20)
    private String witnessMobile;

    /*
       Weekly availability
    */
    @Enumerated(EnumType.STRING)
    @Column(name = "avail_mon", length = 2)
    private Availability mon;

    @Enumerated(EnumType.STRING)
    @Column(name = "avail_tue", length = 2)
    private Availability tue;

    @Enumerated(EnumType.STRING)
    @Column(name = "avail_wed", length = 2)
    private Availability wed;

    @Enumerated(EnumType.STRING)
    @Column(name = "avail_thu", length = 2)
    private Availability thu;

    @Enumerated(EnumType.STRING)
    @Column(name = "avail_fri", length = 2)
    private Availability fri;

    @Enumerated(EnumType.STRING)
    @Column(name = "avail_sat", length = 2)
    private Availability sat;

    @Enumerated(EnumType.STRING)
    @Column(name = "avail_sun", length = 2)
    private Availability sun;

    protected HoaOfficer() {}

    public HoaOfficer(
            HoaOfficerId id,
            Homeowner homeowner,
            LocalDate startDate,
            LocalDate endDate,
            String electionVenue,
            boolean electionQuorum
    ) {
        this.id = id;
        this.homeowner = homeowner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.electionVenue = electionVenue;
        this.electionQuorum = electionQuorum;
    }

    public HoaOfficerId getId() {
        return id;
    }

    public Homeowner getHomeowner() {
        return homeowner;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getElectionVenue() {
        return electionVenue;
    }

    public boolean isElectionQuorum() {
        return electionQuorum;
    }

    public String getWitnessName() {
        return witnessName;
    }

    public String getWitnessMobile() {
        return witnessMobile;
    }

    public Availability getMon() { return mon; }
    public Availability getTue() { return tue; }
    public Availability getWed() { return wed; }
    public Availability getThu() { return thu; }
    public Availability getFri() { return fri; }
    public Availability getSat() { return sat; }
    public Availability getSun() { return sun; }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setElectionVenue(String electionVenue) {
        this.electionVenue = electionVenue;
    }

    public void setElectionQuorum(boolean electionQuorum) {
        this.electionQuorum = electionQuorum;
    }

    public void setWitnessName(String witnessName) {
        this.witnessName = witnessName;
    }

    public void setWitnessMobile(String witnessMobile) {
        this.witnessMobile = witnessMobile;
    }

    public void setMon(Availability mon) { this.mon = mon; }
    public void setTue(Availability tue) { this.tue = tue; }
    public void setWed(Availability wed) { this.wed = wed; }
    public void setThu(Availability thu) { this.thu = thu; }
    public void setFri(Availability fri) { this.fri = fri; }
    public void setSat(Availability sat) { this.sat = sat; }
    public void setSun(Availability sun) { this.sun = sun; }
}