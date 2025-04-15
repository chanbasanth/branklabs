const API_BASE = "http://localhost:8080"; // Update if deployed elsewhere

async function fetchHeadingFromAPI() {
  const res = await fetch(`${API_BASE}/api/heading`);
  const data = await res.text(); // plain string
  return data;
}

async function saveHeadingToAPI(headingText) {
  await fetch(`${API_BASE}/api/heading`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ content: headingText }), // ✅ Must match backend
  });
}
