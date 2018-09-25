$().ready(function () {
    validateRule();
    layui.use(['layer', 'form'], function(){
        var classCategory = window.sessionStorage.getItem('categoryId');
        var layer = layui.layer, $ = layui.jquery,form = layui.form;
        var url = "/items/getClassCategoryItemsList";
        var merchantId = $('#merchantId').val();
        $.ajax({
            url:url,
            type:"POST",
            data:JSON.stringify({merchantId:merchantId}),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(res){
                var classSetHtml = "<option value=''>请选择</option>";
                res.forEach((item,index)=>{
                    classSetHtml += `<option value='${item.id}' ${classCategory == item.id ? "selected":""}>${item.title}</option>`
                })
                $("#categoryId").html(classSetHtml);
                layui.form.render();
            }
        })
    });
});

$.validator.setDefaults({
    submitHandler: function () {
        update();
    }
});
function update() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/classManager/claSet/update",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg(data.msg);
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.msg(data.msg);
            }

        }
    });

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            title: {
                required: true
            },
            bannerUrl: {
                required: true
            }
            ,
            frontCover: {
                required: true
            },
            categoryId: {
                required: true
            },
            requiredMemberLevel: {
                required: true
            }

        },
        messages: {
            title: {
                required: icon + "请输入标题"
            },
            bannerUrl: {
                required: icon + "请输入横幅广告图"
            },
            frontCover: {
                required: icon + "请输入封面图片"
            },categoryId: {
                required: icon + "分类必选"
            },
            requiredMemberLevel: {
                required: icon + "最低等级必选"
            }
        }
    });
}

layui.use('upload', function () {
    var $ = layui.jquery, upload = layui.upload;
    //上传banner图片
    upload.render({
        elem: '#bannerBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#bannerShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#bannerUrl').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传封面图片
    upload.render({
        elem: '#frontCoverBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#frontCoverShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#frontCover').val(res.data.src);
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

    var content_init=layedit.build('content_desc'); //建立编辑器
});

