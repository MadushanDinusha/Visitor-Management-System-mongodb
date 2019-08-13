function addVisitor() {

    var person = new Object();
    person.name = $("#inputName").val();
    $.ajax({
        url: "createVisitor",
        type: "POST",
        contentType: "application/json",
        accept: 'text/plain',
        data: JSON.stringify(person),
        dataType: 'text',
        success: function (result) {
            alert("successfully added")
        },
        error: function (er) {
            alert("error " + er)
        }
    });
}