var server = "http://localhost";
var goodName;
var goodTag;
var goodPrice;
var goodDescription;
var goodCover;
var goodPic;

var localHerf = location.href;
var targetIndex = localHerf.indexOf("=");
var goodId = parseInt(localHerf.substring(targetIndex + 1));
console.log(goodId);

$.ajax({
    type:"post",
    url: server + "/GoodService/findById", // todo: check the url
    async: false,
    data:{
        "id": goodId
    },
    success: function(data) {
        goodName = data.name;
        goodTag = data.tag;
        goodPrice = data.price;
        goodDescription = data.description;
        goodCover = data.cover;
        goodPic = data.pic;
    }
});

$(".goodName").append(goodName);
$(".goodTag").append(goodTag);
$(".goodPrice").append(goodPrice);
$(".goodCover img").prop("src", server + goodCover);
$(".detailContent").append($("<div class = 'article-subtitle'>" + goodDescription + "</div>"));

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
        $(".detailContent img").prop("src", server + goodPic);
        detailContent.append($("<img/>"));
    }
}