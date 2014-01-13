<%@include file="taglib_includes.jsp"%>

<html>

<link
	href="${pageContext.request.contextPath}/resources/css/createUser_style.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		$("#viewCollabTabs").tabs();
	});
</script>
<style>
.ui-tabs-vertical {
	width: 55em;
}

.ui-tabs-vertical .ui-tabs-nav {
	padding: .2em .1em .2em .2em;
	float: left;
	width: 12em;
}

.ui-tabs-vertical .ui-tabs-nav li {
	clear: center;
	width: 100%;
	border-bottom-width: 1px !important;
	border-right-width: 0 !important;
	margin: 0 -1px .2em 0;
}

.ui-tabs-vertical .ui-tabs-nav li a {
	display: block;
}

.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 1px;
	border-right-width: 1px;
}

.ui-tabs-vertical .ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 40em;
}
</style>
</head>
<body>
	<form:form action="collaborators" method="post" id="createCollab"
		commandName="viewCollab">
		<div id="viewCollabTabs">
			<ul>
				<li><a href="#tabs-1">Donnees personelles</a></li>
				<li><a href="#tabs-2">Diplomes</a></li>
				<li><a href="#tabs-3">Technologies</a></li>
				<li><a href="#tabs-4">Reporting</a></li>
			</ul>
			<div id="tabs-1">
				<h2>Donnees personelles</h2>
				<table style="border-collapse: none;"
					background="../images/header-bg.gif" align="center" id="tabcol">
					<tr>
						<td>matricule</td>
						<td><form:input path="matricule" readonly="true" /></td>
						<td>nom</td>
						<td><form:input path="nom" readonly="true" /></td>
						<td>prenom</td>
						<td><form:input path="prenom" readonly="true" /></td>
					</tr>
					<tr>
						<td>abreviation</td>
						<td><form:input path="abreviation" readonly="true" /></td>
						<td>Ancien manager</td>
						<td><form:input path="mgrhAncien" readonly="true" />
						<td>manager actuel</td>
						<td><form:input path="mgrhActuel" readonly="true" /></td>
					</tr>
					<tr>
						<td>sexe</td>
						<td><form:input path="sexe" readonly="true" /></td>
						<td>site</td>
						<td><form:input path="site" readonly="true" /></td>
						<td>bu</td>
						<td><form:input path="bu" /></td>
					</tr>
					<tr>
						<td>salaire actuel</td>
						<td><form:input path="salaireActuel" readonly="true" /></td>
						<td>Date embauche</td>
						<td><form:input path="dateEmbauche" readonly="true" /></td>
						<td>Mois bap</td>
						<td><form:input path="moisBap" readonly="true" /></td>
					</tr>
					<tr>
						<td>Date de depart</td>
						<td><form:input path="dateDepart" readonly="true" /></td>
						<td>Ancien collaborateur</td>
						<td><form:checkbox path="ancienColl" checked="checked"
								name="bu" readonly="true" /></td>
						<td>Participe si</td>
						<td><form:checkbox path="participeSi" readonly="true" /></td>
					</tr>
					<tr>
						<td>Date participation</td>
						<td><form:input path="dateSi" readonly="true" /></td>
						<td>Poste actuel (3)</td>
						<td><form:input path="posteActuel3" readonly="true" /></td>
						<td>Poste actuel (4)</td>
						<td><form:input path="posteActuel4" readonly="true" /></td>
						<td>Role</td>
						<td><form:input path="role" readonly="true" /></td>
					</tr>
				</table>
			</div>
			<div id="tabs-2">
				<h2>Diplome:</h2>
				<c:if test="${diplomesSize!=0}">
					<c:forEach var="dipl" begin="0" end="${diplomesSize - 1}">

						<table background="../images/header-bg.gif"
							style="border-collapse: none;" align="center" id="tabcol">

							<tr>
								<td>Titre:</td>
								<td><form:input path="DIPLOME[${dipl}].nom" readonly="true" /></td>
								<td>Ecole:</td>
								<td><form:input path="DIPLOME[${dipl}].ecole"
										readonly="true" /></td>
								<td>Ecole type:</td>
								<td><form:input path="DIPLOME[${dipl}].ecoleType"
										id="combobox" readonly="true" /></td>
							</tr>
							<tr>
								<td>Diplome type:</td>
								<td><form:input path="DIPLOME[${dipl}].diplomeType"
										readonly="true" /></td>
								<td>promotion:</td>
								<td><form:input path="DIPLOME[${dipl}].promotion"
										readonly="true" /></td>
								<td>niveau:</td>
								<td><form:input path="DIPLOME[${dipl}].niveau" id="niveau"
										readonly="true" /></td>
							</tr>
						</table>

					</c:forEach>
				</c:if>
			</div>
			<div id="tabs-3">
				<h2>Technologie:</h2>
				<c:if test="${technologiesSize!=0}">
					<c:forEach var="tech" begin="0" end="${technologiesSize - 1}">
						<div id="itemTech">
							<table background="../images/header-bg.gif"
								style="border-collapse: none;" align="center" id="tabcol">
								<tr>
									<td>Technologie:</td>
									<td><form:input path="TECHNOLOGIE[${tech}].technologie"
											readonly="true" /></td>

									<td>Competence #1</td>
									<td><form:input path="COMPETENCE[${tech}].competence"
											readonly="true" /></td>

									<td>Niveau d'expertise</td>
									<td><form:input path="COMPETENCE[${tech}].niveauExpertise"
											readonly="true" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>Competence #2</td>
									<td><form:input path="COMPETENCE[${tech +1}].competence"
											readonly="true" /></td>

									<td>Niveau d'expertise</td>
									<td><form:input
											path="COMPETENCE[${tech +1}].niveauExpertise" readonly="true" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>Competence #3</td>
									<td><form:input path="COMPETENCE[${tech +2}].competence"
											readonly="true" /></td>

									<td>Niveau d'expertise</td>
									<td><form:input
											path="COMPETENCE[${tech +2}].niveauExpertise" readonly="true" /></td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</c:if>
			</div>

			<div id="tabs-4">Reporting</div>
			
		</div>
		</form:form>
		<input type="button" value="Back" onclick="go('collaborators');">
</body>


</html>