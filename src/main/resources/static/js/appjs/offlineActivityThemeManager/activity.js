
var prefix = "/offlineActivityTheme"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/getActivityList", // 服务器数据的加载地址
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
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
                                activityAddress:$('#activityAddress').val(),
					           	activityThemeId:$('#id').val()
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
								// 								{
								// 	field : 'id',
								// 	title : ''
								// },
																{
									field : 'activityAddress', 
									title : '开课城市'
								},
								// {
								// 	field : 'applyStartTime',
								// 	title : '报名开始时间'
								// },
								// {
								// 	field : 'applyEndTime',
								// 	title : '报名结束时间'
								// },
																{
									field : 'activityStartTime',
									title : '开课开始时间'
								},
																{
									field : 'activityEndTime',
									title : '开课结束时间'
								},
																{
									field : 'activityPrice', 
									title : '原价',
									formatter: function (value) {
										if(value == null){
											return "-";
										}else {
                                            return value/100+"元";
										}
									}
								},
																{
									field : 'isRetraining', 
									title : '是否复训',
									formatter: function (value) {
										if (value == null) {
											return "-";
										}
										if (value == 0) {
											return "不复训";
										} else if (value == 1) {
											return "复训";
										}
										return "";
									}
								},
								{
									field : 'retrainingPrice',
									title : '复训价格',
									formatter: function (value) {
										if(value == null){
											return "-";
										}else {
											return value/100+"元";
										}
									}
								},
																{
									field : 'activityTheme',
									title : '线下课程主题'
								},
																{
									field : 'orderCount',
									title : '报名人数',
									formatter : function(value, row) {
										var e = '<a  href="#" style="color: blue" mce_href="#" title="查看订单" onclick="getOrderList(\''
											+ row.id
											+ '\')">'+value+'人'+'</a> ';
										return e ;
									}
								},
								// 								{
								// 	field : 'buyCount',
								// 	title : '购买人数'
								// },
								// 								{
								// 	field : 'isRecommend',
								// 	title : '是否推荐',
								// 	formatter: function (value) {
								// 		if (value == null) {
								// 			return "-";
								// 		}
								// 		if (value == 0) {
								// 			return "不推荐";
								// 		} else if (value == 1) {
								// 			return "推荐";
								// 		}
								// 		return "";
								// 	}
								// },
								// 								{
								// 	field : 'isShow',
								// 	title : '是否展示',
								// 	formatter: function (value) {
								// 		if (value == null) {
								// 			return "-";
								// 		}
								// 		if (value == 0) {
								// 			return "不展示";
								// 		} else if (value == 1) {
								// 			return "展示";
								// 		}
								// 		return "";
								// 	}
								// },
								// 								{
								// 	field : 'isRebuy',
								// 	title : '是否可用重复购买',
								// 	formatter: function (value) {
								// 		if (value == null) {
								// 			return "-";
								// 		}
								// 		if (value == 0) {
								// 			return "不可用";
								// 		} else if (value == 1) {
								// 			return "可用";
								// 		}
								// 		return "";
								// 	}
								// },
								// 								{
								// 	field : 'isMaid',
								// 	title : '是否返佣',
								// 	formatter: function (value) {
								// 		if (value == null) {
								// 			return "-";
								// 		}
								// 		if (value == 0) {
								// 			return "不返佣";
								// 		} else if (value == 1) {
								// 			return "返佣";
								// 		}
								// 		return "";
								// 	}
								// },
																{
									field : 'minRequirement', 
									title : '购买最低要求',
									formatter: function (value, row, index) {
										if (row.minRequirement == null) {
											return "-";
										}
										if(row.minRequirement == 0){
                                            return "会员";
										}else if(row.minRequirement == 1) {
											return "学员";
										} else if (row.minRequirement == 4) {
											return "创业教练";
										}else if (row.minRequirement == 5) {
											return "班长";
										}else if (row.minRequirement == 6) {
											return "院长";
										} else if (row.minRequirement == 99) {
											return "校长";
										}
										return "";
									}
								},
								// 								{
								// 	field : 'merchantId',
								// 	title : '商户号'
								// },
								// 								{
								// 	field : 'createTime',
								// 	title : '创建时间'
								// },
								// 								{
								// 	field : 'modifyTime',
								// 	title : '更新时间'
								// },
								// 								{
								// 	field : 'available',
								// 	title : ''
								// },
								// 								{
								// 	title : '操作',
								// 	field : 'id',
								// 	align : 'center',
								// 	formatter : function(value, row, index) {
								// 		var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit('
								// 				+ row.id+ ','+ row.activityThemeId
								// 				+ ')"><i class="fa fa-edit"></i></a> ';
								// 		var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
								// 				+ row.id
								// 				+ '\')"><i class="fa fa-remove"></i></a> ';
								// 		var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
								// 				+ row.id
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
function getOrderList(id) {
    var index = layer.open({
        type : 2,
        title : '查看订单',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : '/offlineActivity/order/' + id// iframe的url
    });
    layer.full(index);
}