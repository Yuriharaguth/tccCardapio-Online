(function(){
    "use strict";
    
    angular.module("myApp").controller("contaClt",function($scope, Data, $ionicModal, $state){
        $scope.Conta = "Contato";
        $scope.contas = [1];
        
        //pegando o numero da mesa
        var numeroMesa = new getStorage();
        console.log(numeroMesa.mesa + " conta ");
        
        
        //modal
        
        $ionicModal.fromTemplateUrl('views/contacalc.html',{
            scope:$scope,
            animation:'slide-in-up'
        }).then(function(modal){
           $scope.modal = modal; 
        });
        //abre modal
        $scope.abreModal = function(){
            $scope.modal.show();
        };
        //fecha modal
        $scope.fechaModal = function(){
            $scope.modal.hide();
        };
        
        
    });

})();