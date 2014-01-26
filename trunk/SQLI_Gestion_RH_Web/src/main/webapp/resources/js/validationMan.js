$(function() {
	var matricule = $("#matricule"), nom = $("#nom"), prenom = $("#prenom"), abreviation = $("#abreviation"), bu = $("#bu"), date_embauche = $("#date_embauche"), site = $("#site"), bap = $("#bap"), poste_actuel3 = $("#poste_actuel3"), poste_actuel4 = $("#poste_actuel4"), salaire = $("#salaire_actuel"), email = $("#email"), login = $("#login"), password = $("#password"), allFields = $(
			[]).add(matricule).add(nom).add(prenom).add(abreviation).add(bap)
			.add(bu).add(date_embauche).add(site).add(
					poste_actuel3).add(poste_actuel4).add(
					salaire).add(email).add(login).add(password), tips = $(".validateTips");

	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}
	
	function checkRegexp(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}

	$("#prenom").change(
			function() {
				$("#abreviation").val(
						$("#prenom").val().substring(0, 1)
								+ $("#nom").val().substring(0, 2));
			});
	$("#nom").change(
			function() {
				$("#abreviation").val(
						$("#prenom").val().substring(0, 1)
								+ $("#nom").val().substring(0, 2));
			});

	$("#date_embauche").change(
			function() {
				var d1 = $('#date_embauche').datepicker('getDate');
				d = new Date(), diff = Math
						.floor((d.getTime() - d1.getTime()) / 86400000);

				if (diff < 15) {
					$("#mois_bap").val(d1.getMonth() + 1);
				} else {
					$("#mois_bap").val((d1.getMonth() + 2) % 12);
				}
				;

			});

	$("#enregister")
			.button()
			.click(
					function() {
						var bValid = true;
//						allFields.removeClass("ui-state-error");
//
//						bValid = bValid
//								&& checkRegexp(matricule, /^([0-9]){5}$/,
//										"Matricule doit etre un entier de 5 chiffres");
//						bValid = bValid
//								&& checkRegexp(nom, /^[a-zA-Z]([a-zA-Z])+$/,
//										"Le nom ne peut pas etre vide et commence par une lettre");
//						bValid = bValid
//								&& checkRegexp(prenom, /^[a-zA-Z]([a-zA-Z])+$/,
//										"Le prenom ne peut pas etre vide et commence par une lettre");
//						bValid = bValid
//								&& checkRegexp(abreviation,
//										/^[a-zA-Z]([0-9a-zA-Z_]){2}$/,
//										"l'abreviation est un text de 3 caractères");
//						bValid = bValid
//								&& checkRegexp(bu, /^[a-zA-Z]([0-9a-zA-Z]){3}$/,
//										"Bu est un champ alphanumérique composé de quatre caractères");
//						bValid = bValid
//								&& checkRegexp(
//										date_embauche,
//										/^(((0[1-9])|(1\d)|(2\d)|(3[0-1]))\/((0[1-9])|(1[0-2]))\/(\d{4}))$/,
//										"Date embauche invalid : jj/mm/aaaa");
//
//						bValid = bValid
//								&& checkRegexp(poste_actuel3,
//										/^[a-zA-Z]([0-9a-zA-Z]){2}$/,
//										"Poste actuel est un champ alphanumérique composé de trois caractères");
//						bValid = bValid
//								&& checkRegexp(poste_actuel4,
//										/^[a-zA-Z]([0-9a-zA-Z]){3}$/,
//										"Poste actuel est un champ alphanumérique composé de quatre caractères");
//						bValid = bValid
//								&& checkRegexp(salaire, /^[0-9]+[\.,]?[0-9]*$/,
//										"Salaire est un entier");
//						bValid = bValid
//								&& checkRegexp(site, /^[a-zA-Z]+$/,
//										"Site est un text");
//						bValid = bValid
//								&& checkRegexp(bap, /^[a-zA-Z]+$/,
//										"Mois bap est un text");
//										
//										
//						bValid = bValid
//								&& checkRegexp(email, /^[\w.-]+@[\w.-]+\.[a-zA-Z]{2,6}$/,
//										"Email invalide !");
//										
//						bValid = bValid
//								&& checkRegexp(login, /^[a-zA-Z0-9]+$/,
//										"Login invalide !");	
//						bValid = bValid
//								&& checkRegexp(password, /^([a-zA-Z0-9]){4,}$/,
//										"Password doit contenir au moins 4 caractères !");										
//										
//
//						bValid = bValid && confirm;
						if (bValid) {
							updateTips("Enregistrement en cours ..");
							document.forms["ManagerForm"].submit();
							allFields.val( "" ).removeClass( "ui-state-error" );
							}
					});
});