<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignUp Employer</title>
</head>
<body>
<div>
    <form action="/signUp_employer" method="post">
        <input name="companyName" placeholder="CompanyName">

        <input name="mail" placeholder="Email">
        <input type="password" name="password" placeholder="Пароль">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="РЕГИСТРАЦИЯ">
    </form>
</div>
</body>
</html>