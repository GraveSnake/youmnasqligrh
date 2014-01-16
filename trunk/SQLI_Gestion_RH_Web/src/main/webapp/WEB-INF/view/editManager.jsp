<%@include file="taglib_includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit collaborateur</title>
</head>
<link
	href="${pageContext.request.contextPath}/resources/css/createUser_style.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		$("#editCollabTabs").tabs();
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
	<p class="validateTips" style="color: red"></p>
	<input type="button" value="Save" id="enregister">
	<input type="button" value="Back" onclick="go('adminManagers');">
	<br/><br/>
	<form:form action="updateManager" method="post" id="ManagerForm"
		commandName="editManager">
		<div id="editCollabTabs">
			<ul>
				<li><a href="#tabs-1">Donnees personelles</a></li>
				<li><a href="#tabs-2">Diplomes</a></li>
				<li><a href="#tabs-3">Technologies</a></li>
				<li><a href="#tabs-4">Compte</a></li>
			</ul>
			<div id="tabs-1">
				<h2 style="color: maroon">Données personelles:</h2>
				<table style="border-collapse: none;" align="center" id="tabcol">
					<tr>
						<td><label>Matricule:</label></td>
						<td><form:input path="matricule" id="matricule"
								readonly="true" /></td>
						<td><label>Nom:</label></td>
						<td><form:input path="nom" id="nom" /></td>
						<td><label>Prenom:</label></td>
						<td><form:input path="prenom" id="prenom" /></td>
					</tr>
					<tr>
						<td><label>Abreviation:</label></td>
						<td><form:input path="abreviation" id="abreviation" /></td>
						<td><label>Sexe:</label></td>
						<td><form:select path="sexe">
								<form:option value="F">F</form:option>
								<form:option value="M">M</form:option>
							</form:select></td>
						<td><label>Site:</label></td>
						<td><form:input path="site" id="site" /></td>

					</tr>
					<tr>

						<td><label>Bu:</label></td>
						<td><form:input path="bu" id="bu" /></td>
						<td><label>Salaire actuel (DH):</label></td>
						<td><form:input path="salaireActuel" id="salaire_actuel" /></td>
						<td><label>Date embauche:</label></td>
						<td><form:input path="dateEmbauche" id="date_embauche" /></td>
					</tr>
					<tr>

						<td><label>Mois bap:</label></td>
						<td><form:input path="moisBap" id="bap" /></td>
						<td><label>Date de depart:</label></td>
						<td><form:input path="dateDepart" id="date_depart" /></td>
						<td><label>Ancien collaborateur:</label></td>
						<td><form:checkbox path="ancienColl" name="bu" /></td>
					</tr>
					<tr>

						<td><label>Participe SI:</label></td>
						<td><form:checkbox path="participeSi" /></td>
						<td><label>Date participation:</label></td>
						<td><form:input path="dateSi" id="date_particp" /></td>
						<td><label>Poste actuel (3):</label></td>
						<td><form:input path="posteActuel3" id="poste_actuel3" /></td>
					</tr>
					<tr>
						<td><label>Poste actuel (4):</label></td>
						<td><form:input path="posteActuel4" id="poste_actuel4" /></td>
					</tr>
				</table>
			</div>
			<div id="tabs-2">
				<h2 style="color: maroon">Diplome:</h2>
				<c:if test="${diplomesSize!=0}">
					<c:forEach var="dipl" begin="0" end="${diplomesSize - 1}">

						<table 
							style="border-collapse: none;" align="center" id="tabcol">

							<tr>
								<td><label>Titre:</label></td>
								<td><form:input path="DIPLOME[${dipl}].nom" /></td>
								<td><label>Ecole:</label></td>
								<td><form:input path="DIPLOME[${dipl}].ecole" /></td>
								<td><label>Ecole type:</label></td>
								<td><form:select path="DIPLOME[${dipl}].ecoleType"
										id="combobox">
										<form:option value="National">National</form:option>
										<form:option value="International">International</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td><label>Diplome type:</label></td>
								<td><form:select path="DIPLOME[${dipl}].diplomeType">
										<form:option value="etatique">etatique</form:option>
										<form:option value="prive">prive</form:option>
									</form:select></td>
								<td><label>Promotion:</label></td>
								<td><form:input path="DIPLOME[${dipl}].promotion"
										id="promotion" /></td>
								<td><label>Niveau:</label></td>
								<td><form:input path="DIPLOME[${dipl}].niveau" id="niveau" /></td>
							</tr>
						</table>
					<hr width="200"/>
					</c:forEach>
				</c:if>
			</div>
			<div id="tabs-3">
				<h2 style="color: maroon">Technologie:</h2>
				<c:if test="${technologiesSize!=0}">
					<c:forEach var="tech" begin="0" end="${technologiesSize - 1}">
						<div id="itemTech">
							<table 
								style="border-collapse: none;" align="center" id="tabcol">
								<tr>
									<td><label>Technologie:</label></td>
									<td><form:input path="TECHNOLOGIE[${tech}].technologie" /></td>

									<td><label>Competence #1:</label></td>
									<td><form:input path="COMPETENCE[${tech}].competence" /></td>

									<td><label>Niveau d'expertise:</label></td>
									<td><form:input
											path="COMPETENCE[${tech}].niveauExpertise"/></td>
								</tr>
							</table>
						</div>
						<hr width="200"/>
					</c:forEach>
				</c:if>
			</div>
			<div id="tabs-4">
				<h2 style="color: maroon">Compte:</h2>
				<table style="border-collapse: none;" align="center" id="tabcol">
					<tr>
						<td><label>Login</label></td>
						<td><form:input path="compte.login" id="login"
								readonly="true" /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="compte.password" id="password" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="compte.email" id="email" /></td>
					</tr>
				</table>
			</div>

		</div>
	</form:form>
</body>


<!-- *************************** -->


</html>