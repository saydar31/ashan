<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Изменение страницы компании</title>
</head>
<body>
<form method="post" action="/home/employer/edit">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <label>
        <input required type="text" name="companyName" placeholder="Название компании" value="${employer.companyName}"><br>
    </label>
    <label>
        <input required type="text" name="phoneNumber" placeholder="Номер телефона" value="${employer.phoneNumber}"><br>
    </label>
    <input type="submit" value="Отправить">
</form>
</body>
</html>