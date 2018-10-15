var prefix = "/orderManager"
$(function () {
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
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
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
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        phone: $("#phone").val(),
                        orderStatus:$("#order_status").val(),
                        orderNo:$('#orderNo').val(),
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
                columns: [
                    {
                        checkbox: true
                    },
                    // {
                    //     field: 'merchantId',
                    //     title: '商户号'
                    // },
                    {
                        field: 'orderNo',
                        title: '订单编号'
                    },
                    {
                        field: 'phone',
                        title: '购买手机号'
                    },
                    {
                        field: 'productName',
                        title: '产品名称'
                    },
                    {
                        field: 'levelName',
                        title: '等级名称'
                    },
                    {
                        field: 'money',
                        title: '订单金额',
                        formatter: function (value, row, index) {
                         return row.money/100;
                         }
                    },
                    {
                        field: 'actualMoney',
                        title: '实付金额',
                        formatter: function (value, row, index) {
                         return row.actualMoney/100;
                         }
                    },
                    {
                        field: 'maidPercent',
                        title: '返佣比例'
                    },
                    {
                        field: 'payWay',
                        title: '支付方式',
                        formatter: function (value, row, index) {
                            if(row.payWay == null ){
                                return "-";
                            }
                            if(row.payWay == 1){
                                return "微信";
                            }
                            return "";
                        }
                    },
                     {
                        field: 'paymentNo',
                        title: '微信支付订单号'
                    },
                    {
                        field: 'orderStatus',
                        title: '订单状态',//  0待支付 1成功  -1超时关闭
                        formatter: function (value, row, index) {
                            if(row.orderStatus == null ){
                                return "-";
                            }
                            if(row.orderStatus == 0){
                                return "待支付";
                            }else if(row.orderStatus == 1){
                                return "成功";
                            }else if(row.orderStatus == -1){
                                return "超时关闭";
                            }
                            return "";
                        }
                    },
                      {
                        field: 'paymentTime',
                        title: '购买时间'
                    },
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center'
//                        ,
//                        formatter: function (value, row, index) {
//                            var f = '<a class="btn btn-primary btn-sm" href="#" title="查看"  mce_href="#" onclick="showInfo(\''
//                                + row.orderNo
//                                + '\')"><i class="fa fa-edit"></i></a> ';
//                            return f;
//                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function add() {
    var index = layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
    layer.full(index);
}

function edit(id) {
    var index = layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
    layer.full(index);
}

function showInfo(id) {
    var index = layer.open({
        type: 2,
        title: '查看',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/info/' + id // iframe的url
    });
    layer.full(index);
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
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
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['orderNo'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

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