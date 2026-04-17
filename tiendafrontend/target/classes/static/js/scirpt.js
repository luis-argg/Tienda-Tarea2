
alert("¡El JS funciona!");

function abrirModal() {
    document.getElementById("modal").style.display = "block";
}

function cerrarModal() {
    document.getElementById("modal").style.display = "none";
}

// ELIMINAR USUARIO
function eliminar(id) {
    if (confirm("¿Seguro que quieres eliminar este usuario?")) {
        fetch("/usuarios/" + id, {
            method: "DELETE"
        })
        .then(() => {
            location.reload();
        });
    }
}