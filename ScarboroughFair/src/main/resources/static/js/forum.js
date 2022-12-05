/*回到页头--------------*/


window.onscroll = function (){
    var scrollPos = getScrollPos();
    if(scrollPos > 100){
        $(".returnTopBtn").css("margin-top","0%");
    } else {
        $(".returnTopBtn").css("margin-top","10%");
    }
}

var getScrollPos = function (){
    var scrollTop=0;
    if(document.documentElement&&document.documentElement.scrollTop){
        scrollTop=document.documentElement.scrollTop;
    }else if(document.body){
        scrollTop=document.body.scrollTop;
    }
    return scrollTop;
}

var returnTop = function (){
    var timer = setInterval(() => {
        var base = getScrollPos();
        if(base <= 1){
            clearInterval(timer);
        }
        document.documentElement.scrollTop = base - Math.pow(base,3/5);
    },10);
}

/*图片放大---------------------------*/

var clickCount = 0;

var picRespond = function (obj){
    clickCount = (clickCount + 1) % 2;
    switch (clickCount){
        case 0:
            obj.className = "itemMain_body_IMG_singleIMG";
            isActive = false;
            break;
        case 1:
            obj.className = "itemMain_body_IMG_singleIMG active";
            isActive = true;
            break;
        default:
            break;
    }
}


/*举报栏的添加------------------------------------------------*/
var count = 0;
var appendReport = function (obj){
    if(count === 1){
        return;
    }
    count++;
    var appendItem = $(obj);
    setTimeout(function (){
        // todo: add report info to database
        appendItem.append("<button class='reportBtn' onmouseleave='removeReport()'>举报</button>");
    },300);
}

var removeReport = function (){
    if(count === 0){
        return;
    }
    count--;
    $(".reportBtn").remove();
}
