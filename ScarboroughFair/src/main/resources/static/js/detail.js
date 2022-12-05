var changeProviderName = function (state){
    if (state === 0)
        $(".providerName").css("color", "#000000");
    else if (state === 1)
        $(".providerName").css("color", "lightskyblue");
}

var showDetailContent = function(type){
    $(".detailContent").remove();
    var detailContent = $("<div class = 'detailContent'></div>")
    var goodDetail = $(".goodDetail")
    goodDetail.append(detailContent);
    if (type === 1){
        detailContent.append($("<div class = 'article-subtitle'>原产地：null</div>"));
        detailContent.append($("<div class = 'article-subtitle'>保质期：null</div>"));
        detailContent.append($("<div class = 'article-subtitle'>用途：null</div>"));
    }
    else if(type === 2){
        detailContent.append($("<img src = '../static/img/demo5.jpg'/>"));
        detailContent.append($("<img src = '../static/img/demo5.jpg'/>"));
    }
}