function validarSenha(input){
        if(input.value != document.getElementById("senha").value){
            input.setCustomValidity('As senhas nao são iguais, repita');
        }else{
           input.setCustomValidity(''); 
        }
    }

