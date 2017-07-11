$(document).ready(function () {
    $(document).on('click', '#addUserBtn', function () {
        let userInfo = {};
        $('#userInfo').serializeArray().forEach(function (item) {
            userInfo[item.name] = item.value;
        });
        $.ajax({
            type: "POST",
            url: userlist,
            data: JSON.stringify(userInfo),
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    });
    $('#birthdate').datetimepicker({
        minView: "month", //选择日期后，不会再跳转去选择时分秒
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        todayBtn: 1,
        autoclose: 1,
    });
});