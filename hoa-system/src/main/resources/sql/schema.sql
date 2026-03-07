DROP TABLE IF EXISTS mobile;
DROP TABLE IF EXISTS resident;
DROP TABLE IF EXISTS homeowner;
DROP TABLE IF EXISTS individual;

CREATE TABLE individual (
    individualid INT AUTO_INCREMENT PRIMARY KEY,
    lastname VARCHAR(45) NOT NULL,
    firstname VARCHAR(45) NOT NULL,
    mi VARCHAR(45),
    email VARCHAR(45) NOT NULL,
    birthday DATE NOT NULL,
    gender CHAR(1) CHECK (gender IN ('M','F')) NOT NULL,
    facebook_url VARCHAR(45),
    pic_filename VARCHAR(45) NOT NULL,
    undertaking BOOLEAN NOT NULL
);

CREATE TABLE mobile (
    mobilenum VARCHAR(20) NOT NULL PRIMARY KEY,
    individualid INT NOT NULL,

    FOREIGN KEY (individualid) REFERENCES individual(individualid)
    -- each individual owns as one to many
    --non-identifiying relationship (fk is not part of pk)
);

CREATE TABLE homeowner (
    homeownerid INT PRIMARY KEY,
    residency_start DATE,
    membership BOOLEAN NOT NULL,
    isresident BOOLEAN NOT NULL,

    FOREIGN KEY (homeownerid) REFERENCES individual(individualid)
);

CREATE TABLE resident (
    residentid INT PRIMARY KEY,
    renter BOOLEAN NOT NULL,
    rel_homeowner VARCHAR(45) BOOLEAN NOT NULL,
    authorized BOOLEAN NOT NULL,
    last_update DATETIME NOT NULL,

    FOREIGN KEY (residentid) REFERENCES individual(individualid)
);

CREATE TABLE homeowner_addinfo (
    homeownerid INT PRIMARY KEY,
    add2_streetno VARCHAR(20),
    add2_street VARCHAR(45),
    add2_brgy VARCHAR(45),
    add2_city VARCHAR(45),
    add2_province VARCHAR(45),
    add2_mapx VARCHAR(45),
    add2_mapy VARCHAR(45),
    email2 VARCHAR(45),

    FOREIGN KEY (homeownerid) REFERENCES homeowner(homeownerid)

)

CREATE TABLE property (
    propertycode VARCHAR(6) PRIMARY KEY,
    homeownerid INT NOT NULL,
    size INT NOT NULL,
    turnover_date DATE NOT NULL,

    FOREIGN KEY (homeownerid) REFERENCES homeowner(homeownerid),
)

CREATE TABLE household(
    householdid INT PRIMARY KEY,
    propertycode VARCHAR(6) NOT NULL,

    FOREIGN KEY (propertycode) REFERENCES property(propertycode)

)


CREATE TABLE payment(
    orno INT PRIMARY KEY,
    amount DECIMAL (5,2)

)

CREATE TABLE resident_id(
    cardno INT PRIMARY KEY,
    request_date DATE NOT NULL,
    request_reason VARCHAR(45) NOT NULL,
    issue_date DATE NOT NULL,
    hoa_officer VARCHAR(45) NOT NULL,
    orno VARCHAR(45),
    resident_id INT,
    status CHAR(1) CHECK (status IN ('A','L','C')) NOT NULL,
-- why is status highlighted syntax?
    FOREIGN KEY (resident_id) REFERENCES resident(resident_id),
    FOREIGN KEY (orno) REFERENCES payment(orno)

)
