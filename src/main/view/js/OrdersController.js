var order = {
    "order_id": 1,
    "table_id": 1,
    "products": [{
            "product": "PIZZA",
            "quantity": 3,
            "price": "$15.000"
        },
        {
            "product": "HAMBURGER",
            "quantity": 1,
            "price": "$12.300"
        },
        {
            "product": "BEER",
            "quantity": 5,
            "price": "$14.500"
        }
    ]
}
function addOrder() {
    var tableOrder = document.getElementById("tableOrder");
    var header = document.createElement("tr");
    var cell = document.createElement("th");
    cell.innerHTML = "Product";
    header.appendChild(cell);
    var cell = document.createElement("th");
    cell.innerHTML = "Quantity";
    header.appendChild(cell);
    var cell = document.createElement("th");
    cell.innerHTML = "Price";
    header.appendChild(cell);
    tableOrder.appendChild(header);
    for (var i = 0; i < order.products.length; i++) {
        var row = document.createElement("tr");

        var cell = document.createElement("td");
        cell.innerHTML = order.products[i].product;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = order.products[i].quantity;
        row.appendChild(cell);

        var cell = document.createElement("td");
        cell.innerHTML = order.products[i].price;
        row.appendChild(cell);

        tableOrder.appendChild(row);
    }
}
