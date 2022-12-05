var musicOpacity = 0;
var userID = 2;
var avatorScaler = function (size){
    $(".avator img").css("width", size);
    $(".avator img").css("height", size);
    if(size === "100px")
        appendDropDown();
    else
        deleteDropDown();
}
var deleteDropDown = function (){
    $(".userBox").css("height", "70px");
    $(".dropDown").remove();
}
var appendDropDown = function (){
    if($(".dropDown").length > 0)return;
    if(userID !== 0) {
        $.ajax({
                type: "post",
                url: "http://localhost/userService/getDropdown",
                data: {
                    "userId": userID
                },
                success: function (data) {
                    var dropDown = $("<div class='dropDown'></div>");
                    var userBox = $(".userBox");
                    userBox.css("height", "410px");
                    userBox.append(dropDown);
                    setTimeout(function () {
                        dropDown.append($("<div class='article-subtitle' style='height: 10%'>{{data.userName}}</div>"));
                        dropDown.append($("<div class='saying'>最怕你一生碌碌无为，还安慰自己平凡可贵</div>"));
                        dropDown.append($("<button class='dropDownBtn'><img src='/img/userCenter.png'/>个人中心</button>"));
                        dropDown.append($("<button class='dropDownBtn'><img src='/img/good.png'/>上架管理</button>"));
                        dropDown.append($("<button class='dropDownBtn'><img src='/img/exit.png'/>退出登录</button>"));
                    }, 300);
                }
            }
        );
    }
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
var changeMusic = function (){
    var music = $("#music");
    if(music.length === 0){
        $(".navBar").append($("<audio src='/music/ScarboroughFair.mp3' id='music' style='bottom: 0; position: absolute' controls></audio>"));
    }
    else{
        musicOpacity ^= 1;
        music.css("opacity", musicOpacity === 1 ? "1" : "0");
    }
}

var reg_error;
var log_error;
var postInfo = function (){
    if(cover === false){
        var usr = $("input[name='regusr']");
        var pwd = $("input[name='regpwd']");
        var enpwd = $("input[name='enspwd']");
        if(usr[0].value === "") {
            if(reg_error !== undefined)
                reg_error.remove();
            reg_error = $('<span>请输入用户名！</span>');
            usr.css("border-color", "red");
            pwd.css("border-color", "#25b3ff");
            enpwd.css("border-color", "#25b3ff");
        }
        else if(pwd[0].value === "") {
            if(reg_error !== undefined)
                reg_error.remove();
            reg_error = $('<span>请输入密码！</span>');
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "red");
            enpwd.css("border-color", "#25b3ff");
        }
        else if(enpwd[0].value === "") {
            if(reg_error !== undefined)
                reg_error.remove();
            reg_error = $('<span>请确认密码！</span>');
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "#25b3ff");
            enpwd.css("border-color", "red");
        }
        else if(pwd[0].value !== enpwd[0].value) {
            if(reg_error !== undefined)
                reg_error.remove();
            reg_error = $('<span>前后密码不一致！</span>');
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "red");
            enpwd.css("border-color", "red");
        }
        else {
            if(reg_error !== undefined) {
                reg_error.remove();
                reg_error = undefined;
            }
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "#25b3ff");
            enpwd.css("border-color", "#25b3ff");
            $.ajax({
                    type:"post",
                    url:"http://localhost/userService/addUser",
                    data:{
                        "inputName": usr[0].value,
                        "inputPwd":pwd[0].value
                    },
                    success: function(data)
                    {
                        alert(data.message);
                    }
                }
            )
        }
        if(reg_error !== undefined){
            reg_error.css({"color" : "red", "font-family" : "楷体", "font-size" : "15px"});
            reg_error.attr("id", "error");
            $(".register-form").append(reg_error);
        }
    }
    else{
        var user = $("input[name='logusr']");
        var password = $("input[name='logpwd']");
        if(user[0].value === ""){
            if(log_error !== undefined)
                log_error.remove();
            log_error = $('<span>请输入用户名！</span>');
            user.css("border-color", "red");
            password.css("border-color", "#25b3ff");
        }
        else if(password[0].value === ""){
            if(log_error !== undefined)
                log_error.remove();
            log_error = $('<span>请输入密码！</span>');
            user.css("border-color", "#25b3ff");
            password.css("border-color", "red");
        }
        else{
            if(log_error !== undefined) {
                log_error.remove();
                log_error = undefined;
            }
            user.css("border-color", "#25b3ff");
            password.css("border-color", "#25b3ff");
            $.ajax({
                    type:"post",
                    url:"http://localhost/userService/checkUser",
                    data:{
                        "inputName": user[0].value,
                        "inputPwd":password[0].value
                    },
                    success: function(data) {
                        if(data.isSucceed)
                        {
                            userID = data.id;
                            window.open("http://localhost/index");
                        }
                        alert(data.message);
                    }
                }
            );
        }
        if(log_error !== undefined){
            log_error.css({"color" : "red", "font-family" : "楷体", "font-size" : "15px"});
            log_error.attr("id", "error");
            $(".login-form").append(log_error);
        }
    }
}