
function addNewTag() {

    let tagName = $("#new_tag_name").val();
    let json = {"tagName": tagName};

    if(tagName != '') {

        $.ajax({
            type: 'POST',
            url: '/api/admin/add_tag',
            contentType: "application/json",

            headers: {
                Authorization: token
            },

            data: JSON.stringify(json),
            dataType: 'json',
        })
            .done(function (response) {
                $("#new_tag_name").val('');
                if (response.state == "success") {
                    addNewRow(response.description, tagName);
                } else if (response.state == "fail") {
                    alert(response.description)
                }
            })
            .fail(function () {
                alert('Error')
            });
    }
}

function deleteTag(tagId) {
    let json = {"tagId": tagId};

    $.ajax({
        type: 'POST',
        url: '/api/admin/delete_tag',
        contentType: "application/json",

        headers: {
            Authorization: token
        },

        data: JSON.stringify(json),
        dataType: 'json',
    })
        .done(function (response) {
            if (response.state == "success") {
                deleteRows(tagId);
            } else if (response.state == "fail") {
                alert(response.description)
            }

        })
        .fail(function () {
            alert('Error')
        });
}

function deleteRows(tagId) {
    document.getElementById("tag_" + tagId).remove();
}

function addNewRow(tagId, tagName) {
    let newTr = $("<tr/>")
    newTr.attr('id', "tag_" + tagId);

    let newButton = $("<button/>");
    newButton.click(function () {
        deleteTag(tagId);
    });
    newButton.attr("class", "btn btn-secondary")
    newButton.text("удалить");

    let td1 = $("<td/>")
    let td2 = $("<td/>")

    td1.text(tagName);
    td2.append(newButton)

    newTr.append(td1);
    newTr.append(td2);

    $("#tag_list").prepend(newTr);
}