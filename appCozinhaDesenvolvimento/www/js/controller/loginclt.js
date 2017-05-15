(function(){
    "use strict";
    
    angular.module("myApp").controller("loginClt",function($scope, Data, $ionicModal, $state){
        $scope.loginTitle = "Login";
        $scope.retornoLongin;

        
        /*LOGIN*/
        $scope.loginEnviar = function(login){
             
            Data.setLogin(login).success(function(data){
              
                $scope.retornoLongin = data;
                //estamos recebendo
                console.log($scope.retornoLongin);
               
                if(login.senha === $scope.retornoLongin.senha){
                    console.log("LOGADO");
                    alert("Logado!");
                    $state.go('menu.pedidos');
                }else{
                    alert("Usuario ou senha incorretos!");
                }
                
            }).error(function(data){
                console.log("não ok");
            });
           
            
        };
        

    });

})();