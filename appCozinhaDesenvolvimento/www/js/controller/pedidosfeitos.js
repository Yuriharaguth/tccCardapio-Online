(function(){
    "use strict";
    
    angular.module("myApp").controller("pedidosfeitosClt",function($scope, Data, $ionicModal, $location){
        $scope.pedidoFeitos = "Lista de Pedidos Concluidos";
        $scope.pedidosConcluidos = [];
        
      
        
        //pegando os pedidos feitos
        var getDataPedidosFeitos = function(){
            Data.getDataPedidosFeitos().success(function(data){
                console.log(data);
                //recebe os pedidos
                $scope.pedidosConcluidos = data;
                
            }).error(function(data){
                console.log(data? data:"Não foi possivel acessar o servidor!");
            });
        }
        
        getDataPedidosFeitos();
        
    });

})();