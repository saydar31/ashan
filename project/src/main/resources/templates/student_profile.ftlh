<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
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
</head>
<body>
<div>
    <p>Student: ${student.name}</p>
</div>
<table>
    <tr><td>Имя</td><td>${student.surname}</td></tr>
    <tr><td>Фамилия</td><td>${student.name}</td></tr>
    <tr><td>Отчество</td><td>${student.patronymic}</td></tr>
    <tr><td>номер группы</td><td>11-${student.groupNumber}</td></tr>
    <tr><td>компетенция</td><td>${student.competence}</td></tr>
    <tr><td>преподаватель</td><td>${student.teacher.surname} ${student.teacher.name} ${student.teacher.patronymic}</td></tr>
</table>
</body>
</html>