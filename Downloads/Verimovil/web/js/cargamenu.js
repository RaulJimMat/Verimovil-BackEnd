$(document).ready(function(){
	$('#inicio').click(function(){
		$('.contenedor').load('home.html');
	});
	$('#autos').click(function(){
		$('.contenedor').load('automotor.html');
	});
	$('#registro').click(function(){
		$('.contenedor').load('historico.html');
	});
	$('#contacto').click(function(){
		$('.contenedor').load('contacto.html');
	});
	$('#cuenta').click(function(){
		$('.contenedor').load('perfil.html');
	});
	$('.contenedor').load('home.html');
});