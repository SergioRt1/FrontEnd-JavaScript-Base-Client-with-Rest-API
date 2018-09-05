
var url = 'http://localhost:8080';
function getOrders() {
    return axios.get(url+"/orders").then(function (response) {
    // handle success
    return response.data;
  })
}


function loadOrders() {
    var orders = getOrders();
    console.log(orders);
    for(var j = 0; j < orders.length; j++){
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
        var order = orders[j];
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
}
