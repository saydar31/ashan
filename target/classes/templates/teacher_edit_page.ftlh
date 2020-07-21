
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Редактирование профиля преподавателя</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous">
    </script>
    <script>
        function handleFileSelect(evt) {
            var file = evt.target.files; // FileList object
            // Loop through the FileList and render image files as thumbnails.
            for (var i = 0, f; f = file[i]; i++) {

                // Only process image files.
                if (!f.type.match('image.*')) {
                    alert("Image only please....");
                }
                var reader = new FileReader();
                // Closure to capture the file information.

                reader.onload = (function (theFile) {
                    return function (e) {
                        // Render thumbnail.
                        var span = document.createElement('span');
                        span.innerHTML = ['<img class="img-thumbnail" width="200" height="200" title="', escape(theFile.name), '" src="', e.target.result, '" />'].join('');
                        $('#output').empty();
                        document.getElementById('output').insertBefore(span, null);
                    };
                })(f);
                // Read in the image file as a data URL.
                reader.readAsDataURL(f);
            }
        }

        window.onload = function () {
            var eventId = document.getElementById('file');
            eventId.addEventListener('change', handleFileSelect, false);
        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">АШАН</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"/>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/students">Поиск студентов</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/home">Личный кабинет</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/myStudents/competence/toConfirm">Список на подтверждение</a>
            </li>
        </ul>
        <button class="btn btn-primary my-2 my-sm-0" type="submit"><a class="tabs" href="/logout">Выйти</a></button>
    </div>
</nav>
<div class="container-fluid">
    <b>Редактирования профиля преподавателя</b>
    <div class="row">
        <form action="/teacher/edit" method="post" enctype="multipart/form-data">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="col-md-12">
                <div class="tab-content">
                    <div class="tab-pane active" >
                        <div class="form">

                            <div class="form-group">
                                <span id="output">
                                    <#if teacher.mainPhotoId?has_content>
                                        <img class="img-thumbnail" width="200" height="200"
                                             src="/image/${teacher.mainPhotoId}">
                                    </#if>
                                </span>
                                <p>
                                    <label for="image">Фото</label>
                                    <input type="file" id="file" accept="image/*" name="image"
                                           placeholder="Имя файла..."/>
                                </p>
                            </div>

                            <div class="form-group">
                                <label for="surname">Фамилия:</label>
                                <input name="surname" class="form-control" id="surname" placeholder="Фамилия" value=<#if teacher.surname??>"${teacher.surname}</#if>">
                            </div>
                            <div class="form-group">
                                <label for="name">Имя:</label>
                                <input id="name" class="form-control" name="name" value="<#if teacher.name??>${teacher.name}</#if>">
                            </div>
                            <div class="form-group">
                                <label for="patronymic">Отчество:</label>
                                <input id="patronymic" class="form-control" name="patronymic" value="<#if teacher.patronymic??>${teacher.patronymic}</#if>">
                            </div>
                            <div class="form-group">
                                <label for="education">Образование:</label>
                                <input id="education" class="form-control" name="education" value="<#if teacher.education??>${teacher.education}</#if>">
                            </div>
                            <div class="form-group">
                                <label for="positionHeld">Занимаемая должность:</label>
                                <input id="positionHeld" class="form-control" name="positionHeld" value="<#if teacher.positionHeld??>${teacher.positionHeld}</#if>">
                            </div>
                            <div class="form-group">
                                <label for="languages">Знание языков:</label>
                                <input id="languages" class="form-control" name="knowledgeOfLanguages" value="<#if teacher.knowledgeOfLanguages??>${teacher.knowledgeOfLanguages}</#if>">
                            </div>
                            <div class="form-group">
                                <label for="additionInformation">Дополнительная информация:</label>
                                <input id="additionInformation" class="form-control competence" name="additionInformation" value="<#if teacher.additionInformation??>${teacher.additionInformation}</#if>">
                            </div>
                            <input class="btn-secondary btn" type="submit" value="Сохранить">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>