(function(){
    "use strict";
    
    angular.module("myApp").controller("loginClt",function($scope, Data, $location, $state){
        $scope.loginTitle = "Login";
        $scope.retornoLongin;
        
        //acesso a localStorage
        var numeroMesa = new getStorage();
        
        /*LOGIN*/
        $scope.loginEnviar = function(login){
             
            Data.setLogin(login).success(function(data){
              
                $scope.retornoLongin = data;
                //estamos recebendo
                console.log($scope.retornoLongin);
               
                if(login.senha === $scope.retornoLongin.senha ){
                    console.log("LOGADO");
                    
                    //salvando o numero da mesa localmente
                    numeroMesa.save($scope.retornoLongin.mesa);
                    alert("Logado!");
                    $state.go('menu.home');
                }else{
                    alert("Usuario ou senha incorretos!");
                }
                
            }).error(function(data){
                console.log("não ok");
            });
           
            
        };
    });

})();