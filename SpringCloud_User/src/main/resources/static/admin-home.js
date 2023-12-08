function renderOrderData(table) {
    var orderInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/order/all",
        success: function (response) {
            orderInfoData = response;
            console.log("全部订单返回:", orderInfoData);
            //遍历orderInfoData
            orderInfoData.forEach(function (order) {
                statusCode = order.completionStatus;
                if (statusCode == 0) {
                    order.completionStatus = "进行中";
                } else if (statusCode == 1) {
                    order.completionStatus = "未开始";
                } else if (statusCode == 2) {
                    order.completionStatus = "已完成";
                }

            });
            // 渲染表格
            table.render({
                elem: '#orderTable',
                data: orderInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', title: '订单编号' },
                    { field: 'orderTime', width: 200, title: '交易日期' },
                    { field: 'amountMoney', title: '订单金额' },
                    { field: 'completionStatus', title: '订单状态' },
                    { fixed: 'right', align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(orderTable)', function (obj) {
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

function renderCustomerData(table) {
    var customerInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/customer/all",
        success: function (response) {
            customerInfoData = response;
            console.log("全部客户返回:", customerInfoData);
            // 渲染表格
            table.render({
                elem: '#customerTable',
                data: customerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', title: '客户编号' },
                    { field: 'username', title: '客户姓名' },
                    { field: 'sex', title: '客户性别' },
                    { field: 'phoneNumber', title: '客户电话' },
                    { field: 'totalConsumption', title: '消费额' },
                    { fixed: 'right', align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(customerTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/employee/customerDetail/" + selectedData.id;
                }
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}