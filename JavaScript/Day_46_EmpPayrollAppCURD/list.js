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
       <td class="actions">
          <button class="icon-btn edit" onclick="editEmployee(${index})" title="Edit">✏️</button>
          <button class="icon-btn delete" onclick="removeEmployee(${index})" title="Delete">🗑</button>
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

function editEmployee(index) {
  window.location.href = `addEmployee.html?editIndex=${index}`;
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