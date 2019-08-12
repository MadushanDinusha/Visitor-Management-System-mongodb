function addVisitor() {
    var name = $("#exampleInputEmail1").val();
    var ids = $("#exampleInputPassword1").val();
    console.log("name and id " + name + " " + ids);
    $.ajax({
        url: "createVisitor",
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(
            {
                "name": name,
                "visitorId": ids
            }),
        processData: false,
        success: function (result) {
            alert("successfully added")
        },
        error: function (er) {
            alert("error " + er)
        }
    });
}