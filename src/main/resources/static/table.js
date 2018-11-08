/**
 * Data table creation and manipulations 
 */

/**
 * 
 * @param parent
 * @param data
 * @param id
 * @param structure
 * @returns
 */
function createTable(parent, data, id, structure, reload, addEventListeners) {
	var tbodyId = "t_body";
	var table = document.createElement("TABLE");
	table.id = id;
	table.classList.add("dataTable");
	var header = table.createTHead();
	var tr = header.insertRow(0);
	var i, j, td;
	var headersLength = structure.headers.length;
	for (i = 0; i < headersLength; i++) {
		th = document.createElement('th');
		th.innerText = structure.headers[i];
		tr.appendChild(th);
		var sortFunction = createSortFunction(tbodyId, i);
		th.addEventListener('click', sortFunction);
	}

	var isEditable = structure.options.hasOwnProperty('update');
	var isDeletable = structure.options.hasOwnProperty('deleteURL');
	var isUnDetailed = structure.options.hasOwnProperty('details');

	// add options column
	if (isEditable || isDeletable || isUnDetailed) {
		th = document.createElement('th');
		th.innerText = "Options";
		tr.appendChild(th);
	}

	var tbody = document.createElement('tbody');
	tbody.id = tbodyId;
	var dataLength = data.length;
	for (i = 0; i < dataLength; i++) {
		tr = tbody.insertRow(-1);
		for (j = 0; j < structure.keys.length; j++) {
			td = document.createElement('td');
			var func = new Function("return function (obj) {return obj."
					+ structure.keys[j] + "}")();
			try {
				td.innerHTML = func(data[i]);
			} catch (e) {
				td.innerHTML = "";
			}

			tr.appendChild(td);
		}

		td = document.createElement('td');

		if (isEditable || isDeletable || isUnDetailed) {

			if (isEditable) {
				var icon1 = createOptionIcon("editIcon", [ "fa", "fa-edit" ]);
				icon1.addEventListener('click', createShowUpdateFormFunction(
						parent, structure, data[i].id, reload,
						addEventListeners));
				td.appendChild(icon1);
			}

			if (isDeletable) {
				var icon2 = createOptionIcon("deleteIcon",
						[ "fa", "fa-trash-o" ]);
				icon2.addEventListener('click', createSendAjaxRequestFunction(
						structure.url + "/" + data[i].id, "DELETE", function() {
							// loadDepartments(parent);
							reload();
						}));
				td.appendChild(icon2);
			}

			if (isUnDetailed) {
				var icon3 = createOptionIcon("detailIcon", [ "fa",
						"fa-info-circle" ]);
				icon3.addEventListener('click', createShowDetailPageFunction(
						parent, structure, data[i].id));
				td.appendChild(icon3);
			}

			tr.appendChild(td);
		}

	}
	table.appendChild(tbody);
	return table;
}

/**
 * 
 * @param parent
 * @param structure
 * @param id
 * @returns
 */
function createShowUpdateFormFunction(parent, structure, id, reload,
		addEventListeners) {
	return function() {
		getViewSection(parent, structure.options.update.updateForm.replace(
				"/id", "/" + id), function() {
			submitButton = parent.querySelector("input[type=submit]");
			submitButton.addEventListener('click', function(e) {
				e.preventDefault();
				handleFormSubmit(parent, function() {
					// loadDepartments(parent);
					reload();
				});
			});
			if (typeof addEventListeners === "function")
				addEventListeners();
		});
	};
}

function createShowDetailPageFunction(parent, structure, id) {
	return function() {
		getViewSection(parent, structure.options.details.replace("/id", "/"
				+ id));
	};
}

/**
 * 
 * @param parent
 * @param structure
 * @returns
 */
function createShowAddFormButton(parent, structure, reload, callback) {
	var addButton = document.createElement('button');
	addButton.innerHTML = "Add";
	addButton.classList.add("add-btn");

	var showAddFormFunction = createShowAddFormFunction(parent, structure,
			reload, callback);
	addButton.addEventListener('click', showAddFormFunction);
	return addButton;
}

/**
 * 
 * @param parent
 * @param structure
 * @returns
 */
function createShowAddFormFunction(parent, structure, reload, callback) {
	return function() {
		getViewSection(parent, structure.options.create.createForm, function() {
			submitButton = parent.querySelector("input[type=submit]");
			submitButton.addEventListener('click', function(e) {
				e.preventDefault();
				handleFormSubmit(parent, function() {
					// loadDepartments(parent);
					reload();
				});
			});
			if (typeof callback === "function")
				callback();
		});
	};
}

function createSendAjaxRequestFunction(url, method, callback) {
	return function() {
		sendAjaxRequest(url, method, callback);
	}
}

function createOptionIcon(id, classes) {
	var icon = document.createElement('i');
	icon.id = id;
	classes.forEach(function(cssClass) {
		icon.classList.add(cssClass);
	});
	return icon;
}

function createSearchField(id) {
	var searchField = document.createElement("input");
	searchField.setAttribute("type", "text");
	searchField.setAttribute("id", "search_input");
	searchField.setAttribute("placeholder", "Search..");
	searchField.setAttribute("title", "Search");
	searchField.classList.add("searchInput");
	searchField.addEventListener('keyup', function() {
		searchTable(searchField, id);
	});
	return searchField;

}

function searchTable(searchField, tableId) {
	var filter, found, table, tr, td, i, j;

	filter = searchField.value.toUpperCase();
	table = document.getElementById(tableId);
	tr = table.getElementsByTagName("tr");
	var trLength = tr.length;
	for (i = 1; i < trLength; i++) {
		td = tr[i].getElementsByTagName("td");
		for (j = 0; j < td.length; j++) {
			if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
				found = true;
			}
		}
		if (found) {
			tr[i].style.display = "";
			found = false;
		} else {
			tr[i].style.display = "none";
		}
	}
}

/**
 * 
 * @param tbodyId
 * @param i
 * @returns
 */
function createSortFunction(tbodyId, i) {
	return function() {
		sort(tbodyId, i);
	};
}

var index; // cell index
var sortDir;

/**
 * 
 * @param tbodyId
 * @param index
 * @returns
 */
function sort(tbodyId, index) {
	var i;
	this.index = index;
	if (sortDir) {
		sortDir = false;
	} else {
		sortDir = true;
	}
	var tbody = document.getElementById(tbodyId);
	var datas = new Array();
	var tbodyLength = tbody.rows.length;
	for (i = 0; i < tbodyLength; i++) {
		datas[i] = tbody.rows[i];
	}

	// sort by cell[index]
	datas.sort(compareCells);
	for (i = 0; i < tbody.rows.length; i++) {
		// rearrange table rows by sorted rows
		tbody.appendChild(datas[i]);
	}
}

/**
 * 
 * @param a
 * @param b
 * @returns
 */
function compareCells(a, b) {
	var aVal = a.cells[index].innerText;
	var bVal = b.cells[index].innerText;

	aVal = aVal.replace(/\,/g, '');
	bVal = bVal.replace(/\,/g, '');

	if (sortDir) {
		var temp = aVal;
		aVal = bVal;
		bVal = temp;
	}

	if (aVal.match(/^[0-9]+$/) && bVal.match(/^[0-9]+$/)) {
		return parseFloat(aVal) - parseFloat(bVal);
	} else {
		if (aVal < bVal) {
			return -1;
		} else if (aVal > bVal) {
			return 1;
		} else {
			return 0;
		}
	}
}
