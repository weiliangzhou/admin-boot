$().ready(function() {
    init();
    validateRule();
});

function init(){
    //默认隐藏银行卡列
    $("#bank_info").hide();
    $("#wechat_info").hide();
	var payType = $("#payWayType").val();
	if(payType == 1){
		$("#payWayTxt").val("微信");
        $("#wechat_info").show();
	}else if(payType == 3){
        $("#payWayTxt").val("银行卡");
        $("#bank_info").show();
    }else{
        $("#payWayTxt").val("其他");
    }
}
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/withdrawManager/update/",
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
		// rules : {
		// 	name : {
		// 		required : true
		// 	}
		// },
		// messages : {
		// 	name : {
		// 		required : icon + "请输入姓名"
		// 	}
		// }
	})
}