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

	<form:form action="managers" method="post" id="createMan"
		commandName="newManager">

		<br />


		<input type="button" value="Save" id="enregister" />
		<input type="button" value="Previous" id="previous" />
		<input type="button" value="Next" id="next" />
		<hr color="black" />
		<p class="validateTips" style="color: red">All form fields are
			required.</p>
		<div class="form_page" id="page1">
			<h2>Donnees personelles</h2>
			<table style="border-collapse: none;"
				background="../images/header-bg.gif" align="center" id="tabcol">
				<tr>
					<td>Matricule</td>
					<td><form:input path="matricule" id="matricule" /></td>
					<td>Nom</td>
					<td><form:input path="nom" id="nom" /></td>
					<td>Prenom</td>
					<td><form:input path="prenom" id="prenom" /></td>
				</tr>
				<tr>
					<td>Abreviation</td>
					<td><form:input path="abreviation" id="abreviation" /></td>
					<td>Sexe</td>
					<td><form:select path="sexe" id="combobox">
							<form:option value="F">F</form:option>
							<form:option value="M">M</form:option>
						</form:select></td>
					<td>Site</td>
					<td><form:input path="site" id="site" value="Rabat" /></td>

				</tr>
				<tr>
					<td>Bu</td>
					<td><form:input path="bu" id="bu" /></td>
					<td>Salaire actuel</td>
					<td><form:input path="salaireActuel" id="salaire_actuel" /></td>
					<td>Date embauche</td>
					<td><form:input path="dateEmbauche" id="date_embauche" /></td>
				</tr>
				<tr>

					<td>Mois bap</td>
					<td><form:input path="moisBap" id="mois_bap" /></td>
					<td>Date de depart</td>
					<td><form:input path="dateDepart" id="date_depart" /></td>
					<td>Ancien collaborateur</td>
					<td><form:checkbox path="ancienColl" checked="checked"
							name="bu" /></td>
				</tr>
				<tr>

					<td>Participe si</td>
					<td><form:checkbox path="participeSi" id="participe_si" /></td>
					<td>Date participation</td>
					<td><form:input path="dateSi" id="date_particp" /></td>
					<td>Poste actuel (3)</td>
					<td><form:input path="posteActuel3" id="poste_actuel3" /></td>
				</tr>
				<tr>
					<td>Poste actuel (4)</td>
					<td><form:input path="posteActuel4" id="poste_actuel4" /></td>
				</tr>
			</table>
		</div>
		<div class="form_page" id="page2">
			<h2>Diplome:</h2>
			<div id=itemRows>
				<table style="border-collapse: none;"
					background="../images/header-bg.gif" align="center" id="tabcol">

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
						<td>Promotion:</td>
						<td><form:input path="DIPLOME[0].promotion" /></td>
						<td>Niveau:</td>
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
				<table style="border-collapse: none;"
					background="../images/header-bg.gif" align="center" id="tabcol">
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
			<table style="border-collapse: none;"
				background="../images/header-bg.gif" align="center" id="tabcol">
				<tr>
					<td>Login</td>
					<td><form:input path="compte.login" id="Login" size="50" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="compte.password" id="Password"
							type="password" size="50" /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input id="Confirm_Password" type="password" size="50" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="compte.email" id="Email" size="50" /></td>
				</tr>
			</table>
		</div>
		<hr color="black" />
	</form:form>
	<div id="actions"></div>
</body>
</html>