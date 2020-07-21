<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Tag Panel</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script src="/static/js/tag_panel.js" type="application/javascript"></script>

    <script>
        token = "${admin.token}"
    </script>
</head>
<body>
<#include "include/admin_navbar.ftlh">
<div class="container-fluid">
    <h4><b>Добавление нового тега</b></h4>
    <div id="input_place">
        <input id="new_tag_name" name="new_tag_name" placeholder="Название тега"/>
        <button class="btn btn-secondary" onclick="addNewTag()">Добавить</button>
    </div>
    <h4><b>Список всех тегов</b></h4>
    <ul>
        <table id="tag_list" class="table table-responsive">
            <tbody>
            <#if tagList?has_content>
                <#list tagList as tag>
                    <tr id="tag_${tag.id}">
                        <td>${tag.tagName}</td>
                        <td>
                            <button class="btn btn-secondary" onclick="deleteTag('${tag.id}')">удалить</button>
                        </td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>

    </ul>
</div>
</body>
</html>