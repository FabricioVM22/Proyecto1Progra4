// Contenido del header
const headerContent = `
<header>
    <div class="container">
        <h1>Registro de Facturas</h1>
    </div>
</header>
`;

// Contenido del nav
//<!--<li><a href="/Administracion" th:text="${modelo.message}"></a></li>-->
const navContent = `
<nav>
    <div class="container">
        <ul  id="nav-container">
            <li><a href="/Perfil">Perfil</a></li>
            <li><a href="/Clientes">Registrar Clientes</a></li>
            <li><a href="/Productos">Registrar Productos</a></li>
            <li><a href="/Facturas">Facturar</a></li>
        </ul>
    </div>
</nav>
`;

// Contenido del footer
const footerContent = `
<footer>
    <div class="container">
        <p>&copy; 2024 Tu Empresa. Todos los derechos reservados.</p>
    </div>
</footer>
`;

// Función para cargar contenido en un elemento con un ID específico
function loadContent(id, content) {
    document.getElementById(id).innerHTML = content;
}

// Evento para cargar el contenido cuando el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', () => {
    loadContent('header', headerContent);
    loadContent('nav', navContent);
    const Nav = document.getElementById('nav-container');
    if (sessionStorage.getItem('idUsuarioActivo') === "1") {
        const Administracion = document.createElement("li");
        Administracion.innerHTML = `
                    <a href="/Administracion">Administracion</a>
                    `;
        Nav.appendChild(Administracion);
    }
    const logout = document.createElement("li");

    logout.innerHTML = `
                    <a href="/">Log Out</a>
                    `;
    Nav.appendChild(logout);
    loadContent('footer', footerContent);
});
