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
    mobilenum VARCHAR(20),
    individualid INT,
    PRIMARY KEY (mobilenum, individualid),
    FOREIGN KEY (individualid) REFERENCES individual(individualid)
);