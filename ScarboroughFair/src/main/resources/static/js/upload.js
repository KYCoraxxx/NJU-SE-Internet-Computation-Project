var upl_error;
//todo: 未上传封面时的处理
var postUploadInfo = function(){
    var name = $("input[name='name']");
    var tag = $("input[name='tag']");
    var price = $("input[name='price']");
    var description = $("input[name='description']");
    var cover = $("#upl_cover")[0].files[0];
    var pic = $("#upl_pic")[0].files[0];
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
    else if (cover === null){
        if (upl_error !== undefined)
            upl_error.remove();
        upl_error = $('<span>这篇大地的商品并非不需要被展示</span>');
        name.css("border-color", "mediumpurple");
        tag.css("border-color", "mediumpurple");
        price.css("border-color", "mediumpurple");
        description.css("border-color", "mediumpurple");
    }
    else if (pic === null){
        if (upl_error !== undefined)
            upl_error.remove();
        upl_error = $('<span>这篇大地的商品并非不需要被展示</span>');
        name.css("border-color", "mediumpurple");
        tag.css("border-color", "mediumpurple");
        price.css("border-color", "mediumpurple");
        description.css("border-color", "mediumpurple");
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
    else{
        uploadGoodInfo();
    }
}

var displayNewCover = function(node){
    var reader = new FileReader();
    var file = node.files[0];
    reader.readAsDataURL(file);
    reader.onload = function (){
        $("#cover").prop("src", this.result);
    }
}
var displayNewPic = function(node){
    var reader = new FileReader();
    var file = node.files[0];
    reader.readAsDataURL(file);
    reader.onload = function (){
        $("#pic").prop("src", this.result);
    }
}
var uploadGoodInfo = function (){
    var formData = new FormData();
    var name = $("input[name='name']")[0];
    var tag = $("input[name='tag']")[0];
    var price = $("input[name='price']")[0];
    var description = $("input[name='description']")[0];
    var cover = $("#upl_cover")[0].files[0];
    var pic = $("#upl_pic")[0].files[0];
    formData.append("name", name.value);
    formData.append("tag", tag.value);
    formData.append("price", price.value);
    formData.append("cover", cover);
    formData.append("pic", pic);
    formData.append("description", description.value);
    
    
    $.ajax({
        type: "POST",
        url: server + "/GoodService/addGood", 
        data: formData,
        async: false,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data){
            if(data.isSucceed) {
                alert(data.message);
                window.location.replace("/index");
            }
        }
    });
}