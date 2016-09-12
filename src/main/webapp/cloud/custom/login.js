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

//注册表单验证
	function register(form){
		form.submit(); 
	}
	$("#registerForm").validate({
		errorPlacement : function(error, element) {
			error.insertAfter(element);
		},
		errorElement : "sapn",
		rules : {
			registerFullname:{
				required: true
			},
			registerUsername:{
				required: true
			},
			registerEmail :{
				required: true,
				email:true,
				remote: {
				    url: "register.action",     //后台处理程序
				    type: "get",               //数据发送方式
				    dataType: "json",         //接受数据格式   
				    dataFilter : function(data, type) {
						if (data == "true")
							return true;
						else
							return false;
					}

				}
			},
			registerPassword :{
				required: true,
				minlength:5
			},
			registerPasswordConfirm:{
				required: true,
				minlength:5,
				equalTo:"#registerPassword"
			},
			
		},
		messages : {
			registerFullname:{
				required: "This field is required."
			},
			registerUsername:{
				required: "This field is required."
			},
			registerEmail :{
				required: "This field is required.",
				email: "Please enter a valid email address.",
				remote: "Please fix this field."
			},
			registerPassword :{
				required: "This field is required.",
				minlength: $.validator.format( "Please enter at least {0} characters." )
			},
			registerPasswordConfirm:{
				required: "This field is required.",
				equalTo: "Please enter the same value again."
			},
			registerAggree:{
				required: "This field is required."
			}
		},
		submitHandler : function(form) {
			register(form);
		}
	});
	
});