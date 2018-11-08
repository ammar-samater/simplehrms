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
			if (input.type == "radio") {
				if (input.checked)
					setValue(obj, input.name, input.value);
			} else {
				setValue(obj, input.name, input.value);
			}
		}
	}
	
	var msinputs = document.getElementsByClassName("multiSelectContainer");

	var j, l2 = msinputs.length;
	for (j = 0; j < l2; j++) {
		var getGlobalSelectedItemsObject = Function("return "+msinputs[j].id);
		var selectedItems = getGlobalSelectedItemsObject();
		setValue(obj, msinputs[j].id, selectedItems);
		//alert(JSON.stringify(selectedItems));
	/*	if (input[j].classList.containes("tagRenderedElement"))
			setValue(obj, input[j].id, input[j].id.substring(1,
					id.length - 1));*/
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

function filterCompetencies() {
	// get competencies list
	var competencyOptions = document
			.getElementById("requiredCompetenciesOptions");

	var competencies = competencyOptions.children;

	// get user input
	var requiredCompetenciesInput = document
			.getElementById("competenciesMultiSelect");
	var filter = requiredCompetenciesInput.value.toUpperCase();

	// create filtered list <p id= "competencies[i].id">
	var i, p, l = competencies.length;
	var found = false;

	for (i = 0; i < l; i++) {
		if (competencies[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
			competencies[i].style.display = "";
			found = true;
			/*
			 * p = document.createElement('p'); p.id = competencies[i].id;
			 * p.innerHTML = competencies[i].name;
			 * competencyOptions.appendChild(p);
			 */
		} else {
			competencies[i].style.display = "none";
		}
	}

	if (found == true) {
		competencyOptions.style.display = "block";
	} else {
		competencyOptions.style.display = "none";
	}
	// display filtered list

	// find selected items and set them as selected ///////////////////////

}

function hideDropdown() {
	var element = document.getElementById("requiredCompetenciesOptions");
	if (element.style.display != "none")
		element.style.display = "none";
}

function addSelectedCompetency(event) {
	var selected = event.target;
	addCompetency(selected.textContent.trim(), selected.id);
	// add item id to selected object
}

function addCompetency(value, id) {
	var span = document.createElement('span');
	span.id = id + "d";
	span.classList.add("tagRenderedElement");
	span.innerHTML = value + "<span class='closeTag' onclick='closeTag(\"" + id
			+ "d\")'>&times;</span>";
	// add closing span to span, and add event listener to remove tag
	var div = document.getElementById("competencies");
	var input = document.getElementById("competenciesMultiSelect");
	input.value = "";
	div.insertBefore(span, input);
	hideDropdown();
	// add item id to selected object
	window.competencies.push({"id" : parseInt(id)});
}

function closeTag(id) {
	var element = document.getElementById(id);
	element.parentNode.removeChild(element);
	removeCompetency(id.substring(1, id.length - 1));
}

function removeCompetency(id) {
	var i, l = window.competencies.length;
	for (i = 0; i < l; i++) {
		if (window.competencies[i].id === id) {
			window.competencies.splice(i, 1);
		}
	}
}
