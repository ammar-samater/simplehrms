/**
 * 
 */

function createTable(parent, data, id, url, headers, keys, isEditable,
		isDeletable) {
	var tbodyId = "t_body";
	var table = document.createElement("TABLE");
	table.id = id;
	table.classList.add("dataTable");
	var header = table.createTHead();
	var tr = header.insertRow(0);
	var i, j, td;
	var headersLength = headers.length;
	for (i = 0; i < headersLength; i++) {
		th = document.createElement('th');
		th.innerText = headers[i];
		tr.appendChild(th);
		var sortFunction = createSortFunction(tbodyId, i);
		th.addEventListener('click', sortFunction);
	}

	// add options column
	if (isEditable || isDeletable) {
		th = document.createElement('th');
		th.innerText = "Options";
		tr.appendChild(th);
	}

	var tbody = document.createElement('tbody');
	tbody.id = tbodyId;
	var dataLength = data.length;
	for (i = 0; i < dataLength; i++) {
		tr = tbody.insertRow(-1);
		for (j = 0; j < keys.length; j++) {
			td = document.createElement('td');
			var func = new Function("return function (obj) {return obj."
					+ keys[j] + "}")();
			try {
				td.innerHTML = func(data[i]);
			} catch (e) {
				td.innerHTML = "";
			}

			tr.appendChild(td);
		}

		if (isEditable || isDeletable) {

			if (isEditable) {
				var icon1 = createOptionIcon("editIcon", [ "fa", "fa-edit" ]);
				icon1.addEventListener('click', createShowUpdateFormFunction(url+ "/"+data[i].id+ "/update", "update_"+url.substring(1)+"_form", parent));  // "forms/update" +url+ "/"+data[i].id
			}

			if (isDeletable) {
				var icon2 = createOptionIcon("deleteIcon",
						[ "fa", "fa-trash-o" ]);
				icon2.addEventListener('click', createSendAjaxRequestFunction(
						url + "/" + data[i].id, "DELETE", function() {
							loadDepartments(parent);
						}));
			}

			td = document.createElement('td');
			td.appendChild(icon1);
			td.appendChild(icon2);
			tr.appendChild(td);
		}

	}
	table.appendChild(tbody);
	return table;
}

function createShowUpdateFormFunction(url, formId){
	return function() {
		showUpdateForm(url, formId);
	}
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

function createSortFunction(tbodyId, i) {
	return function() {
		sort(tbodyId, i);
	};
}

var index; // cell index
var sortDir;
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

function createShowAddFormButton(formId) {
	var addButton = document.createElement('button');
	addButton.innerHTML = "Add";
	addButton.classList.add("add-btn");

	var showAddFormFunction = createShowAddFormFunction(formId);
	addButton.addEventListener('click', showAddFormFunction);
	return addButton;
}

// all addition forms are under '/forms/add/{entity}'
function createShowAddFormFunction(formId) {
	return function() {
		var element = document.getElementById(formId);
		hideSiblings(element);
		element.classList.remove("hidden");
	};
}