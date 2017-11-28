<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2017/11/22
  Time: 20:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <script src="js/jquery-2.0.3.min.js"></script>
</head>
<body>
<jsp:include page="common/nav.jsp"/>


<video id="video" width="320px" height="320px" autoplay></video>
<button id="picture" style="display:block">拍照</button>
<canvas id="canvas" width="320px" height="320px"></canvas>
<button id="sc" style="display:block">上传</button>

<script>
    navigator.getUserMedia = navigator.getUserMedia ||
        navigator.webkitGetUserMedia ||
        navigator.mozGetUserMedia;
    if (navigator.getUserMedia) {
        navigator.getUserMedia({audio: true, video: {width: 320, height: 320}},
            function (stream) {
                var video = document.getElementById("video");
                video.src = window.URL.createObjectURL(stream);
                video.onloadedmetadata = function (e) {
                    console.log('nihao44eee4aaaaddda');
                    video.play();
                };
            },
            function (err) {
                console.log("The following error occurred: " + err.name);
            }
        );
    } else {
        console.log("getUserMedia not supported");
    }
    var context = document.getElementById("canvas").getContext("2d");
    document.getElementById("picture").addEventListener("click", function () {
        context.drawImage(video, 0, 0, 320, 320);
    });
    document.getElementById("sc").addEventListener("click", function () {
        var imgData = document.getElementById("canvas").toDataURL("image/png");
        var data = imgData.substr(22);
        $.post('faceLogin', {'pic': data});
    });
</script>
</body>

</html>
