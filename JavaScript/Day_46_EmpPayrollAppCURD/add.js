let editIndex = null;

// Run on page load
window.onload = () => {
  const params = new URLSearchParams(window.location.search);
  editIndex = params.get("editIndex");

  if (editIndex !== null) {
    const employees = JSON.parse(localStorage.getItem("employees")) || [];
    originalEmployee = JSON.parse(JSON.stringify(employees[editIndex])); // deep copy
    loadEmployeeForEdit(editIndex);
    document.querySelector(".submit").innerText = "Update";
  }
};

// Load employee into form
function loadEmployeeForEdit(index) {
  const employees = JSON.parse(localStorage.getItem("employees")) || [];
  const emp = employees[index];

  if (!emp) return;

  document.getElementById("name").value = emp.name;
  document.getElementById("salary").value = emp.salary;
  document.getElementById("startDate").value = emp.startDate;
  document.getElementById("notes").value = emp.notes || "";

  // Gender
  document
    .querySelector(`input[name="gender"][value="${emp.gender}"]`)
    .checked = true;

  // Department
  document
    .querySelectorAll("input[type='checkbox']")
    .forEach(cb => {
      cb.checked = emp.department.includes(cb.value);
    });
}

// Save or Update employee
function saveEmployee() {
  const name = document.getElementById("name").value.trim();
  const salary = document.getElementById("salary").value;
  const startDate = document.getElementById("startDate").value;
  const notes = document.getElementById("notes").value;

  const genderEl = document.querySelector("input[name='gender']:checked");
  const departments = [];

  document
    .querySelectorAll("input[type='checkbox']:checked")
    .forEach(cb => departments.push(cb.value));

  if (!name || !salary || !startDate || !genderEl || departments.length === 0) {
    alert("Please fill all required fields");
    return;
  }

  const employee = {
    name,
    gender: genderEl.value,
    department: departments.join(", "),
    salary,
    startDate,
    notes
  };

  const employees = JSON.parse(localStorage.getItem("employees")) || [];

  if (editIndex !== null) {
    // UPDATE
    employees[editIndex] = employee;
  } else {
    // CREATE
    employees.push(employee);
  }

  localStorage.setItem("employees", JSON.stringify(employees));
  window.location.href = "index.html";
}

function goBackToList() {
  window.location.href = "index.html";
}

function resetForm() {
  if (editIndex !== null && originalEmployee) {
    // ✏️ UPDATE MODE → restore original values
    fillForm(originalEmployee);
  } else {
    // ➕ ADD MODE → clear everything
    clearForm();
  }
}

function fillForm(emp) {
  document.getElementById("name").value = emp.name;
  document.getElementById("salary").value = emp.salary;
  document.getElementById("startDate").value = emp.startDate;
  document.getElementById("notes").value = emp.notes || "";

  // Gender
  document
    .querySelector(`input[name="gender"][value="${emp.gender}"]`)
    .checked = true;

  // Department
  document
    .querySelectorAll("input[type='checkbox']")
    .forEach(cb => {
      cb.checked = emp.department.includes(cb.value);
    });

  // Profile image (optional)
  if (emp.profile) {
    document
      .querySelectorAll("input[name='profile']")
      .forEach(r => r.checked = r.value === emp.profile);
  }
}

function clearForm() {
  document.getElementById("name").value = "";
  document.getElementById("salary").value = "";
  document.getElementById("startDate").value = "";
  document.getElementById("notes").value = "";

  document
    .querySelectorAll("input[name='gender']")
    .forEach(r => r.checked = false);

  document
    .querySelectorAll("input[name='profile']")
    .forEach((r, i) => r.checked = i === 0);

  document
    .querySelectorAll("input[type='checkbox']")
    .forEach(cb => cb.checked = false);

  document.getElementById("salary").selectedIndex = 0;
}
