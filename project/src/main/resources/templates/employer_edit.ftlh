<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Изменение страницы компании</title>
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

<form method="post" action="/home/employer/edit"  enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <div class="form-group">
        <span id="output">
             <#if employer.mainPhotoId?has_content>
                 <img class="img-thumbnail" width="200" height="200" src="/image/${employer.mainPhotoId}">
             </#if>
        </span>
        <p>
            <label for="image">Фото</label>
            <input type="file" id="file" accept="image/*" name="image"
                   placeholder="Имя файла..."/>
        </p>
    </div>
    <label>
        <input required type="text" name="companyName" placeholder="Название компании"
               value="${employer.companyName}"><br>
    </label>
    <label>
        <input required type="text" name="phoneNumber" placeholder="Номер телефона" value="${employer.phoneNumber}"><br>
    </label>
    <input type="submit" value="Отправить">
</form>
</body>
</html>