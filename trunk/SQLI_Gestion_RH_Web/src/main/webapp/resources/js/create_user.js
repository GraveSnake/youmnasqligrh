$(function() {
	var matricule = $("#matricule"), nom = $("#nom"), prenom = $("#prenom"), abreviation = $("#abreviation"), sexe = $("#sexe"), bu = $("#bu"), date_embauche = $("#date_embauche"), date_depart = $("#date_depart"), site = $("#site"), bap = $("#bap"), participe_si = $("#participe_si"), date_particp = $("#date_particp"), poste_actuel3 = $("#poste_actuel3"), poste_actuel4 = $("#poste_actuel4"), salaire = $("#salaire_actuel"), niveau = $("#niveau"), email = $("#email"), login = $("#login"), password = $("#Password"), confirmPassword = $("#Confirm_Password"), allFields = $(
			[]).add(matricule).add(nom).add(prenom).add(abreviation).add(sexe)
			.add(bu).add(date_embauche).add(site).add(date_depart).add(
					poste_actuel3).add(poste_actuel4).add(confirmPassword).add(
					salaire), tips = $(".validateTips");

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

	$("#enregister")
			.button()
			.click(
					function() {
						var bValid = true;
//						allFields.removeClass("ui-state-error");
//
//						bValid = bValid
//								&& checkRegexp(matricule, /^([0-9]){5}$/,
//										"matricule doit etre un entier de 5 chiffres");
//						bValid = bValid
//								&& checkRegexp(nom, /^[a-zA-Z]([a-zA-Z])+$/,
//										"le nom ne peut pas etre vide et commence par une lettre");
//						bValid = bValid
//								&& checkRegexp(prenom, /^[a-zA-Z]([a-z])+$/,
//										"le prenom ne peut pas etre vide et commence par une lettre");
//						bValid = bValid
//								&& checkRegexp(abreviation,
//										/^[a-zA-Z]([0-9a-zA-Z_]){2}$/,
//										"l'abreviation est un text de 3 caractères");
//						bValid = bValid
//								&& checkRegexp(bu, /^[a-z]([0-9a-z]){3}$/,
//										"bu est un champ alphanumérique composé de quatre caractères");
//						bValid = bValid
//								&& checkRegexp(
//										date_embauche,
//										/^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/,
//										"date embauche invalid : jj/mm/aaaa");
//						bValid = bValid
//								&& checkRegexp(
//										date_depart,
//										/(^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2}))?$/,
//										"date depart invalid : jj/mm/aaaa");
//					/*	bValid = bValid
//								&& checkRegexp(poste_actuel3,
//										/^[a-zA-Z]([0-9a-zA-Z]){2}$/,
//										"poste actuel est un champ alphanumérique composé de trois caractères");*/
//						bValid = bValid
//								&& checkRegexp(poste_actuel4,
//										/^[a-zA-Z]([0-9a-zA-Z]){3}$/,
//										"poste actuel est un champ alphanumérique composé de quatre caractères");
//						bValid = bValid
//								&& checkRegexp(salaire, /^[0-9]+$/,
//										"le salaire est un entier");
						confirm = (password.val() == confirmPassword.val());
						if (!confirm) {
							o.addClass("ui-state-error");
							updateTips("Confirmation du Password incorrecte");
						}
						bValid = bValid && confirm;
						if (bValid) {
							document.forms["createCollab"].submit();						}
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
var rowTech= 0;
var rowComp= 2;
var rowNum = 0;
function addRow() {
	rowNum++;
	var row = '<p id="rowNum'
			+ rowNum
			+ '"><table bgcolor="lightblue" style="border-collapse: none;" align="center"> <tr><td>Titre:</td><td><input name="DIPLOME['+rowNum+'].nom" /></td><td>Ecole:</td><td><input name="DIPLOME['+rowNum+'].ecole" /></td><td>Ecole type:</td><td><select name="DIPLOME['+rowNum+'].ecoleType" id="combobox"><option value="National">National</option><option value="International">International</option></select></td></tr><tr><td>Diplome type:</td><td><select name="DIPLOME['+rowNum+'].diplomeType"><option value="etatique">etatique</:option><option value="prive">prive</option></select></td><td>promotion:</td><td><input name="DIPLOME['+rowNum+'].promotion" /></td><td>niveau:</td><td><input name="DIPLOME['+rowNum+'].niveau" id="niveau"/></td></tr></table></p>';

	jQuery('#itemRows').append(row);
	$("#removeDip").removeAttr('disabled').removeClass( 'ui-state-disabled' );
}


function removeRow() {
	jQuery('#rowNum' + rowNum).remove();
	rowNum--;
	if(rowNum==0){
		$("#removeDip").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	}
}

function addTech() {
	rowTech++;
	rowComp++;
	var row = '<p id="rowTech'
			+ rowTech
			+ '"><table bgcolor="lightblue" style="border-collapse: none;"align="center"><tr><td>Technologie:</td><td><input name="TECHNOLOGIE['+rowTech+'].technologie" /></td><td>Competence #1</td><td><input name="COMPETENCE['+rowComp+'].competence" /></td><td>Niveau d\'expertise</td><td><input name="COMPETENCE['+rowComp+'].niveauExpertise" /></td></tr><tr><td></td><td></td><td>Competence #2</td><td><input name="COMPETENCE['+rowComp+'].competence" /></td><td>Niveau d\'expertise</td><td><input name="COMPETENCE['+rowComp+'].niveauExpertise" /></td></tr><tr><td></td><td></td><td>Competence #3</td><td><input name="COMPETENCE['+rowComp+'].competence" /></td><td>Niveau d\'expertise</td><td><input name="COMPETENCE['+rowComp+'].niveauExpertise" /></td></tr></table></p>';

	jQuery('#itemTech').append(row);
	$("#removeTech").removeAttr('disabled').removeClass( 'ui-state-disabled' );
}

function remove2() {
	jQuery('#rowTech' + rowTech).remove();
	rowTech--;
	rowComp--;
	if(rowTech==0){
		$("#removeTech").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	}
}

function go(url) {
	window.location = url;
}


$(document).ready(function() {

    var numPages = $('.form_page').length;
    var currentPage = 1;
    var $actions = $('#actions');
    for(i = 2; i <= numPages; i++) {
     
        $('#page' + i).hide();     
    }
     $('#previous').click(function() {
        
        if (currentPage > 1) {
            
            $('#page' + currentPage).hide();
            currentPage--;
            $('#page' + currentPage).show();
        }

    }).appendTo($actions);

     $('#next').click(function() {

        if (currentPage < numPages) {
            
            $('#page' + currentPage).hide();
            currentPage++;
            $('#page' + currentPage).show();
        }

    }).appendTo($actions);
});