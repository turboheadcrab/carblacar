<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Поездки</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/business-frontpage.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-datetimepicker.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <script src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/moment-with-locales.js"></script>
    <script src="/resources/js/bootstrap-datetimepicker.js"></script>
    <script src="/resources/js/MyScripts1.js"></script>
    <script async="" src="/resources/js/analytics.js"></script>
    <!-- jQuery -->


</head>
<body>

<#include "header.ftl">
<#--<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>-->
<!-- Image Background Page Header -->
<!-- Note: The background image is set within the business-casual.css file. -->
<header class="classic-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1>Поиск поездок</h1>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">
    <form action="/trips/" method="POST">
        <div class="form-group row">
            <label for="departure" class="col-sm-2 col-form-label">Откуда</label>
            <div class="col-sm-10">
                <input type="text" name="departure" class="form-control" id="departure" oninput="findTrips(this)"
                       placeholder="Пункт отправления"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="destination" class="col-sm-2 col-form-label">Куда</label>
            <div class="col-sm-10">
                <input type="text" name="destination" class="form-control" id="destination" oninput="findTrips(this)"
                       placeholder="Пункт назначения"/>
            <#--<@form.errors path="email"></@form.errors>-->
            </div>
        </div>
    </form>
    <div class="row" id="trips">
    <#list trips as trip>

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12">
                            <p><strong>Место отправления: </strong> ${trip.departure} </p>
                            <p><strong>Место назначения: </strong> ${trip.destination} </p>
                            <p><strong>Дата и время выезда: </strong> ${trip.date} </p>
                            <p><strong>Водитель: </strong> ${trip.driver.user.firstname} ${trip.driver.user.surname}
                            </p>
                            <p><strong>Автомобиль: </strong> ${trip.auto.brand} ${trip.auto.model}
                                - ${trip.auto.licensePlate} </p>
                            <a href="/trips/${trip.id}">
                                <button class="btn btn-success">Записаться</button>
                            </a>
                        </div><!--/col-->

                    </div><!--/col-->

                </div><!--/row-->

            </div><!--/panel-body-->
        </div><!--/panel-->

    </#list>

    <#include "footer.ftl">

    </div>


    <!-- /.container -->


</body>
</html>