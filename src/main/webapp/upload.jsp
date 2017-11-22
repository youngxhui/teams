<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>文件上传</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<jsp:include page="common/nav.jsp"/>

<div class="container kv-main">
    <br>
    <form enctype="multipart/form-data" method="post">
        <div class="form-group">
            <input type="text" value="${sessionScope.userInfo.uid}" name="uid" hidden>
            <select class="form-control" name="type" id="select">
                <option value="0">公开</option>
                <option value="1">私有</option>
            </select>
        </div>
        <div class="form-group">
            <input id="upload" type="file" multiple class="file" data-overwrite-initial="true"
                   name="upload" data-min-file-count="1">
        </div>
    </form>
</div>

<footer class="footer">
    <div class="container">
        <span class="text-muted">Github仓库</span> <br>
        <span class="text-muted">本代码受开源GPL-3.0开源协议保护</span>
    </div>
</footer>
</body>

<script src="js/fileinput_locale_zh.js"></script>
<script>
    $("#upload").fileinput({
        language: "zh",//配置语言
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        initialCaption: "请选择上传素材",
        uploadUrl: 'uploadfiles.action',
        allowedFileExtensions: ['jpg', 'png', 'gif', 'py', 'pdf', 'doc', 'docx', 'ppt', 'pptx', 'json', 'css','md','xls','xlsx'],
        overwriteInitial: false,
        showCaption: false,//是否显示标题
        maxFileSize: 100000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        },
        uploadExtraData: {
            "uid": '${sessionScope.userInfo.uid}',
            "type": $('#select').find('option:selected').val()
        }
    });
    //    上传文件成功，回调函数
    $('#upload').on("filebatchuploadsuccess", function (event, data, previewId, index) {
        var result = data.response; //后台返回的json
        var json = JSON.stringify(result);
        var obj = jQuery.parseJSON(json);
        if (obj.code !== "200") {
        }
    });


</script>
</html>