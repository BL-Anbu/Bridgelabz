let editIndex = null;
let originalEmployee = null;

/* ===============================
   PAGE LOAD
================================ */
window.onload = () => {
  const params = new URLSearchParams(window.location.search);
  editIndex = params.get("editIndex");

  if (editIndex !== null) {
    loadEmployeeForEdit(editIndex);
    document.querySelector(".submit").innerText = "Update";
  }
};

/* ===============================
   LOAD EMPLOYEE FOR UPDATE
================================ */
function loadEmployeeForEdit(index) {
  fetch("http://localhost:3000/employees")
    .then(res => res.json())
    .then(employees => {
      const emp = employees[index];
      if (!emp) return;

      // snapshot for reset
      originalEmployee = JSON.parse(JSON.stringify(emp));

      fillForm(emp);
    })
    .catch(err => console.error("Error loading employee:", err));
}

/* ===============================
   FILL FORM
================================ */
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
  document.querySelectorAll("input[type='checkbox']").forEach(cb => {
    cb.checked = emp.department.includes(cb.value);
  });
}

/* ===============================
   SAVE / UPDATE EMPLOYEE
================================ */
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

  // UPDATE
  if (editIndex !== null) {
    fetch(`http://localhost:3000/employees/${editIndex}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee)
    })
      .then(() => window.location.href = "index.html")
      .catch(err => console.error("Update failed:", err));
  }
  // CREATE
  else {
    fetch("http://localhost:3000/employees", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee)
    })
      .then(() => window.location.href = "index.html")
      .catch(err => console.error("Save failed:", err));
  }
}

/* ===============================
   CANCEL
================================ */
function cancelForm() {
  window.location.href = "index.html";
}

/* ===============================
   RESET
================================ */
function resetForm() {
  if (editIndex !== null && originalEmployee) {
    // Restore original data (Update mode)
    fillForm(originalEmployee);
  } else {
    // Clear form (Add mode)
    clearForm();
  }
}

function goBackToList() {
  window.location.href = "index.html";
}

function clearForm() {
  document.getElementById("name").value = "";
  document.getElementById("salary").value = "";
  document.getElementById("startDate").value = "";
  document.getElementById("notes").value = "";

  document
    .querySelectorAll("input[name='gender']")
    .forEach(r => (r.checked = false));

  document
    .querySelectorAll("input[type='checkbox']")
    .forEach(cb => (cb.checked = false));
}
