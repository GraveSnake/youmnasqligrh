<%@include file="taglib_includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<!-- Insert datatable here -->
	<div id="tablewrapper">
		<div id="tableheader">
			<div class="search">
				<select id="columns" onchange="sorter.search('query')"></select> <input
					type="text" id="query" onkeyup="sorter.search('query')" />
			</div>
			<span class="details">
				<div>
					Records <span id="startrecord"></span>-<span id="endrecord"></span>
					of <span id="totalrecords"></span>
				</div>
				<div>
					<a href="javascript:sorter.reset()">reset</a>
				</div>
			</span>
		</div>
		<table cellpadding="0" border="2" id="table" class="tinytable">
			<thead>
				<tr>
					<!--  <th class="nosort"><h3>ID</h3></th>-->
					<th><h3>Matricule</h3></th>
					<th><h3>Nom&Prenom</h3></th>
					<th><h3>Date Embauche</h3></th>
					<th><h3>Poste Actuel</h3></th>
					<th><h3>Salaire actuel</h3></th>
					<th><h3>Ancien</h3></th>
					<th><h3>Manager Ancien</h3></th>
					<th><h3>Manager Actuel</h3></th>
					<th><h3>Role</h3></th>
					<th><h3>Actions</h3></th>
				</tr>
			</thead>
			<tbody>

		<!--<c:forEach var="collabs" items="${ListCollab}">
			<tr>
			<td><c:out value="${collabs.matricule}"></c:out></td>
			<td><c:out value="${collabs.nom}"/><c:out value="${collabs.prenom}"/></td>
			<td><c:out value="${collabs.dateEmbauche}"></c:out></td>
			<td><c:out value="${collabs.posteActuel3}"></c:out></td>
			<td><c:out value="${collabs.salaireActuel}"></c:out></td>
			<td><c:out value="${collabs.ancienColl}"></c:out></td>
			<td><c:out value="${collabs.mgrhAncien}"></c:out></td>	
			<td><c:out value="${collabs.mgrhActuel}"></c:out></td>	
			<td><c:out value="${collabs.role}"></c:out></td>
			<td>
			<a href="updateCollab?COLLAB_ID=${collabs.matricule}">Edit</a>  
     			  &nbsp;&nbsp;  
          <a href="viewCollab?COLLAB_ID=${collabs.matricule}">View</a> 
               	&nbsp;&nbsp;  
          <a href="deleteCollab?COLLAB_ID=${collabs.matricule}">Delete</a> 
          </td>	
			</tr>
		</c:forEach>-->
		
			</tbody>
		</table>
		<div id="tablefooter">
			<div id="tablenav">
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/first.gif" width="16" height="16" alt="First Page"
						onclick="sorter.move(-1,true)" /> <img src="${pageContext.request.contextPath}/resources/images/previous.gif"
						width="16" height="16" alt="First Page" onclick="sorter.move(-1)" />
					<img src="${pageContext.request.contextPath}/resources/images/next.gif" width="16" height="16" alt="First Page"
						onclick="sorter.move(1)" /> <img src="${pageContext.request.contextPath}/resources/images/last.gif" width="16"
						height="16" alt="Last Page" onclick="sorter.move(1,true)" />
				</div>
				<div>
					<select id="pagedropdown"></select>
				</div>
				<div>
					<a href="javascript:sorter.showall()">view all</a>
				</div>
			</div>
			<div id="tablelocation">
				<div>
					<select onchange="sorter.size(this.value)">
						<option value="5">5</option>
						<option value="10" selected="selected">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select> <span>Entries Per Page</span>
				</div>
				<div class="page">
					Page <span id="currentpage"></span> of <span id="totalpages"></span>
				</div>
			</div>
		</div>
	</div>
	<script
	src="${pageContext.request.contextPath}/resources/js/script.js">
	
</script>
	<script type="text/javascript">
		var sorter = new TINY.table.sorter('sorter', 'table', {
			headclass : 'head',
			ascclass : 'asc',
			descclass : 'desc',
			evenclass : 'evenrow',
			oddclass : 'oddrow',
			evenselclass : 'evenselected',
			oddselclass : 'oddselected',
			paginate : true,
			size : 10,
			colddid : 'columns',
			currentid : 'currentpage',
			totalid : 'totalpages',
			startingrecid : 'startrecord',
			endingrecid : 'endrecord',
			totalrecid : 'totalrecords',
			hoverid : 'selectedrow',
			pageddid : 'pagedropdown',
			navid : 'tablenav',
			sortcolumn : 1,
			sortdir : 1,
			//sum:[8],
			//avg:[6,7,8,9],
			columns : [ {
				index : 7,
				format : '%',
				decimals : 1
			}, {
				index : 8,
				format : '$',
				decimals : 0
			} ],
			init : true
		});
	</script>
</body>
</html>