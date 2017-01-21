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
    <meta charset="UTF-8"/>
    <title>Demo
    <#if pageTitle??>
        :: ${pageTitle}
    </#if>
    </title>

    <script src="/webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="/webjars/datatables/1.10.12/css/dataTables.bootstrap.min.css"/>

    <link rel="stylesheet" href="<@spring.url "/assets/css/application.css" />"/>
    <script src="<@spring.url "/assets/js/application.js" />"></script>
</head>

<body>
<h1 id="title">Spring Boot Demo</h1>
${view_html}
</body>
<footer>
    application.css: <@spring.url "/assets/css/application.css" />.
    view: ${view}
</footer>

</html>