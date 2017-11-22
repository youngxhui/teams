/***************************************
 由于Chrome、IOS10等已不再支持非安全域的浏览器定位请求，为保证定位成功率和精度，请尽快升级您的站点到HTTPS。
 ***************************************/
var map, geolocation, j, w;

//加载地图，调用浏览器定位服务
map = new AMap.Map('container', {
    resizeEnable: false
});

map.plugin('AMap.Geolocation', function () {
    geolocation = new AMap.Geolocation({
        enableHighAccuracy: true,//是否使用高精度定位，默认:true
        timeout: 10000,          //超过10秒后停止定位，默认：无穷大
        buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
        zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
        buttonPosition: 'RB'
    });
    map.addControl(geolocation);
    geolocation.getCurrentPosition();
    AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
    AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息

});

//解析定位结果
function onComplete(data) {
    var str = ['定位成功'];
//        str.push('经度：' + data.position.getLng());
    j = data.position.getLng();
    w = data.position.getLat();
    document.getElementById("j").innerHTML = j;
    document.getElementById("w").innerHTML = w;
    console.log(j);
    console.log(w);
}

//解析定位错误信息
function onError(data) {
    document.getElementById('tip').innerHTML = '定位失败';
}


$('#btn').click(function () {
    var Jtext = $('#j').html();
    var Wtext = $('#w').html();
    $('#longitude').val(Jtext);
    $('#latitude').val(Wtext);
});