// Función para filtrar productos
function filtrarProductos(genero, categoria) {
    var productos = document.getElementsByClassName('producto');
    for (var i = 0; i < productos.length; i++) {
        var producto = productos[i];
        var generoProducto = producto.querySelector('.genero').innerText;
        var categoriaProducto = producto.querySelector('.categoria').innerText;

        console.log('Género: ' + generoProducto);
        console.log('Categoría: ' + categoriaProducto);
        
        if (generoProducto === genero && categoriaProducto === categoria) {
            producto.style.display = 'block';
        } else {
            producto.style.display = 'none';
        }
    }
}