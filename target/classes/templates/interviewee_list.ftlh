<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
        function refuse(id) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax(
                {
                    url: "/interview/student/"+id+"/refuse",
                    type: "POST",
                    processData: false,
                    contentType: false,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(header,token)
                    }
                }
            ).done(function () {
                $('#student'+id+'confirm').html('');
                $('#student'+id+'refuse').html('');
            })
        }

        function accept(id) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax(
                {
                    url: "/interview/student/"+id+"/accept",
                    type: "POST",
                    processData: false,
                    contentType: false,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(header,token)
                    }
                }
            ).done(function () {
                $('#student'+id+'confirm').html('');
                $('#student'+id+'refuse').html('');
            })
        }
    </script>
    <title>Студенты, приглашенные на собеседование</title>
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
            <li class="nav-item">
                <a class="nav-link" href="/home">Личный кабинет<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/interviewees">Приглашенные студенты<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <button class="btn btn-primary my-2 my-sm-0" type="submit"><a class="tabs" href="/logout">Выйти</a></button>
    </div>
</nav>
<div class="container-fluid">
    <table class="table table-responsive my-table">
        <thead>
        <tr>
            <th scope="col">Фамилия Имя Отчество</th>
            <th scope="col">Группа</th>
            <th scope="col">Принять</th>
            <th scope="col">Отклонить</th>
        </tr>
        </thead>
        <#if interviewees?size != 0>
            <tbody>
            <#list interviewees as student>
                <tr>
                    <td><a href="/student/${student.id}">${student.surname} ${student.name} ${student.patronymic}</a></td>
                    <td>11-${student.groupNumber}</td>
                    <td><span id="student${student.id}confirm"><button class="btn btn-secondary" onclick="accept('${student.id}')">Прошел</button></span></td>
                    <td><span id="student${student.id}refuse"><button class="btn btn-secondary" onclick="refuse('${student.id}')">Провалил</button></span> </td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
</html>