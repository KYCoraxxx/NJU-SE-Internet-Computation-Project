

/*头部栏点击*/
var titleBtnSold = $(".manageMain_Title_Btn_sold");
var  titleBtnUnsold = $(".manageMain_Title_Btn_unsold");

var manageBodyUnsold = $(".manageMain_body_unsold");
var manageBodySold = $(".manageMain_body_sold");
var switchContent = function (type){
    switch (type) {
        case 1:
            manageBodyUnsold.css("margin-left","0");
            manageBodyUnsold.css("position","relative");
            manageBodySold.css("margin-left","100%");
            manageBodySold.css("position","absolute");
            titleBtnSold.css("color","darkgrey");
            titleBtnUnsold.css("color","black");
            break;
        case 2:
            manageBodyUnsold.css("margin-left","-100%");
            manageBodyUnsold.css("position","absolute");
            manageBodySold.css("margin-left","0");
            manageBodySold.css("position","relative");
            titleBtnSold.css("color","black");
            titleBtnUnsold.css("color","darkgrey");
            break
        default:
            break
    }
}

/*删除商品-----------------------------------------------------*/
var targetItem;
var targetPic;

var locateItem = function (obj){
    targetItem = $(obj);
    /*todo: how to locate the target picture???*/
    console.log("." + obj.className + ".manageMain_body_List_row_col_IMG" + " img");
}

var removeItem = function (){
    targetItem.remove();
}