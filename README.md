# CCINFOM
Information Management

# Homeowners Association (HOA) Database Application

## Overview

This project is a **Database Design and Java Web Application** for managing a Homeowners Association (HOA). It is used as a case study and implementation exercise for **Introduction to Databases (CCINFOM)**. The system models the administrative, operational, and asset-management processes of a subdivision HOA, with emphasis on proper relational database design, integrity, and realistic business rules.

The application assumes the **primary user is an HOA Officer In-Charge of Assets**, though the database design supports many other HOA functions.

---

## Objectives

* Design a **normalized relational database** that accurately represents HOA operations.
* Populate the database with sufficient sample data to demonstrate functionality.
* Implement a **Java Web Application** that supports a defined feature set.
* Demonstrate correct use of database design techniques and integrity constraints.

---

## Database Design Principles

The database design should follow these criteria:

* **Completeness**: All required HOA data can be stored.
* **Integrity**: Domain, relational, and referential integrity are enforced at the highest possible level.
* **Reduced Redundancy**: Data duplication is minimized through normalization.

Recommended design techniques include composite attributes, multi-valued attributes, artificial identifiers, generalization and specialization, controlled values, normalization, and proper use of foreign keys.

---

## Core System Entities

### HOA Information

Stores official information about the Homeowners Association, including:

* HOA name and subdivision name
* Office address with full breakdown and map location
* Year of establishment and official website
* Legal and governance documents such as Articles of Incorporation, By-Laws, certifications, attendance sheets, and Code of Ethics
* Regular monthly dues and designated collection day

---

### Homeowners

Each homeowner is uniquely identified by a **Homeowner ID** and includes:

* Personal information and contact details
* Years as homeowner
* Owned properties within the subdivision
* Declaration of data accuracy and intent to become an HOA member
* Other addresses and contact information when not residing in the subdivision

A homeowner may own **multiple properties**.

---

### Properties and Households

* Each property is identified by a **Property Code** (e.g., B06L08).
* A property has exactly one homeowner and one household.
* A household is identified by a **Household ID** and is associated with one property.
* Households contain one or more residents.

Only homeowners can change the authorized resident for their property.

---

### Residents

Residents are individuals living in a household and are identified by a **Resident ID**.
Stored information includes:

* Personal and contact details
* Residency type, renter or owner
* Relationship to the homeowner
* Declaration of data accuracy and valid residency

A resident can belong to **only one household at a time**, though household transfers are allowed without deleting resident history.

---

### Resident ID Cards

* Residents may be issued multiple ID cards over time.
* Each ID card has a unique card number.
* The system records request dates, reasons, authorization details, payment OR number, and issuance dates.
* The first ID is free, succeeding IDs require payment.

Resident information must be updated annually to qualify for ID issuance.

---

### HOA Officers

* Only homeowners can be officers.
* Officers are defined by position, term dates, and election details.
* Officer availability is recorded by day and time slot (morning or afternoon).

---

## Asset Management

### Assets

Assets owned by the HOA are identified by an **Asset ID** and include:

* Asset name, description, value, status, and location
* Acquisition date and rental eligibility
* Asset type: Property, Equipment, Furniture and Fixtures, or Other

Assets may contain other assets, such as equipment inside a room.

---

### Asset Activities

Records non-rental activities performed on assets, such as repair or maintenance:

* Activity dates and descriptions
* Authorizing officer
* Schedule, cost, receipt, and status

Activities cannot be physically deleted, only marked as deleted with presidential approval.

---

### Asset Transfers

Tracks movement of assets between locations:

* Scheduled and actual transfer dates
* Origin and destination locations
* Authorizing officer and transfer personnel
* Cost, receipt, and status

Transfers are logically deleted only, with presidential approval.

---

### Asset Rentals

Assets marked as rentable may be rented by residents. Rental records include:

* Reservation and rental dates
* Renting resident and authorizing officer
* Rental fees, discounts, and official receipt
* Return inspection details and assessed damages

When an asset with inclusions is rented or returned, all included assets are processed together.

---

### Donations

Donated assets are recorded with:

* Donor information
* Items and values donated
* Accepting officer and donation date
* Supporting documents and photos

Donation records are publicly visible and cannot be physically deleted.

---

## Application Requirements

### Deliverables

* Populated **.sql database export**
* **Java Web Application** project folder (NetBeans format)
* Database design file (**.mwb**) and non-forward-engineered SQL scripts

---

### Feature Sets

Each group implements **one** of the following feature sets:

#### Feature Set 1: Asset Activities

* Register, update, delete, and dispose assets
* Record, update, complete, and delete asset activities

#### Feature Set 2: Asset Rentals

* Register, update, delete, and dispose assets
* Record, return, update, and delete rentals

#### Feature Set 3: Donations

* Register, update, delete, and dispose assets
* Record, update, and delete donation information

---

## Advanced Design Cases

### Monthly Dues, Billing, and Payments

Covers incidents, penalties, evidence, household billing, and partial or advance payments. Bills are generated monthly per household and payments are tracked via controlled OR numbers.

---

### Programs and Participation

Manages HOA programs, committees, participant registration, expenses, evidence, feedback, and ratings.

---

### Elections

Supports HOA elections including:

* Election scheduling and status
* Candidate registration and qualification
* Voting rules and quorum checks
* Declaration of board members

---

## Evaluation

During the **DB Design Defense**, students must justify their schema by simulating realistic data and explaining how integrity, constraints, and relationships are enforced.

---

## Notes

* Physical deletion of critical records is generally prohibited.
* Most deletions are logical, implemented via status fields.
* Strong emphasis is placed on real-world modeling and database correctness.
