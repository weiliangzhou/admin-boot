
var prefix = "/salon"
$(function() {
	load();
});
function DoOnMsoNumberFormat(cell, row, col) {
    var result = "";
    if (row > 0 && col == 0)
        result = "\\@";
    return result;
}
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/getOrderList", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                        exportTypes:['excel'],  //导出文件类型
                        Icons:'glyphicon-export',
                        exportOptions:{
                            ignoreColumn: [0,1],  //忽略某一列的索引
                            fileName: '会员表',  //文件名称设置
                            worksheetName: 'sheet1',  //表格工作区名称
                            tableName: '会员表',
                            excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
                            onMsoNumberFormat: DoOnMsoNumberFormat
                        },
                        showExport: true,                     //是否显示导出
                        exportDataType: "all",              //basic', 'all', 'selected'.
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
					            phone:$('#phone').val(),
					            realName:$('#realName').val(),
								// orderStatus:$('#orderStatus').val(),
								activityId:$('#id').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'orderNo', 
									title : '订单号'
								},
																{
									field : 'activityAddress',
									title : '开课城市'
								},
																{
									field : 'themeName',
									title : '线下课程名称'
								},
								// 								{
								// 	field : 'activityCode',
								// 	title : '活动消费码'
								// },
																{
									field : 'activityPrice', 
									title : '订单价格',
									formatter: function (value) {
										return value/100+"元";
									}
								},
																{
									field : 'actualMoney',
									title : '实际支付金额',
									formatter: function (value) {
										return value/100+"元";
									}
								},
																{
									field : 'orderStatus', 
									title : '订单状态',
									formatter: function (value) {
										if (value == 0) {
											return "待支付";
										} else if(value == 1){
											return "支付成功";
										}else if(value == -1){
											return "超时";
										}else {
											return "-";
										}
									}
								},
								// 								{
								// 	field : 'userId',
								// 	title : ''
								// },
																{
									field : 'sex', 
									title : '性别',
									formatter: function (value) {
										if (value == 0) {
											return "男";
										} else{
											return "女";
										}
									}
								},
																{
									field : 'phone', 
									title : '手机号' 
								},
																{
									field : 'realName', 
									title : '真实姓名' 
								},
								{
									field : 'wechatNo',
									title : '微信号'
								},
								{
									field : 'slReferrerPhone',
									title : '邀约人手机号'
								},
								{
									field : 'slReferrerName',
									title : '邀约人姓名'
								},
																{
									field : 'city', 
									title : '所在城市' 
								},
																{
									field : 'idCardNum', 
									title : '身份证号码'
								},
								// 								{
								// 	field : 'paymentNo',
								// 	title : '支付流水号'
								// },
								// 								{
								// 	field : 'paymentTime',
								// 	title : '支付时间'
								// },
								// 								{
								// 	field : 'merchantId',
								// 	title : '商户号'
								// },
								// 								{
								// 	field : 'createTime',
								// 	title : ''
								// },
								// 								{
								// 	field : 'modifyTime',
								// 	title : ''
								// },
								// 								{
								// 	field : 'available',
								// 	title : ''
								// },
								// 								{
								// 	field : 'isMaid',
								// 	title : '是否返佣，0不返佣，1返佣'
								// },
								// 								{
								// 	field : 'isRetraining',
								// 	title : '是否复训 0不是1是'
								// },
								// 								{
								// 	title : '操作',
								// 	field : 'id',
								// 	align : 'center',
								// 	formatter : function(value, row, index) {
								// 		var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(\''
								// 				+ row.orderNo
								// 				+ '\')"><i class="fa fa-edit"></i></a> ';
								// 		var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
								// 				+ row.orderNo
								// 				+ '\')"><i class="fa fa-remove"></i></a> ';
								// 		var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
								// 				+ row.orderNo
								// 				+ '\')"><i class="fa fa-key"></i></a> ';
								// 		return e + d ;
								// 	}
								// }
						]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}