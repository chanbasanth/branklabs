// Use relative API path so it works both locally and on deployment
const API_BASE = ""; // same origin as current site

// Fetch heading from backend API
async function fetchHeadingFromAPI() {
  try {
    const res = await fetch(`${API_BASE}/api/heading`);
    if (!res.ok) throw new Error("Failed to fetch heading");
    const data = await res.text(); // plain string
    return data;
  } catch (err) {
    console.error("Error fetching heading:", err);
    return "Failed to load heading";
  }
}

// Save new heading to backend API
async function saveHeadingToAPI(headingText) {
  try {
    const res = await fetch(`${API_BASE}/api/heading`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ content: headingText }),
    });
    if (!res.ok) throw new Error("Failed to save heading");
  } catch (err) {
    console.error("Error saving heading:", err);
  }
}

// Example: load heading into the page on load
document.addEventListener("DOMContentLoaded", async () => {
  const headingEl = document.querySelector("#dynamic-heading");
  const headingText = await fetchHeadingFromAPI();
  if (headingEl) {
    headingEl.textContent = headingText;
  }
});
