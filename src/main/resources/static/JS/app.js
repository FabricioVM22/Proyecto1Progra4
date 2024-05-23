//función para obtener los usuarios
function obtenerUsuarios() {
    return fetch("/api/usuarios", { // Determinamos el repositorio de datos al cual nos vamos a conectar
        method: "GET", // Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => {
            if(response.ok) { // Respuesta positiva
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
function guardarCliente(Cliente){
    fetch("/api/clientes", { //Primero determinamos el repositorio de datos al cual nos vamos a conectar
        method: "POST", //Configuramos la acción HTTP que nos va a permitir ejecutar el proceso
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario) //Convertimos el usuario que obtuvimos desde el formulario a Json para poder enviarlo al servicio Rest
    })
        .then(response => {
            if(response.ok) //Respuesta positiva
            { //Si la respuesta es positiva, quiere decir que se almacenó el usuario
                alert("Usuario agregado correctamente!"); //Notificamos
                window.location.href = "/"; //Redireccionamos a la lista de usuarios
            }
            else //Cualquier otra cosa va a ser un error
            {
                throw new Error("Error al guardar el usuario");
            }
        })
        .catch(error => console.error("Error al guardar el usuario: ", error));
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
                <th>ID Cliente</th>
                <th>Nombre del Cliente</th>
                <th>Correo Electrónico</th>
                <th>Cédula</th>
            `;
            tablaClientes.appendChild(encabezado);

            // Llenar la tabla con los datos de los clientes
            clientes.forEach(cliente => {
                const fila = document.createElement("tr");
                fila.innerHTML = `
                    <td>${cliente.id}</td>
                    <td>${cliente.nombre}</td>
                    <td>${cliente.correo}</td>
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
                <td>${factura.numProducto}</td>
                <td>${factura.descripcion}</td>
                <td>${factura.cantidad}</td>
                `;
            });
        })
        .catch(error => console.error("Error al obtener productos:", error));
}
function fetchUsuarios() {
    fetch("/api/usuarios")
        .then(response => response.json()).then(usuarios => {
            const listaUsuarios = document.getElementById("lista-usuarios");
            listaUsuarios.innerHTML = "";
            const encabezado = document.createElement("tr");
            encabezado.innerHTML = `
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Contraseña</th>
                <th>Estado</th>
            `;
            //llenar tablas

            usuarios.forEach(usuario => {
                const li = document.createElement("li");
                li.textContent = `ID: ${usuario.id}, Nombre: ${usuario.nombre}, Correo: ${usuario.correo}`;
                listaUsuarios.appendChild(li);
            });
        })
        .catch(error => console.error("Error al obtener usuarios:", error));
}



//listener para los formularios (y otros para las tablas)
document.addEventListener('DOMContentLoaded', function(){
    //cargar listas de páginas

    if(window.location.pathname === "Clientes"){
        fetchClientes();
    }
    if(window.location.pathname === "Facturas"){
        fetchClientes();
    }
    if(window.location.pathname === "Productos"){
        fetchClientes();
    }
    if(window.location.pathname === "Proveedores"){
        fetchClientes();
    }
    if(window.location.pathname === "Administracion"){
        fetchClientes();
    }


    //formularios
    //formulario de nuevo cliente
    const formularioUsuario = document.getElementById('formularioCliente');
    if(formularioUsuario){
        formularioUsuario.addEventListener('submit', function(event){
            event.preventDefault();
            const nombre = document.getElementById('nombre').value;
            const correo = document.getElementById('correo').value;
            const tipo_cedula = document.getElementById('tipo_cedula').value;
            guardarCliente({nombre,correo,tipo_cedula});
        })
    }


})