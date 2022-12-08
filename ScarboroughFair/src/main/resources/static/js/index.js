var items = $(".loopItem");
var points = $(".loopPoint");
var left = $("#leftBtn");
var right = $("#rightBtn");
var loop = $(".carousel");
var index = 0;
var time = 0;//用于定时换图

var inValidAll = function (){
    for(i = 0;i < items.length;i++){
        items[i].className = "loopItem";
    }
    for(i = 0;i < points.length;i++){
        points[i].className = "loopPoint";
    }
}

var activateIndex = function (){
    inValidAll();
    items[getNext()].className = "loopItem next";
    items[getPre()].className = "loopItem pre";
    items[index].className = "loopItem active";
    points[index].className = "loopPoint active";
}

var getNext = function (){
    if(index + 1 >= items.length)
        return 0;
    else return index + 1;
}

var getPre = function (){
    if(index - 1 < 0)
        return items.length - 1;
    else return index - 1;
}

var leftSwitch = function (){
    index = getPre();
    activateIndex();
}

var rightSwitch = function (){
    index = getNext();
    activateIndex();
}

var timer;

var loopPlay = function (){
    timer = setInterval(() => {
        time++;
        if(time === 30){
            rightSwitch();
            time = 0;
        }
    },100);
}

loopPlay();

var loopStop = function (){
    clearInterval(timer);
}

// renew goodList here
var goodList = $(".goodBar");

if($.cookie("userID") === undefined)
    window.location.replace(server + "/login");
else{
    $.ajax({
        type:"post",
        url: server + "/userService/getData",
        async: false,
        data:{
            "page": "universal",
            "userID": $.cookie("userID")
        },
        success: function(data) {
            for(var i in data){
                goodList.append("<div class='goodItem' id='" + i +"'>");
                $("#"+i).append($("<img src='"+ i.picture +"'/>")).append("<div class='goodInfo' id='" + (10 + i) + "'></div>");
                $("#" + (10 + i)).append($("<div class='article-subtitle'></div>").text(i.name));
                $("#" + (10 + i)).append($("<div class='tag'></div>").text(i.description));
                $("#" + (10 + i)).append($("<div class='price'></div>").text("￥" + i.price));
                $("#" + (10 + i)).append($("<button class='details'>查看详情</button>"));
            }
        }
    });
}

