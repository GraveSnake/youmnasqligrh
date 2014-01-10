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
		commandName="editCollab">
		<p class="validateTips" style="color: red">All form fields are
			required.</p>
		<br />
		<h2>Donnees personelles</h2>
		<table bgcolor="lightblue" style="border-collapse: none;"
			align="center">
			<tr>
				<td>matricule</td>
				<td><form:input path="matricule" id="matricule" readonly="true"/></td>
				<td>nom</td>
				<td><form:input path="nom" id="nom" /></td>
				<td>prenom</td>
				<td><form:input path="prenom" id="prenom" /></td>
			</tr>
			<tr>
				<td>abreviation</td>
				<td><form:input path="abreviation" id="abreviation" /></td>
				<td>Ancien manager</td>
				<td><form:input path="mgrhAncien" id="Ancien_manager" /></td>
				<td>manager actuel</td>
				<td><form:input path="mgrhActuel" id="manager_actuel" /></td>
			</tr>
			<tr>
				<td>sexe</td>
				<td><form:select path="sexe" id="combobox">
						<option value="">F</option>
						<option value="">M</option>
					</form:select></td>
				<td>site</td>
				<td><form:input path="site" id="site" value="Rabat" /></td>
				<td>bu</td>
				<td><form:input path="bu" id="bu" /></td>
			</tr>
			<tr>
				<td>salaire actuel</td>
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
				<td>Poste actuel</td>
				<td><form:input path="posteActuel3" id="poste_actuel" /></td>
				<td>Role</td>
				<td><form:select path="role" id="combobox">
						<option value="">Collaborateur</option>
						<option value="">Manager</option>
						<option value="">Ambassadeur</option>
						<option value="">Manager de production</option>
					</form:select></td>
			</tr>
		</table>
		<input type="button" value="Save" id="enregister">
		<input type="button"  value="Back" onclick="go('collaborators');"> 
	</form:form>
</body>
</html>