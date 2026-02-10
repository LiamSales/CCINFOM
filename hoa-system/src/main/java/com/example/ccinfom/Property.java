import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

// Every property in the subdivision has only one homeowner, one household that lives in the property,
//  and maybe several authorized residents in the household.
// 
// Properties in the subdivision/ is identifiable by a property code. Properties are identified by its block and lot like B06L08. (natural)
// Other details of the property include the 
// (a) size of the property and the 
// (b) date it was turned over to the homeowner.

// For every property in the subdivision, the household residing in the property must also be registered.
// This information is being used in order to
// identify who are residents of the subdivision and for the issuance of the resident’s ID.
// The authorized Resident/s of the household is responsible
// for maintaining (adding, modifying or deleting) resident members of the household.
// A resident member cannot be a member of multiple households.
// 
// A household is provided with a household ID and is associated with only one property within the subdivision.
// If the homeowner is an authorized Resident of the household in his property, this means that he is residing in his/her property.
// A household has several resident members. 
// 
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
public class Property {

    @Id
    @Column(length = 10)
    private String propertyCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "homeowner_id")
    private Homeowner homeowner;


}
