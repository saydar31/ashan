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

            var image = $("#form_edit")[0];
            var fd = new FormData(image);
            var tag1Id = $('#tag_place_1 :selected').val();
            var tag2Id = $('#tag_place_2 :selected').val();
            var tag3Id = $('#tag_place_3 :selected').val();
            var tag4Id = $('#tag_place_4 :selected').val();
            var tag5Id = $('#tag_place_5 :selected').val();

            var data = {name: name, surname: surname, patronymic: patronymic, teacherId: teacherId,
                competence: competence, tag1Id : tag1Id, tag2Id : tag2Id, tag3Id : tag3Id,
                tag4Id :tag4Id, tag5Id : tag5Id};

            fd.append('name', name);

            $.ajax({
                type: "POST",
                url: "/student/edit",
                processData: false,
                data: data,
                headers: {
                    'X-CSRF-TOKEN': csrf
                },
            })
                .fail(function () {
                    alert('Error')
                });
        }

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
<#include "include/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <form action="/student/edit" method="post"
              enctype="multipart/form-data" id="form_edit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
                                <input type="text" class="form-control" name="patronymic" id="patronymic"
                                       value="${student.patronymic}">
                            </div>
                            <div class="form-group">
                                <label for="inputState">Преподаватель:</label>
                                <select id="inputState" class="form-control" name="teacherId">
                                    <#if student.teacherDto?has_content>
                                        <option value="${student.teacherDto.id}" hidden>${student.teacherDto.surname} ${student.teacherDto.name}</option>
                                        <option value="">Не выбрано</option>
                                    <#else>
                                        <option selected value="">Не выбрано</option>
                                    </#if>
                                    <#if teachers??>
                                        <#list teachers as teacher>
                                            <option id="teacherId"
                                                    value="${teacher.id}">${teacher.surname} ${teacher.name} </option>
                                        </#list>
                                    </#if>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Теги:</label>
                                <select class="form-control tag_select" id="tag_place_1" name="tag1Id">
                                    <#if student.tagDtoSet?has_content>
                                        <#if student.tagDtoSet[0]?has_content>
                                            <option value="${student.tagDtoSet[0].id}"
                                                    hidden>${student.tagDtoSet[0].tagName}</option>
                                            <option value="">Не выбрано</option>
                                        <#else>
                                            <option selected value="">Не выбрано</option>
                                        </#if>
                                    <#else>
                                        <option selected value="">Не выбрано</option>
                                    </#if>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_1" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_2" name="tag2Id">
                                    <#if student.tagDtoSet?has_content>
                                        <#if student.tagDtoSet[1]?has_content>
                                            <option value="${student.tagDtoSet[1].id}"
                                                    hidden>${student.tagDtoSet[1].tagName}</option>
                                            <option value="">Не выбрано</option>
                                        <#else>
                                            <option selected value="">Не выбрано</option>
                                        </#if>
                                    <#else>
                                        <option selected value="">Не выбрано</option>
                                    </#if>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_2" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_3" name="tag3Id">
                                    <#if student.tagDtoSet?has_content>
                                        <#if student.tagDtoSet[2]?has_content>
                                            <option value="${student.tagDtoSet[2].id}"
                                                    hidden>${student.tagDtoSet[2].tagName}</option>
                                            <option value="">Не выбрано</option>
                                        <#else>
                                            <option selected value="">Не выбрано</option>
                                        </#if>
                                    <#else>
                                        <option selected value="">Не выбрано</option>
                                    </#if>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_3" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_4" name="tag4Id">
                                    <#if student.tagDtoSet?has_content>
                                        <#if student.tagDtoSet[3]?has_content>
                                            <option value="${student.tagDtoSet[3].id}"
                                                    hidden>${student.tagDtoSet[3].tagName}</option>
                                            <option value="">Не выбрано</option>
                                        <#else>
                                            <option selected value="">Не выбрано</option>
                                        </#if>
                                    <#else>
                                        <option selected value="">Не выбрано</option>
                                    </#if>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_4" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>

                                <select class="form-control tag_select" id="tag_place_5" name="tag5Id">
                                    <#if student.tagDtoSet?has_content>
                                        <#if student.tagDtoSet[4]?has_content>
                                            <option value="${student.tagDtoSet[4].id}"
                                                    hidden>${student.tagDtoSet[4].tagName}</option>
                                            <option value="">Не выбрано</option>
                                        <#else>
                                            <option selected value="">Не выбрано</option>
                                        </#if>
                                    <#else>
                                        <option selected value="">Не выбрано</option>
                                    </#if>
                                    <#if tags??>
                                        <#list tags as tag>
                                            <option id="tag_5" value="${tag.id}">${tag.tagName} </option>
                                        </#list>
                                    </#if>
                                </select>
                            </div>

                            <div class="form-group">
                                <span id="output">
                                    <#if student.mainPhotoId?has_content>
                                        <img class="img-thumbnail" width="200" height="200"
                                             src="/image/${student.mainPhotoId}">
                                    </#if>
                                </span>
                                <p>
                                    <label for="image">Фото</label>
                                    <input type="file" id="file" accept="image/*" name="image"
                                           placeholder="Имя файла..."/>
                                </p>
                            </div>

                            <div class="form-group competence">
                                <label for="competence">О себе:</label>
                                <#if student.competence??>
                                    <input type="text" class="form-control" name="competence" id="competence" value="${student.competence}"/>
                                <#else>
                                    <input type="text" class="form-control" name="competence" id="competence"/>
                                </#if>
                            </div>

                            <input class="btn btn-secondary" type="submit" value="Сохранить">

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