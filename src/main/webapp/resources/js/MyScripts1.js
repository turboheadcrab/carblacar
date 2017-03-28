findTrips = function (request, response) {
    $.ajax({
        type: 'POST',
        url: "/trips/find",
        data: {"departure": $("#departure").val(), "destination": $("#destination").val()},
        dataType: "json",
        async: true,
        success: function (trips) {
            //info = $('#info');
            //alert(trips.length);
            $("#trips").html("");
            for (var i = 0; i < trips.length; i++) {
                var backToDate = new Date(trips[i].date);
                var day = backToDate.getDay();
                var month = backToDate.getUTCMonth() + 1;
                var year = backToDate.getUTCFullYear();
                $('#trips').append("<div class=\"col-md-6\">" +
                    "<div class=\"panel panel-default\">" +
                    "<div class=\"panel-body\">" +
                    "<div class=\"row\">" +
                    "<div class=\"col-xs-12 col-sm-12\"> " +
                    " <p><strong>Место отправления: </strong> " + trips[i].departure + " </p>" +
                    "<p><strong>Место назначения: </strong> " + trips[i].destination + " </p> " +
                    "<p><strong>Дата и время выезда: </strong> " + day + "." + month + "." + year +
                    " - " + backToDate.getHours() + ":" + backToDate.getMinutes() +
                " </p>" +
                "<p><strong>Водитель: </strong> " + trips[i].driver.user.firstname + " " + trips[i].driver.user.surname + "" +
                "</p>" +
                " <p><strong>Автомобиль: </strong> " + trips[i].auto.brand + " " + trips[i].auto.model + "" +
                " - " + trips[i].auto.licensePlate + " </p>" +
                " <a href=\"/trips/\"" + trips[i].id + ">" +
                "   <button class=\"btn btn-success\">Записаться</button>" +
                "   </a>" +
                "    </div>" +
                "    </div>" +
                "    </div>" +
                "    </div>" +
                "    </div>"
            )
                ;

            }

        }
    });
};

