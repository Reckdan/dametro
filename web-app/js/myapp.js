function populateCategories(data) {
  var $element = $('#category');
  $element.empty();
  var i=0;
  $.each(data, function(key, value) {
    var option = $('<option/>').val(value.id).text(value.categoryName);
   
    $element.append(option)
  });
  $element.removeAttr('disabled');
//  $("#loginBtn").bind("click", function() {
//  	var formData = {
//  			'userName' 				: $('input[name=username]').val(),
//  			'password' 			: $('input[name=password]').val()
//  			//,
//  			//'superheroAlias' 	: $('input[name=superheroAlias]').val()
//  		};
//  			$.ajax({
//  				type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
//  				url:'/dametro/fixedfee/getMincharge',
//  				data: formData, // our data object
//  				dataType: 'json' // what type of data do we expect back from the server
//          
//  			success: function(data){
//              $("#dialogPlaceholder").html(data);
//              $("#dialogPlaceholder").dialog("open");
//          }
//      })
//   // using the done promise callback
//		.done(function(data) {
//
//			// log data to the console so we can see
//			console.log(data); 
//
//			// here we will handle errors and validation messages
//		});
//
//	// stop the form from submitting the normal way and refreshing the page
//	event.preventDefault();
//  });

}
function test1(){
	return 'Testing something';
}
function updateMincharge(data){
	var $element=$('#minCharge');
	$element.val(data.minCharge);
	$('#ratePa').focus();
}