const BASE_URL = "http://localhost:3000/employees";
let editId = null;

window.onload = () => {
  const params = new URLSearchParams(window.location.search);
  editId = params.get("id");

  if (editId) {
    fetch(`${BASE_URL}/${editId}`)
      .then(res => res.json())
      .then(emp => populateForm(emp));
  }
};

function populateForm(emp) {
  document.getElementById("name").value = emp.name;
  document.getElementById("salary").value = emp.salary;
  document.getElementById("startDate").value = emp.startDate;

  document.querySelector(`input[name="gender"][value="${emp.gender}"]`).checked = true;

  document.querySelectorAll("input[type='checkbox']").forEach(cb => {
    cb.checked = emp.department.includes(cb.value);
  });
}

function saveEmployee() {
  const name = document.getElementById("name").value.trim();
  const salary = document.getElementById("salary").value;
  const startDate = document.getElementById("startDate").value;
  const gender = document.querySelector("input[name='gender']:checked")?.value;
  const department = [...document.querySelectorAll("input[type='checkbox']:checked")]
    .map(cb => cb.value)
    .join(", ");

  if (!name || !salary || !startDate || !gender || !department) {
    alert("Please fill all fields");
    return;
  }

  const employee = { name, salary, startDate, gender, department };

  const method = editId ? "PUT" : "POST";
  const url = editId ? `${BASE_URL}/${editId}` : BASE_URL;

  fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee)
  })
    .then(() => window.location.href = "index.html")
    .catch(err => console.error(err));
}

function goBack() {
  window.location.href = "index.html";
}
