<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
</head>
<body>
<div>
    <form action="/teacher/home/edit" method="post">
        <input name="name" placeholder="Имя" value="<#if teacher.name??>${teacher.name}</#if>">
        <input name="surname" placeholder="Фамилия" value=<#if teacher.surname??>"${teacher.surname}</#if>">
        <input name="patronymic" placeholder="Отчество" value="<#if teacher.patronymic??>${teacher.patronymic}</#if>">
        <input name="education" placeholder="Образование" value="<#if teacher.education??>${teacher.education}</#if>">
        <input name="positionHeld" placeholder="Занимаемая должность" value="<#if teacher.positionHeld??>${teacher.positionHeld}</#if>">
        <input name="knowledgeOfLanguages" placeholder="Знание языков" value="<#if teacher.knowledgeOfLanguages??>${teacher.knowledgeOfLanguages}</#if>">
        <input name="additionInformation" placeholder="Дополнительная информация" value="<#if teacher.additionInformation??>${teacher.additionInformation}</#if>">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="Сохранить изменения">
    </form>
    Это студенты
    <#if students??>
        <#list students as student>
            <a>${student.name} ${student.surname}</a>
        </#list>
    </#if>
</div>
</body>
</html>