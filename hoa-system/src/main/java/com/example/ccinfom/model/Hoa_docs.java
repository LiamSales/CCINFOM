package com.example.ccinfom.model;

import java.time.LocalDateTime;
import java.util.Objects;

/*
Table: hoa_docs

Business Rules:
1. submission_type uniquely identifies each type of document.
2. doc_name is required and describes the HOA document.
3. submission_date records when the document was submitted.
4. Document records are referenced by hoa_submissions.
*/

public class Hoa_docs {

    private Integer submission_type;
    private String doc_name;
    private LocalDateTime submission_date;

    public Hoa_docs() {}

    public Hoa_docs(Integer submission_type, String doc_name, LocalDateTime submission_date) {
        this.submission_type = submission_type;
        this.doc_name = doc_name;
        this.submission_date = submission_date;
    }

    public Integer getSubmission_type() {
        return submission_type;
    }

    public void setSubmission_type(Integer submission_type) {
        this.submission_type = submission_type;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public LocalDateTime getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(LocalDateTime submission_date) {
        this.submission_date = submission_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoaDocs hoaDocs = (HoaDocs) o;
        return Objects.equals(submission_type, hoaDocs.submission_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submission_type);
    }
}
