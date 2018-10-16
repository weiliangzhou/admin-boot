
var prefix = "/memberManager"
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
						url : prefix + "/list", // 服务器数据的加载地址
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
                                registerMobile:$('#registerMobile').val(),
                                memberLevel:$('#memberLevel').val(),
                                // userId:$('#userId').val(),
                                registerFrom:$('#registerFrom').val(),
                                referrerMobile:$('#referrerMobile').val(),
                                minTime:$('#minTime').val(),
                                maxTime:$('#maxTime').val()
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

								// 								{
								// 	field : 'wechatOpenid',
								// 	title : '微信openid'
								// }
								// ,
								// 								{
								// 	field : 'wechatUnionId',
								// 	title : '微信unionID'
								// }
								//  ,

								{
									field : 'realName',
									title : '真实姓名'
								},
								{
									field : 'registerMobile', 
									title : '绑定手机号',
                                    formatter : function(value, row, index) {
                                        var e = '<a  href="#" style="color: blue" mce_href="#" title="查看下线" onclick="getXiaXianList(\''
                                            + row.userId
                                            + '\')">'+value+'</a> ';
                                        return e ;
                                    }
								},
								{
									field : 'levelName',
									title : '会员等级'
								},
								{
									field : 'referrerRealName',
									title : '推荐人'
								},
								{
									field : 'referrerMobile',
									title : '推荐人手机号'
								},
								{
									field : 'xiaxianCount',
									title : '下级数量'
								},
								{
									field : 'totalPerformance',
									title : '总业绩'
								},
								{
									field : 'wechatAccount',
									title : '微信账号'
								},
								// {
								// 	field : 'userId',
								// 	title : 'userId',
                                 //    visible : false
								// },
								// 								{
								// 	field : 'referrer',
								// 	title : '推荐人userId ',
								// 	visible : false
								// },
								// {
								// 	field : 'expiresTime',
								// 	title : '会员到期时间',
                                 //    // visible : false
								// },
								{
									field : 'registerTime',
									title : '注册时间'
								},
								{
									field : 'registerFrom',
									title : '注册渠道',
									formatter: function (value, row, index) {
										if(row.registerFrom == null ){
											return "";
										}
										if (row.registerFrom == 1){
											return "注册";
										}else if (row.registerFrom == 2){
											return "线下导入";
										}
										return "";
									}
								},
                            	{
                                	field : 'actualMoney',
                                	title : '消费金额'
								},
								// {
								// 	field : 'merchantId',
								// 	title : '商户号',
								// 	visible : false
								// },
								// 								{
								// 	field : 'modifyTime',
								// 	title : '更新时间'
								// },
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										// var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
										// 		+ row.id
										// 		+ '\')"><i class="fa fa-remove"></i></a> ';
										// var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
										// 		+ row.id
										// 		+ '\')"><i class="fa fa-key"></i></a> ';
										// return e + d ;
										return e ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
    var index = layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
    layer.full(index);
}
function edit(id) {
    var index = layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
    layer.full(index);
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}

layui.use('laydate', function(){
  var laydate = layui.laydate;

  //执行一个laydate实例
  laydate.render({
    elem: '#minTime' //指定元素
     ,type: 'datetime'
  });
});

layui.use('laydate', function(){
  var laydate = layui.laydate;

  //执行一个laydate实例
  laydate.render({
    elem: '#maxTime' //指定元素
    ,type: 'datetime'
  });
});

function getXiaXianList(userId) {
    var index = layer.open({
        type : 2,
        title : '查看下线',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/xiaXian/' + userId// iframe的url
    });
    layer.full(index);
}