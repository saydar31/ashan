<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script src="/static/js/admin.js" type="application/javascript"></script>
    <title>Профиль администратора</title>
    <script>
        token = '${admin.token}';
    </script>
</head>
<body>
<#include "include/admin_navbar.ftlh">
<div class="container-fluid">
    <button class="btn btn-secondary my-btn" onclick="getNotConfirmedStudents('${admin.token}')">Студенты</button>
    <button class="btn btn-secondary my-btn" onclick="getNotConfirmedTeachers('${admin.token}')">Преподаватели</button>
    <button class="btn btn-secondary my-btn" onclick="getNotConfirmedEmployers('${admin.token}')">Работадатели</button>

    <table class="table table-responsive my-table">
        <thead>
        <tr>
            <th scope="col">Фамилия Имя Отчество</th>
            <th scope="col">Курс</th>
            <th scope="col">Номер группы</th>
            <th scope="col">Принять</th>
            <th scope="col">Отклонить</th>
        </tr>
        </thead>
        <tbody id="users">

        </tbody>
    </table>
</div>

</body>
</html>

