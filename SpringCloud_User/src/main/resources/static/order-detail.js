function renderOrderContentTable(table, orderID) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/getorderinfo/content/" + orderID,
        success: function (response) {
            
            // 产品列表
            let data = response;
            data.forEach(function (product) {
                product.price = calculateAmount(product);
            });
            console.log(data);
            // 渲染表格
            table.render({
                elem: '#orderContentTable',
                data: data,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id',  title: '产品编号' },
                    { field: 'productName',  title: '产品名称' },
                    { field: 'unitPrice',  title: '单价' },
                    { field: 'num',  title: '数量' },
                    { field: 'price',  title: '金额' },
                ]],
                page: true
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });

    
}
function calculateAmount(product) {
    return product.unitPrice * product.inventoryNum;
}