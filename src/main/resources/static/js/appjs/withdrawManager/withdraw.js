var prefix = "/withdrawManager"
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
//                sortable: true,
//                sortOrder: "asc",
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        realName: $('#realName').val(),
                        status: $('#status').val(),
                        minTime: $('#minTime').val(),
                        maxTime: $('#maxTime').val(),
                        minSuccessTime: $('#minSuccessTime').val(),
                        maxSuccessTime: $('#maxSuccessTime').val(),
                        phone: $('#phone').val(),
                        // withdrawId:$("#withdrawId").val()
                        // username:$('#searchName').val()
                        merchantId: $('#merchantId').val()
                    };
                },
//                showExport: true,  //是否显示导出按钮
//                buttonsAlign:"right",  //按钮位置
                exportTypes: ['excel'],  //导出文件类型
                Icons: 'glyphicon-export',
                exportOptions: {
                    ignoreColumn: [0, 1],  //忽略某一列的索引
                    fileName: '提现申请表',  //文件名称设置
                    worksheetName: 'sheet1',  //表格工作区名称
                    tableName: '提现申请表',
                    excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
                    onMsoNumberFormat: DoOnMsoNumberFormat
                },
                showExport: true,                     //是否显示导出
                exportDataType: "all",              //basic', 'all', 'selected'.
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    }
                    ,
                    // {
                    //     field: 'merchantId',
                    //     title: '商户号'
                    // },
                    {
                        field: 'phone',
                        title: '手机号'
                    }
                    ,
                    // {
                    //     field: 'withdrawId',
                    //     title: '提现编号'
                    // }
                    // ,
                    {
                        field: 'realName',
                        title: '真实姓名'
                    }
                    ,
                    {
                        field: 'xiaxianCount',
                        title: '下线'
                    },
                    {
                        field: 'actualMoney',
                        title: '消费金额',
                        formatter: function (value, row, index) {
                            return row.actualMoney / 100;
                        }
                    },
                    {
                        field: 'money',
                        title: '提现金额',
                        formatter: function (value, row, index) {
                            return row.money / 100;
                        }
                    },
                    {
                        field: 'balance',
                        title: '可用余额',
                        formatter: function (value, row, index) {
                            return row.balance / 100;
                        }
                    },
                    {
                        field: 'totalMaidAmount',
                        title: '累计返佣金额',
                        formatter: function (value, row, index) {
                            return row.totalMaidAmount / 100;
                        }
                    },

                    {
                        field: 'payWay',
                        title: '提现方式',
                        formatter: function (value, row, index) {
                            if (row.payWay == null) {
                                return "";
                            }
                            if (row.payWay == 1) {
                                return "微信";
                            } else if (row.payWay == 2) {
                                return "余额";
                            } else if (row.payWay == 3) {
                                return "银行卡";
                            }
                            return "";
                        }
                    },
                    {
                        field: 'account',
                        title: '收款账户',
                        formatter: function ( value) {
                            return ":"+value;
                        }
                    },
                    {
                        field: 'bankAddress',
                        title: '银行卡地址'
                    },
                    {
                        field: 'bankBranch',
                        title: '开户支行'
                    },
                    {
                        field: 'idCard',
                        title: '身份证号码',
                        formatter: function ( value) {
                            return ":"+value;
                        }
                    },

                    {
                        field: 'status',
                        title: '提现状态',
                        formatter: function (value, row, index) {
                            if (row.status == null) {
                                return "";
                            }
                            if (row.status == 1) {
                                return "审核中";
                            } else if (row.status == 2) {
                                return "审核通过";
                            } else if (row.status == 3) {
                                return "未通过";
                            }else if(row.status ==4){
                                return "已到账";
                            }
                            return "";
                        }
                    },
                    // {
                    //     field: 'operator',
                    //     title: '审核人员'
                    // },
                    {
                        field: 'remark',
                        title: '审核意见'
                    }
                    ,
                    {
                        field: 'successTime',
                        title: '审核通过时间'
                    }

                    // ,
                    // {
                    //     field: 'paymentNo',
                    //     title: '提现微信订单号'
                    // }
                    // ,
                    // {
                    //     field: 'paymentTime',
                    //     title: '到账时间'
                    // }
                    ,
                    {
                        field: 'createTime',
                        title: '提交时间'
                    }
//                    ,
//                    {
//                        field: 'modifyTime',
//                        title: '更新时间'
//                    }
                    // ,
                    // {
                    //     field: 'available',
                    //     title: ''
                    // }
                    ,
                    {
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            return e;
                        }
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
            ids[i] = row['id'];
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

layui.use('laydate', function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#minTime' //指定元素
        , type: 'datetime'
    });
});

layui.use('laydate', function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#maxTime' //指定元素
        , type: 'datetime'
    });
});
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#minSuccessTime' //指定元素
        , type: 'datetime'
    });
});

layui.use('laydate', function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#maxSuccessTime' //指定元素
        , type: 'datetime'
    });
});