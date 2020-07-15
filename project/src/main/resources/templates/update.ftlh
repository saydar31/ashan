<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update profile</title>
</head>
<body>

<form method="post" enctype="multipart/form-data" class="row">
    <div class="col-sm-9">
        <div class="tab-content">
            <div class="tab-pane active" id="home">
                <div class="form" id="registrationForm">
                    <div class="form-group">
                        <label for="first_name"><h4>name</h4></label>
                        <input type="text" class="form-control" name="name" id="name"
                               value="${student.name}">
                    </div>
                    <div class="form-group">
                        <label for="first_name"><h4>surname</h4></label>
                        <input type="text" class="form-control" name="surname" id="surname"
                               value="${student.surname}">
                    </div>
                    <div class="form-group">
                        <label for="first_name"><h4>patronymic</h4></label>
                        <input type="text" class="form-control" name="patromynic" id="patronymic"
                               value="${student.patronymic}">
                    </div>
                    <div class="form-group">
                        <label for="email"><h4>Course</h4></label>
                        <input type="text" class="form-control" name="course" id="course"
                               value="${student.course}">
                    </div>
                    <div class="form-group">
                        <label for="location"><h4>GroupNumber</h4></label>
                        <input class="text" id="location" value="${student.groupNumber}"
                               title="group number" name="groupNumber">
                    </div>
                    <div class="form-group">
                        <form action="search" method="post">
                            <select class="custom-select col-md-2" id="inputGroupSelect06">
                                <#if teachers??>
                                    <#list teachers as teacher>
                                        <option value="${teacher.id}">${teacher.name} ${teacher.surname}</option>
                                    </#list>
                                </#if>
                            </select>
                        </form>
                    </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <br>
                        <button class="btn btn-lg btn-success" name="submit" type="submit" onclick="clicked()">
                            <i class="glyphicon glyphicon-ok-sign"></i>
                            Save
                        </button>
                    </div>
                </div>
            </div>
        <hr>
        </div>
    </div>
</form>
</body>
</html>