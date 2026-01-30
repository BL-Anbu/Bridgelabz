// =======================================
// Load employees from localStorage
// =======================================
let employees = JSON.parse(localStorage.getItem("employees")) || [];

// Load data on page load
window.addEventListener("DOMContentLoaded", () => {
  renderTable();
});

// =======================================
// Add Employee
// =======================================
function addEmployee() {
  const name = document.getElementById("name").value.trim();
  const salary = document.getElementById("salary").value;
  const gender = document.getElementById("gender").value;
  const department = document.getElementById("department").value;
  const startDate = document.getElementById("startDate").value;
  const error = document.getElementById("error");

  // Validation
  if (name.length < 3) {
    error.textContent = "Name must be at least 3 characters";
    return;
  }

  if (salary <= 0) {
    error.textContent = "Salary must be greater than 0";
    return;
  }

  if (!gender || !department || !startDate) {
    error.textContent = "All fields are required";
    return;
  }

  error.textContent = "";

  const employee = {
    name,
    salary,
    gender,
    department,
    startDate
  };

  employees.push(employee);
  localStorage.setItem("employees", JSON.stringify(employees));

  renderTable();
  clearForm();
}

// =======================================
// Render Table
// =======================================
function renderTable() {
  const table = document.getElementById("employeeTable");
  table.innerHTML = "";

  if (employees.length === 0) {
    table.innerHTML = `
      <tr>
        <td colspan="6" style="text-align:center;">No Employees Found</td>
      </tr>
    `;
    return;
  }

  employees.forEach((emp, index) => {
    table.innerHTML += `
      <tr>
        <td>${emp.name}</td>
        <td>${emp.salary}</td>
        <td>${emp.gender}</td>
        <td>${emp.department}</td>
        <td>${emp.startDate}</td>
        <td class="buttom-remove">
          <button class="remove-btn" onclick="removeEmployee(${index})">Remove</button>
        </td>
      </tr>
    `;
  });
}

// =======================================
// Remove Employee (Local Storage)
// =======================================
function removeEmployee(index) {
  if (!confirm("Are you sure you want to remove this employee?")) return;

  employees.splice(index, 1);
  localStorage.setItem("employees", JSON.stringify(employees));
  renderTable();
}

// =======================================
// Clear Form
// =======================================
function clearForm() {
  document.getElementById("name").value = "";
  document.getElementById("salary").value = "";
  document.getElementById("gender").value = "";
  document.getElementById("department").value = "";
  document.getElementById("startDate").value = "";
  document.getElementById("error").textContent = "";
}
