<#import "/spring.ftl" as spring>
<#include  "../helpers/macros.ftl">
<#--Render View HTML before the view so variables can be exported-->
<#assign view_html>
    <#include "../${view}.ftl">
</#assign>

<#--Main layout body etc-->
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Demo
    <#if pageTitle??>
        :: ${pageTitle}
    </#if>
    </title>

    <script src="/webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap-theme.css"/>
    <#--<link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.bootstrap.min.css"/>-->

    <link rel="stylesheet" href="<@spring.url "/assets/css/application.css" />"/>
    <script src="<@spring.url "/assets/js/application.js" />"></script>
</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Spring Boot Demo</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${controller?switch('HomeController', 'active', '')}"><a href="/">Home</a></li>
                <li class="${view?switch('another/index', 'active', '')}"><a href="/another">Another Controller</a></li>
                <li class="${view?switch('another/page', 'active', '')}"><a href="/another/page">Another Controller Page</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
${view_html}
</div>

</body>

<footer>
    <div class="container">
        Controller: ${controller}.
        View: ${view}.
    </div>
</footer>

</html>
