var server = "http://localhost:8080";
var musicOpacity = 0;
var userID;
var userName;
var userAvator;
var userSaying;
if($.cookie("userID") === undefined)
    window.location.replace(server + "/login");
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
    window.location.replace(server + "/index");
}
var appendDropDown = function (){
    if($(".dropDown").length > 0)return;
    var dropDown = $("<div class='dropDown'></div>");
    var userBox = $(".userBox");
    userBox.css("height", "410px");
    userBox.append(dropDown);
    setTimeout(function () {
        dropDown.append($("<div class='article-subtitle' style='height: 10%'></div>").text(userName));
        // dropDown.append($("<div class='saying'>最怕你一生碌碌无为，还安慰自己平凡可贵</div>"));
        dropDown.append($("<div class='saying'></div>").text(userSaying));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/userCenter.png'/>个人中心</button>").bind("click", function (){
            window.location.replace(server + "/usercenter");
        }));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/good.png'/>上架管理</button>"));
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
var jumpLocation = function (location){
    window.location.replace(server + location);
}