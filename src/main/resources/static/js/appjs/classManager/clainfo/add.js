$().ready(function() {
	validateRule();
    layui.use(['layer', 'form'], function(){
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
                if(!res){
                    return
                }
                var classSetHtml = "<option value=''>请选择</option>";
                res.forEach(item=>{
                    classSetHtml+="<option value='"+item.id+"'>"+item.title+"</option>"
                })
                $("#categoryId").html(classSetHtml);
                layui.form.render();
            }
        })

    });
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
		url : "/classManager/claInfo/save",
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
            title: {
                required: true
            },
            audioUrl: {
                required: true
            },
            logoUrl: {
                required: true
            },
            content: {
                required: true
            },
            categoryId: {
                required: true
            }
		},
		messages : {
            title: {
                required: icon + "请输入标题"
            },
            audioUrl: {
                required: icon + "请上传音/视频"
            },
            logoUrl: {
                required: icon + "请上传logo图"
            },
            content: {
                required: icon + "请输入简介"
            },
            categoryId: {
                required: icon + "分类必选"
            }
		}
	})
}

layui.use('upload', function () {
    var $ = layui.jquery, upload = layui.upload;
    //上传图片
    upload.render({
        elem: '#logoBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'images'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#logoShow').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            if (res.code == 0) {
                parent.layer.msg("上传成功");
                $('#logoUrl').val(res.data.src);
            }
            //上传完毕回调
        }
        , error: function () {
            //请求异常回调
        }
    });

    //执行实例
    upload.render({
        elem: '#audioBtn' //绑定元素
        , url: '/file/upload/' //上传接口
        , accept: 'file'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            console.log(obj);
        }
        , done: function (res) {

            if (res.code == 0) {
               parent.layer.msg("上传成功");
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
    content_init = layedit.build('content_desc'); //建立编辑器

});


layui.use(['layer', 'form'], function(){
    var layer = layui.layer, $ = layui.jquery,form = layui.form;
    form.on('select(categoryId)', function(data){//一级课程选择的改变
        if(!data){
            return;
        }
        var url = "/items/getClassSetItemsList";
        var merchantId = $('#merchantId').val();
        $.ajax({
            url:url,
            type:"POST",
            data:JSON.stringify({merchantId:merchantId,categoryId:data.value}),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(res){
                if(!res){
                    return
                }
                var classSetHtml = "";
                res.forEach(item=>{
                    classSetHtml+="<option value='"+item.id+"'>"+item.title+"</option>"
                })
                $("#classSetId").html(classSetHtml);
                layui.form.render();
            }
        })
    });

});