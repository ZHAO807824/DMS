//业务逻辑分包
var DmsLogin={
		//封装登录相关ajax的url
		URL:{
			register:function(){
				return "register";
			}
		},
		//表单提交
		Submit:function(form){
			form.submit();
		},
		//登录表单校验
		Validate:function(form){
			$(form).validate({
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
				}
			})
		},
		//登录逻辑
		Login:{
			init:function(){
				//设置 jquery validate的默认值
				$.validator.setDefaults({
					  submitHandler: function(form) { 
						 DmsLogin.Submit(form);
					  }
				});
				//登录表单校验
				DmsLogin.Validate("#form");
			}
		}
		
}