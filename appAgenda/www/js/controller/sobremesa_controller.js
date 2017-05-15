(function(){
    "use strict";
    
    angular.module("myApp").controller("sobremesaClt",function($scope, Data, $ionicModal, $location){
        $scope.sobremesa = "Sobremesa";
        $scope.produtos = [];
        
        //pegando o numero da mesa
        var numeroMesa = new getStorage();
        console.log(numeroMesa.mesa + " sobremesa ");
        
        //setando o id de categoria
        var categoria = { "id": "4" };
        
        console.log(categoria);
        
        //pegando produtos
        var getDataProdutos = function(categoria){
            
            Data.getDataProdutos(categoria).success(function(data){
                $scope.produtos = data;
                console.log($scope.produtos);
            }).error(function(data){
                console.log(data? data:"Não foi possivel acessar o servidor!");
            });
        
        }
        //abre modal
        $ionicModal.fromTemplateUrl('views/produtoSelecionado.html',{
            scope:$scope,
            animation:'slide-in-up'
            
        }).then(function(modal){
           $scope.modal = modal; 
        });
        //fecha modal
        $scope.abreModal = function(id){
            $scope.produtoSelect = $scope.produtos.filter(function(element){
                return element.id == id;
            });
            $scope.modal.show();
        };
        //fecha modal
        $scope.fechaModal = function(){
            $scope.modal.hide();
        };
        
        $scope.setPedido = function(produto){ 
            
            //pegando o numero da mesa
            var numeroMesa = new getStorage();
            var mesa = numeroMesa.mesa;
            //pegando id do produto
            var idProduto = produto.id;
          
            //CONSTRUÇÃO DO PEDIDO
            var pedido = { 
                            "pro": 
                                { "id" : idProduto },
                            "mesa": 
                                { "id" : mesa }
                         };
            
            Data.setDataPedido(pedido).success(function(data){
                alert(data);
            }).error(function(data){
                console.log(data? data:"Não foi possivel acessar o servidor!");
            });
        }
        
        getDataProdutos(categoria);
    });

})();