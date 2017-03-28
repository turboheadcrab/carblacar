<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Car 2 Bla</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/trips">Найти</a>
                </li>
            <#if user?exists && user.driver?exists>
                <li>
                    <a href="/newtrip">Предложить поездку</a>
                </li>
            </#if>
            <#if user?exists>
                <li>
                    <a href="/users/${user.id}">${user.nickname}</a>
                </li>
                <li>
                    <a href="/logout">Выход</a>
                </li>
            <#else>
                <li>
                    <a href="/registration">Регистрация</a>
                </li>
                <li>
                    <a href="/login">Вход</a>
                </li>
            </#if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>