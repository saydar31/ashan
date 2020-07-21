<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

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
            ).done(
                function () {
                    $('#inviteButton').hide();
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
        <div class="col-2">
            <#if student.mainPhotoId?has_content>
                <img src="/image/${student.mainPhotoId}" class="img-thumbnail">
            <#else>
                <img src="https://s00.yaplakal.com/pics/userpic/6/2/6/av-363626.png" class="img-thumbnail">
            </#if>
        </div>
        <div class="col-10">
            <p>Статус:
                <#if student.state == "CONFIRMED">
                    [Аккаунт подтвержден]
                <#elseif student.state == "NOT_CONFIRMED">
                    [Аккаунт не подтвержден]
                <#elseif student.state == "REFUSED">
                    [Аккаунту отказано в подтверждении]
                </#if>
            </p>
            <table>
                <tr><td><b>Фамилия: </b></td><td>${student.surname}</td></tr>
                <tr><td><b>Имя: </b></td><td>${student.name}</td></tr>
                <tr><td><b>Отчество: </b></td><td>${student.patronymic}</td></tr>
                <tr><td><b>Курс: </b></td><td>${student.course}</td></tr>
                <tr><td><b>Номер группы: </b></td><td>11-${student.groupNumber}</td></tr>
                <#if student.competence??>
                    <tr>
                        <td><b>Компетенция: </b></td><td>${student.competence}
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
                    <tr><td><b>Преподаватель: </b></td><td><a href="/teacher/${student.teacherDto.getId()}">${student.teacherDto.getSurname()} ${student.teacherDto.getName()}</a></td></tr>
                <#else>
                    <tr><td><b>Преподаватель: </b></td><td> не выбран</td></tr>
                </#if>
                <#if student.employerDto?has_content>
                    <tr><td><b>Место работы: </b></td><td><a href="/employer/${student.employerDto.getId()}">${student.employerDto.companyName}</a></td></tr>
                <#else>
                    <tr><td><b>Место работы: </b></td><td>не работает</td></tr>
                </#if>

                <#if student.tagDtoSet?has_content>
                    <tr><td><b>Теги: </b></td>
                        <td>
                            <#list student.tagDtoSet as tag>
                                #${tag.tagName}
                            </#list>
                        </td>
                    </tr>
                </#if>
            </table>
            <#if role?? && role== "EMPLOYER"&&!student.employerDto??>
                <button id="inviteButton" class="btn btn-secondary" onclick="invite(${student.id})">Пригласить на собеседование</button>
            </#if>
        </div>
    </div>
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