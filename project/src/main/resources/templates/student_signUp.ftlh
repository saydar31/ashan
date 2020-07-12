<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignUp Student</title>
</head>
<body>
<h1>Регистрация</h1>
<div>
    <form action="/signUp_student" method="post">
        <input name="name" placeholder="Имя">
        <input name="surname" placeholder="Фамилие">
        <input name="patronymic" placeholder="Отчество">
        <input name="course" placeholder="Курс">
        <input name="groupNumber" placeholder="Номер группы">

        <input name="mail" placeholder="Email">
        <input type="password" name="password" placeholder="Пароль">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="РЕГИСТРАЦИЯ">
    </form>
</div>

</body>
</html>