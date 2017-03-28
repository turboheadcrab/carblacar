<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Предложить поездку</title>

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
                <h1>Информация о поездке</h1>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-12">

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
                        </div><!--/col-->

                    </div><!--/col-->

                </div><!--/col-->

            </div><!--/row-->
        </div><!--/panel-body-->
    </div><!--/panel-->

    <form action="/trips/${trip.id}/status" method="POST">
        <div class="form-group row">
            <label for="trip" class="col-sm-2 col-form-label">Статус</label>
            <div class="col-sm-10">
                <select class="form-control select2" style="width: 100%;" name="status">
                    <option selected="selected"></option>
                    <option>Ожидание</option>
                    <option>Поездка</option>
                    <option>Завершено</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </div>
    </form>
<#include "footer.ftl">

</div>


<!-- /.container -->


</body>
</html>