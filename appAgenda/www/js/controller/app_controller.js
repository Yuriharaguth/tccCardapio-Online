(function(){
    "use strict";
    
    angular.module("myApp").controller("initCtrl",function($scope, Data, $ionicModal, $location){
        $scope.home = "Home";
        $scope.sobre = "Sobre";
        $scope.conta = "Conta";
       
        var numeroMesa = new getStorage();
        console.log(numeroMesa.mesa + " home ");
        
    });

})();