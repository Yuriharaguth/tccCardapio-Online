(function(){
    "use strict";
    
    angular.module("myApp").controller("contatoClt",function($scope, Data, $ionicModal, $state){
        $scope.titleContato = "Contato";
        
        //pegando o numero da mesa
        var numeroMesa = new getStorage();
        console.log(numeroMesa.mesa + " contato ");
        
        /*CADASTRAR*/
        $scope.cadastroContato = function(contato){
            
            Data.setDataComentarios(contato).success(function(data){
                console.log(contato  + "ok comentario");
            }).error(function(data){
                console.log(contato  + "não ok comentario");
            });
            
            $state.go('menu.home');
        };
        
        
    });

})();