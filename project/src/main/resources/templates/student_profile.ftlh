<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
    <script>
        function sendFile() {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            // данные для отправки
            let formData = new FormData();
            // забрал файл из input
            let files = ($('#file'))[0]['files'];
            // добавляю файл в formData
            [].forEach.call(files, function (file) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                beforeSend: function(request) {
                    request.setRequestHeader(header, token);},
                url: "/student/photo",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (html) {
                    $("#content").html(html);
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>
</head>
<body>
<div>
    <#if student.mainPhoto.size != 0>
        ${student.mainPhoto}
    </#if>
    <input type="file" id="file" name="file" placeholder="Имя файла..."/>
    <button onclick="sendFile()"><@spring.message 'upload.file'/></button>
    <input type="hidden" id="file_hidden">
    <div class="filename"></div>
</div>
    ${student.name}
    ${student.competenceState}
</body>
</html>