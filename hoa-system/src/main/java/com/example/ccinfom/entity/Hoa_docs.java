package com.example.ccinfom;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hoa_docs")
public class Hoa_docs {

    @Id
    @Column(name = "submission_type")
    private Integer submissionType;

    @Column(name = "doc_name", length = 100, nullable = false)
    private String docName;

    @Column(name = "submission_date")
    private LocalDate submissionDate;

    @OneToMany(mappedBy = "document")
    private List<HoaSubmission> hoaLinks = new ArrayList<>();


    protected HoaDoc() {}

    public HoaDoc(Integer submissionType, String docName, LocalDate submissionDate) {
        this.submissionType = submissionType;
        this.docName = docName;
        this.submissionDate = submissionDate;
    }

    public Integer getSubmissionType() {
        return submissionType;
    }

    public String getDocName() {
        return docName;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }
    
    public List<HoaSubmission> getHoaLinks() {
        return hoaLinks;
    }
}