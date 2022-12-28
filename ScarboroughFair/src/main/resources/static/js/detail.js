var server="http://110.42.252.167";
var goodName;
var goodTag;
var goodPrice;
var goodDescription;
var goodCover;
var goodPic;
var uploaderID;
var uploader;
var uploaderAvator;
var uploaderName;
var uploaderSaying;

var localHerf = location.href;
var targetIndex = localHerf.indexOf("=");
var goodId = parseInt(localHerf.substring(targetIndex + 1));
console.log(goodId);

$.ajax({
    type:"post",
    url: server + "/GoodService/findById",
    async: false,
    data:{
        "id": goodId
    },
    success: function(data) {
        console.log(data);
        goodName = data.name;
        goodTag = data.tag;
        goodPrice = data.price;
        goodDescription = data.description;
        goodCover = data.cover;
        goodPic = data.picture;
        uploaderID = data.userID;
        console.log(uploaderID);
        $(".goodName").append("<div class = 'goodName'>" + goodName + "</div>");
        $(".goodTag").append("<div class = 'goodTag'>" + goodTag + "</div>");
        $(".goodPrice").append("<div class = 'goodPrice'>" + goodPrice + "</div>");
        $(".goodCover").append("<img src = '" + goodCover + "'/>");
        $(".detailContent").append($("<div class = 'article-subtitle'>" + goodDescription + "</div>"));
    }
});
$.ajax({
    type:"post",
    url: server + "/userService/getData",
    async: false,
    data:{
        "page": "detail",
        "userID": "" + uploaderID
    },
    success: function(data) {
        console.log(data);
        uploaderSaying = data.saying;
        uploaderAvator = data.avator;
        uploaderName = data.userName;
        $(".saying").append(uploaderSaying);
        $(".providerSculp").append("<img src = '" + uploaderAvator + "'/>");
        $(".providerName").append(uploaderName);
    }
})
/*
$(".goodName").append(goodName);
$(".goodTag").append(goodTag);
$(".goodPrice").append(goodPrice);
$(".goodCover img").prop("src", server + goodCover);
$(".detailContent").append($("<div class = 'article-subtitle'>" + goodDescription + "</div>"));
*/
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
        detailContent.append($("<div class = 'article-subtitle'>" + goodDescription + "</div>"));
    }
    else if(type === 2){
        detailContent.append("<img src = '" + goodPic + "'/>");
    }
}