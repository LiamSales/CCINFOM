DROP TABLE IF EXISTS hoa_docs;
DROP TABLE IF EXISTS hoa_submissions;
DROP TABLE IF EXISTS hoa;
DROP TABLE IF EXISTS hoa_officer;
DROP TABLE IF EXISTS resident_id;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS household;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS homeowner_addinfo;
DROP TABLE IF EXISTS resident;
DROP TABLE IF EXISTS homeowner;
DROP TABLE IF EXISTS mobile;
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
    mobilenum VARCHAR(20) PRIMARY KEY,
    individualid INT NOT NULL,
    CONSTRAINT fk_mobile_individual
        FOREIGN KEY (individualid)
        REFERENCES individual(individualid)
        ON DELETE CASCADE
);


CREATE TABLE homeowner (
    homeownerid INT PRIMARY KEY,
    residency_start DATE,
    membership BOOLEAN NOT NULL,
    isresident BOOLEAN NOT NULL,
    CONSTRAINT fk_homeowner_individual
        FOREIGN KEY (homeownerid)
        REFERENCES individual(individualid)
        ON DELETE CASCADE
);


CREATE TABLE resident (
    residentid INT PRIMARY KEY,
    renter BOOLEAN NOT NULL,
    rel_homeowner VARCHAR(45) NOT NULL,
    authorized BOOLEAN NOT NULL,
    last_update DATETIME NOT NULL,
    CONSTRAINT fk_resident_individual
        FOREIGN KEY (residentid)
        REFERENCES individual(individualid)
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
    CONSTRAINT fk_addinfo_homeowner
        FOREIGN KEY (homeownerid)
        REFERENCES homeowner(homeownerid)
        ON DELETE CASCADE
);


CREATE TABLE property (
    propertycode VARCHAR(6) PRIMARY KEY,
    homeownerid INT NOT NULL,
    size INT NOT NULL,
    turnover_date DATE NOT NULL,
    CONSTRAINT fk_property_homeowner
        FOREIGN KEY (homeownerid)
        REFERENCES homeowner(homeownerid)
);


CREATE TABLE household(
    householdid INT PRIMARY KEY,
    propertycode VARCHAR(6) NOT NULL,
    CONSTRAINT fk_household_property
        FOREIGN KEY (propertycode)
        REFERENCES property(propertycode)
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

    CONSTRAINT fk_residentid_payment
        FOREIGN KEY (orno)
        REFERENCES payment(orno),

    CONSTRAINT fk_residentid_resident
        FOREIGN KEY (residentid)
        REFERENCES resident(residentid)
);


CREATE TABLE hoa (
    hoaname VARCHAR(100) PRIMARY KEY,

    office_streetno VARCHAR(20),
    office_street VARCHAR(45),
    office_brgy VARCHAR(45),
    office_city VARCHAR(45),
    office_province VARCHAR(45),
    office_region VARCHAR(45),
    office_zip VARCHAR(10),

    office_mapx DOUBLE,
    office_mapy DOUBLE,

    year_est INT,
    website VARCHAR(100),
    subd_name VARCHAR(45),

    monthly_dues INT,
    collection_day INT,

    articles_file VARCHAR(255),
    bylaws_file VARCHAR(255),
    ga_minutes_file VARCHAR(255),
    attendance_sheet_file VARCHAR(255),
    code_of_ethics_file VARCHAR(255),

    other_hoa_exists BOOLEAN NOT NULL,
    other_hoa_name VARCHAR(100),
    other_hoa_address VARCHAR(255)
);


CREATE TABLE hoa_docs(
    submission_type INT PRIMARY KEY,
    doc_name VARCHAR(100) NOT NULL
);


CREATE TABLE hoa_submissions(
    hoa_hoaname VARCHAR(100),
    submission_type INT,
    submission_date DATE,

    PRIMARY KEY (hoa_hoaname, submission_type, submission_date),

    CONSTRAINT fk_submission_hoa
        FOREIGN KEY (hoa_hoaname)
        REFERENCES hoa(hoaname)
        ON DELETE CASCADE,

    CONSTRAINT fk_submission_doc
        FOREIGN KEY (submission_type)
        REFERENCES hoa_docs(submission_type)
);


CREATE TABLE hoa_officer(
    homeownerid INT,
    hoaname VARCHAR(100),
    start_date DATE NOT NULL,
    end_date DATE,

    elec_venue VARCHAR(45),
    elec_quorum BOOLEAN NOT NULL,
    elec_witnessname VARCHAR(100),
    elec_witnessmobile VARCHAR(20),

    avail_mon VARCHAR(2),
    avail_tue VARCHAR(2),
    avail_wed VARCHAR(2),
    avail_thu VARCHAR(2),
    avail_fri VARCHAR(2),
    avail_sat VARCHAR(2),
    avail_sun VARCHAR(2),

    PRIMARY KEY (homeownerid, hoaname),

    CONSTRAINT fk_officer_homeowner
        FOREIGN KEY (homeownerid)
        REFERENCES homeowner(homeownerid),

    CONSTRAINT fk_officer_hoa
        FOREIGN KEY (hoaname)
        REFERENCES hoa(hoaname)
);