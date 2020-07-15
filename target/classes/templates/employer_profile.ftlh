<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employer</title>
</head>
<body>
<table>
    <tr><td>Название</td><td>${employer.companyName}</td></tr>
    <tr><td>Почта</td><td>${employer.mail}</td></tr>
    <tr><td>Телефон</td><td>${employer.phoneNumber}</td></tr>
</table>
<ol>
    <#list employer.studentDtoSet as student>
        <li><a href="/student/${student.id}">${student.surname} ${student.name} ${student.patronymic} 11-${student.groupNumber}</a></li>
    </#list>
</ol>
</body>
</html>