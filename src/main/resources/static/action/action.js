(function(){
    $.action = function(url, params, callback){
        $.ajax({
            url: url,
            type: 'POST',
            data: params,
            dataType: 'json',
            contentType: 'application/json',
            success: function (res) {
                callback(res);
            },
            error: function () {
                console.log('Ajax请求失败！');
            }
        });
    }
})($);