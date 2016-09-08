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
				required: true,
				email:true
			},
			password :{
				required: true,
				minlength:5
			}
		},
		messages : {
			email : {
				required: "This field is required.",
				email:"Please enter a valid email address."
			},
			password : {
				required: "This field is required.",
				minlength:$.validator.format( "Please enter at least {0} characters." )
			}
		},
		submitHandler : function(form) {
			login(form);
		}
	});
	
	
});