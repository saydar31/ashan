<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Профиль компании</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">АШАН</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/students">Поиск студентов</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/home">Личный кабинет<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/interviewees">Приглашенные студенты</a>
            </li>
        </ul>
        <button class="btn btn-primary my-2 my-sm-0" type="submit"><a class="tabs" href="/logout">Выйти</a></button>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-2">
            <#if employer.mainPhotoId?has_content>
                <img src="/image/${employer.mainPhotoId}" class="img-thumbnail">
            <#else>
                <img src="https://s00.yaplakal.com/pics/userpic/6/2/6/av-363626.png" class="img-thumbnail">
            </#if>
            <a href="/home/employer/edit">Редактировать профиль</a>
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