const BASE_URL = "http://localhost:3000/employees";

const httpService = {
  get: () => fetch(BASE_URL).then(res => res.json()),

  getById: (id) =>
    fetch(`${BASE_URL}/${id}`).then(res => res.json()),

  post: (data) =>
    fetch(BASE_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    }),

  put: (id, data) =>
    fetch(`${BASE_URL}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    }),

  delete: (id) =>
    fetch(`${BASE_URL}/${id}`, { method: "DELETE" })
};
