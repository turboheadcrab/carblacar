<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Добавить автомобиль</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/css/business-frontpage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <h1>Добавить автомобиль</h1>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <hr>

    <form action="/newauto" method="POST">
        <div class="form-group row">
            <label for="nickname" class="col-sm-2 col-form-label">Марка</label>
            <div class="col-sm-10">
                <input type="text" name="brand" class="form-control" id="brand" placeholder="Марка автомобиля"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Модель</label>
            <div class="col-sm-10">
                <input type="text" name="model" class="form-control" id="model" placeholder="Модель автомобиля"/>
            <#--<@form.errors path="email"></@form.errors>-->
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label">Гос. номер</label>
            <div class="col-sm-10">
                <input type="text" name="licensePlate" class="form-control"
                       placeholder="Государственный номерной знак (Пример: A123BC116RUS)"/>
            <#--<@form.errors path="password"></@form.errors>-->
            </div>
        </div>
        <div class="form-group row">
            <label for="nickname" class="col-sm-2 col-form-label">Год выпуска</label>
            <div class="col-sm-10">
                <input type="text" name="age" class="form-control" id="age"
                       placeholder="Год выпуска"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Добавить автомобиль</button>
            </div>
        </div>


    </form>


    <hr>

<#include "footer.ftl">

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>