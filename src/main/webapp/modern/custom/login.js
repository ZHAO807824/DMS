//业务逻辑分包
var DmsLogin={
		//封装登录相关ajax的url
		URL:{
			register:function(){
				return "register";
			}
		},
		//表单提交
		Submit:{
			loginSubmit:function(form){
				form.submit();
			},
			registerSubmit:function(form){
				form.submit();
			}
		},
		//表单校验
		Validate:{
			//登录表单校验
			loginValidate:function(form){
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
			//注册表单校验
			registerValidate:function(form){
				$(form).validate({
					errorPlacement : function(error, element) {
						error.insertAfter(element);
					},
					errorElement : "sapn",
					rules : {
						fullName:{
							required: true
						},
						houseName:{
							required: true
						},
						email :{
							required: true,
							email:true,
							remote: {
							    url: DmsLogin.URL.register(),     //后台处理程序
							    type: "get",               //数据发送方式
							    dataType: "json",         //接受数据格式   
							    dataFilter : function(data, type) {
									if (data== "true")
										return true;
									else{
										return false;
									}
								}
							}
						},
						password :{
							required: true,
							minlength:5
						},
						confirmPassword:{
							required: true,
							minlength:5,
							equalTo:"#password"
						}
					},
					messages : {
						fullName:{
							required: "This field is required."
						},
						houseName:{
							required: "This field is required."
						},
						email :{
							required: "This field is required.",
							email: "Please enter a valid email address.",
							remote: "Please fix this field."
						},
						password :{
							required: "This field is required.",
							minlength: $.validator.format( "Please enter at least {0} characters." )
						},
						confirmPassword:{
							required: "This field is required.",
							equalTo: "Please enter the same value again."
						}
					}
				});
			}
		},
		
		//登录逻辑
		Login:{
			init:function(){
				//设置 jquery validate的默认值
				$.validator.setDefaults({
					  submitHandler: function(form) { 
						DmsLogin.Submit.loginSubmit(form);
					  }
				});
				//登录表单校验
				DmsLogin.Validate.loginValidate("#form");
			}
		},
		//注册逻辑
		Register:{
			init:function(){
				//设置 jquery validate的默认值
				$.validator.setDefaults({
					  submitHandler: function(form) { 
						 DmsLogin.Submit.registerSubmit(form);
					  }
				});
				//注册表单校验
				DmsLogin.Validate.registerValidate("#registerForm")
			}
		}
		
}

