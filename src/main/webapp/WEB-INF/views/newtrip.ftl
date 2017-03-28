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
                <h1>Предложить поездку</h1>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <hr>

    <form action="/newtrip" method="POST">
        <div class="form-group row">
            <label for="auto" class="col-sm-2 col-form-label">Автомобиль</label>
            <div class="col-sm-10">
                <select class="form-control select2" style="width: 100%;" name="auto">
                    <option selected="selected"></option>
                <#list automobileList as auto>
                    <option>${auto.id} - ${auto.brand} ${auto.model} </option>
                </#list>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="nickname" class="col-sm-2 col-form-label">Откуда</label>
            <div class="col-sm-10">
                <input type="text" name="departure" class="form-control" id="departure"
                       placeholder="Пункт отправления"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Куда</label>
            <div class="col-sm-10">
                <input type="text" name="destination" class="form-control" id="destination"
                       placeholder="Пункт назначения"/>
            <#--<@form.errors path="email"></@form.errors>-->
            </div>
        </div>
        <div class="form-group row">
            <label for="date" class="col-sm-2 col-form-label">Дата</label>
            <div class=' col-sm-10 input-group date' id='datetimepicker2'>
                <input name="date" type='text' class="form-control"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker2').datetimepicker({
                    locale: 'ru'
                });
            });
        </script>

        <div class="form-group row">
            <label class="col-sm-2 control-label">Цена</label>
            <div class="col-sm-10">
                <input type="text" name="price" class="form-control"
                       placeholder="Цена"/>
            <#--<@form.errors path="password"></@form.errors>-->
            </div>
        </div>
        <div class="form-group row">
            <label for="nickname" class="col-sm-2 col-form-label">Свободные места</label>
            <div class="col-sm-10">
                <input type="text" name="count" class="form-control" id="count"
                       placeholder="Количество свободных мест"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label">Информация:</label>
            <div class="col-sm-10">
                                <textarea class="form-control" name="info" placeholder="Дополнительная информация"
                                          rows="10"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Предложить поездку</button>
            </div>
        </div>


    </form>


    <hr>

<#include "footer.ftl">

</div>
<!-- /.container -->



</body>
</html>