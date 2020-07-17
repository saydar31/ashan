<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Profile</title>
</head>
<body>
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10">
            <p>Студент
                <#if student.state == "CONFIRMED">
                    [Аккаунт подтвержден]
                <#elseif student.state == "NOT_CONFIRMED">
                    [Аккаунт не подтвержден]
                <#elseif student.state == "REFUSED">
                    [Аккаунту отказано в подтверждении]
                </#if>
            </p>
                <table>
                    <tr><td>Фамилия: </td><td>${student.surname}</td></tr>
                    <tr><td>Имя: </td><td>${student.name}</td></tr>
                    <tr><td>Отчество: </td><td>${student.patronymic}</td></tr>
                    <tr><td>Курс: </td><td>${student.course}</td></tr>
                    <tr><td>Номер группы: </td><td>11-${student.groupNumber}</td></tr>
                    <#if student.competence??>
                        <tr>
                            <td>О себе: </td><td>${student.competence}
                                <#if student.competenceState == "CONFIRMED">
                                    [подтверждена]
                                <#elseif student.competenceState == "NOT_CONFIRMED">
                                    [не подтверждена]
                                <#elseif student.competenceState == "REFUSED">
                                    [отказано]
                                </#if>
                            </td>
                        </tr>
                    </#if>
                    <#if student.teacherDto??>
                        <tr><td>Преподаватель: </td><td><a href="/teacher/${student.teacherDto.getId()}">${student.teacherDto.getSurname()} ${student.teacherDto.getName()}</a></td></tr>
                    <#else>
                        <tr><td>Преподаватель: </td><td> не выбран</td></tr>
                    </#if>
                </table>
            <#if student.employerDto?has_content>
                <p>Место работы: <a href="/employerDto/${student.employerDto.getId()}">${student.employerDto.companyName}</a></p>
            <#else>
                <p>Место работы: не работает</p>
            </#if>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>