<%@include file="taglib_includes.jsp"%>
<style>
body {
	font-size: 62.5%;
}

input.text {
	margin-bottom: 14px;
	width: 100%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td,div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 4px solid transparent;
	padding: 0.3em;
}
</style>

<div id="tabs" title="Creer un nouveau collaborateur">
	<form:form action="collaborators" method="post" id="createCollab">
		<ul>
			<li><a href="#tabs-1">Données personelles</a></li>
			<li><a href="#tabs-2">Diplomes</a></li>
			<li><a href="#tabs-3">Technologies</a></li>
			<li><a href="#tabs-4">Compte</a></li>
		</ul>
		<div id="tabs-1">
			<div id="dialog-form" title="Données personelles">
				<p class="validateTips">All form fields are required.</p>

				<label for="matricule">matricule</label>
				<form:input type="text" path="matricule"
					class="text ui-widget-content ui-corner-all" />
				<label for="nom">nom</label>
				<form:input path="nom" />
				<label for="prenom">prenom</label>
				<form:input path="prenom"
					class="text ui-widget-content ui-corner-all" />
				<label for="abreviation">abreviation</label>
				<form:input path="abreviation"
					class="text ui-widget-content ui-corner-all" />
				<label for="Ancien_manager">Ancien manager</label>
				<form:input path="mgrhAncien" type="text" name="Ancien_manager"
					id="Ancien_manager" value=""
					class="text ui-widget-content ui-corner-all" />
				<label for="manager_actuel">manager actuel</label>
				<form:input path="mgrhActuel" type="text" name="manager_actuel"
					id="manager_actuel" value=""
					class="text ui-widget-content ui-corner-all" />
				<label for="sexe">sexe</label>
				<form:select path="sexe" id="combobox"
					class="text ui-widget-content ui-corner-all">
					<option value="">F</option>
					<option value="">M</option>
				</form:select>
				<label for="site">site</label>
				<form:input path="site" type="text" name="site" id="site"
					value="Rabat" class="text ui-widget-content ui-corner-all" />
				<label for="bu">bu</label>
				<form:input path="bu" type="text" name="bu" id="bu" value=""
					class="text ui-widget-content ui-corner-all" />
				<label for="salaire_actuel">salaire actuel</label>
				<form:input path="salaireActuel" type="text" name="salaire_actuel"
					id="salaire_actuel" value=""
					class="text ui-widget-content ui-corner-all" size="10" />
				<label for="Date_embauche">Date embauche</label>
				<form:input path="dateEmbauche" type="text" name="Date_embauche"
					id="date_embauche" value=""
					class="text ui-widget-content ui-corner-all" size="10" />
				<label for="mois_bap">Mois bap</label>
				<form:input path="moisBap" type="text" name="mois_bap" id="mois_bap"
					value="" class="text ui-widget-content ui-corner-all" size="10" />
				<label for="date_depart">Date de depart</label>
				<form:input path="dateDepart" type="text" name="date_depart"
					id="date_depart" value=""
					class="text ui-widget-content ui-corner-all" size="10" />
				<label for="ac">Ancien collaborateur</label>
				<form:checkbox path="ancienColl" checked="checked" name="bu" />
				<label for="participe_si">Participé au séminaire
					d'intégration</label>
				<form:input path="participeSi" type="text" name="participe_si"
					id="participe_si" value=""
					class="text ui-widget-content ui-corner-all" size="10" />
				<label for="date_particp">Date participation</label>
				<form:input path="dateSi" type="text" name="date_particp"
					id="date_particp" value=""
					class="text ui-widget-content ui-corner-all" size="10" />
				<label for="poste_actuel">Poste actuel</label>
				<form:input path="posteActuel3" type="text" name="poste_actuel"
					id="poste_actuel" value=""
					class="text ui-widget-content ui-corner-all" size="10" />
			</div>
		</div>
		<div id="tabs-2" title="Diplomes">

			Titre:
			<form:input path="DIPLOME[0].nom" type="text" name="add_titre"
				size="8" />
			Ecole:
			<form:input path="DIPLOME[0].ecole" type="text" name="add_ecole"
				size="6" />
			Ecole type:
			<form:input path="DIPLOME[0].ecoleType" type="text"
				name="add_ecole_type" size="6" />
			Diplome type:
			<form:input path="DIPLOME[0].diplomeType" type="text"
				name="add_diplome" size="6" />
			promotion:
			<form:input path="DIPLOME[0].promotion" type="text"
				name="add_promotion" size="6" />
			<input onclick="addRow();" type="button" value="Add row" />
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
			<p>
				<label for="Login">Login</label>
				<form:input path="compte.login" type="text" name="Login" id="Login"
					class="text ui-widget-content ui-corner-all" />
				<label for="Password">Password</label>
				<form:input path="compte.password" type="password" name="Password"
					id="Password" class="text ui-widget-content ui-corner-all" />
				<label for="Email">Email</label>
				<form:input path="compte.email" type="text" name="Email" id="Email"
					class="text ui-widget-content ui-corner-all" />
		</div>
	</form:form>

</div>
