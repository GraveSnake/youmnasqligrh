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

	<form:form action="collaborators" method="post" id="CollabForm"
		commandName="newCollab">

		<br />


		<input type="button" value="Enregistrer" id="enregister" />
		<input type="button" value="Précedent" id="previous" />
		<input type="button" value="Suivant" id="next" />
		<input type="button" value="Back" onclick="go('collaborators');">
		<hr color="black" />
		<p class="validateTips" style="color: red"></p>
		<div class="form_page" id="page1">

			<fieldset>
				<legend>Données personelles: </legend>

				<!--  <h2 style="color: maroon;">Données personelles:</h2>-->
				<table style="border-collapse: none;" align="center">

					<tr>
						<td><label>Matricule:</label></td>
						<td><form:input path="matricule" id="matricule" /></td>
						<td><label>Nom:</label></td>
						<td><form:input path="nom" id="nom" /></td>
						<td><label>Prenom:</label></td>
						<td><form:input path="prenom" id="prenom" /></td>
					</tr>
					<tr>
						<td><label>Abreviation:</label></td>
						<td><form:input path="abreviation" id="abreviation" /></td>
						<td><label>Ancien manager:</label></td>
						<td><form:select path="mgrhAncien">
								<form:option value="Aucun">Aucun</form:option>
								<form:options items="${managers}" />
							</form:select></td>
						<td><label>Manager actuel:</label></td>
						<td><form:select path="mgrhActuel">
								<form:option value="Aucun">Aucun</form:option>
								<form:options items="${managers}" />
							</form:select></td>
					</tr>
					<tr>
						<td><label>Sexe:</label></td>
						<td><form:select path="sexe">
								<form:option value="F">F</form:option>
								<form:option value="M">M</form:option>
							</form:select></td>
						<td><label>Site:</label></td>
						<td><form:input path="site" id="site" value="Rabat" /></td>
						<td><label>Bu:</label></td>
						<td><form:input path="bu" id="bu" /></td>
					</tr>
					<tr>
						<td><label>Salaire actuel (DH):</label></td>
						<td><form:input path="salaireActuel" id="salaire_actuel" /></td>
						<td><label>Date embauche:</label></td>
						<td><form:input path="dateEmbauche" id="date_embauche" /></td>
						<td><label>Mois bap:</label></td>
						<td><form:input path="moisBap" id="bap" /></td>
					</tr>

					<tr>
						<td><label>Date de depart:</label></td>
						<td><form:input path="dateDepart" id="date_depart" /></td>
						<td><label>Ancien collaborateur:</label></td>
						<td><form:checkbox path="ancienColl" name="bu" /></td>
						<td><label>Participe SI:</label></td>
						<td><form:checkbox path="participeSi" /></td>

					</tr>

					<tr>
						<td><label>Date participation</label></td>
						<td><form:input path="dateSi" id="date_particp" /></td>
						<td><label>Poste actuel (3):</label></td>
						<td><form:input path="posteActuel3" id="poste_actuel3" /></td>
						<td><label>Poste actuel (4):</label></td>
						<td><form:input path="posteActuel4" id="poste_actuel4" /></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="form_page" id="page2">
			<div id=itemRows>

				<fieldset>
					<legend>Diplome: </legend>
					<table style="border-collapse: none;" align="center" id="tabcol">

						<tr>
							<td><label>Titre:</label></td>
							<td><form:input path="DIPLOME[0].nom" /></td>
							<td><label>Ecole:</label></td>
							<td><form:input path="DIPLOME[0].ecole" /></td>
							<td><label>Ecole type:</label></td>
							<td><form:select path="DIPLOME[0].ecoleType" id="combobox">
									<form:option value=""></form:option>
									<form:option value="National">National</form:option>
									<form:option value="International">International</form:option>
								</form:select></td>
						</tr>
						<tr>
							<td><label>Diplome type:</label></td>
							<td><form:select path="DIPLOME[0].diplomeType">
									<form:option value=""></form:option>
									<form:option value="etatique">etatique</form:option>
									<form:option value="prive">prive</form:option>
								</form:select></td>
							<td><label>Promotion:</label></td>
							<td><form:input path="DIPLOME[0].promotion" id="promotion" /></td>
							<td><label>Niveau:</label></td>
							<td><form:input path="DIPLOME[0].niveau" id="niveau" /></td>
						</tr>
					</table>
				</fieldset>
				<input onclick="addRow();" type="button" value="Nouveau"
					align="left" /> <input onclick="removeRow();" type="button"
					value="Annuler" align="left" id="removeDip" disabled="disabled" />
			</div>
		</div>

		<div class="form_page" id="page3">

			<fieldset>
				<legend>Technologie: </legend>
				<div id="itemTech">
					<table style="border-collapse: none;" align="center" id="tabcol">
						<tr>
							<td><label>Technologie:</label></td>
							<!--  <td><form:input path="TECHNOLOGIE[0].technologie" id="techno" /></td>-->
							<td><form:select path="TECHNOLOGIE[0].technologie"
									id="techno">
									<form:option value=""></form:option>
									<form:options items="${technologies}" />
								</form:select></td>
							<td><label>Competence #1:</label></td>
							<td><form:input path="COMPETENCE[0].competence" /></td>

							<td><label>Niveau d'expertise:</label></td>
							<td><form:select path="COMPETENCE[0].niveauExpertise"
									id="nivExp">
									<form:option value=""></form:option>
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
								</form:select></td>
						</tr>
					</table>
					<input onclick="addTech();" type="button" value="Nouveau"
						align="left" /> <input onclick="remove2();" type="button"
						value="Annuler" align="left" id="removeTech" disabled="disabled" />
				</div>
			</fieldset>
		</div>

		<div class="form_page" id="page4">
			<fieldset>
				<legend>Compte: </legend>
				<table style="border-collapse: none;" align="center" id="tabcol">
					<tr>
						<td><label>Login:</label></td>
						<td><form:input path="compte.login" id="login" size="50" /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="compte.password" id="password"
								type="password" size="50" /></td>
					</tr>
					<tr>
						<td><label>Confirm Password:</label></td>
						<td><input id="Confirm_Password" type="password" size="50" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="compte.email" id="email" size="50" /></td>
					</tr>
				</table>
				</fieldset>
		</div>
		<hr color="black" />
	</form:form>
	<div id="actions"></div>
	<label id="initDipl">${initDipl}</label>
	<label id="initTech">${initTech}</label>
</body>
</html>