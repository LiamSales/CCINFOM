package com.example.ccinfom;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class HoaSubmissionId implements Serializable {

    private String hoaHoaname;
    private Integer submissionType;
    private LocalDate submissionDate;

    public HoaSubmissionId() {}

    public HoaSubmissionId(String hoaHoaname, Integer submissionType, LocalDate submissionDate) {
        this.hoaHoaname = hoaHoaname;
        this.submissionType = submissionType;
        this.submissionDate = submissionDate;
    }

    public String getHoaHoaname() {
        return hoaHoaname;
    }

    public Integer getSubmissionType() {
        return submissionType;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoaSubmissionId that)) return false;
        return Objects.equals(hoaHoaname, that.hoaHoaname)
                && Objects.equals(submissionType, that.submissionType)
                && Objects.equals(submissionDate, that.submissionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoaHoaname, submissionType, submissionDate);
    }
}