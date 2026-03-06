DROP TABLE IF EXISTS mobile;
DROP TABLE IF EXISTS resident;
DROP TABLE IF EXISTS homeowner;
DROP TABLE IF EXISTS individual;

CREATE TABLE individual (
    individualid INT AUTO_INCREMENT PRIMARY KEY,
    lastname VARCHAR(45) NOT NULL,
    firstname VARCHAR(45),
    mi VARCHAR(45),
    birthday DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    email VARCHAR(45),
    facebook_url VARCHAR(45),
    pic_filename VARCHAR(45),
    undertaking BOOLEAN NOT NULL
);

CREATE TABLE mobile (
    mobilenum VARCHAR(20) NOT NULL,
    individualid INT NOT NULL,

    PRIMARY KEY (mobilenum, individualid),

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