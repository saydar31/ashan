<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
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
    </script>
</head>
<body>

<script>
    window.onload = function () {
        var eventId = document.getElementById('file');
        eventId.addEventListener('change', handleFileSelect, false);
    }

</script>

<h3><a href="/teacher/home">Профиль</a> | <a href="/teacher/home/edit">Редактировать профиль</a> | <a
            href="/myStudents/competence/toConfirm">Список на подтверждение</a></h3>
<div>
    <form action="/teacher/edit" method="post" enctype="multipart/form-data" id="form_edit">

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

        <p>Имя: <input name="name" value="<#if teacher.name??>${teacher.name}</#if>"></p>
        <p>Фамилия: <input name="surname" placeholder="Фамилия" value=<#if teacher.surname??>"${teacher.surname}</#if>">
        </p>
        <p>Отчество: <input name="patronymic" placeholder="Отчество"
                            value="<#if teacher.patronymic??>${teacher.patronymic}</#if>"></p>
        <p>Образование: <input name="education" placeholder="Образование"
                               value="<#if teacher.education??>${teacher.education}</#if>"></p>
        <p>Занимаемая должность: <input name="positionHeld" placeholder="Занимаемая должность"
                                        value="<#if teacher.positionHeld??>${teacher.positionHeld}</#if>"></p>
        <p>Знание языков: <input name="knowledgeOfLanguages" placeholder="Знание языков"
                                 value="<#if teacher.knowledgeOfLanguages??>${teacher.knowledgeOfLanguages}</#if>"></p>
        <p>Дополнительная информация: <input name="additionInformation" placeholder="Дополнительная информация"
                                             value="<#if teacher.additionInformation??>${teacher.additionInformation}</#if>">
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" value="Сохранить изменения">
    </form>
</div>
</body>
</html>