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
        type: "post",
        url: server + "/userupload",
        data: formData,
        cache: false,
        processData:false,
        contentType:false,
        success: function (data){
            var message = JSON.parse(data);
            if(message.isSucceed) {
                window.location.replace(server + "/index");
                alert("用户信息修改成功！");
            }
        }
    });
}
