
function dibujarCanvas() {

    var valor = document.getElementById('a').innerHTML;
    var a = valor;
    var ap=a*10;
    document.getElementById('a').innerHTML=ap;
    //var a = (valor / 10);
    var valor = document.getElementById('b').innerHTML;
    var b = valor;
    var bp=valor*10;
    document.getElementById('b').innerHTML=bp;
    //var b = (valor / 10);
    var valor = document.getElementById('c').innerHTML;
    var c = valor;
    var cp=valor*10;
    document.getElementById('c').innerHTML=cp;
    //var c = (valor / 10);
    var total = ((ap + cp + bp) / 3)/10; //var total que se cambia
    var ptotal = total.toFixed(1);
    document.getElementById('ptotal').innerHTML = ptotal;
    var canvas = document.getElementById('miCanvas');
    var contexto = canvas.getContext('2d');
    // Aqui se hace el bordede la grafica superior (Dominio del tema)
    contexto.beginPath();
    contexto.arc(95, 95, 90, radianes('180'), hubicarup(a), false);
    contexto.arc(95, 95, 60, hubicarup(a), radianes('180'), true);
    contexto.fillStyle = '#13A89E';
    contexto.fill();
    contexto.closePath();

    //Aqui se encuentra la elaboracion del relleno de la pagina segun el promedio de tema
    contexto.beginPath();
    contexto.arc(95, 95, 90, radianes('180'), radianes('0'), false);

    contexto.arc(95, 95, 60, radianes('0'), radianes('180'), true);

    contexto.closePath();
    contexto.stroke();

    // Aqui se hace el bordede la grafica inferior izquierdo (Calidad de ense�anza)
    contexto.beginPath();
    contexto.arc(90, 110, 85, radianes('90'), hubicardown(b), false);

    contexto.arc(90, 110, 55, hubicardown(b), radianes('90'), true);
    contexto.fillStyle = '#0F75BC';
    contexto.fill();
    contexto.closePath();

    //Aqui se encuentra la elaboracion del relleno de la pagina segun el promedio la Calidad de ense�anza
    contexto.beginPath();
    contexto.arc(90, 110, 85, radianes('90'), radianes('180'), false);

    contexto.arc(90, 110, 55, radianes('180'), radianes('90'), true);

    contexto.closePath();
    contexto.stroke();


    // Aqui se hace el bordede la grafica inferior derecho (Asistencia)
    contexto.beginPath();
    contexto.arc(100, 110, 85, radianes('0'), hubicardown_b(c), false);

    contexto.arc(100, 110, 55, hubicardown_b(c), radianes('0'), true);
    contexto.fillStyle = '#8CC63F';
    contexto.fill();
    contexto.closePath();

    //Aqui se encuentra la elaboracion del relleno de la pagina segun el promedio la Asistencia
    contexto.beginPath();
    contexto.arc(100, 110, 85, radianes('0'), radianes('90'), false);

    contexto.arc(100, 110, 55, radianes('90'), radianes('0'), true);

    contexto.closePath();
    contexto.stroke();
}





function radianes(grados) {
    var radianes = (Math.PI / 180) * grados;
    return radianes;
}

function hubicarup(promedio) {
    var promedio1 = 10 - promedio;
    var punto = 360 - (promedio1 * 180 / 10);
    var radianes = (Math.PI / 180) * punto;
    return radianes;
}

function hubicardown(promedio) {
    var promedio1 = 10 - promedio;
    var punto = 180 - (promedio1 * 90 / 10);
    var radianes = (Math.PI / 180) * punto;
    return radianes;
}

function hubicardown_b(promedio) {
    var promedio1 = 10 - promedio;
    var punto = 90 - (promedio1 * 90 / 10);
    var radianes = (Math.PI / 180) * punto;
    return radianes;
}