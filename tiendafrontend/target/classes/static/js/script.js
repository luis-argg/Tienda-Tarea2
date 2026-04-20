function abrirModal() {
    document.getElementById('modal').style.display = 'block';
}

function cerrarModal() {
    document.getElementById('modal').style.display = 'none';
}

function actualizarPagina() {
    location.reload();
}


//Usuarios functinsos
function prepararEdicion(boton) {
    document.getElementById('modal-titulo').innerText = 'Editar Usuario';

    document.getElementById('idUsuario').value = boton.getAttribute('data-id');
    document.getElementById('nombreUsuario').value = boton.getAttribute('data-nombre');
    document.getElementById('apellidoUsuario').value = boton.getAttribute('data-apellido');
    document.getElementById('edadUsuario').value = boton.getAttribute('data-edad');
    document.getElementById('username').value = boton.getAttribute('data-username');
    document.getElementById('password').value = boton.getAttribute('data-password');

    document.getElementById('modal').style.display = 'block';
}

function abrirNuevoUsuario() {
    document.getElementById('modal-titulo').innerText = "Nuevo Usuario";
    const form = document.getElementById('usuarioForm');
    if (form) form.reset();
    document.getElementById('idUsuario').value = "";
    abrirModal();
}

//Functions producros
function prepararEdicionProductos(btn) {
    document.getElementById('idProducto').value = btn.getAttribute('data-id');
    document.getElementById('nombreProducto').value = btn.getAttribute('data-nombre');
    document.getElementById('precioProducto').value = btn.getAttribute('data-precio');
    document.getElementById('stock').value = btn.getAttribute('data-stock');

    const categoriaId = btn.getAttribute('data-categoria');
    document.getElementById('idCategoria').value = categoriaId;

    document.getElementById('modal-titulo').innerText = "Editar Producto";
    document.getElementById('modal').style.display = 'block';
}

function abrirNuevoProducto() {
    document.getElementById('modal-titulo').innerText = "Nuevo Producto";
    const formulario = document.getElementById('productoForm');
    if (formulario) formulario.reset();

    const idProd = document.getElementById('idProducto');
    if (idProd) idProd.value = "";

    document.getElementById('modal').style.display = 'block';
}
function eliminar(id) {
    if (confirm("Estass seguro de que deseas eliminar este registro?")) {
        window.location.href = "/productos/eliminar/" + id;
    }
}

window.onclick = function(event) {
    let modal = document.getElementById('modal');
    if (event.target == modal) {
        cerrarModal();
    }
}
//Funcions para categoria
function prepararEdicionCategorias(btn) {
    document.getElementById('idCategoriaModal').value = btn.getAttribute('data-id');
    document.getElementById('nombreCategoria').value = btn.getAttribute('data-nombre');
    document.getElementById('descripcionCategoria').value = btn.getAttribute('data-descripcion');

    document.getElementById('modal-titulo').innerText = "Editar Categoría";
    document.getElementById('modal').style.display = 'block';
}

function abrirNuevaCategoria() {
    document.getElementById('modal-titulo').innerText = "Nueva Categoría";
    const form = document.getElementById('categoriaForm');
    if (form) form.reset();

    document.getElementById('idCategoriaModal').value = "";
    document.getElementById('modal').style.display = 'block';
}

function eliminarCategoria(id) {
    if (confirm("Estas seguro de que deseas eliminar esta categoria?")) {
        window.location.href = "/categorias/eliminar/" + id;
    }
}

//Functions peddidos
function prepararEdicionPedidos(btn) {
    document.getElementById('idPedido').value = btn.getAttribute('data-id');
    document.getElementById('fechaPedido').value = btn.getAttribute('data-fecha');
    document.getElementById('totalPedido').value = btn.getAttribute('data-total');
    document.getElementById('idUsuarioPedido').value = btn.getAttribute('data-usuario');

    document.getElementById('modal-titulo').innerText = "Editar Pedido";
    abrirModal();
}

function abrirNuevoPedido() {
    document.getElementById('modal-titulo').innerText = "Nuevo Pedido";
    const form = document.getElementById('pedidoForm');
    if (form) form.reset();
    document.getElementById('idPedido').value = "";
    abrirModal();
}

function eliminarPedido(id) {
    if (confirm("EstAs seguro de que deseas eliminar este pedido?")) {
        window.location.href = "/pedidos/eliminar/" + id;
    }
}
//Functions para detallepedido
function prepararEdicionDetalles(btn) {
    document.getElementById('idDetalle').value = btn.getAttribute('data-id');
    document.getElementById('idPedidoDetalle').value = btn.getAttribute('data-pedido');
    document.getElementById('idProductoDetalle').value = btn.getAttribute('data-producto');
    document.getElementById('cantidadDetalle').value = btn.getAttribute('data-cantidad');
    document.getElementById('precioUnitarioDetalle').value = btn.getAttribute('data-precio');

    document.getElementById('modal-titulo').innerText = "Editar Detalle";
    abrirModal();
}

function abrirNuevoDetalle() {
    document.getElementById('modal-titulo').innerText = "Nuevo Detalle";
    const form = document.getElementById('detalleForm');
    if (form) form.reset();
    document.getElementById('idDetalle').value = "";
    abrirModal();
}

function eliminarDetalle(id) {
    if (confirm("Estas seguro de que deseas eliminar este detalle?")) {
        window.location.href = "/detallepedidos/eliminar/" + id;
    }
};