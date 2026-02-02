const BASE_URL = "http://localhost:3000/employees";

window.onload = loadEmployees;

function loadEmployees() {
  fetch(BASE_URL)
    .then(res => res.json())
    .then(data => renderTable(data))
    .catch(err => console.error(err));
}

function renderTable(employees) {
  const table = document.getElementById("employeeTable");
  table.innerHTML = "";

  if (employees.length === 0) {
    table.innerHTML = `
      <tr>
        <td colspan="6" style="text-align:center;">No Employees Found</td>
      </tr>`;
    return;
  }

  employees.forEach(emp => {
    table.innerHTML += `
      <tr>
        <td>${emp.name}</td>
        <td>${emp.gender}</td>
        <td>${emp.department}</td>
        <td>₹${emp.salary}</td>
        <td>${emp.startDate}</td>
        <td class="actions">
          <button class="icon-btn edit" onclick="editEmployee(${emp.id})">✏️</button>
          <button class="icon-btn delete" onclick="deleteEmployee(${emp.id})">🗑</button>
        </td>
      </tr>`;
  });
}

function goToAddEmployee() {
  window.location.href = "addEmployee.html";
}

function editEmployee(id) {
  window.location.href = `addEmployee.html?id=${id}`;
}

function deleteEmployee(id) {
  if (!confirm("Are you sure you want to delete?")) return;

  fetch(`${BASE_URL}/${id}`, { method: "DELETE" })
    .then(() => loadEmployees())
    .catch(err => console.error(err));
}
