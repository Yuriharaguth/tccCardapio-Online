(function(){
    "use strict";
    
    angular.module("myApp").controller("pedidoClt",function($scope, Data, $ionicModal, $location,  $timeout){
        $scope.pedido = "Lista de Pedidos";
        $scope.pedidos = [];
        $timeout(callAtTimeout, 5000);
        
        //pegando os pedidos
        var getDataPedidos = function(){
            Data.getDataPedidos().success(function(data){
                //recebe os pedidos
                $scope.pedidos = data;
                console.log("chamou");
            }).error(function(data){
                console.log(data? data:"Não foi possivel acessar o servidor!");
            });
        };
        
        $scope.attPedido = function(pedido){
            
            Data.setAttPedido(pedido).success(function(data){
                $scope.pedidos = data;
            }).error(function(data){
                console.log(data? data:"Não foi possivel acessar o servidor!");
            });  
            
        };
        
        function callAtTimeout() {
            $timeout(callAtTimeout, 150000);
            getDataPedidos();
        }
        
        getDataPedidos();

    });

})();