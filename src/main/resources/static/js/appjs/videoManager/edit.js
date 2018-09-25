$().ready(function () {
    validateRule();
    //回显视频封面
    // $('#information_video_img').attr('src', $("#imageUrl").val()); //图片链接（base64）
});

$.validator.setDefaults({
    submitHandler: function () {
        update();
    }
});

function update() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/videoManager/update",
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
            title : {
                required : true
            },
            imageUrl : {
                required : true
            },
            videoUrl : {
                required : true
            },
            minute : {
                required : true
            },
            second : {
                required : true
            },
            content : {
                required : true
            }
        },
        messages: {
            title : {
                required : icon + "请输入视频标题"
            },
            imageUrl : {
                required : icon + "请输入视频封面"
            },
            videoUrl : {
                required : icon + "请上传视频"
            },
            minute : {
                required : icon + "请输入时长"
            },
            second : {
                required : icon + "请输入时长"
            },
            content : {
                required : icon + "请输入视频介绍"
            }
        }
    })
}

layui.use('upload', function () {
    var $ = layui.jquery, upload = layui.upload;
    //上传视频封面
    upload.render({
        elem: '#imageBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#imageShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#imageUrl').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传视频
    upload.render({
        elem: '#videoBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'file'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            console.log(obj);
        }
        , done: function (res) {

            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#videoUrl').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });


});
var content_init = undefined;
layui.use('layedit', function () {
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/file/upload/' //接口url
            , type: 'post' //默认post
        }
    });
    content_init = layedit.build('content'); //建立编辑器

});
