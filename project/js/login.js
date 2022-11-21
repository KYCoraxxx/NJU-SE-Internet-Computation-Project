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
var matchPwd = function (){
    if(cover === false){
        var pwd = $("input[name='regpwd']")[0].value;
        var enpwd = $("input[name='enspwd']")[0].value;
        if(pwd !== enpwd){
            error = $('<span>前后密码不一致！</span>');
            error.css({"color" : "red", "font-family" : "楷体", "font-size" : "15px"});
            error.attr("id", "dismatch");
            $(".register-form").append(error);
        }
        else{
            if(error !== undefined)
                error.remove();
        }
    }
}
