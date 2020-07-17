
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
<h3><a href="/teacher/home">Профиль</a> | <a href="/teacher/home/edit">Редактировать профиль</a> | <a href="/myStudents/competence/toConfirm">Список на подтверждение</a></h3>
<div>
    <form action="/teacher/edit" method="post">
        <p>Имя: <input name="name" value="<#if teacher.name??>${teacher.name}</#if>"></p>
        <p>Фамилия: <input name="surname" placeholder="Фамилия" value=<#if teacher.surname??>"${teacher.surname}</#if>"></p>
        <p>Отчество: <input name="patronymic" placeholder="Отчество" value="<#if teacher.patronymic??>${teacher.patronymic}</#if>"></p>
        <p>Образование: <input name="education" placeholder="Образование" value="<#if teacher.education??>${teacher.education}</#if>"></p>
        <p>Занимаемая должность: <input name="positionHeld" placeholder="Занимаемая должность" value="<#if teacher.positionHeld??>${teacher.positionHeld}</#if>"></p>
        <p>Знание языков: <input name="knowledgeOfLanguages" placeholder="Знание языков" value="<#if teacher.knowledgeOfLanguages??>${teacher.knowledgeOfLanguages}</#if>"></p>
        <p>Дополнительная информация: <input name="additionInformation" placeholder="Дополнительная информация" value="<#if teacher.additionInformation??>${teacher.additionInformation}</#if>"></p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="Сохранить изменения">
    </form>
</div>
</body>
</html>