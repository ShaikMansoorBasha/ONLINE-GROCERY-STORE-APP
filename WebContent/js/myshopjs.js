function AddToCart_js() {
    var productname="ProductName="+document.getElementById("ProductName").value
    var Quantity="Quantity="+document.getElementById("Quantity").value
    var ProductPrice="ProductPrice="+document.getElementById("ProductPrice").value
    
    
 var http = new XMLHttpRequest();    
    http.open("POST", "http://localhost:8080/ongs/AddToCart.jsp", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");   
   // http.send(productname);
   // http.send(Quantity);
    var params = productname+'&'+Quantity+'&'+ProductPrice; 
    console.log(params);
    http.send(params);
   
    
    
    
    http.onload = function() {
        alert(http.responseText);
        window.location.reload();
    }
}



