(function(){
    "use strict";
    angular.module("myApp").config(function($stateProvider, $urlRouterProvider){
        
        $urlRouterProvider.otherwise("/login");
        
        $stateProvider
            .state("menu",{
                url:"/menu",
                templateUrl:"views/menu.html",
                abstract:true,
                controller:"initCtrl"
        })
        .state("menu.home", {
            url:"/home",
            views:{
                'menuContent':{
                    templateUrl:"views/home.html"
                }
            }
        })
        .state("menu.lanches", {
            url:"/lanches",
            views:{
                'menuContent':{
                    templateUrl:"views/lanches.html",
                    controller:"lanchesClt"
                }
            }
        })
        .state("menu.porcoes", {
            url:"/porcoes",
            views:{
                'menuContent':{
                    templateUrl:"views/porcoes.html",
                    controller: "porcoesClt"
                }
            }
        })
        .state("menu.bebidas", {
            url:"/bebidas",
            views:{
                'menuContent':{
                    templateUrl:"views/bebidas.html",
                    controller: "bebidasClt"
                }
            }
         
        })
        .state("menu.sobremesa", {
            url:"/sobremesa",
            views:{
                'menuContent':{
                    templateUrl:"views/sobremesa.html",
                    controller:"sobremesaClt"
                }
            }
        })
        .state("menu.conta", {
            url:"/conta",
            views:{
                'menuContent':{
                    templateUrl:"views/conta.html",
                    controller:"contaClt"
                }
            }
        })
        .state("menu.sobre", {
            url:"/sobre",
            views:{
                'menuContent':{
                    templateUrl:"views/sobre.html"
                }
            }
        })
        .state("menu.contato", {
            url:"/contato",
            views:{
                'menuContent':{
                    templateUrl:"views/contato.html",
                    controller: "contatoClt"
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