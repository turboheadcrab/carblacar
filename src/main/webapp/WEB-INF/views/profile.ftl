<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${userinfo.nickname}</title>

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
                <h1>Профиль пользователя ${userinfo.nickname}</h1>
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
                <#--<div class="row">-->
                    <div class="col-xs-12 col-sm-8">
                        <h2>${userinfo.firstname} ${userinfo.surname}</h2>
                        <p><strong>Пассажир: </strong> <#if userinfo.passenger?exists>Да<#else>Нет</#if> </p>
                        <p><strong>Водитель: </strong> <#if userinfo.driver?exists>Да<#else>Нет</#if> </p>
                    <#if userinfo.driver?exists>
                        <h4><strong>Автомобили: </strong></h4>
                        <#list userinfo.driver.automobileList as auto>
                            <p>${auto.brand} ${auto.model}</p>
                        </#list>

                    </#if>


                    </div><!--/col-->
                    <div class="col-xs-12 col-sm-4 text-center" style="margin-bottom: 10px;">
                        <img src="/files/${userinfo.avatar}" alt=""
                             class="center-block img-responsive">

                    </div><!--/col-->
                    <div class="col-xs-12 <#if userinfo.driver?exists>col-sm-6<#else>col-sm-12</#if> "
                         style="background: #c1e2b3">
                        <h3 style="text-align: center">Пассажир</h3>
                        <h4>Рейтинг: <strong> ${userinfo.passenger.rating} </strong></h4>
                        <h4>Количество поездок: <strong> ${endPasTrips?size} </strong></h4>
                    <#if user.id == userinfo.id>
                        <#if userinfo.driver?exists>
                            <h4 style="text-align: center">
                                <a href="/newtrip">
                                    <button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span>
                                        Предложить
                                        поездку
                                    </button>
                                </a>
                            </h4>
                        <#else>
                            <h4 style="text-align: center">
                                <a href="/newauto">
                                    <button class="btn btn-info btn-block"><span
                                            class="fa fa-plus-circle"></span>
                                        Стать водителем (Добавить авто)
                                    </button>
                                </a>
                            </h4>
                        </#if>
                    </#if>
                    </div>
                <#if userinfo.driver?exists>
                    <div class="col-xs-12 col-sm-6" style="background: #bce8f1">
                        <h3 style="text-align: center">Водитель </h3>
                        <#if endDriverTrips?exists>
                            <h4>Рейтинг: <strong>${userinfo.driver.rating}</strong></h4>
                            <h4>Количество поездок: <strong> ${endDriverTrips?size} </strong></h4>
                        </#if>
                        <#if user.id == userinfo.id>
                            <h4 style="text-align: center">
                                <a href="/newauto">
                                    <button class="btn btn-info btn-block"><span
                                            class="fa fa-plus-circle"></span>
                                        Добавить авто
                                    </button>
                                </a>
                            </h4>
                        </#if>

                    </div><!--/col-->
                </#if>

                <#--</div><!--/col&ndash;&gt;-->

                <#if bookings?has_content>
                    <div class="col-xs-12 col-sm-12">
                        <hr/>
                        <h3 style="text-align: center">Желающие поехать с вами</h3>
                    </div>
                    <#list bookings as b>

                        <div class="col-xs-12 col-sm-12" style="background: #bce8f1; padding-top: 20px">
                            <div class="col-xs-6 col-sm-6">
                                <p>${b.trip.departure} - ${b.trip.destination} : ${b.trip.date} </p>
                                <h4>Пассажиры: ${b.passenger.user.firstname} ${b.passenger.user.firstname}
                                    (${b.count}
                                    пассажиров)</h4>
                                <p>Комментарий пассажира: ${b.info}</p>
                            </div>
                            <div class="col-xs-3 col-sm-3">

                                <a href="/bookings/${b.id}/conf">
                                    <button class="btn btn-success btn-block"><span
                                            class="fa fa-plus-circle"></span>
                                        Принять
                                    </button>
                                </a>
                            </div>
                            <div class="col-xs-3 col-sm-3">

                                <a href="/bookings/${b.id}/deny">
                                    <button class="btn btn-danger btn-block"><span class="fa fa-plus-circle"></span>
                                        Отклонить
                                    </button>
                                </a>
                            </div>

                        </div>
                        <hr/>

                    </#list>

                </#if>
                <#if driverTrips?has_content || pasTrips?has_content>

                    <div class="col-xs-12 col-sm-12">
                        <hr/>
                        <h3 style="text-align: center">Предстоящие поездки</h3>
                    </div>

                    <#if pasTrips?has_content>
                        <div class="col-xs-12 col-sm-6" style="background: #c1e2b3">

                            <#list pasTrips as pt>
                                <h4>${pt.departure} - ${pt.destination} : ${pt.date}</h4>
                                <p>Статус: ${pt.status}</p>
                                <hr/>
                            </#list>
                        </div><!--/col-->

                    </#if>

                    <#if driverTrips?has_content>
                        <div class="col-xs-12 col-sm-6" style="background: #bce8f1">

                            <#list driverTrips as dt>
                                <h4>${dt.departure} - ${dt.destination} : ${dt.date} </h4>
                                <p>Статус: <#if user.id = userinfo.id><a
                                        href="/trips/${dt.id}/status">${dt.status}</a><#else>${dt.status}</#if>
                                </p>
                                <#if user.id != dt.driver.user.id>
                                    <a href="/trips/${dt.id}">Записаться</a>
                                </#if>
                                <hr/>
                            </#list>
                        </div><!--/col-->

                    </#if>
                </#if>

                <#if endPasTrips?has_content || endDriverTrips?has_content>
                    <div class="col-xs-12 col-sm-12">
                        <hr/>
                        <h3 style="text-align: center">Последние поездки</h3>
                    </div>

                    <#if endPasTrips?has_content>
                        <div class="col-xs-12 col-sm-6" style="background: #c1e2b3">

                            <#list endPasTrips as pt>
                                <h4>${pt.departure} - ${pt.destination} : ${pt.date}</h4>
                                <#if user.id = userinfo.id><p><a
                                        href="/trips/${pt.id}/review">Оставить отзыв</a></p></#if>
                                <hr/>
                            </#list>
                        </div><!--/col-->

                    </#if>

                    <#if endDriverTrips?has_content>
                        <div class="col-xs-12 col-sm-6" style="background: #bce8f1">

                            <#list endDriverTrips as dt>
                                <h4>${dt.departure} - ${dt.destination} : ${dt.date} </h4>
                                <#if user.id = userinfo.id><p><a
                                        href="/trips/${dt.id}/review">Оставить отзыв</a></p></#if>
                                <hr/>
                            </#list>
                        </div><!--/col-->

                    </#if>
                </#if>


                </div><!--/row-->
            </div><!--/panel-body-->
        </div><!--/panel-->


    </div>
<#include "footer.ftl">

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>