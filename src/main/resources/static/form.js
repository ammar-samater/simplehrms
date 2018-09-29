/**
 * Form validation and submission
 */

function handleFormSubmit(parent, callback) {

	// collect the form data while iterating over the inputs
	var form = parent.querySelector("form");

	var obj = {};
	for (var i = 0, l = form.length; i < l; ++i) {
		var input = form[i];
		if (input.name) {
			setValue(obj, input.name, input.value);
		}
	}

	// construct an HTTP request
	var xhr = new XMLHttpRequest();

	xhr.open(form.method, form.action, true);
	xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

	// send the collected data as JSON
	xhr.send(JSON.stringify(obj));

	xhr.onloadend = function() {
		callback();
	};
}

function setValue(obj, path, value) {
	var schema = obj; // a moving reference to internal objects within obj
	var pList = path.split('.');
	var len = pList.length;
	for (var i = 0; i < len - 1; i++) {
		var elem = pList[i];
		if (!schema[elem])
			schema[elem] = {}
		schema = schema[elem];
	}

	schema[pList[len - 1]] = value;
}

/**
 * This method shows the cities for the selected country. Assumes there is an
 * exisiting select element with the id 'cities'
 * 
 */
function getCitySelectList() {
	var country_select = document.getElementById("country");
	var country_id = country_select.options[country_select.selectedIndex].value;

	sendAjaxRequest("/countries/" + country_id + "/cities", "GET", function(
			data) {
		data = JSON.parse(data);
		var citySelect = document.getElementById("city");
		citySelect.options.length = 0;
		
		var option, city, i;
		var length = data.length;
     
		for (i = 0; i < length; i++) {
			city = data[i];
			option = document.createElement("option");
			option.value = city.id;
			option.text = city.name;
			citySelect.add(option);
		}

	});

}
