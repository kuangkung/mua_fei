let phoneNumber = document.getElementById('phoneNumber');
let printPhoneNumber = function() {
    console.log(phoneNumber.value);
    if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phoneNumber.value))){ 
        alert("手机号码格式有误，请重新填写！");  
        return false; 
    }
}
