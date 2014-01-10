$(function() {
	var matricule = $("#matricule"), nom = $("#nom"), prenom = $("#prenom"), abreviation = $("#abreviation"), sexe = $("#sexe"), bu = $("#bu"), date_embauche = $("#date_embauche"), date_depart = $("#date_depart"), site = $("#site"), bap = $("#bap"), participe_si = $("#participe_si"), date_particp = $("#date_particp"), poste_actuel = $("#poste_actuel"), poste_actuel4 = $("#poste_actuel4"), salaire = $("#salaire_actuel"), niveau = $("#niveau"), email = $("#email"), login = $("#login"), password = $("#password"), allFields = $(
			[]).add(matricule).add(nom).add(prenom).add(abreviation).add(sexe)
			.add(bu).add(date_embauche).add(site).add(date_depart).add(
					poste_actuel).add(salaire), tips = $(".validateTips");

	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}

	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips("Length of " + n + " must be between " + min + " and "
					+ max + ".");
			return false;
		} else {
			return true;
		}
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

	$("#tabs").dialog({
		autoOpen : false,
		height : 500,
		width : 880,
		modal : true,
		resizable : false,
		
		buttons : {
			"Create an account" : function() {
				var bValid = true;
				allFields.removeClass("ui-state-error");
				
				  bValid = bValid && checkRegexp(matricule, /^([0-9]){5}$/, "matricule doit etre un entier de 5 chiffres"); 
				  bValid = bValid && checkRegexp(nom, /^[a-zA-Z]([a-zA-Z_])+$/, "le nom ne peut pas etre vide et commence par une lettre"); 
				  bValid = bValid && checkRegexp(prenom, /^[a-z]([a-z_])+$/, "le prenom ne peut pas etre vide et commence par une lettre");
				  bValid = bValid && checkRegexp(abreviation, /^[a-z]([0-9a-z_]){2}$/, "l'abreviation est un text de 3 caractères"); 
				  bValid = bValid && checkRegexp(bu, /^[a-z]([0-9a-z]){3}$/, "bu est un champ alphanumérique composé de quatre caractères"); 
				  bValid = bValid && checkRegexp( date_embauche,/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/,"date embauche invalid : jj/mm/aaaa"); 
				  bValid = bValid && checkRegexp( date_depart,/(^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2}))?$/,"date depart invalid : jj/mm/aaaa");
				  bValid = bValid && checkRegexp(poste_actuel, /^[a-z]([0-9a-z]){2}$/, "poste actuel est un champ alphanumérique composé de trois caractères");
				  bValid = bValid && checkRegexp(salaire,/^[0-9]+$/, "le salaire est un entier");
				 
				if (bValid) {
					 document.forms["createCollab"].submit();
					$(this).dialog("close");
				}
			},
			Cancel : function() {
				$(this).dialog("close");
			}

		},
		close : function() {
			allFields.val("").removeClass("ui-state-error");
		}
		

	});

	$("#create-user").button().click(function() {
		$("#tabs").dialog("open");
	});
});
$(function() {
	var tabs = $("#tabs").tabs();
	tabs.find(".ui-tabs-nav").sortable({
		axis : "x",
		stop : function() {
			tabs.tabs("refresh");
		}
	});
});
$(function() {
	$.datepicker.setDefaults({
		dateFormat : 'dd/mm/yy'
	});

	$("#date_embauche").datepicker();
	$("#date_depart").datepicker();
	$("#date_particp").datepicker();
});

var rowNum = 0;
function addRow() {
	rowNum++;
	var row = '<p id="rowNum'
			+ rowNum
			+ '">Titre: <input type="text" name="titre[]" size="8" value="'
			+ frm.add_titre.value
			+ '"> Ecole: <input type="text" name="ecole[]" value="'
			+ frm.add_ecole.value
			+ '" size="6"> Ecole type: <input type="text" name="type[]" size="6" value="'
			+ frm.add_ecole_type.value
			+ '"> Diplome: <input type="text" name="diplome[]" size="6" value="'
			+ frm.add_diplome.value
			+ '"> Promotion: <input type="text" name="promotion[]" size="6" value="'
			+ frm.add_promotion.value
			+ '"> <input type="button" value="Remove" onclick="removeRow('
			+ rowNum + ');"></p>';
	jQuery('#itemRows').append(row);
	frm.add_titre.value = '';
	frm.add_ecole.value = '';
	frm.add_ecole_type.value = '';
	frm.add_diplome.value = '';
	frm.add_promotion.value = '';
}

function removeRow(rnum) {
	jQuery('#rowNum' + rnum).remove();
}
