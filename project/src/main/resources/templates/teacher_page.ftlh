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
<table>
    <tr><td>Фамилия:</td><td>${teacher.surname}</td></tr>
    <tr><td>Имя:</td><td>${teacher.name}</td></tr>
    <tr><td>Отчество:</td><td>${teacher.patronymic}</td></tr>
    <tr><td>Почта:</td><td>${teacher.mail}</td></tr>
    <tr><td>Образование:</td><td><#if teacher.education?has_content>${teacher.education}</#if></td></tr>
    <tr><td>Знание языков:</td><td><#if teacher.knowledgeOfLanguages?has_content>${teacher.knowledgeOfLanguages}</#if></td></tr>
    <tr><td>Занимаемая должность:</td><td><#if teacher.positionHeld?has_content>${teacher.positionHeld}</#if></td></tr>
    <tr><td>Дополнительная информация:</td><td><#if teacher.additionInformation?has_content>${teacher.additionInformation}</#if></td></tr>
</table>
<ol>
    <#if teacher.studentDtoSet ??>
        <#list teacher.studentDtoSet as student>
            <li><a href="/student/${student.id}">${student.name} ${student.surname} 11-${student.groupNumber}</a></li>
        </#list>
    </#if>
</ol>
</body>
</html>