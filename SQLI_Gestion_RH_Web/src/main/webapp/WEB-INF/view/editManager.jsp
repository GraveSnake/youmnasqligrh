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
	<p class="validateTips" style="color: red">All form fields are
		required.</p>
	<form:form action="collaborators" method="post" id="Collab"
		commandName="editCollab">
		<div id="editCollabTabs">
			<ul>
				<li><a href="#tabs-1">Donnees personelles</a></li>
				<li><a href="#tabs-2">Diplomes</a></li>
				<li><a href="#tabs-3">Technologies</a></li>
				<li><a href="#tabs-4">Compte</a></li>
			</ul>
			<div id="tabs-1">
				<h2>Donnees personelles</h2>
				<table style="border-collapse: none;"
					background="../images/header-bg.gif" align="center" id="tabcol">
					<tr>
						<td>Matricule</td>
						<td><form:input path="matricule" id="matricule"
								readonly="true" /></td>
						<td>Nom</td>
						<td><form:input path="nom" id="nom" /></td>
						<td>Prenom</td>
						<td><form:input path="prenom" id="prenom" /></td>
					</tr>
					<tr>
						<td>Abreviation</td>
						<td><form:input path="abreviation" id="abreviation" /></td>
						<td>Ancien manager</td>
						<td><form:select path="mgrhAncien" id="Ancien_manager">
								<form:option value="Aucun">Aucun</form:option>
								<form:options items="${managers}" />
							</form:select></td>
						<td>Manager actuel</td>
						<td><form:select path="mgrhActuel" id="manager_actuel">
								<form:option value="Aucun">Aucun</form:option>
								<form:options items="${managers}" />
							</form:select></td>
					</tr>
					<tr>
						<td>Sexe</td>
						<td><form:select path="sexe" id="combobox">
								<form:option value="F">F</form:option>
								<form:option value="M">M</form:option>
							</form:select></td>
						<td>Site</td>
						<td><form:input path="site" id="site" /></td>
						<td>Bu</td>
						<td><form:input path="bu" id="bu" /></td>
					</tr>
					<tr>
						<td>Salaire actuel</td>
						<td><form:input path="salaireActuel" id="salaire_actuel" /></td>
						<td>Date embauche</td>
						<td><form:input path="dateEmbauche" id="date_embauche" /></td>
						<td>Mois bap</td>
						<td><form:input path="moisBap" id="mois_bap" /></td>
					</tr>
					<tr>
						<td>Date de depart</td>
						<td><form:input path="dateDepart" id="date_depart" /></td>
						<td>Ancien collaborateur</td>
						<td><form:checkbox path="ancienColl" checked="checked"
								name="bu" /></td>
						<td>Participe si</td>
						<td><form:checkbox path="participeSi" id="participe_si" /></td>
					</tr>
					<tr>
						<td>Date participation</td>
						<td><form:input path="dateSi" id="date_particp" /></td>
						<td>Poste actuel (3)</td>
						<td><form:input path="posteActuel3" id="poste_actuel3" /></td>
						<td>Poste actuel (4)</td>
						<td><form:input path="posteActuel4" id="poste_actuel4" /></td>
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
								<td><form:input path="DIPLOME[${dipl}].nom" /></td>
								<td>Ecole:</td>
								<td><form:input path="DIPLOME[${dipl}].ecole" /></td>
								<td>Ecole type:</td>
								<td><form:select path="DIPLOME[${dipl}].ecoleType"
										id="combobox">
										<form:option value="National">National</form:option>
										<form:option value="International">International</form:option>
									</form:select></td>
							</tr>
							<tr>
								<td>Diplome type:</td>
								<td><form:select path="DIPLOME[${dipl}].diplomeType">
										<form:option value="etatique">etatique</form:option>
										<form:option value="prive">prive</form:option>
									</form:select></td>
								<td>Promotion:</td>
								<td><form:input path="DIPLOME[${dipl}].promotion" /></td>
								<td>Niveau:</td>
								<td><form:input path="DIPLOME[${dipl}].niveau" id="niveau" /></td>
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
									<td><form:input path="TECHNOLOGIE[${tech}].technologie" /></td>

									<td>Competence #1</td>
									<td><form:input path="COMPETENCE[${tech}].competence" /></td>

									<td>Niveau d'expertise</td>
									<td><form:input path="COMPETENCE[${tech}].niveauExpertise" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>Competence #2</td>
									<td><form:input path="COMPETENCE[${tech +1}].competence" /></td>

									<td>Niveau d'expertise</td>
									<td><form:input
											path="COMPETENCE[${tech +1}].niveauExpertise" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>Competence #3</td>
									<td><form:input path="COMPETENCE[${tech +2}].competence" /></td>

									<td>Niveau d'expertise</td>
									<td><form:input
											path="COMPETENCE[${tech +2}].niveauExpertise" /></td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<div id="tabs-4">
				<h2>Compte:</h2>
				<table background="../images/header-bg.gif"
					style="border-collapse: none;" align="center" id="tabcol">
					<tr>
						<td>Login</td>
						<td><form:input path="compte.login" id="Login"
								readonly="true" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input path="compte.password" id="Password"
								type="password" /></td>
					</tr>
					<tr>
						<td>Confirm Password</td>
						<td><input id="Confirm_Password" type="password" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><form:input path="compte.email" id="Email" /></td>
					</tr>
				</table>
			</div>
			<input type="button" value="Save" id="enregister"> <input
				type="button" value="Back" onclick="go('collaborators');">
		</div>
	</form:form>
</body>


<!-- *************************** -->


</html>