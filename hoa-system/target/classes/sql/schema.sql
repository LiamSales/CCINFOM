DROP TABLE IF EXISTS hoa_docs;
DROP TABLE IF EXISTS hoa_submissions;
DROP TABLE IF EXISTS hoa;
DROP TABLE IF EXISTS hoa_officer;
DROP TABLE IF EXISTS hoa_submission_id;
DROP TABLE IF EXISTS resident_id;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS household;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS homeowner_addinfo;
DROP TABLE IF EXISTS resident;
DROP TABLE IF EXISTS homeowner;
DROP TABLE IF EXISTS mobile;
DROP TABLE IF EXISTS individual;

CREATE TABLE hoa_docs(

);

CREATE TABLE hoa_submissions(

);

CREATE TABLE hoa(

);

CREATE TABLE hoa_officer(

);

CREATE TABLE hoa_submission_id(

);

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
    mobilenum VARCHAR(20) PRIMARY KEY,
    individualid INT NOT NULL,


--  CONSTRAINT fk_mobile_individual
    FOREIGN KEY (individualid) REFERENCES individual(individualid)
    ON DELETE CASCADE
    );

CREATE TABLE homeowner (
    homeownerid INT PRIMARY KEY,
    residency_start DATE,
    membership BOOLEAN NOT NULL,
    isresident BOOLEAN NOT NULL,

    FOREIGN KEY (homeownerid) REFERENCES individual(individualid)
    ON DELETE CASCADE
);

CREATE TABLE resident (
    residentid INT PRIMARY KEY,
    renter BOOLEAN NOT NULL,
    rel_homeowner VARCHAR(45) NOT NULL,
    authorized BOOLEAN NOT NULL,
    last_update DATETIME NOT NULL,

    FOREIGN KEY (residentid) REFERENCES individual(individualid)
    ON DELETE CASCADE
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
    ON DELETE CASCADE
);

CREATE TABLE property (
    propertycode VARCHAR(6) PRIMARY KEY,
    homeownerid INT NOT NULL,
    size INT NOT NULL,
    turnover_date DATE NOT NULL,

    FOREIGN KEY (homeownerid) REFERENCES homeowner(homeownerid)
);

CREATE TABLE household(
    householdid INT PRIMARY KEY,
    propertycode VARCHAR(6) NOT NULL,

    FOREIGN KEY (propertycode) REFERENCES property(propertycode)
    ON DELETE CASCADE
);

CREATE TABLE payment(
    orno INT PRIMARY KEY,
    amount DECIMAL(5,2)
);

CREATE TABLE resident_id(
    cardno INT PRIMARY KEY,
    request_date DATE NOT NULL,
    request_reason VARCHAR(45) NOT NULL,
    issue_date DATE NOT NULL,
    hoa_officer VARCHAR(45) NOT NULL,
    orno INT,
    residentid INT,
    status CHAR(1) CHECK (status IN ('A','L','C')) NOT NULL,

    FOREIGN KEY (residentid) REFERENCES resident(residentid),
    FOREIGN KEY (orno) REFERENCES payment(orno)
);