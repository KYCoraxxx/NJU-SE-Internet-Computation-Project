var musicOpacity = 0;
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
var appendDropDown = function (){
    if($(".dropDown").length > 0)return;
    var dropDown = $("<div class='dropDown'></div>");
    var userBox = $(".userBox");
    userBox.css("height", "410px");
    userBox.append(dropDown);
    setTimeout(function (){
        dropDown.append($("<div class='article-subtitle' style='height: 10%'>DefaultUser</div>"));
        dropDown.append($("<div class='saying'>最怕你一生碌碌无为，还安慰自己平凡可贵</div>"));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/userCenter.png'/>个人中心</button>"));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/good.png'/>上架管理</button>"));
        dropDown.append($("<button class='dropDownBtn'><img src='/img/exit.png'/>退出登录</button>"));
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