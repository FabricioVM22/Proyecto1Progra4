//función para obtener los usuarios
function obtenerUsuarios() {
    return fetch("/api/usuarios", { // Determinamos el repositorio de datos al cual nos vamos a conectar
        method: "GET", // Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => {
            if (response.ok) { // Respuesta positiva
                return response.json(); // Convertimos la respuesta a JSON
            } else { // Cualquier otra cosa va a ser un error
                throw new Error("Error al obtener los usuarios");
            }
        })
        .catch(error => {
            console.error("Error al obtener los usuarios: ", error);
            throw error; // Propagamos el error para que pueda ser manejado por el llamador de esta función
        });
}

//función para guardar clientes nuevos
function guardarCliente(Cliente) {
    fetch("/api/clientes", { //Primero determinamos el repositorio de datos al cual nos vamos a conectar
        method: "POST", //Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Cliente) //Convertimos el usuario que obtuvimos desde el formulario a Json para poder enviarlo al servicio Rest
    })
        .then(response => {
            if (response.ok) //Respuesta positiva
            { //Si la respuesta es positiva, quiere decir que se almacenó el usuario
                alert("Usuario agregado correctamente!"); //Notificamos
                window.location.href = "/Clientes"; //Redireccionamos a la lista de usuarios
            } else //Cualquier otra cosa va a ser un error
            {
                alert("Error al guardar el cliente");
                throw new Error("Error al guardar el usuario");
            }
        })
        .catch(error => console.error("Error al guardar el usuario: ", error));
}

//función para guardar usuarios nuevos
function guardarUsuario(Usuario) {
    fetch("/api/usuarios", { //Primero determinamos el repositorio de datos al cual nos vamos a conectar
        method: "POST", //Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Usuario) //Convertimos el usuario que obtuvimos desde el formulario a Json para poder enviarlo al servicio Rest
    })
        .then(response => {
            if (response.ok) //Respuesta positiva
            { //Si la respuesta es positiva, quiere decir que se almacenó el usuario
                alert("Usuario agregado correctamente!"); //Notificamos
                window.location.href = "/"; //Redireccionamos a la lista de usuarios
            } else //Cualquier otra cosa va a ser un error
            {
                alert("Error al guardar el usuario");
                throw new Error("Error al guardar el usuario");
            }
        })
        .catch(error => console.error("Error al guardar el usuario: ", error));
}

//función para guardar productos nuevos
function guardarProducto(Producto) {
    fetch("/api/productos", { //Primero determinamos el repositorio de datos al cual nos vamos a conectar
        method: "POST", //Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Producto) //Convertimos el usuario que obtuvimos desde el formulario a Json para poder enviarlo al servicio Rest
    })
        .then(response => {
            if (response.ok) //Respuesta positiva
            { //Si la respuesta es positiva, quiere decir que se almacenó el producto
                alert("Usuario agregado correctamente!"); //Notificamos
                window.location.href = "/Productos"; //Redireccionamos a la lista de productos
            } else //Cualquier otra cosa va a ser un error
            {
                alert("Error al guardar el producto");
                throw new Error("Error al guardar el producto");
            }
        })
        .catch(error => console.error("Error al guardar el producto: ", error));
}

//función para guardar facturas nuevas
function guardarFactura(Factura) {
    fetch("/api/facturas", { //Primero determinamos el repositorio de datos al cual nos vamos a conectar
        method: "POST", //Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Factura) //Convertimos el usuario que obtuvimos desde el formulario a Json para poder enviarlo al servicio Rest
    })
        .then(response => {
            if (response.ok) //Respuesta positiva
            { //Si la respuesta es positiva, quiere decir que se almacenó el producto
                alert("Usuario agregado correctamente!"); //Notificamos
                window.location.href = "/Facturas"; //Redireccionamos a la lista de productos
            } else //Cualquier otra cosa va a ser un error
            {
                alert("Error al guardar la factura");
                throw new Error("Error al guardar la factura");
            }
        })
        .catch(error => console.error("Error al guardar la factura: ", error));
}
function Login(Usuario) {
    fetch("/login", { //Primero determinamos el repositorio de datos al cual nos vamos a conectar
        method: "POST", //Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(Usuario) //Convertimos el usuario que obtuvimos desde el formulario a Json para poder enviarlo al servicio Rest
    })
        .then(response => {
            if (response.ok) //Respuesta positiva
            { //Si la respuesta es positiva, quiere decir que se almacenó el producto
                console.log("Inicio de sesion correcto"); //Notificamos
                window.location.href = "/Perfil"; //Redireccionamos a la lista de productos
            } else //Cualquier otra cosa va a ser un error
            {
                alert("Error al iniciar sesion");
                throw new Error("Error al guardar la factura");
            }
        })
        .catch(error => console.error("Error al guardar la factura: ", error));
}


//funciones para cargar las tablas
function fetchClientes() {
    fetch("/api/clientes")
        .then(response => response.json())
        .then(clientes => {
            const tablaClientes = document.getElementById("tabla-clientes");
            tablaClientes.innerHTML = ""; // Limpiar la tabla antes de llenarla

            // Crear la fila de encabezados
            const encabezado = document.createElement("tr");
            encabezado.innerHTML = `
                <th>Nombre del Cliente</th>
                <th>Correo Electrónico</th>
                <th>Cédula</th>
            `;
            tablaClientes.appendChild(encabezado);

            // Llenar la tabla con los datos de los clientes
            clientes.forEach(cliente => {
                const fila = document.createElement("tr");
                fila.innerHTML = `
                    <td>${cliente.nombre}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cedula}</td>
                `;
                tablaClientes.appendChild(fila);
            });
        })
        .catch(error => console.error("Error al obtener clientes:", error));
}
function fetchFacturas() {
    fetch("/api/facturas")
        .then(response => response.json()).then(facturas => {
        const tablafacturas = document.getElementById("tabla-facturas");
        tablafacturas.innerHTML = "";

        // Crear la fila de encabezados
        const encabezado = document.createElement("tr");
        encabezado.innerHTML = `
                    <th>Numero de factura</th>
                    <th>Nombre del Cliente</th>
                    <th>Correo Electrónico</th>
                `;
        tablafacturas.appendChild(encabezado);

        //lenar las tablas
        facturas.forEach(factura => {
            const fila = document.createElement("tr");
            fila.innerHTML = `
                <td>${factura.numFactura}</td>
                <td>${factura.cliente}</td>
                <td>${factura.email}</td>
                `;
            tablafacturas.appendChild(fila);
        });
    })
        .catch(error => console.error("Error al obtener facturas:", error));
}
function fetchProdutos() {
    fetch("/api/productos")
        .then(response => response.json()).then(productos => {
        const tablaProductos = document.getElementById("Tabla-Productos");
        tablaProductos.innerHTML = "";

        //crear fila de encabezados
        const encabezado = document.createElement("tr");
        encabezado.innerHTML = `
            <th>Numero producto</th>
            <th>Descripción</th>
            <th>Cantidad</th>
        `;
        tablaProductos.appendChild(encabezado);
        //lenar las tablas
        productos.forEach(producto => {
            const fila = document.createElement("tr");
            fila.innerHTML = `
                <td>${producto.numProducto}</td>
                <td>${producto.descripcion}</td>
                <td>${producto.cantidad}</td>  
                `;
            tablaProductos.appendChild(fila);
        });
    })
        .catch(error => console.error("Error al obtener productos:", error));
}
function fetchUsuarios() {
    fetch('/api/usuarios')
        .then(response => response.json()).then(usuarios => {
            const tablaUsuarios = document.getElementById('tabla-usuarios');
            tablaUsuarios.innerHTML = "";

            //crear fila de encabezados
            const encabezado = document.createElement("tr");
            encabezado.innerHTML = `
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo electrónico</th>
            <th>Estado del usuario</th>
        `;
            tablaUsuarios.appendChild(encabezado);
            //lenar las tablas
            usuarios.forEach(usuario => {
                const fila = document.createElement('tr');
                fila.innerHTML = `
                    <td>${usuario.id}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.estado === 'true' ? 'Activo' : 'Inactivo'}</td>
                `;
                tablaUsuarios.appendChild(fila);
            });

            console.log('Tabla de solo estado actualizada');
        })
        .catch(error => console.error("Error al obtener usuarios:", error));
}
function fetchUsuarioMD() {
    fetch('/api/usuarios')
        .then(response => response.json())
        .then(usuarios => {
            const tablaUsuarios = document.getElementById('tabla-usuarios-editable');
            tablaUsuarios.innerHTML = "";
            const encabezado = document.createElement("tr");
            encabezado.innerHTML = `
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo electrónico</th>
            <th>Estado del usuario</th>
            `
            tablaUsuarios.appendChild(encabezado);

            //llenar las tablas
            usuarios.forEach(usuario => {
                const fila = document.createElement('tr');
                fila.innerHTML = `
                    <td>${usuario.id}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.email}</td>
                    <td>
                        <select data-user-id="${usuario.id}">
                            <option value="true" ${usuario.estado === 'true' ? 'selected' : ''}>Activo</option>
                            <option value="false" ${usuario.estado === 'false' ? 'selected' : ''}>Inactivo</option>
                        </select>
                    </td>
                `;
                tablaUsuarios.appendChild(fila);

                // Añadir evento change al select
                const select = fila.querySelector('select');
                select.addEventListener('change', (event) => {
                    cambiarEstadoUsuario(event.target.dataset.userId, event.target.value);
                });
            });

            console.log('Tabla editable actualizada');
        })
        .catch(error => console.error("Error al obtener usuarios:", error));
}
function fetchProveedor(nombre) {
    fetch("/api/usuarios")
        .then(response => response.json()).then(usuarios => {

        usuarios.forEach(usuario => {
            if (usuario.nombre === nombre){
                var nombreUsarioActivo;
                var correoUsuarioActivo;
                var idUsuarioActivo;
                nombreUsarioActivo = usuario.nombre;
                correoUsuarioActivo = usuario.email;
                idUsuarioActivo = usuario.id;
                sessionStorage.setItem('nombreUsuarioActivo',nombreUsarioActivo);
                sessionStorage.setItem('correoUsuarioActivo',correoUsuarioActivo);
                sessionStorage.setItem('idUsuarioActivo',idUsuarioActivo);

            }
        });
    })
        .catch(error => console.error("Error al obtener usuarios:", error));
}
function fetchPerfil() {
    const DetallesProveedor = document.getElementById('Detalles-Proveedor');
    const PerfilNombre = document.createElement("h2");
    const PerfilEmail = document.createElement("h2")
    PerfilNombre.innerHTML = sessionStorage.getItem('nombreUsuarioActivo');
    PerfilEmail.innerHTML = sessionStorage.getItem('correoUsuarioActivo');
    DetallesProveedor.appendChild(PerfilNombre);
    DetallesProveedor.appendChild(document.createElement("br"));
    DetallesProveedor.appendChild(PerfilEmail);

}

//metodo para cambiar el estado de un usuario
function cambiarEstadoUsuario(userId, nuevoEstado) {
    console.log(`Cambiando estado del usuario con ID ${userId} a ${nuevoEstado}`);

    // Actualizar el estado en el DOM
    const fila = document.querySelector(`select[data-user-id="${userId}"]`).closest('tr');
    fila.querySelector('td:nth-child(5)').innerText = nuevoEstado === 'true' ? 'Activo' : 'Inactivo';

    // Enviar la actualización al servidor
    fetch(`/api/usuarios/${userId}/estado`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ estado: nuevoEstado === 'true' })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la actualización del estado del usuario');
            }
            return response.json();
        })
        .then(data => {
            console.log('Estado del usuario actualizado en el servidor:', data);
        })
        .catch(error => console.error('Error al actualizar el estado del usuario:', error));
}
//listener para los formularios (y otros para las tablas)
document.addEventListener('DOMContentLoaded', function () {

    const formularioLogin = document.getElementById('formularioLogin');
    if (formularioLogin){
        formularioLogin.addEventListener('submit', function (event) {
            event.preventDefault();
            const nombre = document.getElementById('nombre').value;
            const contrasena = document.getElementById('contrasena').value;
            Login({nombre,contrasena});
            fetchProveedor(nombre);
        })
    }
    //cargar listas de páginas

    if (window.location.pathname === "/Clientes") {
        fetchClientes();
    }
    if (window.location.pathname === "/Facturas") {
        fetchFacturas();
    }
    if (window.location.pathname === "/Productos") {
        fetchProdutos();
    }
    if (window.location.pathname === "/Proveedores") {
        fetchClientes();
    }
    if (window.location.pathname === "/Administracion") {
        fetchUsuarios();
    }
    if (window.location.pathname === "/AdministrarProveedores") {
        fetchUsuarioMD();
    }
    if (window.location.pathname === "/Perfil") {
        fetchPerfil();
    }

    //formularios
    //formulario de nuevo cliente
    const formularioCliente = document.getElementById('formularioCliente');
    if (formularioCliente) {
        formularioCliente.addEventListener('submit', function (event) {
            event.preventDefault();
            const nombre = document.getElementById('nombre').value;
            const email = document.getElementById('email').value;
            const tipo_cedula = document.getElementById('tipo_cedula').value;
            guardarCliente({nombre, email, tipo_cedula});
        })
    }

    //formulario de nuevo producto
    const formularioProductos = document.getElementById('formularioProductos');
    if (formularioProductos) {
        formularioProductos.addEventListener('submit', function (event) {
            event.preventDefault();
            const descripcion = document.getElementById('descripcion').value;
            const cantidad = document.getElementById('cantidad').value;
            guardarProducto({descripcion, cantidad});
        })
    }

    //formulario de nueva factura
    const formularioFacturas = document.getElementById('formularioFacturas');
    if (formularioFacturas) {
        formularioFacturas.addEventListener('submit', function (event) {
            event.preventDefault();
            const cliente = document.getElementById('cliente').value;
            const email = document.getElementById('email').value;
            guardarFactura({cliente, email});
        })
    }

    //formulario de nuevo usuario
    const formularioUsuario = document.getElementById('formularioUsuario');
    if (formularioUsuario) {
        formularioUsuario.addEventListener('submit', function (event) {
            event.preventDefault();
            const nombre = document.getElementById('nombre').value;
            const contrasena = document.getElementById('clave').value;
            const email = document.getElementById('email').value;
            const estado = false;
            const id = 0;
            guardarUsuario({id, nombre, email, contrasena, estado});
        })
    }

})