function getStorage(){
    this.mesa = " ";
    
    this.mesa = localStorage.getItem("variavel");
    
    this.save = function(numero){
        localStorage.setItem("variavel",numero);
    }
}