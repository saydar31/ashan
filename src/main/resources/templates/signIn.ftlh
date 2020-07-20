
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/signIn.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Hello, world!</title>
</head>
<body class="text-center">
<form action="/signIn" method="post" class="form-signin">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <h1 class="h3 mb-3 font-weight-normal">Авторизация</h1>
    <label for="inputEmail" class="sr-only">Почта</label>
    <input type="email" name="mail" id="inputEmail" class="form-control" placeholder="Почта" required autofocus>
    <label for="inputPassword" class="sr-only">Пароль</label>
    <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Пароль" required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" name="remember-me">Запомнить меня
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти в личный кабинет</button>
    <a href="/signUp">Регистрация</a>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>