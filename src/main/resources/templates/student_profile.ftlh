<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <script>
        function sendFile() {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            // данные для отправки
            let formData = new FormData();
            // забрал файл из input
            let files = ($('#file'))[0]['files'];
            // добавляю файл в formData
            [].forEach.call(files, function (file) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                beforeSend: function (request) {
                    request.setRequestHeader(header, token);
                },
                url: "/student/photo",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (html) {
                    $("#content").html(html);
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>
    <title>Profile</title>
</head>
<body>
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <table>
            <tr><td>Имя</td><td>${student.surname}</td></tr>
            <tr><td>Фамилия</td><td>${student.name}</td></tr>
            <tr><td>Отчество</td><td>${student.patronymic}</td></tr>
            <tr><td>Курс</td><td>${student.course}</td></tr>
            <tr><td>Номер группы</td><td>11-${student.groupNumber}</td></tr>
            <#if student.competence??>
                <tr><td>Компетенция</td><td>${student.competence}</td></tr>
            </#if>
            <#if student.teacher??>
                <tr><td>Преподаватель</td><td>${student.teacher.surname} ${student.teacher.name} ${student.teacher.patronymic}</td></tr>
            </#if>
        </table>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>