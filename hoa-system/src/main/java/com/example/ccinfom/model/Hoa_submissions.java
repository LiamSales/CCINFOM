package com.example.ccinfom.model;

import java.time.LocalDate;
import java.util.Objects;

/*
Table: hoa_submissions

Business Rules:
1. Composite Primary Key:
      (hoa_hoaname, hoa_docs_submission_type, submission_date)

2. hoa_hoaname must reference an existing HOA.
3. hoa_docs_submission_type must reference a valid document type in hoa_docs.
4. submission_date represents the specific submission instance.
*/

public class Hoa_submissions {

    private String hoa_hoaname;
    private Integer hoa_docs_submission_type;
    private LocalDate submission_date;

    public Hoa_submissions() {}

    public Hoa_submissions(String hoa_hoaname,
                          Integer hoa_docs_submission_type,
                          LocalDate submission_date) {
        this.hoa_hoaname = hoa_hoaname;
        this.hoa_docs_submission_type = hoa_docs_submission_type;
        this.submission_date = submission_date;
    }

    public String getHoa_hoaname() {
        return hoa_hoaname;
    }

    public void setHoa_hoaname(String hoa_hoaname) {
        this.hoa_hoaname = hoa_hoaname;
    }

    public Integer getHoa_docs_submission_type() {
        return hoa_docs_submission_type;
    }

    public void setHoa_docs_submission_type(Integer hoa_docs_submission_type) {
        this.hoa_docs_submission_type = hoa_docs_submission_type;
    }

    public LocalDate getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(LocalDate submission_date) {
        this.submission_date = submission_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoaSubmissions that = (HoaSubmissions) o;

        return Objects.equals(hoa_hoaname, that.hoa_hoaname)
                && Objects.equals(hoa_docs_submission_type, that.hoa_docs_submission_type)
                && Objects.equals(submission_date, that.submission_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoa_hoaname, hoa_docs_submission_type, submission_date);
    }
}
