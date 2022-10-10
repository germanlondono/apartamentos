

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });
   
        getIngresos(false, "ASC");

        $("#ordenar-genero").click(ordenarIngresos);
    });


 

    function getIngresos(ordenar, orden) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletIngresoListar",
            data: $.param({
                ordenar: ordenar,
                orden: orden
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    mostrarIngresos(parsedResult);
                } else {
                    console.log("Error recuperando los datos de los ingresos");
                }
            }
        });
    }

    function mostrarIngresos(ingresos) {

        let contenido = "";

        $.each(ingresos, function (index, ingreso) {
            ingreso = JSON.parse(ingreso);
            
            contenido += '<tr><th scope="row">' + ingresos.id + '</th>' +
                    '<td>' + ingresos.novedad + '</td>' +
                    '<td>' + ingresos.genero + '</td>' +
                    '<td>' + ingresos.nombre + +  '</td>' +
                    '<td>' + ingresos.cedulas + '</td>' +
                    '<td>' + ingresos.personas + '</td>' +
                    '<td>' + ingresos.objetos + '</td>';

        });
        $("#ingresos-tbody").html(contenido);
    }

    function ordenarIngresos() {
        if ($("#icono-ordenar").hasClass("fa-sort")) {
            getIngresos(true, "ASC");
            $("#icono-ordenar").removeClass("fa-sort");
            $("#icono-ordenar").addClass("fa-sort-down");
        } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
            getIngresos(true, "DESC");
            $("#icono-ordenar").removeClass("fa-sort-down");
            $("#icono-ordenar").addClass("fa-sort-up");
        } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
            getIngresos(false, "ASC");
            $("#icono-ordenar").removeClass("fa-sort-up");
            $("#icono-ordenar").addClass("fa-sort");
        }
    }




