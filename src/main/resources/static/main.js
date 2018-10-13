/**
 * 
 */

window.addEventListener('load', function() {

	var mainDiv = document.getElementById("main");

	document.getElementById("home_tab").addEventListener("click", function() {
		loadDashboard(mainDiv);
	});

	document.getElementById("departments_tab").addEventListener("click",
			function() {
				loadDepartmentsSection(mainDiv);
			});

	document.getElementById("employee_mangement_tab").addEventListener("click",
			function() {
				loadEmployeesSection(mainDiv);
			});

	document.getElementById("leave_management_tab").addEventListener("click",
			function() {
				loadLeaveManagementSection(mainDiv);
			});
});

function loadDashboard(parent) {

}

function loadDepartmentsSection(parent) {

	var structure = {
		entityName : "department",
		url : "http://localhost:8080/departments",
		headers : [ "Department Id", "Department Name", "إسم القسم", "Site" ],
		keys : [ "departmentId", "name", "nameLang2", "site.name" ],
		options : {
			create : {
				createForm : "http://localhost:8080/forms/departments/create",
				createURL : "http://localhost:8080/departments"
			},
			update : {
				updateForm : "http://localhost:8080/forms/departments/id/update",
				updateURL : "http://localhost:8080/departments/id"
			},
			details : "http://localhost:8080/departments/id/details",    
			audit : "http://localhost:8080/departments/id/audit",
			deleteURL : "http://localhost:8080/departments/id"
		}
	};
	sendAjaxRequest(structure.url, "GET", function(data) {
		data = JSON.parse(data);
		var container = document.createElement('div');
		container.id = "data";
		var tableId = "departments_table";

		container.appendChild(createSearchField(tableId));

		container.appendChild(createTable(parent, data, tableId, structure,
				function() {
					loadDepartmentsSection(parent);
				}));

		container.appendChild(createShowAddFormButton(container, structure,
				function() {
					loadDepartmentsSection(parent);
				}));

		dropChildNodes(parent);
		var frag = document.createDocumentFragment();
		frag.appendChild(container);
		parent.appendChild(frag);
	});
}

function loadEmployeesSection(parent) {

	var structure = {
		url : "http://localhost:8080/employees",
		headers : [ "Employee Number", "First Name", "Last Name",
				"Date of Birth", "Date of Hire" ],
		keys : [ "employeeNumber", "firstName", "lastName", "dob", "hireDate" ],
		options : {
			create : {
				createForm : "http://localhost:8080/forms/employees/create",
				createURL : "http://localhost:8080/employees"
			},
			update : {
				updateForm : "http://localhost:8080/forms/employees/id/update",
				updateURL : "http://localhost:8080/employees/id"
			},
			audit : "http://localhost:8080/employees/id/audit",
			deleteURL : "http://localhost:8080/employees/id/audit"
		}
	};
	sendAjaxRequest(structure.url, "GET", function(data) {
		data = JSON.parse(data);
		var container = document.createElement('div');
		container.id = "data";
		var tableId = "employees_table";

		container.appendChild(createSearchField(tableId));

		container.appendChild(createTable(parent, data, tableId, structure,
				function() {
					loadEmployeesSection(parent);
				}, function() {
					document.getElementById("country").addEventListener(
							"change", getCitySelectList);
				}));
		// var addFormId = "add_employees_form";

		container.appendChild(createShowAddFormButton(container, structure,
				function() {
					loadEmployeesSection(parent);
				}, function() {
					document.getElementById("country").addEventListener(
							"change", getCitySelectList);
				}));

		// document.getElementById("country").addEventListener("change",
		// getCitySelectList);

		dropChildNodes(parent);
		var frag = document.createDocumentFragment();
		frag.appendChild(container);
		parent.appendChild(frag);
	});
}

function loadLeaveManagementSection(parent) {
	// alert(parent);
	// display boxs with leave detail
	// create table with leave history

	// var menu = createLeaveMenuItem();

	dropChildNodes(parent);

	var row = createElement("div", [ "row" ], undefined, undefined);
	var frag = document.createDocumentFragment();
	frag.appendChild(row);

	for (i = 0; i < 8; i++) {
		row.appendChild(createLeaveMenuItem());
	}

	parent.appendChild(frag);
}

function dropChildNodes(element) {
	while (element.hasChildNodes()) {
		element.removeChild(element.lastChild);
	}
}

function sendAjaxRequest(url, method, callback) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback(this.responseText);
		} else if (this.readyState == 4) {
			// callback(this.status); display errorMessage()
		}
	};
	xhttp.open(method, url, true);
	xhttp.send();
}

function getViewSection(parent, url, callback) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			parent.innerHTML = this.responseText.trim();
			if (callback !== undefined)
				callback();
		} else if (this.readyState == 4) {
			// callback(this.status); display errorMessage()
		}

	};
	xhttp.open("GET", url, true);
	xhttp.send();
}

function hideSiblings(element) {
	var sibling = element.parentNode.firstChild;

	for (; sibling; sibling = sibling.nextSibling)
		if (sibling.nodeType == 1 && sibling != element)
			sibling.classList.add("hidden");

}

function createLeaveMenuItem(leaveInfo) {

	var col = createElement("div", [ "col" ]);
	var card = col.appendChild(createElement("div", [ "card" ]));

	card.appendChild(createElement("h2", [], undefined, "Paid"));

	card.appendChild(createElement("label", [], undefined, "Annual"));
	card.appendChild(createElement("p", [], undefined, "10"));

	card.appendChild(createElement("label", [], undefined, "Used"));
	card.appendChild(createElement("p", [], undefined, "5"));

	card.appendChild(createElement("label", [], undefined, "Avaliable"));
	card.appendChild(createElement("p", [], undefined, "5"));

	var button = card.appendChild(createElement("button", [], undefined,
			"Request"));
	// add eventlistener to button
	return col;

}

function createElement(type, classes, id, innerText) {
	var element = document.createElement(type);
	var i, length = classes.length;
	for (i = 0; i < length; i++) {
		element.classList.add(classes[i]);
	}
	if (typeof id !== "undefined")
		element.id = id;
	if (typeof innerText !== "undefined")
		element.innerText = innerText;
	return element;
}
