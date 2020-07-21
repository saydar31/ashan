<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Employer profile</title>
</head>
<body>
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <div class="col-2">
            <#if employer.mainPhotoId?has_content>
                <img src="/image/${employer.mainPhotoId}" class="img-thumbnail">
            <#else>
                <img src="https://s00.yaplakal.com/pics/userpic/6/2/6/av-363626.png" class="img-thumbnail">
            </#if>
        </div>
        <div class="col-3">
            <table>
                <tr><td><b>Название компании: </b></td><td>${employer.companyName}</td></tr>
                <tr><td><b>Почта: </b></td><td>${employer.mail}</td></tr>
                <tr><td><b>Номер телефона: </b></td><td>${employer.phoneNumber}</td></tr>
            </table>
        </div>
        <div class="col-7">
            <ol>
                Студенты, работающие в компании:
                <#if employer.studentDtoSet ??>
                    <#list employer.studentDtoSet as student>
                        <li><a href="/student/${student.id}">${student.surname} ${student.name} ${student.patronymic} 11-${student.groupNumber}</a></li>
                    </#list>
                </#if>
            </ol>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>