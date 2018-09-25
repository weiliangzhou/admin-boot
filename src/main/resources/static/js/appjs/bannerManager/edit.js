$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/bannerManager/banner/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
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
		rules : {
            imageUrl : {
				required : true
			},
            hrefType : {
                required : true
            },
            theme : {
                required : true
            },
            queueNumber : {
                required : true
            }
		},
		messages : {
            imageUrl : {
				required : icon + "请上传banner图片"
			},
            hrefType : {
                required : icon + "请选择跳转类型"
            },
            theme : {
                required : icon + "请填写banner主题"
            },
            queueNumber : {
                required : icon + "请填写排序号"
            }
		}
	})
}

layui.use('upload', function () {
    var $ = layui.jquery, upload = layui.upload;
    //上传图片
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
                $('#imageUrl').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
});