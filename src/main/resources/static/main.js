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
				loadDepartments(mainDiv);
			});

	document.getElementById("employee_mangement_tab").addEventListener("click",
			function() {
				loadEmployees(mainDiv);
			});
});

function loadDashboard(parent) {

}

function loadDepartments(parent) {

	var structure = {
		entityName : "department",
		url : "http://localhost:8080/departments",
		headers : [ "Department Id", "Department Name", "إسم القسم", "Site" ],
		keys : [ "departmentId", "name", "nameLang2", "site.name" ],
		options : {
			create : {
				createForm : "http://localhost:8080/departments/create",
				createURL : "http://localhost:8080/departments"
			},
			update : {
				updateForm : "http://localhost:8080/departments/id/update",
				updateURL : "http://localhost:8080/departments/id"
			},
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

		container.appendChild(createTable(parent, data, tableId, structure, function() {loadDepartments(parent);}));

		container.appendChild(createShowAddFormButton(container, structure, function() {loadDepartments(parent);}));

		dropChildNodes(parent);
		var frag = document.createDocumentFragment();
		frag.appendChild(container);
		parent.appendChild(frag);
	});
}

function loadEmployees(parent) {

	var structure = {
		url : "http://localhost:8080/employees",
		headers : [ "Employee Number", "First Name", "Last Name",
				"Date of Birth", "Date of Hire" ],
		keys : [ "employeeNumber", "firstName", "lastName", "dob", "hireDate" ],
		options : {
			create : {
				createForm : "http://localhost:8080/employees/create",
				createURL : "http://localhost:8080/employees"
			},
			update : {
				updateForm : "http://localhost:8080/employees/id/update",
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

		container.appendChild(createTable(parent, data, tableId, structure, function() {loadEmployees(parent);}));
		// var addFormId = "add_employees_form";
		container.appendChild(createShowAddFormButton(container, structure, function() {loadEmployees(parent);}));

		dropChildNodes(parent);
		var frag = document.createDocumentFragment();
		frag.appendChild(container);
		parent.appendChild(frag);
	});
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
