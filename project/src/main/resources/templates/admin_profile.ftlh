<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script src="/static/js/admin.js" type="application/javascript"></script>

    <title>Admin Profile</title>

    <script>
        token = '${admin.token}';
    </script>

</head>
<body>
AdminId: ${admin.id}

<div>
    <button onclick="getNotConfirmedStudents('${admin.token}')">Студенты</button>
    <button onclick="getNotConfirmedTeachers('${admin.token}')">Преподы</button>
    <button onclick="getNotConfirmedEmployers('${admin.token}')">Работадатели</button>

    <ul id="users">

    </ul>
</div>

</body>
</html>