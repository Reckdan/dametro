function test1(){
	return 'Testing something';
}
var wizardContent = $('#wizard');
var wizardForm = $('#form');
function initWizard(){
    // function to initiate Wizard Form
	
    wizardContent.smartWizard({
        selected: 0,
        keyNavigation: false,
        onLeaveStep: leaveAStepCallback,
        onShowStep: onShowStep,
    });
   //alert('testing');
    var numberOfSteps = 0;
    animateBar();
   // initValidator();
}
function animateBar(val) {
    if ((typeof val == 'undefined') || val == "") {
        val = 1;
    };
    numberOfSteps = $('.swMain > ul > li').length;
    var valueNow = Math.floor(100 / numberOfSteps * val);
    $('.step-bar').css('width', valueNow + '%');
}
function displayConfirm () {
    $('.display-value', form).each(function () {
        var input = $('[name="' + $(this).attr("data-display") + '"]', form);
        if (input.attr("type") == "text" || input.attr("type") == "email" || input.is("textarea")) {
            $(this).html(input.val());
        } else if (input.is("select")) {
            $(this).html(input.find('option:selected').text());
        } else if (input.is(":radio") || input.is(":checkbox")) {

            $(this).html(input.filter(":checked").closest('label').text());
        } else if ($(this).attr("data-display") == 'card_expiry') {
            $(this).html($('[name="card_expiry_mm"]', form).val() + '/' + $('[name="card_expiry_yyyy"]', form).val());
        }
    });
}

function onShowStep (obj, context) {
    $(".next-step").unbind("click").click(function (e) {
        e.preventDefault();
        
        	wizardContent.smartWizard("goForward");
        	
        
    });
    $(".back-step").unbind("click").click(function (e) {
        e.preventDefault();
        wizardContent.smartWizard("goBackward");
    });
    $(".finish-step").unbind("click").click(function (e) {
        e.preventDefault();
        onFinish(obj, context);
    });
}
function leaveAStepCallback (obj, context) {
    return validateSteps(context.fromStep, context.toStep);
    // return false to stay on step and true to continue navigation
}
 function onFinish(obj, context) {
    if (validateAllSteps()) {
        //alert('form submit function');
        $('.anchor').children("li").last().children("a").removeClass('wait').removeClass('selected').addClass('done');
        wizardForm.submit();
    }
}
function validateSteps (stepnumber, nextstep) {
    var isStepValid = false;
    if (numberOfSteps > nextstep && nextstep > stepnumber) {
        // cache the form element selector
    	// wizardForm.validate();
        if (wizardForm.valid()) { // validate the form
            wizardForm.validate().focusInvalid();
            $('.anchor').children("li:nth-child(" + stepnumber + ")").children("a").removeClass('wait');
            //focus the invalid fields
            animateBar(nextstep);
            isStepValid = true;
            return true;
        };
    } else if (nextstep < stepnumber) {
        $('.anchor').children("li:nth-child(" + stepnumber + ")").children("a").addClass('wait');
        animateBar(nextstep);
        return true;
    } else {
        $('.anchor').children("li:nth-child(" + stepnumber + ")").children("a").removeClass('wait');
        displayConfirm();
        animateBar(nextstep);
        return true;
    };
}
function validateAllSteps() {
    var isStepValid = true;
    // all step validation logic
    return isStepValid;
}
