<%@include file="taglib_includes.jsp"%>

<link
	href="${pageContext.request.contextPath}/resources/css/createUser_style.css"
	rel="stylesheet" type="text/css" />
<div id="tabs" title="Creer un nouveau collaborateur">
	<form:form action="collaborators" method="post" id="createCollab"
		commandName="newCollab">
		<ul>
			<li><a href="#tabs-1">Données personelles</a></li>
			<li><a href="#tabs-2">Diplomes</a></li>
			<li><a href="#tabs-3">Technologies</a></li>
			<li><a href="#tabs-4">Compte</a></li>
		</ul>
		<div id="tabs-1">
			<div id="dialog-form" title="Données personelles">
				<p class="validateTips" style="color: red"></p>
				<table bgcolor="lightblue" style="border-collapse: none;">
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
			</div>
		</div>
		<div id="tabs-2" title="Diplomes">
		<h3>Diplomes</h3>
			<br /> <br /> 
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
					<td><input/></td>
				</tr>
			</table>
			<input onclick="addRow();" type="button" value="Add row" align="left" />
		</div>
		<div id="tabs-3">

			<p>
				<label for="technologie">technologie: </label>
				<form:input path="TECHNOLOGIE[0].technologie" id="technologie"
					class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="competences">competences: </label>
				<form:input path="COMPETENCE[0].competence" id="competences"
					class="text ui-widget-content ui-corner-all" />
				<label for="niveau_expertise">niveau d'expertise: </label>
				<form:input path="COMPETENCE[0].niveauExpertise"
					id="niveau_expertise" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<button id="nouveau">Nouveau</button>
			</p>

		</div>
		<div id="tabs-4">
		<h3>Compte</h3>
			<br />
			<br />
			<br />
			<table bgcolor="lightblue" style="border-collapse: none;"
				align="center">
				<tr>
					<td>Login</td>
					<td><form:input path="compte.login" id="Login" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="compte.password" id="Password" type="password" /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input id="Password" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="compte.email" id="Email" /></td>
				</tr>
			</table>
		</div>
	</form:form>

</div>