package com.example.ccinfom;

import jakarta.persistence.*;

@Entity
@Table(name = "hoa_submissions")
public class HoaSubmissions {

    @EmbeddedId
    private HoaSubmissionId id;

    /*
       IDENTIFYING relationship to HOA
       FK is part of PK
    */
    @ManyToOne(optional = false)
    @MapsId("hoaHoaname")
    @JoinColumn(name = "hoa_hoaname")
    private Hoa hoa;

    /*
       IDENTIFYING relationship to HoaDoc
       FK is part of PK
    */
    @ManyToOne(optional = false)
    @MapsId("submissionType")
    @JoinColumn(name = "submission_type")
    private HoaDoc document;

    protected HoaSubmission() {}

    public HoaSubmission(Hoa hoa, HoaDoc document) {
        this.hoa = hoa;
        this.document = document;
        this.id = new HoaSubmissionId(
                hoa.getHoaName(),
                document.getSubmissionType(),
                document.getSubmissionDate()
        );
    }

    public HoaSubmissionId getId() {
        return id;
    }

    public Hoa getHoa() {
        return hoa;
    }

    public HoaDoc getDocument() {
        return document;
    }
}

