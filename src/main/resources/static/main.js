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
	dropChildNodes(parent);
	var url = "/departments";
	getJson(
			url,
			function(data) {
				var frag = document.createDocumentFragment();

				// table
				var container = document.createElement('div');
				var tableId = "departments_table";

				container.id = "data";
				container.appendChild(createSearchField(tableId));
				var headers = [ "Department Id", "Department Name",
						"إسم القسم", "Site" ];
				var keys = [ "departmentId", "name", "nameLang2", "site.name" ];
				container.appendChild(createTable(parent, data, tableId, url, headers,
						keys, true, true));
				var addFormId = "add_department_form";
				container.appendChild(createShowAddFormButton(addFormId));
				frag.appendChild(container);

				// add-department form
				var container2 = document.createElement('div');
				container2.id = addFormId;
				container2.classList.add("hidden");
				getViewSection(container2,  url + "/add", function() {  // /forms/add/departments   departments/add
					var submitButton = container2
							.querySelector("input[type=submit]");
					submitButton.addEventListener('click', function(e) {
						e.preventDefault();
						handleFormSubmit(addFormId, function() {
							loadDepartments(parent);
						});
					});
				});
				frag.appendChild(container2);
				
				// update-department form
				var container3 = document.createElement('div');
				var updateFormId = "update_departments_form";
				container3.id = updateFormId;
				container3.classList.add("hidden");
				frag.appendChild(container3);
				
				parent.appendChild(frag);
			});
}

function loadEmployees(parent) {
	dropChildNodes(parent);
	var url = "/employees";
	getJson(
			url,
			function(data) {
				var frag = document.createDocumentFragment();

				// table
				var container = document.createElement('div');
				var tableId = "employees_table";

				container.id = "data";
				container.appendChild(createSearchField(tableId));
				var headers = [ "Employee Number", "First Name", "Last Name", 
						"Date of Birth", "Date of Hire"];
				var keys = [ "employeeNumber", "firstName", "lastName", "dob", "hireDate" ];
				container.appendChild(createTable(parent, data, tableId, url, headers,
						keys, true, true));
				var addFormId = "add_employee_form";
				container.appendChild(createShowAddFormButton(addFormId));
				frag.appendChild(container);

				// add-department form
				var container2 = document.createElement('div');
				container2.id = addFormId;
				container2.classList.add("hidden");
				getViewSection(container2, url + "/add", function() { //"/forms/add" + url
					var submitButton = container2
							.querySelector("input[type=submit]");
					submitButton.addEventListener('click', function(e) {
						e.preventDefault();
						handleFormSubmit(addFormId, function() {
							loadEmployees(parent);
						});
					});
				});
				frag.appendChild(container2);
				
		
				var container3 = document.createElement('div');
				container3.id = "update_employee_form";
				container3.classList.add("hidden");
				frag.appendChild(container3);
				
				parent.appendChild(frag);
			});
}

function dropChildNodes(element) {
	//alert(element);
	while (element.hasChildNodes()) {
		element.removeChild(element.lastChild);
	}
}

function getJson(url, callback) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback(JSON.parse(this.responseText));
		} else if (this.readyState == 4) {
			// callback(this.status); display errorMessage()
		}
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}

function sendAjaxRequest(url, method, callback){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback();
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


