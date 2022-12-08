if(userAvator !== "null")
    $("#avator").prop("src", server + userAvator);
var displayNewAvator = function (node){
    var reader = new FileReader();
    var file = node.files[0];
    reader.readAsDataURL(file);
    reader.onload = function (){
        $("#avator").prop("src", this.result);
    }
}
var uploadUserInfo = function (){
    var formData = new FormData();
    var nickname = $("input[name='nickname']")[0];
    var saying = $("textarea")[0];
    var file = $("#upl_avator")[0].files[0];
    formData.append("avator", file);
    formData.append("nickname", nickname.value);
    formData.append("saying", saying.value);
    formData.append("userID", $.cookie("userID"));
    $.ajax({
        type: "POST",
        url: server + "/userupload",
        data: formData,
        async: false,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data){
            if(data.isSucceed) {
                alert(data.message);
                window.location.replace("/index");
            }
        }
    });
}
