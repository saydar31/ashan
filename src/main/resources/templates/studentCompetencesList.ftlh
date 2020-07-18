<html lang="en">
<head>
    <title>Students</title>
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function confirm(id) {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $.ajax(
            {
                type: "POST",
                url: "/competence/student/"+id+"/confirm",
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header,token)
                }
            }
        )
    }

    function refuse(id) {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $.ajax(
            {
                type: "POST",
                url: "/competence/student/"+id+"/refuse",
                processData: false,
                contentType: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header,token)
                }
            }
        )
    }
</script>
<body>
<h3><a href="/teacher/home">Профиль</a> | <a href="/teacher/home/edit">Редактировать профиль</a> | <a href="/myStudents/competence/toConfirm">Список на подтверждение</a></h3>
<ol>
    <#if students?size != 0>
        <#list students as student>
            <li><a href="/student/${student.id}">${student.name} ${student.surname} 11-${student.groupNumber}, ${student.competence}</a>, <button onclick="confirm('${student.id}')">confirm</button> <button onclick="refuse('${student.id}')">refuse</button></li>
        </#list>
    </#if>
</ol>
</body>
</html>