<#import "/spring.ftl" as spring>
<#include  "../helpers/macros.ftl">
<#--Render View HTML before the view so variables can be exported-->
<#assign view_html>
    <#include "../${view}.ftl">
</#assign>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8" />
    <title>Demo
    <#if pageTitle??>
        :: ${pageTitle}
    </#if>
    </title>
    <link rel="stylesheet" href="<@spring.url "/assets/css/application.css" />" />
    <script src="<@spring.url "/assets/js/application.js" />"></script>
</head>

<body>
<h1>APPLICATION</h1>
${view_html}
</body>
<footer>
    application.css: <@spring.url "/assets/css/application.css" />.
    view: ${view}
</footer>

</html>