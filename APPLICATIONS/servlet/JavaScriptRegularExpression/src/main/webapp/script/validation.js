
function validate(form){
	var validPattern="[a-z]|[A-Z]|[\s]|[^0-9]*";
	
	if(form.userName.value==""){
		alert("USER NAME IS REQUEIRED ");
		return false;
	}
	
	
	
	if(!validPattern.test(form.userName.value)){
		alert("USER NAME IS NOT VALID ");
		return false;
	}	
   return true;	
}