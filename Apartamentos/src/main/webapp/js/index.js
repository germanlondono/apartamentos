$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });
    $("#form-register").submit(function (event){
        event.preventDefault();
        registrarUsuario();
    });   
});

function autenticarUsuario(){
    let username = $("#usuario").val();
    let contrasena = $("#contrasena").val();
    
    $.ajax({
       type: "GET",
       dataType: "html",
       url: "./ServletUsuarioLogin",
       data: $.param({
           username: username,
           contrasena: contrasena
       }),
       success: function (result) {
           let parsedResult = JSON.parse(result);
           
           if(parsedResult != false){
               $("#login-error").addClass("d-none");
               let username = parsedResult['username'];
               document.location.href = "home.html?username=" + username;
               }else{
                   $("#login-error").removeClass("d-none");
               }
       }
    });
}

function registrarUsuario(){
    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let numero_de_apartamento = $("#input-numero_de_apartamento").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let genero = $("#genero").val();
    let email = $("#input-email").val();
    
    if (contrasena == contrasenaConfirmacion) {
        
        $.ajax({
            type:"GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username: username,
                contrasena: contrasena,
                numero_de_apartamento: numero_de_apartamento,
                nombre: nombre,
                apellidos:apellidos,
                genero:genero,
                email:email
            }),
          success: function (result) {
              let parsedResult = JSON.parse(result);
              if (parseResult !== false) {
                  $("register-error").addClass("d-none");
                  let username = parseResult['username'];
                  document.location.href = "home.html?username=" + username;
              } else {
                  $("#register-error").removeClass("d-none");
                  $("#register-error").html("Error en el registro del usuario");
              }
          }  
        });
    } else {
        $("#register-error").removeClass("d*none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}