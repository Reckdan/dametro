$('#useradd').change(function(){
  if($(this).is(':checked')){
    $.ajax({
  		url: "/api/getWeather",
  		data: {
    		zipcode: 97201
  	},
  	success: function( data ) {
   

    $("submetro").prop('disabled','disabled');
    $("constituency").prop('disabled','disabled');
    $("street").prop('disabled','disabled');
    $("electoralarea").prop('disabled','disabled');
    $("community").prop('disabled','disabled');
    $("unit").prop('disabled','disabled');
    $("housenumber").prop('disabled','disabled');


    $("submetro").val(data.submetro.id);
    $("constituency").val(data.constituency.id);
    $("street").val(data.street.id);
    $("electoralarea").val(data.electoralarea.id);
    $("community").val(data.community.id);
    $("unit").val(data.unit.id);
    $("housenumber").val(data.housenumber);


  }
});



  } else {
    $("submetro").prop('disabled',false);
    $("constituency").prop('disabled',false);
    $("street").prop('disabled',false);
    $("electoralarea").prop('disabled',false);
    $("community").prop('disabled',false);
    $("unit").prop('disabled',false);
    $("housenumber").prop('disabled',false);
  }
});