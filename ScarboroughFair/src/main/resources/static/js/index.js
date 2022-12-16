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
var renewCount = 0;
var totalGoods = -1;
var goodBarCount = -1;
var goodList = $(".goodBlock");
var alreadyUploadIndex = 0;
var renewLock = 0;

var uploadGood = function(){
    $.ajax({
        type:"post",
        url: server + "/GoodService/findAll",
        async: false,
        data:{
        },
        success: function(data) {
            if(totalGoods == -1){
                for(var i in data){
                    totalGoods++;
                }
            }
            var start = alreadyUploadIndex;
            for(i = start;i < start + 4 && i <= totalGoods;i++){
                if(i % 4 === 0){
                    goodBarCount++;
                    goodList.append("<div class='goodBar' id='goodBar" + goodBarCount + "'></div>");
                }
                $("#goodBar" + goodBarCount).append("<div class='goodItem' id='goodItem" + i +"'>");
                $("#goodItem" + i).append($("<img src='"+ data[i].picture +"'/>")).append("<div class='goodInfo' id='goodItem_goodInfo" + i + "'></div>");
                $("#goodItem_goodInfo" + i).append($("<div class='article-subtitle'></div>").text(data[i].name));
                $("#goodItem_goodInfo" + i).append($("<div class='tag'></div>").text(data[i].tag));
                $("#goodItem_goodInfo" + i).append($("<div class='price'></div>").text("￥" + data[i].price));
                $("#goodItem_goodInfo" + i).append($("<button class='details'>查看详情</button>"));
                alreadyUploadIndex++;
            }
        }
    });
    renewLock = 0;
    $(".renewIcon").remove();
    return 0;
}

if(renewCount === 0){
    if($.cookie("userID") === undefined)
        window.location.replace(server + "/login");
    else{
        renewLock = 1;
        setTimeout(uploadGood,3000);
        goodList.append("<div class='renewIcon'><img src='/img/renewIcon.png' width='50px' height='50px' style='margin-top: 30px;'></div>");
    }
    renewCount++;
}

window.onscroll = function (){
    var scrollPos = getScrollPos();
    var scrollHeight = getScrollHeight();
    var windowHeight = getWindowHeight();
    if(scrollPos + windowHeight >= scrollHeight && renewLock === 0){
        renewLock = 1;
        // this would invoke the renew function
        if(alreadyUploadIndex <= totalGoods){
            setTimeout(uploadGood,3000);
            goodList.append("<div class='renewIcon'><img src='/img/renewIcon.png' width='50px' height='50px' style='margin-top: 30px;'></div>");
        }
        else{
            goodList.append("<div class='renewIcon' style='font-size=10px;'>已经到底了QWQ</div>");
        }
    }
}

var getScrollPos = function (){
    var scrollTop = 0;
    if(document.documentElement&&document.documentElement.scrollTop){
        scrollTop = document.documentElement.scrollTop;
    }else if(document.body){
        scrollTop = document.body.scrollTop;
    }
    return scrollTop;
}

var getScrollHeight = function(){
    var scrollHeight = 0;
    if(document.documentElement&&document.documentElement.scrollHeight){
        scrollHeight = document.documentElement.scrollHeight;
    }else if(document.body){
        scrollHeight = document.body.scrollHeight;
    }
    return scrollHeight;
}

var getWindowHeight = function(){
    var windowHeight = 0;
    if(document.compatMode === "CSS1Compat"){
        windowHeight = document.documentElement.clientHeight;
    }
    else{
        windowHeight = document.body.clientHeight;
    }
    return windowHeight;
}



