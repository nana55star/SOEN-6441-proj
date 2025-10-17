document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const input = form.querySelector('input[name="q"]');
    const resultsDiv = document.getElementById("results");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const q = input.value.trim();
        if (!q) return;

        resultsDiv.innerHTML = "Loading...";
        try {
            const res = await fetch(`/search?q=${encodeURIComponent(q)}`);
            if (!res.ok) throw new Error(`HTTP ${res.status}`);
            const data = await res.json();

            if (data.status === "error") {
                resultsDiv.textContent = data.message || "API returned an error.";
                return;
            }

            const items = (data.articles || [])
                .map(
                    (a) => `
          <li style="margin:8px 0">
            <a href="${a.url}" target="_blank" rel="noopener">${a.title || "(no title)"}</a>
            <div style="font-size:0.9em;color:#555">${a.source?.name ?? ""}</div>
            <div style="font-size:0.9em">${a.description ?? ""}</div>
          </li>`
                )
                .join("");

            resultsDiv.innerHTML = items ? `<ul>${items}</ul>` : "No results found.";
        } catch (err) {
            resultsDiv.textContent = `❌ Failed to fetch results: ${err.message}`;
        }
    });
});
