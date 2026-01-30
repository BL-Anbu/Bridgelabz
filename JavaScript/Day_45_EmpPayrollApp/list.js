let employees = JSON.parse(localStorage.getItem("employees")) || [];

window.onload = () => {
  renderTable();
};

function goToAddEmployee() {
  window.location.href = "addEmployee.html";
}

function renderTable() {
  const table = document.getElementById("employeeTable");
  table.innerHTML = "";

  if (employees.length === 0) {
    table.innerHTML = `
      <tr>
        <td colspan="6" style="text-align:center;">
          No Employees Found
        </td>
      </tr>
    `;
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
        <td>
          <button onclick="removeEmployee(${index})">🗑</button>
        </td>
      </tr>
    `;
  });
}

function removeEmployee(index) {
  if (!confirm("Are you sure you want to remove this employee?")) return;

  employees.splice(index, 1);
  localStorage.setItem("employees", JSON.stringify(employees));
  renderTable();
}
