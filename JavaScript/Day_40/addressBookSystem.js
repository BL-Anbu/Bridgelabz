console.log("===== ADDRESS BOOK SYSTEM USING JAVASCRIPT =====");

/* =========================================================
   UC 1 – Contact Validation using Regex & Errors
   ========================================================= */

// Regex Patterns
const nameRegex = /^[A-Z][a-z]{2,}$/;
const addressRegex = /^[A-Za-z]{4,}$/;
const zipRegex = /^[0-9]{3}\s?[0-9]{3}$/;
const phoneRegex = /^[6-9][0-9]{9}$/;
const emailRegex =
    /^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\.[a-zA-Z]{2,})$/;

/* =========================================================
   Contact Class
   ========================================================= */
class Contact {
    constructor(firstName, lastName, address, city, state, zip, phone, email) {
        if (!nameRegex.test(firstName)) throw new Error("Invalid First Name");
        if (!nameRegex.test(lastName)) throw new Error("Invalid Last Name");
        if (!addressRegex.test(address)) throw new Error("Invalid Address");
        if (!addressRegex.test(city)) throw new Error("Invalid City");
        if (!addressRegex.test(state)) throw new Error("Invalid State");
        if (!zipRegex.test(zip)) throw new Error("Invalid Zip");
        if (!phoneRegex.test(phone)) throw new Error("Invalid Phone");
        if (!emailRegex.test(email)) throw new Error("Invalid Email");

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    toString() {
        return `${this.firstName} ${this.lastName}, ${this.city}, ${this.state}, ${this.zip}`;
    }
}

/* =========================================================
   UC 2 – Address Book Array
   ========================================================= */
let addressBook = [];

/* =========================================================
   UC 6 – Check Duplicate before Add
   ========================================================= */
function addContact(contact) {
    let isDuplicate = addressBook.some(c =>
        c.firstName === contact.firstName && c.lastName === contact.lastName
    );
    if (isDuplicate) throw new Error("Duplicate Contact Not Allowed");
    addressBook.push(contact);
}

/* =========================================================
   ADD SAMPLE CONTACTS
   ========================================================= */
try {
    addContact(new Contact(
        "Anbu", "A",
        "Street", "Chennai", "Tamilnadu",
        "600001", "9876543210", "abc@gmail.com"
    ));
    addContact(new Contact(
        "Ravi", "K",
        "Mainroad", "Bangalore", "Karnataka",
        "560001", "9123456789", "ravi@yahoo.com"
    ));
} catch (e) {
    console.error(e.message);
}

console.log("\nAddress Book:", addressBook.map(c => c.toString()));

/* =========================================================
   UC 3 – Find & Edit Contact
   ========================================================= */
function editContact(firstName, lastName, newCity) {
    let person = addressBook.find(
        c => c.firstName === firstName && c.lastName === lastName
    );
    if (person) person.city = newCity;
}
editContact("Anbu", "A", "Madurai");

/* =========================================================
   UC 4 – Delete Contact
   ========================================================= */
function deleteContact(firstName, lastName) {
    addressBook = addressBook.filter(
        c => !(c.firstName === firstName && c.lastName === lastName)
    );
}

/* =========================================================
   UC 5 – Count Contacts (Reduce)
   ========================================================= */
let count = addressBook.reduce(cnt => cnt + 1, 0);
console.log("\nUC5 – Contact Count:", count);

/* =========================================================
   UC 7 – Search Person by City or State
   ========================================================= */
function searchByCity(city) {
    return addressBook.filter(c => c.city === city);
}
console.log("\nUC7 – Persons in Madurai:", searchByCity("Madurai"));

/* =========================================================
   UC 8 – View Persons by City / State
   ========================================================= */
function viewByCity(city) {
    addressBook.filter(c => c.city === city)
        .map(c => console.log(c.toString()));
}
console.log("\nUC8 – View by City Madurai:");
viewByCity("Madurai");

/* =========================================================
   UC 9 – Count by City / State
   ========================================================= */
function countByCity() {
    return addressBook.reduce((map, c) => {
        map[c.city] = (map[c.city] || 0) + 1;
        return map;
    }, {});
}
console.log("\nUC9 – Count by City:", countByCity());

/* =========================================================
   UC 10 – Sort by Person Name
   ========================================================= */
let sortByName = addressBook.slice().sort(
    (a, b) => a.firstName.localeCompare(b.firstName)
);
console.log("\nUC10 – Sorted by Name:");
sortByName.forEach(c => console.log(c.toString()));

/* =========================================================
   UC 11 – Sort by City / State / Zip
   ========================================================= */
function sortByCity() {
    return addressBook.slice().sort((a, b) => a.city.localeCompare(b.city));
}

function sortByState() {
    return addressBook.slice().sort((a, b) => a.state.localeCompare(b.state));
}

function sortByZip() {
    return addressBook.slice().sort((a, b) => a.zip.localeCompare(b.zip));
}

console.log("\nUC11 – Sorted by City:");
sortByCity().forEach(c => console.log(c.toString()));

console.log("\n===== END OF ADDRESS BOOK SYSTEM =====");