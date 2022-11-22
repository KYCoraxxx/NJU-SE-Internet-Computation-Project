let cover = true;
var error;
var changePicture = function(flag){
    if(flag === 0)
        $("img").attr("src", "img/psw.jpg");
    else
        $("img").attr("src", "img/usr.jpg");
}
var moveBlock = function(){
    if(cover === true){
        $(".cover-box").css("margin-left", "0");
        $("#change").attr("value", "直接来罢>_<");
        cover = false;
    }
    else{
        $(".cover-box").css("margin-left", "30%");
        $("#change").attr("value", "注个册先('◡')");
        cover = true;
    }
}
var postInfo = function (){
    if(cover === false){
        var usr = $("input[name='regusr']");
        var pwd = $("input[name='regpwd']");
        var enpwd = $("input[name='enspwd']");
        if(usr[0].value === "") {
            if(error !== undefined)
                error.remove();
            error = $('<span>请输入用户名！</span>');
            usr.css("border-color", "red");
            pwd.css("border-color", "#25b3ff");
            enpwd.css("border-color", "#25b3ff");
        }
        else if(pwd[0].value === "") {
            if(error !== undefined)
                error.remove();
            error = $('<span>请输入密码！</span>');
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "red");
            enpwd.css("border-color", "#25b3ff");
        }
        else if(enpwd[0].value === "") {
            if(error !== undefined)
                error.remove();
            error = $('<span>请确认密码！</span>');
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "#25b3ff");
            enpwd.css("border-color", "red");
        }
        else if(pwd[0].value !== enpwd[0].value) {
            if(error !== undefined)
                error.remove();
            error = $('<span>前后密码不一致！</span>');
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "red");
            enpwd.css("border-color", "red");
        }
        else {
            if(error !== undefined) {
                error.remove();
                error = undefined;
            }
            usr.css("border-color", "#25b3ff");
            pwd.css("border-color", "#25b3ff");
            enpwd.css("border-color", "#25b3ff");
        }
        if(error !== undefined){
            error.css({"color" : "red", "font-family" : "楷体", "font-size" : "15px"});
            error.attr("id", "error");
            $(".register-form").append(error);
        }
    }
}
