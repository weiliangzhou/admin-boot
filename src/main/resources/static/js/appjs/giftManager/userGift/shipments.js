$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        shipments();
    }
});

function shipments() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/userGift/shipments",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            expressCompany: {
                required: true
            },
            expressNo: {
                required: true
            }
        },
        messages: {
            expressCompany: {
                required: "请选择快递公司"
            },
            expressNo: {
                required: "请输入快递单号"
            }
        }
    })
}