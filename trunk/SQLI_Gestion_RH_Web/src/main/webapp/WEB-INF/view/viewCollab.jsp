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
<body>
	<form:form action="collaborators" method="post" id="createCollab"
		commandName="viewCollab">

		<br />
		<h2>Donnees personelles</h2>
		<table bgcolor="lightblue" style="border-collapse: none;"
			align="center">
			<tr>
				<td>matricule</td>
				<td><form:input path="matricule" id="matricule" readonly="true"/></td>
				<td>nom</td>
				<td><form:input path="nom" id="nom" readonly="true" /></td>
				<td>prenom</td>
				<td><form:input path="prenom" id="prenom" readonly="true" /></td>
			</tr>
			<tr>
				<td>abreviation</td>
				<td><form:input path="abreviation" id="abreviation" readonly="true" /></td>
				<td>Ancien manager</td>
				<td><form:input path="mgrhAncien" id="Ancien_manager" readonly="true"/></td>
				<td>manager actuel</td>
				<td><form:input path="mgrhActuel" id="manager_actuel" readonly="true" /></td>
			</tr>
			<tr>
				<td>sexe</td>
				<td><form:select path="sexe" id="combobox" readonly="true">
						<option value="">F</option>
						<option value="">M</option>
					</form:select></td>
				<td>site</td>
				<td><form:input path="site" id="site" readonly="true" /></td>
				<td>bu</td>
				<td><form:input path="bu" id="bu" readonly="true" /></td>
			</tr>
			<tr>
				<td>salaire actuel</td>
				<td><form:input path="salaireActuel" id="salaire_actuel" readonly="true" /></td>
				<td>Date embauche</td>
				<td><form:input path="dateEmbauche" id="date_embauche" readonly="true" /></td>
				<td>Mois bap</td>
				<td><form:input path="moisBap" id="mois_bap" readonly="true" /></td>
			</tr>
			<tr>
				<td>Date de depart</td>
				<td><form:input path="dateDepart" id="date_depart" readonly="true" /></td>
				<td>Ancien collaborateur</td>
				<td><form:checkbox path="ancienColl" checked="checked"
						name="bu" readonly="true"/></td>
				<td>Participe si</td>
				<td><form:checkbox path="participeSi" id="participe_si" readonly="true"/></td>
			</tr>
			<tr>
				<td>Date participation</td>
				<td><form:input path="dateSi" id="date_particp" readonly="true" /></td>
				<td>Poste actuel</td>
				<td><form:input path="posteActuel3" id="poste_actuel" readonly="true" /></td>
				<td>Role</td>
				<td><form:select path="role" id="combobox" readonly="true">
						<option value="">Collaborateur</option>
						<option value="">Manager</option>
						<option value="">Ambassadeur</option>
						<option value="">Manager de production</option>
					</form:select></td>
			</tr>
		</table>
		<input type="button"  value="Back" onclick="go('collaborators');"> 
	</form:form>
</body>
</html>