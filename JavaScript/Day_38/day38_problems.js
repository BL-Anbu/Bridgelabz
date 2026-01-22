

// ---------- SEQUENCE PROBLEMS ----------
function singleDigit() {
    console.log("Single Digit:", Math.floor(Math.random() * 10));
}

function diceNumber() {
    console.log("Dice Number:", Math.floor(Math.random() * 6) + 1);
}

function addDice() {
    const d1 = Math.floor(Math.random() * 6) + 1;
    const d2 = Math.floor(Math.random() * 6) + 1;
    console.log("Dice Sum:", d1 + d2);
}

function sumAndAverage() {
    let sum = 0;
    for (let i = 0; i < 5; i++) {
        sum += Math.floor(Math.random() * 90) + 10;
    }
    console.log("Sum:", sum);
    console.log("Average:", sum / 5);
}

function unitConversion() {
    console.log("42 inches in feet:", 42 / 12);

    const length = 60 * 0.3048;
    const width = 40 * 0.3048;
    const area25Plots = 25 * length * width;
    console.log("Area of 25 plots in acres:", area25Plots / 4046.86);
}

// ---------- IF ELSE ----------
function minMaxThreeDigit() {
    let min = 999, max = 100;
    for (let i = 0; i < 5; i++) {
        let num = Math.floor(Math.random() * 900) + 100;
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    console.log("Min:", min, "Max:", max);
}

function dateRangeCheck(day, month) {
    const result =
        (month === 3 && day >= 20) ||
        month === 4 || month === 5 ||
        (month === 6 && day <= 20);
    console.log(result);
}

function leapYear(year) {
    const isLeap =
        (year % 4 === 0 && year % 100 !== 0) ||
        year % 400 === 0;
    console.log("Leap Year:", isLeap);
}

function coinFlip() {
    console.log(Math.random() < 0.5 ? "Heads" : "Tails");
}

// ---------- IF ELSE IF ----------
function digitToWord(num) {
    if (num === 0) console.log("Zero");
    else if (num === 1) console.log("One");
    else if (num === 2) console.log("Two");
    else console.log("Invalid");
}

function weekday(num) {
    if (num === 1) console.log("Sunday");
    else if (num === 2) console.log("Monday");
    else if (num === 3) console.log("Tuesday");
    else console.log("Invalid");
}

function arithmeticMaxMin(a, b, c) {
    const values = [
        a + b * c,
        a % b + c,
        c + a / b,
        a * b + c
    ];
    console.log("Min:", Math.min(...values));
    console.log("Max:", Math.max(...values));
}

// ---------- SWITCH CASE ----------
function digitToWordSwitch(num) {
    switch (num) {
        case 0: console.log("Zero"); break;
        case 1: console.log("One"); break;
        case 2: console.log("Two"); break;
        default: console.log("Invalid");
    }
}

function unitConversionSwitch(choice, value) {
    switch (choice) {
        case 1: console.log("Feet to Inch:", value * 12); break;
        case 2: console.log("Feet to Meter:", value * 0.3048); break;
        case 3: console.log("Inch to Feet:", value / 12); break;
        case 4: console.log("Meter to Feet:", value / 0.3048); break;
        default: console.log("Invalid");
    }
}

// ---------- FOR LOOP ----------
function powerOfTwo(n) {
    for (let i = 0; i <= n; i++) {
        console.log(2 ** i);
    }
}

function harmonicNumber(n) {
    let sum = 0;
    for (let i = 1; i <= n; i++) {
        sum += 1 / i;
    }
    console.log("Harmonic Number:", sum);
}

function isPrime(n) {
    if (n < 2) return false;
    for (let i = 2; i * i <= n; i++) {
        if (n % i === 0) return false;
    }
    return true;
}

function factorial(n) {
    let fact = 1;
    for (let i = 1; i <= n; i++) {
        fact *= i;
    }
    console.log("Factorial:", fact);
}

function primeFactors(n) {
    for (let i = 2; i * i <= n; i++) {
        while (n % i === 0) {
            console.log(i);
            n /= i;
        }
    }
    if (n > 1) console.log(n);
}

// ---------- WHILE LOOP ----------
function flipCoin11Times() {
    let heads = 0, tails = 0;
    while (heads < 11 && tails < 11) {
        Math.random() < 0.5 ? heads++ : tails++;
    }
    console.log("Heads:", heads, "Tails:", tails);
}

// ---------- FUNCTIONS ----------
function cToF(c) {
    return (c * 9 / 5) + 32;
}

function fToC(f) {
    return (f - 32) * 5 / 9;
}

function isPalindrome(n) {
    return n.toString() === n.toString().split("").reverse().join("");
}

function primePalindrome(n) {
    console.log(isPrime(n) && isPrime(Number(n.toString().split("").reverse().join(""))));
}

// ---------- MAIN (TEST RUN) ----------
console.log("=== PRACTICE PROBLEMS OUTPUT ===");

singleDigit();
diceNumber();
addDice();
sumAndAverage();
unitConversion();

minMaxThreeDigit();
dateRangeCheck(15, 4);
leapYear(2024);
coinFlip();

digitToWord(2);
weekday(3);
arithmeticMaxMin(5, 3, 2);

digitToWordSwitch(1);
unitConversionSwitch(2, 10);

powerOfTwo(5);
harmonicNumber(5);
console.log("Is Prime:", isPrime(29));
factorial(5);
primeFactors(56);

flipCoin11Times();

console.log("0°C to °F:", cToF(0));
console.log("32°F to °C:", fToC(32));
console.log("Palindrome:", isPalindrome(121));
primePalindrome(131);
