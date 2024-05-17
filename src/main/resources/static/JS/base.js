// Contenido del header
const headerContent = `
<header>
    <div class="container">
        <h1>Registro de Facturas</h1>
    </div>
</header>
`;

// Contenido del nav
const navContent = `
<nav>
    <div class="container">
        <ul>
            <li><a href="/Perfil">Perfil</a></li>
            <li><a href="/Clientes">Registrar Clientes</a></li>
            <li><a href="/Productos">Registrar Productos</a></li>
            <li><a href="/Facturas">Facturar</a></li>
            <!--<li><a href="/Administracion" th:text="${modelo.message}"></a></li>-->
            <li><a href="/">Log Out</a></li>
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
    loadContent('footer', footerContent);
});
