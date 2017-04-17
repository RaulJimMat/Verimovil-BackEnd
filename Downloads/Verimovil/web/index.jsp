<%-- 
    Document   : index
    Created on : 28/02/2017, 07:49:36 PM
    Author     : GRISELDA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text"> 
	<link rel="stylesheet" type="text/css" href="css/estilos.css"> 
        <link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
	<title>Verimovil</title>
</head>
<body>
	<!--<div class="contenedor">-->
		<header>
			<div class="contenedor">
			<img src="img/Logo1.png" align="center"> 
			<div id="login"><br>
			<form action="login" method="post" name="form1">
				<table>
						<tr>
							<td><p>Nombre de usuario</p></td>
							<td><p>Contraseña</p></td>
						</tr>
						<tr>
							<td><input type="text" name="username" id="username" required/>
							<!--<span ng-show="form.nomusr.$dirty && form.nomusr.$error.required">Usuario es requerido</span>--></td>
							<td><input type="password" name="password" id="password"  required/></td>
							<td><input type="submit" value="Iniciar sesión" /></td>  
						</tr>
						<tr>
							<td><p><a href="registro.html">Registrarme</a></p></td>
							<td><a href="">¿Olvidaste tu cuenta?</a></td> 
						</tr>
				</table>
                        </form>
			</div>
			</div>
		</header>
	<div class="contenedor">
		<div class="grafica">
			<img src="img/conta.jpg" align="center" />
		</div>
		<div class="recuadromagico">
			<table>
				<tr>
					<td><a href="login.html">Iniciar Sesiòn</a></td>
				</tr>
				<tr>
					<td><a href="registro.html">Registrarme</a></td>
				</tr>
			</table>
		</div>
		<div class="contenedor-formulario">
			<div class="wrap">
				<!--  Formulario -->
			<form action="newuser" class="formulario" name="formulario_registro" method="get">
				<p>Crea una cuenta</p>
			<table>
				<div>
					<tr>
						<td colspan="2">
							<div class="input-group">
								<input type="text" id="nombre" name="nombre">
								<label class="label" for="nombre">Nombre:</label>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="input-group">
								<input type="text" id="apellidop" name="apellidop">
								<label class="label" for="apellidop">Apellido Paterno:</label>
							</div>
						</td>
						<td>
							<div class="input-group">
								<input type="text" id="apellidom" name="apellidom">
								<label class="label" for="apellidom">Apellido Materno:</label>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="input-group">
								<input type="email" id="email" name="email">
								<label class="label" for="email">Correo:</label>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="input-group">
								<input type="text" id="user" name="username">
								<label class="label" for="user">Nombre de Usuario:</label>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="input-group">
								<input type="password" id="pass" name="pass">
								<label class="label" for="pass">Contraseña</label>
							</div>
						</td>
						<td>
							<div class="input-group">
								<input type="password" id="pass2" name="contraseña2">
								<label class="label" for="pass2">Repetir Contraseña:</label>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="input-group radio">
								<input type="radio" name="sexo" id="hombre" value="Hombre">
								<label for="hombre">Hombre</label>

								<input type="radio" name="sexo" id="mujer" value="Mujer">
								<label for="mujer">Mujer</label>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit"  value="Registrar"> 
						</td>
					</tr>
				</div>
			</table>
			</form>
			</div>
		</div>
	</div>
		<footer>
			<p class="texto">Todos Los Derechos Reservados &copy;-TT2016-A052 (Verimovil)</p>
		</footer>
	<script src="js/formulario.js" type="text/javascript"></script>
	<script type="text/javascript" src="lib/angular.min.js"></script>
        <script src="dist/sweetalert.min.js"></script>
</body>
</html>
