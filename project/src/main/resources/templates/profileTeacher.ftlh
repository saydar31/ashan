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
<p><#if teacher.name??>${teacher.name}</#if></p>
<p><#if teacher.surname??>${teacher.surname}</#if></p>
<p><#if teacher.patronymic??>
${teacher.patronymic}
</#if></p>
<p><#if teacher.education??>
    ${teacher.education}
</#if></p>
<p><#if teacher.positionHeld??>
    ${teacher.positionHeld}
</#if></p>
<p><#if teacher.additionInformation??>
    ${teacher.additionInformation}
</#if></p>
<p>${teacher.mail}</p>

Мои студенты
<#if students??>
    <#list students as student>
        <a>${student.name} ${student.surname}</a>
    </#list>
</#if>
</body>
</html>