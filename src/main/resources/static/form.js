/**
 * 
 */

function showUpdateForm(url, formId){
	alert(formId);
	var container = document.getElementById(formId);
	getViewSection(container, url, function() {    //container is part of DOM now, EventListeners may brake 
		var submitButton = container
				.querySelector("input[type=submit]");
		submitButton.addEventListener('click', function(e) {
			e.preventDefault();
			handleFormSubmit(formId, function() {
				loadDepartments(document.getElementById("main"));
			});
		});
		hideSiblings(container);
		container.classList.remove("hidden");
	});
}

function handleFormSubmit(formId, callback) {
	
	// collect the form data while iterating over the inputs
	var form = document.getElementById(formId).querySelector("form");
	
	var obj = {};
	for (var i = 0, l = form.length; i < l; ++i) {
		var input = form[i];
		if (input.name) {
			//data[input.name] = input.value;
			setValue(obj, input.name, input.value);
		}
	}

	// construct an HTTP request
	var xhr = new XMLHttpRequest();
	
	xhr.open(form.method, form.action, true);
	xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

	//alert(JSON.stringify(obj));
	// send the collected data as JSON
	xhr.send(JSON.stringify(obj));
	
	xhr.onloadend = function() {
		callback();
	};
}


function setValue(obj, path, value) {
    var schema = obj;  // a moving reference to internal objects within obj
    var pList = path.split('.');
    var len = pList.length;
    for(var i = 0; i < len-1; i++) {
        var elem = pList[i];
        if( !schema[elem] ) schema[elem] = {}
        schema = schema[elem];
    }

    schema[pList[len-1]] = value;
}

