var changeProviderLink = function (state){
    if (state === 0)
        $(".goodProviderLink").css("color", "#000000");
    else if (state === 1)
        $(".goodProviderLink").css("color", "lightskyblue");
}