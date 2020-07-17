<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous">
    </script>
    <script>
        function save() {
            let csrf = $('#csrf_value').val();
            var name = $('#name').val();
            var surname = $('#surname').val();
            var patronymic = $('#patronymic').val();
            var teacherId = $('#inputState :selected').val();
            var competence = $('#competence').val();

            var tag1Id = $('#tag_place_1 :selected').val();
            var tag2Id = $('#tag_place_2 :selected').val();
            var tag3Id = $('#tag_place_3 :selected').val();
            var tag4Id = $('#tag_place_4 :selected').val();
            var tag5Id = $('#tag_place_5 :selected').val();

            var data = {name: name, surname: surname, patronymic: patronymic, teacherId: teacherId,
            competence: competence, tag1Id : tag1Id, tag2Id : tag2Id, tag3Id : tag3Id,
                tag4Id :tag4Id, tag5Id : tag5Id};
            $.ajax({
                type: "POST",
                url: "/student/edit",
                data: data,
                headers: {
                    'X-CSRF-TOKEN': csrf
                },
                success: function () {
                    location.reload();
                }
            });
        }

    </script>
    <title>Edit profile</title>
</head>
<body>
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <form onsubmit="save(); return false;">
            <input type="hidden" id="csrf_value" value="${_csrf.token}"/>
            <div class="col-md-12">
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <div class="form" id="registrationForm">
                            <div class="form-group">
                                <label for="surname">Фамилия:</label>
                                <input type="text" class="form-control" name="surname" id="surname" value="${student.surname}">
                            </div>
                            <div class="form-group">
                                <label for="name">Имя:</label>
                                <input type="text" class="form-control" name="name" id="name" value="${student.name}">
                            </div>
                            <div class="form-group">
                                <label for="patronymic">Отчество:</label>
                                <input type="text" class="form-control" name="patromynic" id="patronymic" value="${student.patronymic}">
                            </div>
                            <div class="form-group">
                                <label for="inputState">Преподаватель:</label>
                                <select id="inputState" class="form-control">
                                    <option selected value="">Не выбрано</option>
                                    <#if teachers??>
                                        <#list teachers as teacher>
                                            <option id="teacherId" value="${teacher.id}">${teacher.surname} ${teacher.name} </option>
                                        </#list>
                                    </#if>
                                </select>
                            </div>

                            <div class="form-group">
                                <select class="form-control tag_select" id="tag_place_1">
                                    <option selected value="">Не выбрано</option>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_1" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_2">
                                    <option selected value="">Не выбрано</option>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_2" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_3">
                                    <option selected value="">Не выбрано</option>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_3" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_4">
                                    <option selected value="">Не выбрано</option>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_4" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_5">
                                    <option selected value="">Не выбрано</option>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_5"  value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                            </div>

                            <div class="form-group competence">
                                <label for="competence">О себе:</label>
                                <#if student.competence??>
                                    <input type="text" class="form-control" name="competence" id="competence" value="${student.competence}"/>
                                <#else>
                                    <input type="text" class="form-control" name="competence" id="competence"/>
                                </#if>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <input type="submit" value="Сохранить">
                                </div>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>