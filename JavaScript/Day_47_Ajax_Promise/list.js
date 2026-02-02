/* ===============================
   LOAD EMPLOYEES ON PAGE LOAD
================================ */
window.onload = () => {
  loadEmployees();
};

/* ===============================
   NAVIGATION
================================ */
function goToAddEmployee() {
  window.location.href = "addEmployee.html";
}

function editEmployee(index) {
  window.location.href = `addEmployee.html?editIndex=${index}`;
}

/* ===============================
   LOAD EMPLOYEES (AJAX GET)
================================ */
function loadEmployees() {
  fetch("http://localhost:3000/employees")
    .then(response => response.json())
    .then(data => renderTable(data))
    .catch(err => {
      console.error("Failed to load employees:", err);
      renderEmptyState();
    });
}

/* ===============================
   RENDER TABLE
================================ */
function renderTable(employees) {
  const table = document.getElementById("employeeTable");
  table.innerHTML = "";

  if (!employees || employees.length === 0) {
    renderEmptyState();
    return;
  }

  employees.forEach((emp, index) => {
    table.innerHTML += `
      <tr>
        <td>${emp.name}</td>
        <td>${emp.gender}</td>
        <td>${emp.department}</td>
        <td>₹ ${emp.salary}</td>
        <td>${emp.startDate}</td>
        <td class="actions">
          <button class="icon-btn edit" onclick="editEmployee(${index})" title="Edit">
            ✏️
          </button>
          <button class="icon-btn delete" onclick="deleteEmployee(${index})" title="Delete">
            🗑
          </button>
        </td>
      </tr>
    `;
  });
}

/* ===============================
   EMPTY STATE
================================ */
function renderEmptyState() {
  const table = document.getElementById("employeeTable");
  table.innerHTML = `
    <tr>
      <td colspan="6" style="text-align:center; padding: 20px;">
        No Employees Found
      </td>
    </tr>
  `;
}

/* ===============================
   DELETE EMPLOYEE (AJAX DELETE)
================================ */
function deleteEmployee(index) {
  if (!confirm("Are you sure you want to delete this employee?")) return;

  fetch(`http://localhost:3000/employees/${index}`, {
    method: "DELETE"
  })
    .then(() => loadEmployees())
    .catch(err => console.error("Delete failed:", err));
}
