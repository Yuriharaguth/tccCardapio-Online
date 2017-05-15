(function(){
    "use strict";
    
    angular.module("myApp").value("Config",{
       
        getUrl:"http://localhost:8080/WebServiceRestCardapio/rest/"
    });
    
    angular.module("myApp").service("Data",function($http, Config){
        
        //login
        this.setLogin = function(dados){
            return $http({
                        method:"POST",
                        url: Config.getUrl + "login/cozinha",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
        //buscar os pedidos getDataPedidosFeitos
        this.getDataPedidos = function(){
            return $http({
                        method:"GET",
                        url: Config.getUrl + "pedido/getpedido",
                        data:"",
                        headers : {
				        'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				    }
            });
        };
        
  
        this.getDataPedidosFeitos = function(){
            return $http({
                        method:"GET",
                        url: Config.getUrl + "pedido/getpedidofinalizados",
                        data:"",
                        headers : {
				        'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				    }
            });
        };
        
        //att pedidos        
        this.setAttPedido = function(dados){
            return $http({
                        method:"POST",
                        url: Config.getUrl + "pedido/atualizarpedido",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
    });
    
})();

