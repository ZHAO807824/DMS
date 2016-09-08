$(document).ready(function(){
//	登录表单验证
	function login(form){
		form.submit();     
	}
	
	$("#form").validate({
		errorPlacement : function(error, element) {
			error.insertAfter(element);
		},
		errorElement : "sapn",
		rules : {
			email :{
				email:true
			},
			password :{
				minlength:5
			}
		},
		messages : {
			email : {
				email:"Please enter a valid email address."
			},
			password : {
				minlength:$.validator.format( "Please enter at least {0} characters." )
			}
		},
		submitHandler : function(form) {
			login(form);
		}
	});
	
	
});