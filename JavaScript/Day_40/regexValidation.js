console.log("====== REGEX VALIDATION ======");

// ---------------- PIN CODE ----------------
const pinRegex = /^[0-9]{3}\s?[0-9]{3}$/;

const pinTests = [
    "400088",
    "400 088",
    "A400088",
    "400088B",
    "4000 88"
];

console.log("\nPIN Code Validation:");
pinTests.forEach(pin =>
    console.log(pin, "=>", pinRegex.test(pin))
);

// ---------------- EMAIL ----------------
const emailRegex =
/^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\.[a-zA-Z]{2,})$/;

const validEmails = [
    "abc@yahoo.com",
    "abc-100@yahoo.com",
    "abc.100@yahoo.com",
    "abc111@abc.com",
    "abc-100@abc.net",
    "abc.100@abc.com.au",
    "abc@1.com",
    "abc@gmail.com.com",
    "abc+100@gmail.com"
];

const invalidEmails = [
    "abc",
    "abc@.com.my",
    "abc123@gmail.a",
    "abc123@.com",
    "abc123@.com.com",
    ".abc@abc.com",
    "abc()*@gmail.com",
    "abc@%*.com",
    "abc..2002@gmail.com",
    "abc.@gmail.com",
    "abc@abc@gmail.com",
    "abc@gmail.com.1a",
    "abc@gmail.com.aa.au"
];

console.log("\nValid Email Tests:");
validEmails.forEach(email =>
    console.log(email, "=>", emailRegex.test(email))
);

console.log("\nInvalid Email Tests:");
invalidEmails.forEach(email =>
    console.log(email, "=>", emailRegex.test(email))
);

console.log("\n====== END ======");
