<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student page</title>
</head>
<body>
<p>Студент
    <#if student.state == "CONFIRMED">
        [Аккаунт подтвержден]
    <#elseif student.state == "NOT_CONFIRMED">
        [Аккаунт не подтвержден]
    <#elseif student.state == "REFUSED">
        [Аккаунту отказано в подтверждении]
    </#if>
</p>
<p>Имя: ${student.name}</p>
<p>Фамилие: ${student.surname}</p>
<p>Отчество: ${student.patronymic}</p>
<p>Курс: ${student.course}</p>
<p>Группа: ${student.groupNumber}</p>

<#if student.teacherDto?has_content>
    <p>Преподаватель: <a
                href="/teacher/${student.teacherDto.getId()}">${student.teacherDto.getSurname()} ${student.teacherDto.getName()}</a>
    </p>
<#else>
    <p>Преподаватель: не выбран</p>
</#if>

<#if student.employerDto?has_content>
    <p>Место работы: <a href="/employerDto/${student.employerDto.getId()}">${student.employerDto.companyName}</a></p>
<#else>
    <p>Место работы: не работает</p>
</#if>

<p>Компетенция:
    <#if student.competenceState == "CONFIRMED">
        [подтверждена]
    <#elseif student.competenceState == "NOT_CONFIRMED">
        [не подтверждена]
    <#elseif student.competenceState == "REFUSED">
        [отказано]
    </#if>
</p>

</body>
</html>