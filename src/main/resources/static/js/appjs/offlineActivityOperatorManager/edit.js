$().ready(function() {
	validateRule();
    layui.use(['layer', 'form'], function(){
        var activityTheme = window.sessionStorage.getItem('activityThemeId');
        var layer = layui.layer, $ = layui.jquery,form = layui.form;
        var url = "/items/getActivityThemeItemsList";
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
                var activityThemeIdHtml = "<option value=''>请选择</option>";
                res.forEach(item=>{
                    activityThemeIdHtml += `<option value='${item.id}' ${activityTheme == item.id ? "selected":""}>${item.themeName}</option>`
                })
                $("#activityThemeId").html(activityThemeIdHtml);
                layui.form.render();
            }
        })

    });
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
		url : "/offlineActivityOperator/update",
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
            operator : {
				required : true
			},
            password : {
                required : true
            },
            activityThemeId : {
                required : true
            }
		},
		messages : {
            operator : {
				required : icon + "请输入操作员"
			},
            password : {
                required : icon + "请输入密码"
            },
            activityThemeId : {
                required : icon + "请选择活动主题"
            }
		}
	})
}