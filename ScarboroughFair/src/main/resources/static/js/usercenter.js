if(userAvator !== "null")
    $("#avator").prop("src", server + userAvator);
var displayNewAvator = function (node){
    var reader = new FileReader();
    var file = node.files[0];
    reader.readAsDataURL(file);
    reader.onload = function (){
        $("#avator").prop("src", this.result);
    }
}
var getUserID = function (){
    $("#getUserID").prop("value", $.cookie("userID"));
}
getUserID();