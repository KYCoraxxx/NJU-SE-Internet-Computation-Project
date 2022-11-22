let cover = true;
var reg_error;
var log_error;
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
            $.post('js/data.json', function (data){
                let userExist = false;
                for(var i in data){
                    if(data[i].username === user[0].value){
                        userExist = true;
                        alert("主人重名了啦……(；′⌒`)");
                        break;
                    }
                }
                if(!userExist)
                    alert("欢迎来到新世界o(*￣▽￣*)ブ");
            });
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
            $.post('js/data.json', function (data){
                let userExist = false;
                for(var i in data){
                    if(data[i].username === user[0].value){
                        userExist = true;
                        if(data[i].password === password[0].value)
                            alert("欢迎主人回家！o(*￣▽￣*)ブ");
                        else
                            alert("咒语记错了啦……┭┮﹏┭┮");
                        break;
                    }
                }
                if(!userExist)
                    alert("你真的是这个世界的人嘛(・∀・(・∀・(・∀・*)");
            });
        }
        if(log_error !== undefined){
            log_error.css({"color" : "red", "font-family" : "楷体", "font-size" : "15px"});
            log_error.attr("id", "error");
            $(".login-form").append(log_error);
        }
    }
}
