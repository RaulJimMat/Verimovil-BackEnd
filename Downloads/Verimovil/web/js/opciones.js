$(document).ready(opciones);
 
var contador = 1;

function opciones () {
	$('.menu_opc').click(function(){
		if (contador == 1) {
			$('ul').animate({
				right: '0'
			});
			contador = 0;
		} else {
			contador = 1;
			$('ul').animate({
				right: '-100%'
			});
		}
	});
}