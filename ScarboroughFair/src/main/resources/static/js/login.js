let cover = true;
var changePicture = function(flag){
    if(flag === 0)
        $("img").attr("src", "/img/psw.jpg");
    else
        $("img").attr("src", "/img/usr.jpg");
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
