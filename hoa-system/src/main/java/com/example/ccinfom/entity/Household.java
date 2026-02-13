import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


// When an authorized resident of the household deletes a resident in the household, the resident ID card of the deleted household
// member is cancelled.
// 
// It is possible for a resident transfer household. Since resident information is not deleted, at any time, the homeowner is the
// only one that can change the authorized resident/s to his/her property.
// 
// For each resident, the following information is needed, -----> can this extend from a superclass?
// (a) Complete name of the resident,
// (b) renter or not,
// (c) resident email address
// (d) birthday
// (e) gender
// (f) resident mobile information
// (g) Facebook URL of the resident if there is any
// (h) picture of the resident
// (i) relationship to the homeowner
// (j) undertaking that the information provided is correct, accurate, and signifies representing being a valid resident.
// Every resident has a unique Resident ID

@Entity
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @joinColumn //figure out owning side and inverse side
    private Property property;

    @OneToMany() //incomplete
    private List<Resident> residents  = new ArrayList<>();

    //automatically add linked homeowner upon instantiation

}
