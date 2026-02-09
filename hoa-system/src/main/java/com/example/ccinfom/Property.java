import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


//Property class — TODOs
//Purpose
//Represents a physical lot, unit, or property inside the subdivision that is owned by a homeowner.

@Entity
public class Property {

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
