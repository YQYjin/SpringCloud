function renderOrderTable(table, customerId) {
    var orderInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/order/bycustomerid/"+customerId,
        success: function (response) {
            orderInfoData = response;
            console.log("客户返回:", orderInfoData);
            orderInfoData.forEach(function (order) {
                statusCode=order.completionStatus;
                if(statusCode==0){
                    order.completionStatus="进行中";
                }else if(statusCode==1){
                    order.completionStatus="未开始";
                }else if(statusCode==2){
                    order.completionStatus="已完成";
                }
                
            });
            // 渲染表格
            table.render({
                elem: '#orderInfoTable',
                data: orderInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', title: '订单编号' },
                    { field: 'orderTime', title: '交易日期' },
                    { field: 'amountMoney', title: '订单金额' },
                    { field: 'completionStatus', title: '订单状态' },
                    { fixed: 'right', align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(orderInfoTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/employee/orderDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}

