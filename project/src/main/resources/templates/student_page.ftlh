<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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

        function invite(id) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax(
                {
                    url: "/student/" + id + "/invite",
                    type: "POST",
                    processData: false,
                    contentType: false,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(header, token)
                    }
                }
            )
        }
    </script>
    <title>Profile</title>
</head>
<body>
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <p>Студент
            <#if student.state == "CONFIRMED">
                [Аккаунт подтвержден]
            <#elseif student.state == "NOT_CONFIRMED">
                [Аккаунт не подтвержден]
            <#elseif student.state == "REFUSED">
                [Аккаунту отказано в подтверждении]
            </#if>
        </p>
    </div>
    <div class="row">
        <table>
            <tr>
                <td>Имя</td>
                <td>${student.surname}</td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td>${student.name}</td>
            </tr>
            <tr>
                <td>Отчество</td>
                <td>${student.patronymic}</td>
            </tr>
            <tr>
                <td>Курс</td>
                <td>${student.course}</td>
            </tr>
            <tr>
                <td>Номер группы</td>
                <td>11-${student.groupNumber}</td>
            </tr>
            <#if student.competence??>
                <tr>
                    <td>Компетенция</td>
                    <td>${student.competence}</td>
                </tr>
            </#if>
            <#if student.teacherDto??>
                <tr>
                    <td>Преподаватель</td>
                    <td>
                        <a href="/teacher/${student.teacherDto.getId()}">${student.teacherDto.getSurname()} ${student.teacherDto.getName()}</a>
                    </td>
                </tr>
            <#else>
                <tr>
                    <td>Преподаватель</td>
                    <td> не выбран</td>
                </tr>
            </#if>
        </table>
    </div>
    <#if student.employerDto?has_content>
        <p>Место работы: <a href="/employerDto/${student.employerDto.getId()}">${student.employerDto.companyName}</a>
        </p>
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
    <#if role?? && role== "EMPLOYER">
        <button onclick="invite(${student.id})">пригласить</button>
    </#if>


</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>