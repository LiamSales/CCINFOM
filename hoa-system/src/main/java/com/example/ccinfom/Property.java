import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

//Each property is identified by a Property Code (e.g., B06L08).
//A property has exactly one homeowner and one household.
//A household is identified by a Household ID and is associated with one property.
//Households contain one or more residents.

@Entity
public class Property {

    @Id
    @Column(length = 10)
    private String propertyCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "homeowner_id")
    private Homeowner homeowner;

    
}

//TODO
//Mark the class as a JPA entity
//Add a primary key with auto-generation
//Add fields such as:
//propertyCode or lotNumber
//optional metadata like block, phase, size
//Add a ManyToOne relationship back to Homeowner
//Prevent infinite JSON recursion by ignoring the homeowner field during serialization

//Provide:
//protected no-args constructor
//minimal public constructor
//getters and setters
