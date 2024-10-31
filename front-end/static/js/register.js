function togglePassword(){
    const showPassCheckBox = document.getElementById('show-pass');
    const passInput = document.getElementById('password');
    if(showPassCheckBox.checked){
        passInput.type = "text";
    }
    else {
        passInput.type = "password";
    }
}