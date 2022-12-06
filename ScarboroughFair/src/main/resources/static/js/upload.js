var upload = function (){
    var pictures = $("input[type='file']");
    var i = 0;
    console.log(pictures);
    setTimeout(function (){i++;}, 10000);
    $.ajax({
        method: "post",
        url: "http://172.24.17.172/upload",
        data: {
            "photos": pictures
        },
        success: function (){
            console.log(pictures);
        }
    });
}