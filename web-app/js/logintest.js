$(document).ready(function() {
	
    	        $('.forgot').bind('click', function () {
    	            $('.box-login').hide();
    	            $('.box-forgot').show();
    	        });
    	        $('.register').bind('click', function () {
    	            $('.box-login').hide();
    	            $('.box-register').show();
    	        });
    	        $('.go-back').click(function () {
    	            $('.box-login').show();
    	            $('.box-forgot').hide();
    	            $('.box-register').hide();
    	        });
    	      // runSetDefaultValidation();
              //runLoginValidator();
               //runForgotValidator();
               //runRegisterValidator();
              
   //==================================DEFAULT VALIDATOR======================================
    	        
    	        var runSetDefaultValidation = function () {     
    	        $.validator.setDefaults({
    	            errorElement: "span", // contain the error msg in a small tag
    	            errorClass: 'help-block',
    	            errorPlacement: function (error, element) { // render error placement for each input type
    	                if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
    	                    error.insertAfter($(element).closest('.form-group').children('div').children().last());
    	                } else if (element.attr("name") == "card_expiry_mm" || element.attr("name") == "card_expiry_yyyy") {
    	                    error.appendTo($(element).closest('.form-group').children('div'));
    	                } else {
    	                    error.insertAfter(element);
    	                    // for other inputs, just perform default behavior
    	                }
    	            },
    	            ignore: ':hidden',
    	            highlight: function (element) {
    	                $(element).closest('.help-block').removeClass('valid');
    	                // display OK icon
    	                $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
    	                // add the Bootstrap error class to the control group
    	            },
    	            unhighlight: function (element) { // revert the change done by hightlight
    	                $(element).closest('.form-group').removeClass('has-error');
    	                // set error class to the control group
    	            },
    	            success: function (label, element) {
    	                label.addClass('help-block valid');
    	                // mark the current input as valid and display OK icon
    	                $(element).closest('.form-group').removeClass('has-error');
    	            },
    	            highlight: function (element) {
    	                $(element).closest('.help-block').removeClass('valid');
    	                // display OK icon
    	                $(element).closest('.form-group').addClass('has-error');
    	                // add the Bootstrap error class to the control group
    	            },
    	            unhighlight: function (element) { // revert the change done by hightlight
    	                $(element).closest('.form-group').removeClass('has-error');
    	                // set error class to the control group
    	            }
    	        });
    	        };  
    	        //===========================LOGIN VALIDATOR=========================================================
    	        //var runLoginValidator = function () {
    	        var form = $('.form-login');
    	        var errorHandler = $('.errorHandler', form);
    	        form.validate({
    	            rules: {
    	                username: {
    	                    minlength: 2,
    	                    required: true
    	                },
    	                password: {
    	                    minlength: 6,
    	                    required: true
    	                }
    	            },
    	            submitHandler: function (form) {
    	                errorHandler.hide();
    	                form.submit();    	    	
    	            },
    	            invalidHandler: function (event, validator) { //display error alert on form submit
    	                errorHandler.show();
    	            }
    	        });
    	        
//    	        $("#loginBtn").bind("click", function() {
//    	        	var formData = {
//    	        			'userName' 				: $('input[name=username]').val(),
//    	        			'password' 			: $('input[name=password]').val()
//    	        			//,
//    	        			//'superheroAlias' 	: $('input[name=superheroAlias]').val()
//    	        		};
//    	            $.ajax({
//    	            	type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
//    	                url:'/dametro/user/login',
//    	                data: formData, // our data object
//    	                dataType: 'json' // what type of data do we expect back from the server
//    	                
//    	      //          success: function(data){
////    	                    $("#dialogPlaceholder").html(data);
////    	                    $("#dialogPlaceholder").dialog("open");
//    	        //        }
//    	            })
//    	         // using the done promise callback
//    	    		.done(function(data) {
//
//    	    			// log data to the console so we can see
//    	    			console.log(data); 
//
//    	    			// here we will handle errors and validation messages
//    	    		});
//
//    	    	// stop the form from submitting the normal way and refreshing the page
//    	    	event.preventDefault();
//    	        });
    	        
    	       // };
    	     //=================================FOR VALIDATOR============================================
    	//var runForgotValidator = function () {
        var form2 = $('.form-forgot');
        var errorHandler2 = $('.errorHandler', form2);
        form2.validate({
            rules: {
                email: {
                    required: true
                }
            },
            submitHandler: function (form) {
                errorHandler2.hide();
                form2.submit();
            },
            invalidHandler: function (event, validator) { //display error alert on form submit
                errorHandler2.show();
            }
        });
    	//};
    	        
    	    //===================================REGISTER VALIDATOR=============================================
       // var runRegisterValidator = function () {
            var form3 = $('.form-register');
            var errorHandler3 = $('.errorHandler', form3);
            form3.validate({
                rules: {
                    full_name: {
                        minlength: 2,
                        required: true
                    },
                    address: {
                        minlength: 2,
                        required: true
                    },
                    city: {
                        minlength: 2,
                        required: true
                    },
                    gender: {
                        required: true
                    },
                    email: {
                        required: true
                    },
                    password: {
                        minlength: 6,
                        required: true
                    },
                    password_again: {
                        required: true,
                        minlength: 5,
                        equalTo: "#password"
                    },
                    agree: {
                        minlength: 1,
                        required: true
                    }
                },
                submitHandler: function (form) {
                    errorHandler3.hide();
                    form3.submit();
                },
                invalidHandler: function (event, validator) { //display error alert on form submit
                    errorHandler3.show();
                }
            });
        //};
    	     
//    $("#dialogPlaceholder").dialog({
//        autoOpen: false,
//        height: 200,
//        width: 350,
//        modal: true,
//        title: 'modal window',
//        close: function(){
//            $("#dialogPlaceholder").html('');
//        }
//    });
	

 

 
    
    
    
});