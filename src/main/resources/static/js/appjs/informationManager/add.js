$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/informationManager/save",
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
            title : {
				required : true
			},
            logoUrl : {
                required : true
            },
            // audioUrl : {
            //     required : true
            // },
            content : {
                required : true
            }
		},
		messages : {
            title : {
				required : icon + "请输入标题"
			},
            logoUrl : {
                required : icon + "请上传封面图片"
            },
            // audioUrl : {
            //     required : icon + "请上传音频"
            // },
            content : {
                required : icon + "请输入资讯简介"
            }
		}
	})
}

layui.use('upload', function () {
    var $ = layui.jquery, upload = layui.upload;
    //上传封面图片
    upload.render({
        elem: '#information_upload' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#information_CoverShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                $('#logoUrl').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });
    //上传音频
    upload.render({
        elem: '#information_audioUrl' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'file'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            console.log(obj);
        }
        , done: function (res) {

            if (res.code == 0) {
                $('#audioUrl').val(res.data.src);
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
    content_init = layedit.build('contentText'); //建立编辑器

});
