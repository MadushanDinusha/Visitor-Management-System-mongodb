function addVisitor() {
    var data = new FormData($('#addVisitor')[0]);
    $.ajax({
        url: "createVisitor",
        async: true,
        type: "POST",
        enctype: "multipart/form-data",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        success: function (result) {
           alert("successfully added")
        },
        error: function (er) {
            alert("error")
        }
    });
}