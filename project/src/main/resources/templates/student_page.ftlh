<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student page</title>
</head>
<body>
<table>
    <tr><td>Имя</td><td>${student.surname}</td></tr>
    <tr><td>Фамилия</td><td>${student.name}</td></tr>
    <tr><td>Отчество</td><td>${student.patronymic}</td></tr>
    <tr><td>номер группы</td><td>11-${student.groupNumber}</td></tr>
    <tr><td>компетенция</td><td>${student.competence}</td></tr>
    <tr><td>преподаватель</td><td>${student.teacherDto.surname} ${student.teacherDto.name} ${student.teacherDto.patronymic}</td></tr>
</table>
</body>
</html>