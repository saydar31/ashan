<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
</head>
<body>
<table>
    Teacher
    <tr><td></td><td>${teacher.surname}</td></tr>
    <tr><td></td><td>${teacher.name}</td></tr>
    <tr><td></td><td>${teacher.patronymic}</td></tr>
    <tr><td></td><td>${teacher.mail}</td></tr>
</table>
<ol>
    <#list teacher.studentDtoSet as student>
        <li><a href="/student/${student.id}">${student.name} ${student.surname} 11-${student.groupNumber}, ${student.competence}</a></li>
    </#list>
</ol>
</body>
</html>