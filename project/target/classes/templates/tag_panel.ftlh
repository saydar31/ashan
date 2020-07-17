<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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

<h1><a href="/admin/home">Admin Panel</a> | Tag Panel</h1>

<p>Добавить тег</p>
<div id="input_place">
    <input id="new_tag_name" name="new_tag_name" placeholder="название тега"/>
    <button onclick="addNewTag()">Добавить</button>
</div>

<p>Список всех тегов</p>
<ul id="tag_list">
    <#if tagList?has_content>
        <#list tagList as tag>
            <li id="tag_${tag.id}">${tag.tagName}
                <button onclick="deleteTag('${tag.id}')">удалить</button>
            </li>
        </#list>
    </#if>
</ul>
</body>
</html>