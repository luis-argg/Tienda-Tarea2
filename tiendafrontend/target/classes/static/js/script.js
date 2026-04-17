function abrirModal() {
    document.getElementById('modal').style.display = 'block';
}

function cerrarModal() {
    document.getElementById('modal').style.display = 'none';
}

function actualizarPagina() {
    location.reload();
}

function eliminar(id) {
    if (confirm("¿Estás seguro de que deseas eliminar este usuario?")) {
        window.location.href = "/usuarios/eliminar/" + id;
    }
}

function prepararEdicion(boton) {
    const id = boton.dataset.id;
    const nombre = boton.dataset.nombre;
    const apellido = boton.dataset.apellido;
    const edad = boton.dataset.edad;

    document.getElementById('modal-titulo').innerText = "Editar Usuario";
    document.getElementById('idUsuario').value = id;
    document.getElementById('nombreUsuario').value = nombre;
    document.getElementById('apellidoUsuario').value = apellido;
    document.getElementById('edadUsuario').value = edad;

    abrirModal();
}

function abrirNuevoUsuario() {
    document.getElementById('modal-titulo').innerText = "Nuevo Usuario";
    document.getElementById('usuarioForm').reset();
    document.getElementById('idUsuario').value = "";
    abrirModal();
}

window.onclick = function(event) {
    let modal = document.getElementById('modal');
    if (event.target == modal) {
        cerrarModal();
    }
}