<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Профиль преподавателя</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">АШАН</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"/>
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
                <a class="nav-link" href="/myStudents/competence/toConfirm">Список на подтверждение</a>
            </li>
        </ul>
        <button class="btn btn-primary my-2 my-sm-0" type="submit"><a class="tabs" href="/logout">Выйти</a></button>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-2">
            <#if teacher.mainPhotoId?has_content>
                <img src="/image/${teacher.mainPhotoId}" class="img-thumbnail">
            <#else>
                <img src="https://s00.yaplakal.com/pics/userpic/6/2/6/av-363626.png" class="img-thumbnail">
            </#if>
            <a href="/teacher/home/edit">Редактировать профиль</a>
        </div>
        <div class="col-3">
            <h4>${teacher.surname} ${teacher.name} ${teacher.patronymic}</h4>
            <table>
                <tr><td><b>Почта:</b></td><td>${teacher.mail}</td></tr>
                <#if teacher.education?has_content>
                    <tr><td><b>Образование:</b></td>
                        <td>${teacher.education}</td></tr>
                </#if>
                <#if teacher.knowledgeOfLanguages?has_content>
                    <tr><td><b>Знание языков:</b></td>
                        <td>${teacher.knowledgeOfLanguages}</td></tr>
                </#if>
                <#if teacher.positionHeld?has_content>
                    <tr><td><b>Занимаемая должность:</b></td>
                        <td>${teacher.positionHeld}</td></tr>
                </#if>
                <#if teacher.additionInformation?has_content>
                    <tr><td><b>Дополнительная информация:</b></td>
                        <td>${teacher.additionInformation}</td></tr>
                </#if>
            </table>
        </div>
        <div class="col-7">
            <ol>
                Мои студенты:
                <#if teacher.studentDtoSet ??>
                    <#list teacher.studentDtoSet as student>
                        <li><a href="/student/${student.id}"> 11-${student.groupNumber}  ${student.surname} ${student.name} ${student.patronymic}</a></li>
                    </#list>
                </#if>
            </ol>
        </div>
    </div>
</div>
</body>
</html>