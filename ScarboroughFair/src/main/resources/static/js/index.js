var imgScaler = function (size){
    $(".avator img").css("width", size);
    $(".avator img").css("height", size);
    if(size === "100px")
        appendDropDown();
    else
        deleteDropDown();
}
var deleteDropDown = function (){
    $(".dropDown").css("opacity", "0");
}
var appendDropDown = function (){
    var dropDown = $(".dropDown");
    dropDown.css("opacity", "1");
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
//
//
// /*左侧栏隐藏-----------------------------------------------------------------------------*/
// var navCount = 0;
// var showNav = function (){// control the nav bar
//     navCount = (navCount + 1) % 2;
//     var leftCol = $(".leftCol");
//     var rightCol = $(".rightCol");
//     var leftList = $(".leftList");
//     var navOpener = $(".navButt");
//     leftCol.css("transition","0.6s ease-in-out")
//     if(navCount === 0){
//         leftCol.css("width","20%");
//         rightCol.css("width","78%");
//         rightCol.css("margin-left","21%");
//         leftList.css("opacity","1");
//         setTimeout(function (){leftList.css("display","block")},500);
//
//     }else {
//         leftCol.css("width","0%");
//         rightCol.css("width","98%");
//         rightCol.css("margin-left","1%");
//         leftList.css("opacity","0");
//         setTimeout(function (){leftList.css("display","none")},500);
//     }
// }
// /*用户信息显示---------------------------------------------------------------------*/
// var showClientInfo = function (flag){
//     var portImg = $(".portImg")
//     var clientInfo = $(".clientIfo")
//     if(flag === 0){
//         portImg.css("margin-left","-200%");
//         clientInfo.css("opacity","1");
//         clientInfo.css("visibility","visible");
//     }
//     else {
//         portImg.css("margin-left","0");
//         clientInfo.css("opacity","0");
//         clientInfo.css("visibility","hidden");
//     }
// }
// /*左侧栏固定-----------------------------------------------------------------------*/
// window.onscroll = function (){
//     var scrollPos;
//     if(document.documentElement&&document.documentElement.scrollTop){
//         scrollPos = document.documentElement.scrollTop;
//     }else if(document.body) {
//         scrollPos = document.body.scrollTop;
//     }
//     var leftCol = $(".leftCol");
//     if(scrollPos >= 200){
//         leftCol.css("transition","0s");
//         leftCol.css("position","fixed");
//         leftCol.css("margin-top","-120px")
//     }
//     else {
//         leftCol.css("transition","0s");
//         leftCol.css("position","absolute");
//         leftCol.css("margin-top","0px")
//     }
//     /*This place should get the goods' number to decide whether to expand the good layer or not------------------------------------*/
//     var pageDown = $(".pageDown");
//     var pageEnd = $(".pageEnd");
//     var rightCol = $(".rightCol")
//     var expandTime = 0;
//     if(scrollPos + document.documentElement.clientHeight >= document.documentElement.scrollHeight){
//         expandTime++;
//         if(expandTime < 1){
//             rightCol.css("height","3000px")
//         }
//         else {
//             pageDown.css("opacity","0");
//             pageEnd.css("opacity","1");
//         }
//     }
//     else {
//         pageDown.css("opacity","1");
//         pageEnd.css("opacity","0");
//     }
// }
//
/*轮播图-----------------------------------------------------------------------------*/

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
    items[index].className = "loopItem active";
    items[getNext()].className = "loopItem next";
    items[getPre()].className = "loopItem pre";
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

function play(){
    timer = setInterval(() => {
        time++;
        if(time === 20){
            rightSwitch();
            time = 0;
        }
    },100);
}

play();

loop.onmouseover = function (){
    clearInterval(timer);
}

loop.onmouseleave = function (){
    play();
}


// /*分类栏运动*/
//
// var cateLeftSide = 0;
// var cateList = $(".cateList:nth-child(1)");
// var cateLeftBtn = $(".leftCateBtn");
// var cateRightBtn = $(".rightCateBtn");
//
// var cateLeftMove = function (){
//     if(cateLeftSide > 0){
//         cateLeftSide--;
//         cateList.css("margin-left",-cateLeftSide * 20 + "%");
//         cateRightBtn.css("opacity","1");
//     }
//     if(cateLeftSide === 0){
//         cateLeftBtn.css("opacity","0");
//     }
// }
//
// var cateRightMove = function (){
//     if(cateLeftSide < 4){
//         cateLeftSide++;
//         cateList.css("margin-left",-cateLeftSide * 20 + "%");
//         cateLeftBtn.css("opacity","1");
//     }
//     if(cateLeftSide === 4){
//         cateRightBtn.css("opacity","0");
//     }
// }
//
// /*商品栏变化----------------------------------------------------------------------------*/
//
// var goodItemChangeStatus = function (flag){
//     var goodItem = $(this);
//     if(flag === 1) {
//         this.css("background-color", "black");
//     } else {
//         this.css("background-color", "darkslateblue");
//     }
// }
//
