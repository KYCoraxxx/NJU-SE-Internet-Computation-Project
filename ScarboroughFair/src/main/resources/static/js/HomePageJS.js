

var navCount = 0;

var showNav = function (){// control the nav bar
    navCount = (navCount + 1) % 2;
    var leftCol = $(".leftCol");
    var rightCol = $(".rightCol");
    leftCol.css("transition","0.6s ease-in-out")
    if(navCount === 0){
        leftCol.css("width","20%");
        rightCol.css("width","78%");
        rightCol.css("margin-left","21%")
    }else {
        leftCol.css("width","0%");
        rightCol.css("width","98%");
        rightCol.css("margin-left","1%")
    }
}

var showClientInfo = function (flag){
    var portImg = $(".portImg")
    var clientInfo = $(".clientIfo")
    if(flag === 0){
        portImg.css("margin-left","-200px");
        clientInfo.css("opacity","1");
        clientInfo.css("visibility","visible");
    }
    else {
        portImg.css("margin-left","0");
        clientInfo.css("opacity","0");
        clientInfo.css("visibility","hidden");
    }
}

window.onscroll = function (){
    var scrollPos = 0
    if(document.documentElement&&document.documentElement.scrollTop){
        scrollPos = document.documentElement.scrollTop;
    }else if(document.body) {
        scrollPos = document.body.scrollTop;
    }
    console.log(scrollPos);
    var leftCol = $(".leftCol");
    if(scrollPos >= 200){
        leftCol.css("transition","0s");
        leftCol.css("position","fixed");
        leftCol.css("margin-top","-120px")
    }
    else {
        leftCol.css("transition","0s");
        leftCol.css("position","absolute");
        leftCol.css("margin-top","0px")
    }
}