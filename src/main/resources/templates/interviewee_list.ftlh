<html lang="en">
<head>
    <title>Студенты приглашенные на собеседование</title>
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
        function refuse(id) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax(
                {
                    url: "/interview/student/"+id+"/refuse",
                    type: "POST",
                    processData: false,
                    contentType: false,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(header,token)
                    }
                }
            )
        }

        function accept(id) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax(
                {
                    url: "/interview/student/"+id+"/accept",
                    type: "POST",
                    processData: false,
                    contentType: false,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(header,token)
                    }
                }
            )
        }
    </script>
</head>
<body>
<ol>
    <#list interviewees as student>
        <li><a>${student.name} ${student.surname} ${student.patronymic} 11-${student.groupNumber}</a> ${student.mail} <#if student.competence??>${student.competence}</#if><button onclick="accept(${student.id})">прошел</button><button onclick="refuse(${student.id})">использовал аоп для отправки писем в едиственном месте</button></li>
    </#list>
</ol>
</body>
</html>