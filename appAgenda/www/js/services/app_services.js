(function(){
    "use strict";
    
    angular.module("myApp").value("Config",{
       
        getUrl:"http://localhost:8080/WebServiceRestCardapio/rest/"
    });
    
    angular.module("myApp").service("Data",function($http, Config){
        
        //buscar user não esta sendo usado
        this.getDataUsers = function(){
            return $http({
                        method:"GET",
                        url: Config.getUrl + "user/users",
                        data:"",
                        headers : {
				        'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				    }
            });
        };
        
        //cadastro não esta sendo usado
        this.setDataUsers = function(dados){
            console.log(dados);
            return $http({
                        method:"POST",
                        url: Config.getUrl + "user/cadastrar",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
        //comentarios
        this.setDataComentarios = function(dados){
            console.log(dados + "oi");
            return $http({
                        method:"POST",
                        url: Config.getUrl + "comentario/salvar",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
        //login
        this.setLogin = function(dados){
            return $http({
                        method:"POST",
                        url: Config.getUrl + "login/login",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
        //busca produtos
        this.getDataProdutos = function(dados){
            console.log(dados);
            return $http({
                        method:"POST",
                        url: Config.getUrl + "produto/produtocategoria",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
        //realizar pedido
        this.setDataPedido = function(dados){
            console.log("Esta sendo enviado -> pedidos");
            console.log(dados);
            return $http({
                        method:"POST",
                        url: Config.getUrl + "pedido/pedido",
                        data: dados,
                        headers : {
				        'Content-Type' : 'application/json; charset=UTF-8'
				    }
            });
            
        };
        
        
    });
    
})();

