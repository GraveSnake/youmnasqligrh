<%@include file="taglib_includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div class="form_page" id="page1">
			<h2>Donnees personelles</h2>
			<table  style="border-collapse: none;" background="../images/header-bg.gif"
				align="center" id="tabcol">
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
					<td><form:select path="mgrhAncien" id="Ancien_manager" >
					<form:options items="${managers}"/>
					</form:select></td>
					<td>manager actuel</td>
					<td><form:select path="mgrhActuel" id="manager_actuel" ><form:options items="${managers}"/></form:select></td>
				</tr>
				<tr>
					<td>sexe</td>
					<td><form:select path="sexe" id="combobox">
							<form:option value="F">F</form:option>
							<form:option value="M">M</form:option>
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
					<td>Poste actuel (3)</td>
					<td><form:input path="posteActuel3" id="poste_actuel3" /></td>
					<td>Poste actuel (4)</td>
					<td><form:input path="posteActuel4" id="poste_actuel4" /></td>
					<td>Role</td>
					<td><form:select path="role" id="combobox">
							<form:option value="Collaborateur">Collaborateur</form:option>
							<form:option value="Manager">Manager</form:option>
							<form:option value="Ambassadeur">Ambassadeur</form:option>
							<form:option value="Manager de production">Manager de production</form:option>
						</form:select></td>
				</tr>
			</table>
		</div>
		<div class="form_page" id="page2">
			<h2>Diplome:</h2>
			<div id=itemRows>
				<table bgcolor="midnightBlue" style="border-collapse: none;"
					align="center">

					<tr>
						<td>Titre:</td>
						<td><form:input path="DIPLOME[0].nom" /></td>
						<td>Ecole:</td>
						<td><form:input path="DIPLOME[0].ecole" /></td>
						<td>Ecole type:</td>
						<td><form:select path="DIPLOME[0].ecoleType" id="combobox">
								<form:option value="National">National</form:option>
								<form:option value="International">International</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td>Diplome type:</td>
						<td><form:select path="DIPLOME[0].diplomeType">
								<form:option value="etatique">etatique</form:option>
								<form:option value="prive">prive</form:option>
							</form:select></td>
						<td>promotion:</td>
						<td><form:input path="DIPLOME[0].promotion" /></td>
						<td>niveau:</td>
						<td><form:input path="DIPLOME[0].niveau" id="niveau" /></td>
					</tr>
				</table>
				<input onclick="addRow();" type="button" value="Add row"
					align="left" /> <input onclick="removeRow();" type="button"
					value="Remove" align="left" id="removeDip" disabled="disabled" />
			</div>
		</div>

		<div class="form_page" id="page3">
			<h2>Technologie:</h2>
			<div id="itemTech">
				<table bgcolor="midnightBlue" style="border-collapse: none;"
					align="center">
					<tr>
						<td>Technologie:</td>
						<td><form:input path="TECHNOLOGIE[0].technologie" /></td>

						<td>Competence #1</td>
						<td><form:input path="COMPETENCE[0].competence" /></td>

						<td>Niveau d'expertise</td>
						<td><form:input path="COMPETENCE[0].niveauExpertise" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>Competence #2</td>
						<td><form:input path="COMPETENCE[1].competence" /></td>

						<td>Niveau d'expertise</td>
						<td><form:input path="COMPETENCE[1].niveauExpertise" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>Competence #3</td>
						<td><form:input path="COMPETENCE[2].competence" /></td>

						<td>Niveau d'expertise</td>
						<td><form:input path="COMPETENCE[2].niveauExpertise" /></td>
					</tr>
				</table>
				<input onclick="addTech();" type="button" value="Add row"
					align="left" /> <input onclick="remove2();" type="button"
					value="Remove" align="left" id="removeTech" disabled="disabled" />
			</div>
		</div>

		<div class="form_page" id="page4">
			<h2>Compte:</h2>
			<table bgcolor="midnightBlue" style="border-collapse: none;"
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
		<hr color="black"/>
		<input type="button" value="Save" id="enregister" align="left"/>
		<input type="button" value="Previous" id="previous" align="center"/>
		<input type="button" value="Next" id="next" align="center"/>
		
	</form:form>
	<div id="actions"></div>
</body>
</html>