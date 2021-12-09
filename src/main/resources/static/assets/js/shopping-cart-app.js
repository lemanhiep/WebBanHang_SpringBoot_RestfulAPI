const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl",function ($scope, $http)
{
  $scope.cart = {
      //quản lí giỏ hàng
      items: [],

      add(id){
      //thêm sản phẩm vào giỏ hàng
       var item = this.items.find(item => item.id ==id);
       if(item){
           item.qty++;
           this.saveToLocalStorage();
       }
       else {
           $http.get(`/rest/products/${id}`).then(resp =>
           {
               resp.data.qty = 1;
               this.items.push(resp.data);
               this.saveToLocalStorage();
           })
       }
      },

      remove(id){
          // xóa sản phẩm khỏi giỏ hàng
          var index = this.items.findIndex(item => item.id == id);
          this.items.splice(index,1);
          this.saveToLocalStorage();
      },

      clear(){
          //xóa sạch các mặt hàng có trong giỏ
          this.items = []
          this.saveToLocalStorage();
      },
      amt_of(item){},
      get count(){
          //tính tổng số lượng các mặt hàng trong giỏ
          return this.items
              .map(item => item.qty)
              .reduce((total,qty) => total += qty, 0);
      },
      get amount(){
          //Tổng thành tiền các mặt hàng trong giỏ
          return this.items
              .map(item => item.qty * item.price)
              .reduce((total,qty) => total += qty, 0);

      },
      saveToLocalStorage(){
          //lưu giỏ hàng vào Local Storage
          var json = JSON.stringify(angular.copy(this.items));
          localStorage.setItem("cart", json);
      },
          loadFromLocalStorage(){
          //đọc giỏ hàng từ local storage
          var json = localStorage.getItem("cart");
          this.items = json ? JSON.parse(json) : [];
          }
  }
  $scope.cart.loadFromLocalStorage();
})