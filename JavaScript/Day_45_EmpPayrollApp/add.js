function saveEmployee() {
  console.log("Submit clicked"); // debug

  const name = document.getElementById("name").value.trim();
  const salary = document.getElementById("salary").value;
  const startDate = document.getElementById("startDate").value;
  const notes = document.getElementById("notes").value;

  const genderEl = document.querySelector("input[name='gender']:checked");
  const profileEl = document.querySelector("input[name='profile']:checked");

  const departments = [];
  document
    .querySelectorAll("input[type='checkbox']:checked")
    .forEach(cb => departments.push(cb.value));

  // Validation
  if (!name || !salary || !startDate || !genderEl || departments.length === 0) {
    alert("Please fill all required fields");
    return;
  }

  const employee = {
    name,
    profile: profileEl.value,
    gender: genderEl.value,
    department: departments,
    salary,
    startDate,
    notes
  };

  const employees = JSON.parse(localStorage.getItem("employees")) || [];
  employees.push(employee);
  localStorage.setItem("employees", JSON.stringify(employees));

  // Redirect back to list page
  window.location.href = "index.html";
}

function goBackToList() {
  window.location.href = "index.html";
}

function resetForm() {
  // Text fields
  document.getElementById("name").value = "";
  document.getElementById("salary").value = "";
  document.getElementById("startDate").value = "";
  document.getElementById("notes").value = "";

  // Radio buttons (gender)
  document
    .querySelectorAll("input[name='gender']")
    .forEach(radio => radio.checked = false);

  // Profile image radio (set default)
  const profileRadios = document.querySelectorAll("input[name='profile']");
  profileRadios.forEach((radio, index) => {
    radio.checked = index === 0; // first avatar selected
  });

  // Checkboxes (department)
  document
    .querySelectorAll("input[type='checkbox']")
    .forEach(cb => cb.checked = false);

  // Salary dropdown
  document.getElementById("salary").selectedIndex = 0;
}

