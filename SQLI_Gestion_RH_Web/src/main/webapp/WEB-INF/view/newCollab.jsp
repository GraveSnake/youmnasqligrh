<%@include file="taglib_includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="${pageContext.request.contextPath}/resources/css/createUser_style.css"
	rel="stylesheet" type="text/css" />
<body>
	<form:form action="collaborators" method="post" id="createCollab"
		commandName="newCollab">
		<p class="validateTips" style="color: red">All form fields are
			required.</p>
		<br />
		<h2>Donnees personelles</h2>
		<table bgcolor="lightblue" style="border-collapse: none;"
			align="center">
			<tr>
				<td>matricule</td>
				<td><form:input path="matricule" id="matricule" /></td>
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

		<hr color="black">
		<br />
		<h2>Diplome:</h2>
		<table bgcolor="lightblue" style="border-collapse: none;"
			align="center">

			<tr>
				<td>Titre:</td>
				<td><form:input path="DIPLOME[0].nom" /></td>
				<td>Ecole:</td>
				<td><form:input path="DIPLOME[0].ecole" /></td>
				<td>Ecole type:</td>
				<td><form:select path="DIPLOME[0].ecoleType" id="combobox">
						<option value="">National</option>
						<option value="">International</option>
					</form:select></td>
			</tr>
			<tr>
				<td>Diplome type:</td>
				<td><form:select path="DIPLOME[0].diplomeType">
						<option value="">etatique</option>
						<option value="">prive</option>
					</form:select></td>
				<td>promotion:</td>
				<td><form:input path="DIPLOME[0].promotion" /></td>
				<td>niveau:</td>
				<td><input /></td>
			</tr>
		</table>
		<input onclick="addRow();" type="button" value="Add row" align="left" />
		<hr color="black">
		<br />
		<h2>Technologie:</h2>
		<table bgcolor="lightblue" style="border-collapse: none;"
			align="center">
			<tr>
				<td>technologie</td>
				<td><form:input path="TECHNOLOGIE[0].technologie" id="Login" /></td>
			</tr>
			<tr>
				<td>competence</td>
				<td><form:input path="COMPETENCE[0].competence" /></td>
			</tr>
			<tr>
				<td>niveau d'expertise</td>
				<td><form:input path="COMPETENCE[0].niveauExpertise" /></td>
			</tr>
		</table>
		<hr color="black">
		<br />
		<h2>Compte:</h2>
		<table bgcolor="lightblue" style="border-collapse: none;"
			align="center">
			<tr>
				<td>Login</td>
				<td><form:input path="compte.login" id="Login" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="compte.password" id="Password"
						type="password" /></td>
			</tr>
			<!--  <tr>
				<td>Confirm Password</td>
				<td><input id="Password" /></td>
			</tr>-->
			<tr>
				<td>Email</td>
				<td><form:input path="compte.email" id="Email" /></td>
			</tr>
		</table>
		<input type="button" value="Save" id="enregister">
	</form:form>
</body>
</html>