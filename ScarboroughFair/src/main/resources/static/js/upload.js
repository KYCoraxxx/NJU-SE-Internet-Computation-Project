var upl_error;
//todo: 未上传封面时的处理
var postUploadInfo = function(){
    var name = $("input[name='name']");
    var tag = $("input[name='tag']");
    var price = $("input[name='price']");
    var description = $("input[name='description']");
    if (name[0].value === ""){
        if (upl_error !== undefined)
            upl_error.remove();
        upl_error = $('<span>这篇大地的商品并非不需要被命名</span>');
        name.css("border-color", "red");
        tag.css("border-color", "mediumpurple");
        price.css("border-color", "mediumpurple");
        description.css("border-color", "mediumpurple");
    }
    else if (tag[0].value === ""){
        if (upl_error !== undefined)
            upl_error.remove();
        upl_error = $('<span>这篇大地的商品并非不需要被分类</span>');
        name.css("border-color", "mediumpurple");
        tag.css("border-color", "red");
        price.css("border-color", "mediumpurple");
        description.css("border-color", "mediumpurple");
    }
    else if (price[0].value === ""){
        if (upl_error !== undefined)
            upl_error.remove();
        upl_error = $('<span>这篇大地的商品并非不需要被标价</span>');
        name.css("border-color", "mediumpurple");
        tag.css("border-color", "mediumpurple");
        price.css("border-color", "red");
        description.css("border-color", "mediumpurple");
    }
    else if (description[0].value === ""){
        if (upl_error !== undefined)
            upl_error.remove();
        upl_error = $('<span>这篇大地的商品并非不需要被描述</span>');
        name.css("border-color", "mediumpurple");
        tag.css("border-color", "mediumpurple");
        price.css("border-color", "mediumpurple");
        description.css("border-color", "red");
    }
    else {
        if (upl_error !== undefined){
            upl_error.remove();
            upl_error = undefined;
        }
        name.css("border-color", "mediumpurple");
        tag.css("border-color", "mediumpurple");
        price.css("border-color", "mediumpurple");
        description.css("border-color", "mediumpurple");
    }
    if (upl_error !== undefined){
        upl_error.css({"color" : "red", "font-family" : "楷体", "font-size" : "15px"});
        upl_error.attr("id", "error");
        $(".uploadBar").append(upl_error);
    }
}

//todo: 获取封面和图片