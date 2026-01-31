const http = require("http");

let employees = []; // in-memory storage

const server = http.createServer((req, res) => {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
  res.setHeader("Access-Control-Allow-Headers", "Content-Type");

  if (req.method === "OPTIONS") {
    res.writeHead(204);
    res.end();
    return;
  }

  // GET all employees
  if (req.method === "GET" && req.url === "/employees") {
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(employees));
  }

  // POST new employee
  else if (req.method === "POST" && req.url === "/employees") {
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      const emp = JSON.parse(body);
      employees.push(emp);
      res.writeHead(201);
      res.end("Employee Added");
    });
  }

  // PUT update employee
  else if (req.method === "PUT" && req.url.startsWith("/employees/")) {
    const index = req.url.split("/")[2];
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      employees[index] = JSON.parse(body);
      res.writeHead(200);
      res.end("Employee Updated");
    });
  }

  // DELETE employee
  else if (req.method === "DELETE" && req.url.startsWith("/employees/")) {
    const index = req.url.split("/")[2];
    employees.splice(index, 1);
    res.writeHead(200);
    res.end("Employee Deleted");
  }
});

server.listen(3000, () => {
  console.log("Employee Service running at http://localhost:3000");
});
