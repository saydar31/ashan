<html lang="en">
<head>
    <title>${employer.companyName}</title>
</head>
<body>
<table>
    <tr>
        <td></td><td>${employer.companyName}</td>
    </tr>
    <tr>
        <td></td><td>${employer.mail}</td>
    </tr>
</table>
<ul>
    <#list employer.studentDtoSet as student>
        <li>${student.name} ${student.surname} ${student.patronymic}, ${student.groupNumber}</li>
    </#list>
</ul>
</body>
</html>