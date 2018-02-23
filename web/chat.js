/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#send").click(function () {
        $.get("chatServlet?msg=" + $("#message").val(), ajaxCallBack);
    });
    $("#message").text(" ");

});

function ajaxCallBack(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {
        alert(responseTxt);
    } else {
        alert("Error: " + xhr.status + ": " + xhr.statusText);
    }

}
setInterval(receiveMessages, 10000);
function receiveMessages()
{
    $.post("chatServlet", {}, callback, "json");

}

function callback(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {
        $("#msg tr").remove();
        for (var i in responseTxt) {
            $("#msg").append("<tr><td>" + responseTxt[i].name + "</td>" + "<td>" + responseTxt[i].message + "</td></tr>");
        }
    } else {
        alert("Error: " + xhr.status + ": " + xhr.statusText);
    }

}
setInterval(getUsers, 10000);
function getUsers()
{
    $.get("CurrentSession", {}, callback_2, "json");

}
function callback_2(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {
        $("#onlineusers tr").remove();
        for (var i in responseTxt) {
            $("#onlineusers").append("<tr align='center'><td>" + responseTxt[i].Name + "</td></tr>");
        }
    }
    else{
      alert("Error: " + xhr.status + ": " + xhr.statusText);
    }
}

