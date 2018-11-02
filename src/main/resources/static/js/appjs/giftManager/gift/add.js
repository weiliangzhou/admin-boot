$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/gift/save",
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
            giftMainTitle: {
                required: true
            },
            giftViceTitle: {
                required: true
            },
            buyCount: {
                required: true
            },
            minRequirement: {
                required: true
            },
            giftMainImg: {
                required: true
            },
            giftShareBack:{
                required: true
            },
            price: {
                required: true
            },
            expressFee: {
                required: true
            },
            stock: {
                required: true
            }
        },
        messages: {
            giftMainTitle: {
                required: icon + "请输入主标题"
            },
            giftViceTitle: {
                required: icon + "请输入副标题"
            },
            buyCount: {
                required: icon + "请输入销量"
            },
            minRequirement: {
                required: icon + "请输入购买最低要求"
            },
            giftMainImg: {
                required: icon + "请输入产品主图"
            },
            giftShareBack:{
                required: icon + "请输入产品背景图"
            },
            price: {
                required: icon + "请输入产品价格"
            },
            expressFee: {
                required: icon + "请输入快递费"
            },
            stock: {
                required: icon + "请输入库存"
            }
        }
    });
}

layui.use('upload', function () {
    var $ = layui.jquery, upload = layui.upload;
    //上传图片
    upload.render({
        elem: '#giftMainImgBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#giftMainImgShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#giftMainImg').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传图片
    upload.render({
        elem: '#giftViceImg1Btn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#giftViceImg1Show').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#giftViceImg1').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传图片
    upload.render({
        elem: '#giftViceImg2Btn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#giftViceImg2Show').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#giftViceImg2').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传图片
    upload.render({
        elem: '#giftViceImg3Btn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#giftViceImg3Show').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#giftViceImg3').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传图片
    upload.render({
        elem: '#giftShareBackBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#giftShareBackShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#giftShareBack').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
});

layui.use('layedit', function () {
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/file/upload/' //接口url
            , type: 'post' //默认post
        }
    });
    var giftDesc = layedit.build('giftDesc'); //建立编辑器

});