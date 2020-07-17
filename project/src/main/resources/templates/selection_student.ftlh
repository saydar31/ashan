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
    <title>Students</title>

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

</head>
<body>
<#include "include/navbar.ftlh">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

<form action="/students" method="get">
    <input type="text" id="search_place" name="q" placeholder="Поиск по тегу"/>
    <button type="submit">Поиск</button>
</form>

<#if students??>
    <#list students as student>
        <a href="/student/${student.id}">
            <div id="student_${student.id}" >
                <p>${student.surname} ${student.name}
                    <#if student.tagDtoSet?has_content>
                        <#list student.tagDtoSet as tag>
                            ${tag.tagName}
                        </#list>
                    </#if>
                </p>

            </div>
        </a>
    </#list>
</#if>


</body>
</html>
