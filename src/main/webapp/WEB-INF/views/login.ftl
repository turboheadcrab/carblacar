<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Вход</title>

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
                <h1>Вход</h1>
            </div>
        </div>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <hr>

    <form name="user" action="/login" method="POST">
        <div class="form-group row">
            <label for="nickname" class="col-sm-2 col-form-label">Никнейм</label>
            <div class="col-sm-10">
                <input type="text" name="nickname" class="form-control" id="nickname" placeholder="Никнейм"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 control-label">Пароль:</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control"
                       placeholder="Введите пароль"/>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Вход</button>
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