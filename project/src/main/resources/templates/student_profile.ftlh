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
<form method="post" enctype="multipart/form-data" class="row">

    </div><!--/col-3-->
    <div class="col-sm-9">

        <div class="tab-content">
            <div class="tab-pane active" id="home">
                <p>Имя: ${student.name}</p>
                <p>Фамилие: ${student.surname}</p>
                <p>Отчество: ${student.patronymic}</p>
                <p>Курс: ${student.course}</p>
                <p>Группа: ${student.groupNumber}</p>

                <#if student.teacher?has_content>
                    <p>Преподаватель: ${student.teacher.surname} ${student.teacher.name}</p>
                <#else>
                    <div class="form-group">
                        <form action="/student/home/edit" method="POST">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <select class="studentEditDto" id="inputGroupSelect06">
                                <#if teachers??>
                                    <#list teachers as teacher>
                                        <option name="teacherId" value="${teacher.id}">${teacher.name} ${teacher.surname}</option>
                                    </#list>
                                </#if>
                            </select>
                            <input type="submit" value="Сохранить">
                        </form>
                    </div>
                </#if>
            </div>
            <hr>
        </div><!--/tab-pane-->
    </div>
    </div>
</form>
</body>
</html>