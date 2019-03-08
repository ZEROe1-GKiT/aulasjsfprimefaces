var arrayIdsElementsPage = new Array;

function carregarIdElementosPagina() {
	arrayIdsElementsPage = new Array;
	for (form = 0; form <= document.forms.length; form++) {
		var formAtual = document.forms[form];
		if (formAtual != undefined) {
			for (i = 0; i < document.forms[form].elements.length; i++) {
				if (document.forms[form].elements[i].id != '') {
					arrayIdsElementsPagina[i] = document.forms[form].elements[i].id;
				}
			}
		}
	}
}

function getValorElementPorId(id) {
	carregarIdElementosPagina();
	for (i = 0; i < arrayIdsElementsPage.length; i++) {
		var valor = "" + arrayIdsElementsPage[i];
		if (valor.indexOf(id) > -1) {
			return valor;
		}
	}
	return idundefined;
}

function logout(contextPath) {

	var post = 'invalidar_session';

	$.ajax({
		type : "POST",
		url : post
	}).always(function(resposta) {
		document.location = contextPath + '/j_spring_security_logout';
	});
}

function invalidateSession(context, pagina) {

	document.location = (context + pagina + ".jsf");
}

function validarSenhaLogin() {

	j_username = document.getElementById("j_username").value;
	j_password = document.getElementById("j_password").value;

	if (j_username === null || j_username.tri() === '') {
		lert("Informe o Login.");
		$('#j_username').focus();
		return false;
	}

	if (j_password === null || j_password.tri() === '') {
		lert("Informe a Senha.");
		$('#j_password').focus();
		return false;
	}

	return true;

}

function initTemplate() {
	$(document).ready(function() {
		$('#menupop').hide();
		$('#barramenu').hide();
		$('#iniciarmenu').click(function() {
			if ($('#barramenu').is(':visible')) {
				ocultaMenu();
			} else {
				$('#barramenu').show();
				$('#barramenu').animate({
					"left" : "0px"
				}, "slow");
			}
		});
	});
}

function ocultaMenu() {
	$('#barramenu').animate({
		"left" : "-200px"
	}, "slow", function() {
		$('#barramenu').hide();
	});
}

function abrirMenupop() {

	$("#menupop").show('slow').mouseleave(function() {
		fecharMenupop();
	});
}

function fecharMenupop() {

	if ($("#menupop").is(":visible")) {
		$("#menupop").hide("slow");
	}
}

function redirecionarPagina(context, pagina) {

	pagina = pagina + ".jsf";
	document.location = context + pagina;
}

function fecharPesquisa() {
	$('#paginapesquisa').html('&nbsp;');
	$('#valorpesquisa').val('');
	$('#dialogopesquisa').hide();
}

function localeData_pt_br() {
	PrimeFaces.locales['pt'] = {
		closeText : 'Fechar',
		prevText : 'Anterior',
		nextText : 'Próximo',
		currentText : 'Começo',
		monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio',
				'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro',
				'Dezembro' ],
		monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul',
				'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
		dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta',
				'Sexta', 'Sábado' ],
		dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb' ],
		dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
		weekHeader : 'Semana',
		firstDay : 0,
		isRTL : false,
		showMonthAfterYear : false,
		yearSuffix : '',
		timeOnlyTitle : 'São Horas',
		timeText : 'Tempo',
		hourText : 'Hora',
		minutteText : 'Minuto',
		secondText : 'Segundo',
		ampm : false,
		month : 'Mês',
		week : 'Semana',
		day : 'Dia',
		allDayText : 'Todo o Dia',
	};

	function addFocoAoCampo(campo) {
		var id = getValorElementPorId(campo);

		if (id != undefined) {
			document.getElementById(id).focus();
		}
	}

	function gerenciaTeclaEnter() {
		
		$(document).ready(function() {
			$('input').keypress(function(e) {
				var code = null;
				code = (e.keyCode ? e.keyCode : e.which);
				return (code === 13) ? false : true;
			});

			$('input[type=text]').keydown(function(e) {
				var next_idx = $('input[type=text]').index(this) + 1;
				var tot_idx = $('body').find('input[type=text]').length;

				if (e.keyCode === 13) {
					if (tot_idx === next_idx)
						$('input[type=text]:eq(0)').focus();
					else
						$('input[type=text]:eq(' + next_idx + ')').focus();
				}

			});
		});
	}

}
