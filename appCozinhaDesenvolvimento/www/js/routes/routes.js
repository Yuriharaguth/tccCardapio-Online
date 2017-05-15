(function(){
    "use strict";
    angular.module("myApp").config(function($stateProvider, $urlRouterProvider){
        
        $urlRouterProvider.otherwise("/login");
        
        $stateProvider
            .state("menu",{
                url:"/menu",
                templateUrl:"views/menu.html",
                abstract:true,
                controller:"pedidoClt"
        })
        .state("menu.pedidos", {
            url:"/pedidos",
            views:{
                'menuContent':{
                    templateUrl:"views/pedidos.html"
                }
            }
        })    
        .state("menu.pedidosfeitos", {
            url:"/pedidosfeitos",
            views:{
                'menuContent':{
                    templateUrl:"views/pedidosfeitos.html",
                    controller: "pedidosfeitosClt"
                }
            }
        })
        .state("login", {
            url:"/login",
            templateUrl:"views/login.html",
            controller: "loginClt"
        });

        
    });
        
})();