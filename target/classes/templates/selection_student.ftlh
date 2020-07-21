<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    <style>
        A {
            color : black;
        }
        A:visited {
            color: black; /* Цвет посещенных ссылок */
        }
        A:active {
            color: black; /* Цвет активных ссылок */
        }
    </style>
    <title>Студенты</title>

</head>
<body>
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <b>Найдите интересующих Вас студентов с помощью тега:</b>
    <form action="/students" class="form-inline" method="get">
        <div class="active-purple-4 ">
            <input class="form-control mr-sm-6" type="text" name="q" placeholder="Поиск по тегу" aria-label="Поиск по тегу">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Поиск</button>
        </div>
    </form>
    <#if students??>
        <em>Результаты поиска: ${students?size}</em>
        <div class="container-fluid">
            <div class="row">
                <#list students as student>
                    <div class="d-flex flex-wrap justify-content-center">
                        <div class="card" style="width: 18rem;">
                            <div id="student_${student.id}" class="card-body">
                                <h5 class="card-title">${student.surname} ${student.name}</h5>
                                <p><b>Курс:  </b>${student.course}</p>
                                <p class="card-text">
                                    <#if student.tagDtoSet?has_content>
                                        <#list student.tagDtoSet as tag>
                                            #${tag.tagName}
                                        </#list>
                                    </#if>
                                </p>
                                <a href="/student/${student.id}" class="btn btn-secondary">Перейти в профиль</a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </#if>
</div>
</body>
</html>
