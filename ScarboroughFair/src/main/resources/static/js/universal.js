var server = "http://project.internet-computation.icu";
var musicOpacity = 0;
var userID;
var userName;
var userAvator;
var userSaying;
if($.cookie("userID") === undefined)
    window.location.replace("/login");
else
    $.ajax({
        type:"post",
        url: server + "/userService/getData",
        async: false,
        data:{
            "page": "universal",
            "userID": $.cookie("userID")
        },
        success: function(data) {
            userID = data.userID;
            userName = data.userName;
            userAvator = data.avator;
            userSaying = data.saying;
        }
    });
if(userAvator !== "null")
    $(".avator img").prop("src", server + userAvator);
var avatorScaler = function (size){
    $(".avator img").css("width", size);
    $(".avator img").css("height", size);
    if(size === "100px")
        appendDropDown();
    else
        deleteDropDown();
}
var deleteDropDown = function (){
    $(".userBox").css("height", "70px");
    $(".dropDown").remove();
}
var quitLogin = function (){
    $.removeCookie("userID", {path: "/"});
    window.location.replace("/index");
}
var appendDropDown = function (){
    if($(".dropDown").length > 0)return;
    var dropDown = $("<div class='dropDown'></div>");
    var userBox = $(".userBox");
    userBox.css("height", "410px");
    userBox.append(dropDown);
    setTimeout(function () {
        dropDown.append($("<div class='article-subtitle' style='height: 10%'></div>").text(userName));
        dropDown.append($("<div class='saying'></div>").text(userSaying));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/userCenter.png'/>个人中心</button>").bind("click", function (){
            window.location.replace("/usercenter");
        }));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/good.png'/>上架管理</button>").bind("click", function (){
            window.location.replace("/undone");
        }));
        dropDown.append($("<button class='dropDownBtn' onclick='quitLogin()'><img src='/img/exit.png'/>退出登录</button>"));
    }, 300);
}
var changeSearch = function (state){
    if(state === 0)
        $(".searchBar img").css("background-color", "#00000024");
    else if(state === 1)
        $(".searchBar img").css("background-color", "#00000000");
    else if(state === 2)
        $(".searchBar").css("background-color", "#0000001a");
    else
        $(".searchBar").css("background-color", "#0000000a");
}
var changeMusic = function (){
    var music = $("#music");
    if(music.length === 0){
        $(".navBar").append($("<audio src='/music/ScarboroughFair.mp3' id='music' style='bottom: 0; position: absolute' controls></audio>"));
    }
    else{
        musicOpacity ^= 1;
        music.css("opacity", musicOpacity === 1 ? "1" : "0");
    }
}
var jumpLocation = function (location,obj){
    window.location.replace(location);

}


//上传
var imgIndex = 0;

var addPicture = function (node){
    var reader = new FileReader();
    var file = node.files[0];
    imgIndex++;
    var goal = "#img" + node.id[5];
    reader.readAsDataURL(file);
    reader.onload = function (){
        $(goal).prop("src", this.result);
        $(goal).css("width", "220px");
        $(goal).css("height", "220px");
        $(goal).css("margin", "0 0");
        $(goal).css("border-radius", "5px");
    }
    if(imgIndex < 9) {
        var add = $('<div class=\"singleIMG\">' +
            '<input class=\"inputButton\" type=\"file\" name=\"file\" multiple=\"multiple\" id=\"input' + imgIndex +
            '\" onchange=\"addPicture(this)\"/>' + '<img class=\"inputButton_IMG\" id=\"img' + imgIndex +
            '\" src=\"/img/defaultUpload.png\">' +
            '</div>');
        $(".uploadIMG").append(add);
    }


}
//点击发布上传后端
var uploadAllInfo = function (){

    var formData = new FormData();
    var content = $("#uploadContent")[0];
    for(var i = 0;i < imgIndex;i++){
        //picUpload.push($("#input" + i)[0].files[0]);
        formData.append("picUpload",$("#input"+i)[0].files[0]);
    }
    formData.append("content",content.value);
    formData.append("userID", $.cookie("userID"));
    $.ajax({
        type: "POST",
        url: server + "/postupload",
        data: formData,
        async: false,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data){
            if(data.isSucceed) {
                alert(data.message);
                window.location.replace("/forum");
            }
        }
    });
}

var getPicSize = function(){
    return imgIndex;
}
