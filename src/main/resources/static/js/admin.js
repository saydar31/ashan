function remove() {
    document.getElementById('users').innerHTML = '';
}

function createConfirmButton(id) {
    let html = '<button  class="btn btn-secondary" id="button_confirm_' + id +  '" onclick="confirmUser('  + "'" + token + "'" + ',' + id + ')">Принять</button>';
    return html;
}

function createRefuseButton(id) {
    let html = '<button  class="btn btn-secondary" id="button_refuse_' + id +  '" onclick="refuseUser('  + "'" + token + "'" + ',' + id + ')">Отклонить</button>';
    return html;
}

function removeButtons(id) {
    document.getElementById("button_confirm_" + id).remove();
    document.getElementById("button_refuse_" + id).remove();
}


function getStudents(response) {
    remove();
    //вывод всех студентов, item - элемент (студент)
    response.forEach(function (item) {
        let link = "/student/" + item.id;
        $("#users").append( '<tr><td><a href="' + link + '">' + item.surname + ' ' + item.name + ' ' + item.patronymic  + '</a></td>' +
            '<td>'+ item.course + '</td><td>11-' + item.groupNumber + '</td><td>' +  createConfirmButton(item.id) + '</td><td>' + createRefuseButton(item.id) + '</td></tr>');
    })
}

function getNotConfirmedStudents(token) {

    $.ajax({

        type: 'GET',
        url: '/api/admin/not_confirmed_students',
        contentType: "application/json",

        headers: {
            Authorization: token
        },

        dataType: 'json',
    })
        .done(function (response) {
            getStudents(response);
        })
        .fail(function () {
            alert('Error')
        });
}

function getTeachers(response) {
    remove();
    //вывод всех teacher, item - элемент (препод)
    response.forEach(function (item, i, arr) {
        var newLi = document.createElement('li')
        let link = "/teacher/" + item.id;
        let htmlText = '<a href="' + link + '">' + item.surname + ' '+ item.name + '</a>';

        let buttonConfirm = createConfirmButton(item.id);
        let buttonRefuse = createRefuseButton(item.id);
        htmlText += buttonConfirm;
        htmlText += buttonRefuse;
        newLi.innerHTML = htmlText;
        $("#users").append(newLi);
    })
}

function getNotConfirmedTeachers(token) {

    $.ajax({

        type: 'GET',
        url: '/api/admin/not_confirmed_teachers',
        contentType: "application/json",

        headers: {
            Authorization: token
        },

        dataType: 'json',
    })
        .done(function (response) {
            getTeachers(response);
        })
        .fail(function () {
            alert('Error')
        });
}

function getEmployers(response) {
    remove();
    response.forEach(function (item, i, arr) {
        var newLi = document.createElement('li')
        let link = "/employer/" + item.id;
        let htmlText = '<a href="' + link + '">' + item.companyName + '</a>';

        let buttonConfirm = createConfirmButton(item.id);
        let buttonRefuse = createRefuseButton(item.id);
        htmlText += buttonConfirm;
        htmlText += buttonRefuse;
        newLi.innerHTML = htmlText;
        $("#users").append(newLi);
    })
}

function getNotConfirmedEmployers(token) {

    $.ajax({
        type: 'GET',
        url: '/api/admin/not_confirmed_employers',
        contentType: "application/json",

        headers: {
            Authorization: token
        },

        dataType: 'json',
    })
        .done(function (response) {
            getEmployers(response);
        })
        .fail(function () {
            alert('Error')
        });
}

function confirmUser(token, id) {
    let json = {"id": id};

    $.ajax({

        type: 'POST',
        url: '/api/admin/confirm_user',
        contentType: "application/json",

        headers: {
            Authorization: token
        },

        data: JSON.stringify(json),
        dataType: 'json',
    })
        .done(function (response) {
            removeButtons(id);
        })
        .fail(function () {
            alert('Error')
        });
}

function refuseUser(token, id) {
    let json = {"id": id};

    $.ajax({

        type: 'POST',
        url: '/api/admin/refuse_user',
        contentType: "application/json",

        headers: {
            Authorization: token
        },

        data: JSON.stringify(json),
        dataType: 'json',
    })
        .done(function (response) {
            removeButtons(id);
        })
        .fail(function () {
            alert('Error')
        });
}

