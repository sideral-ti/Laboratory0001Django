document.addEventListener("DOMContentLoaded", () => {
    console.log("JavaScript cargado correctamente.");
});

function viewDetails(button) {
    const projectId = button.getAttribute("data-id");
    alert(`Ver detalles del proyecto con ID: ${projectId}`);
    // Lógica adicional como redirigir a una página de detalles
}