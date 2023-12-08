function renderProductData(table) {
    let productData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/allProduct",
        success: function (response) {
            productData = response;
            console.log("全部产品返回:", productData);
            // 渲染表格
            table.render({
                elem: '#productTable',
                data: productData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id',  title: '产品编号' },
                    { field: 'productName',  title: '产品名称' },
                    { field: 'unitPrice', title: '单价' },
                    { field: 'inventoryNum',  title: '库存数量' },
                    { fixed: 'right',  align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(productTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
                    let selectedData = obj.data;
                    window.location.href = "http://localhost:8080/admin/productModify/" + selectedData.id;
                }
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}
function renderQueryProductData(table, queryName) {
    let queryData = {
        "name": queryName
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/queryProduct",
        data: queryData,
        success: function (response) {
            productInfo = response;
            console.log("查询产品返回:", productInfo);
            // 渲染表格
            table.render({
                elem: '#productQueryTable',
                data: productInfo,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id',  title: '产品编号' },
                    { field: 'productName', title: '产品名称' },
                    { field: 'unitPrice',  title: '单价' },
                    { field: 'inventoryNum',  title: '库存数量' },
                    { fixed: 'right',  align: 'center', toolbar: '#bar2', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(productQueryTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
                    let selectedData = obj.data;
                    window.location.href = "http://localhost:8080/admin/productModify/" + selectedData.id;
                }
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}

