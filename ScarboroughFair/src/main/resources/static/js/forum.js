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
var inCount = 0;
var outCount = 0;

var appendReport = function (obj){
    if(inCount === 1){
        return;
    }
    inCount++;
    var appendItem = $(obj);
    setTimeout(function (){
        // todo: add report info to database
        appendItem.append("<button class='reportBtn' onmouseleave='removeReport()'>举报</button>");
    },300);
}

var removeReport = function (){
    outCount = (outCount + 1) % 2;
    if(inCount === 0){
        return;
    }
    if(outCount === 0) {
        inCount--;
        $(".reportBtn").remove();
    }
}


// renew forumList here
var renewCount = 0;
var forumList = $(".forumList");
var alreadyUploadIndex = 0;
var renewLock = 0;
var totalForum = -1;




var uploadForum = function(){
    $.ajax({
        type:"post",
        url: server + "/ForumService/findAll",
        async: false,
        data:{
        },
        success: function(data) {
            if(totalForum === -1){
                for(var i in data){
                    totalForum++;
                }
            }
            var start = alreadyUploadIndex;
            for(i = start;i < start + 1 && i <= totalForum;i++){
                var targetUser = upLoadUserById(data[i].postUserID);
                forumList.append(
                    "<div class=\"forumItem\" id=\"forumItem" + i + "\"> \
    <div class=\"itemMain\"> \
        <div class=\"itemMain_header\"> \
            <div class=\"itemMain_header_IMG\"> \
                <!--todo: add link to personal page here--> \
                <a href=\"#\" target=\"_blank\"><img src=\""+ (targetUser.avator) + "\" style=\"width: 50px;height: 50px; border-radius: 50%;\"></a> \
            </div> \
            <div class=\"itemMain_header_details\"> \
                <div class=\"itemMain_header_details_name\">"+ (targetUser.userName)  +"</div> \
                <div class=\"itemMain_header_details_date\">Published On "+  (data[i].PostTime)  +"</div> \
            </div> \
            <div class=\"itemMain_header_report\" onmouseover=\"appendReport(this)\" onmouseleave=\"removeReport()\"> \
                <img src=\"/img/ellipsisVertical.png\" style=\"width: 30px;height: 30px;margin-top: 10px;\"> \
            </div> \
        </div> \
        <div class=\"itemMain_body\"> \
            <div class=\"itemMain_body_content\">"+ (data[i].content) +"</div> \
            <div class=\"itemMain_body_IMG\" id='itemMain_body_IMG"+ i +"'> \
                <!--todo:add an index to every item to ease the clearAll function--> \
            </div> \
        </div> \
        <div class=\"itemMainFooter\"> \
            <!--todo:This place should link with actual data--> \
            <div class=\"itemMainFooter_share\"> \
                <img src=\"/img/shareInForum.png\" style=\"width: 30px; height: 30px;\"> \
                <div class=\"itemMainFooter_share_data\">1</div> \
            </div> \
            <div class=\"itemMainFooter_comment\"> \
                <img src=\"/img/commentInForum.png\" style=\"width: 30px; height: 30px;\"> \
                <div class=\"itemMainFooter_comment_data\">"+ (data[i].commentsId.length) +"</div> \
            </div> \
            <div class=\"itemMainFooter_like\"> \
                <img src=\"/img/likeInForum.png\" style=\"width: 30px; height: 30px;\"> \
                <div class=\"itemMainFooter_like_data\">"+ (data[i].starNum) +"</div> \
            </div> \
        </div> \
        <hr style=\"width: 80%; margin-left: 10%;\"> \
    </div> \
    <div class=\"itemCritics\"> \
        <div class=\"itemCritics_Form\" action=\"#\" method=\"post\"> \
            <div class=\"itemCritics_Form_user\"><img src=\"/img/defaultUser.png\" style=\"width:50px;height: 50px\"></div> \
            <!--todo:add an index to every item to ease the clearAll function--> \
            <textarea name=\"itemCriticsForm\" id=\"itemCriticsForm" + data[i].id + "\"  rows=\"4\" placeholder=\"灌下你的水\" minlength=\"1\" maxlength=\"80\" ></textarea> \
            <button class=\"commentSubmit\" type=\"submit\" onclick='uploadComment(" + data[i].id + "," + i + ")'>灌水</button> \
        </div> \
        <div class=\"itemCritics_critics\"> \
            <hr style=\"width: 72%;margin-left: 18%;\"> \
            <!--todo:grab latest remarks--> \
            <div class=\"itemCritics_criticsList\" id='itemCritics_criticsList" + i + "'> \
            </div> \
        </div> \
    </div> \
</div>");
                var imgUpload = $("#itemMain_body_IMG" + i);// upload imgs
                for(var j = 0;j < data[i].imgUrl.length;j++){
                    imgUpload.append("<img class=\"itemMain_body_IMG_singleIMG\" src=\""+ (data[i].imgUrl[j]) +"\" onclick=\"picRespond(this)\" >");
                }
                uploadCrictics(data[i].id,i);
                alreadyUploadIndex++;
            }
        }
    });
    renewLock = 0;
    $(".renewIcon").remove();
    return 0;
}

var upLoadUserById = function(targetId){
    var result;
    $.ajax({
        type:"post",
        url: server + "/userService/getData",
        async: false,
        data:{
            "page": "forum",
            "userID": targetId
        },
        success: function(data) {
            result = data;
        }
    })
    return result;
}

var alreadyUploadCritics = [];
var totalCricticOfEachPost = [];

var uploadCrictics = function(targetId,index){
    $.ajax({
        type:"post",
        url: server + "/ForumService/findCommentById",
        async: false,
        data:{
            "id":24,
        },
        success: function(data) {
            console.log(targetId);

            console.log(data);

            var cirtics;
            if(alreadyUploadCritics.length <= index){// initialize the size of each post's critic
                alreadyUploadCritics.push(0);
                totalCricticOfEachPost[index] = -1;
                for(var i in data){
                    totalCricticOfEachPost[index]++;
                }
            }
            var targetList = $("#itemCritics_criticsList"+index);
            var start = alreadyUploadCritics[index];
            for(var i = start;i < start + 2 && i <= totalCricticOfEachPost[index];i++){
                var targetUser = upLoadUserById(data[i].CommentUserID);
                targetList.append("<div class=\"itemCritics_criticsList_item\"> \
                <div class=\"itemCritics_criticsList_item_user\"> \
                    <a href=\"#\" target=\"_blank\"><img src=\""+ (targetUser.avator) +"\" style=\"width: 40px;height: 40px;\"></a> \
                </div> \
                <div class=\"itemCritics_criticsList_item_details\"> \
                    <div class=\"itemCritics_criticsList_item_name\">" + (targetUser.userName) + "</div> \
                    <div class=\"itemCritics_criticsList_item_content\">"+ (data[i].content) +"</div> \
                    <div class=\"itemCritics_criticsList_item_foot\"> \
                        <div class=\"itemCritics_criticsList_item_foot_time\">Published on "+ (data[i].CommentTime) +"</div> \
                        <div class=\"itemCritics_criticsList_item_foot_like\"> \
                            <img src=\"/img/likeInCritic.png\" style=\"width: 15px; height: 15px; margin-right: 15px;margin-top: 5px\"> \
                            <div class=\"itemCritics_criticsList_item_foot_like_data\">"+ (data[i].starNum) +"</div> \
                        </div> \
                        <div class=\"itemCritics_criticsList_item_foot_report\" onmouseover=\"appendReport(this)\" > \
                            <img src=\"/img/ellipsisVertical.png\" style=\"width: 20px; height: 20px; margin-top: 5px\"> \
                        </div> \
                    </div> \
                    <hr style=\"width: 90%; margin-left: -2%;\"> \
                </div> \
            </div>");
            alreadyUploadCritics[index]++;
            }
            if(alreadyUploadCritics[index] < totalCricticOfEachPost[index]){
                targetList.append("<div class='criticRenewIcon' style=\"display: flex;flex-direction: row; justify-content: space-around;alignment: center;margin-bottom:15px\"><img src='/img/renewIcon.png' width='30px' height='30px' onclick='clickRenewCritcis("+ index +")'></div>");
            }
            else{
                targetList.append("<div class='criticRenewIcon' style='font-size=10px;display: flex;flex-direction: row; justify-content: space-around;alignment: center;margin-bottom:15px'>已经到底了QWQ</div>");
            }
        }
    })
}

var clickRenewCritcis = function(index){// todo connect with postId
    var targetList = $("#itemCritics_criticsList"+index);
    $(".criticRenewIcon").remove();
    uploadCrictics(index);
}

if(renewCount === 0){
    if($.cookie("userID") === undefined)
        window.location.replace(server + "/login");
    else{
        renewLock = 1;
        setTimeout(uploadForum,1000);
        forumList.append("<div class='renewIcon' style=\"display: flex;flex-direction: row; justify-content: space-around;alignment: center;margin-bottom:15px;margin-top:15px;\"><img src='/img/renewIcon.png' width='40px' height='40px'></div>");
    }
    renewCount++;
}

window.onscroll = function (){
    var scrollPos = getScrollPos();
    var scrollHeight = getScrollHeight();
    var windowHeight = getWindowHeight();
    if(scrollPos + windowHeight + 1 >= scrollHeight && renewLock === 0){
        renewLock = 1;
        // this would invoke the renew function
        setTimeout(uploadForum,1000);
        forumList.append("<div class='renewIcon' style=\"display: flex;flex-direction: row; justify-content: space-around;alignment: center;margin-bottom:15px;margin-top:15px;\"><img src='/img/renewIcon.png' width='40px' height='40px'></div>");
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

//评论上传

var uploadComment = function(tag,index){
    var formData = new FormData();
    var comment = $("#itemCriticsForm" + tag)[0];
    formData.append("comment",comment.value);
    formData.append("postid",tag);
    formData.append("userid", $.cookie("userID"));
    console.log(tag);
    $.ajax({
        type: "POST",
        url: server + "/ForumService/CommentPost",
        data: formData,
        async: false,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data){
            if(data.isSucceed) {
                alert(data.message);
            }
        }
    });
    uploadCrictics(tag,index);
}

