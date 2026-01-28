let employees = [];

function addEmployee() {
  const name = document.getElementById("name").value.trim();
  const salary = document.getElementById("salary").value;
  const gender = document.getElementById("gender").value;
  const department = document.getElementById("department").value;
  const startDate = document.getElementById("startDate").value;
  const error = document.getElementById("error");

  if (name.length < 3) {
    error.textContent = "Name must be at least 3 characters";
    return;
  }

  if (salary <= 0) {
    error.textContent = "Salary must be greater than 0";
    return;
  }

  error.textContent = "";

  const employee = { name, salary, gender, department, startDate };
  employees.push(employee);

  renderTable();
  clearForm();
}

function renderTable() {
  const table = document.getElementById("employeeTable");
  table.innerHTML = "";

  employees.forEach(emp => {
    table.innerHTML += `
      <tr>
        <td>${emp.name}</td>
        <td>${emp.salary}</td>
        <td>${emp.gender}</td>
        <td>${emp.department}</td>
        <td>${emp.startDate}</td>
      </tr>
    `;
  });
}

function clearForm() {
  document.getElementById("name").value = "";
  document.getElementById("salary").value = "";
  document.getElementById("gender").value = "";
  document.getElementById("department").value = "";
  document.getElementById("startDate").value = "";
}
