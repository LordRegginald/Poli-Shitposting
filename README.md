### Poli-Shitposting ###

# AVISO #
# Este proyecto no dispone de todas sus funciones; estaría todo listo para implementarse, cosa que aún no se ha realizado. #

IPS - 6to año 2017 - Técnico Informático Profesional y Personal
Aplicaciones Específicas de Redes, Prof. Alejandro Schujman

# En cuanto a nuestro progreso:

- Software utilizado:
  * Eclipse Neon
  * MySQL Workbench
  * Sublime Text
  
- Testeo:
A la página la corríamos de forma local (local-hosting) utilizando servidores Apache Tomcat 8.0/8.5 (desde Eclipse).

- Reporte:  
Como se puede ver, el proyecto está bastante avanzado en cuanto a lo que sería Backend/Frontend, base de datos, interfaces HTML, funciones, etc.; lo que faltaría sería la implementación de las mismas. En este primer commit se puede apreciar todo nuestro progreso hasta la fecha. Lamentablemente, lo único funcional de momento sería su función principal: el mostrar en pantalla un .swf nuevo cada vez que se refresque la página (puede apreciarse en el archivo 'home.html'. Sin embargo, esta función no está implementada aún como quisiera, ya que no se hace uso de la base de datos para llamar a los .swf (el contenido se encuentra alojado en una carpeta llamada 'swf' dentro de WebContent).


# A continuación, se pasarán en limpio algunos detalles previamente redactados en el informe.

- Descripción:
Nuestra página es para fines de entretenimiento; la idea general es que cada vez que se refresque la página, se muestre en pantalla contenidos aleatorios (puede ser una imagen, un gif, un vídeo, música, o combinaciones como un gif con música de fondo) relacionados con el Instituto Politécnico Superior y que no superen los 5 minutos; en algún lado se mostraría el nombre del usuario que aportó el material y un enlace directo a su descarga. Adicionalmente, existiría una sesión de administrador (nosotros), y la posibilidad de que cualquier usuario pueda crearse una cuenta en la página y aportar contenido, el cual posteriormente será analizado por el administrador y decidir si puede mostrarse en pantalla o no. El usuario sólo dispondrá de la función de subir o bajar el contenido (puede ser más de un archivo, para lograr un gif con música de fondo por ejemplo) junto con un comentario.

- Objetivos:
Como ya mencionamos, la única finalidad de esta página es el entretenimiento.

- Metas principales:
  * Idealmente, nuestra página debe contar con las siguientes características:
Cada vez que se ingrese al enlace de nuestra página o se refresque, se muestre un contenido aleatorio.
  * En la página principal, se mostrará el contenido y, de modo que no obstruya el material (preferiblemente en la esquina superior derecha), la sección para iniciar sesión / crear cuenta. Al hacer clic en Iniciar Sesión se desplegará una ventana que pida usuario / e-mail y contraseña.
  * Al hacer clic en Crear Cuenta, saldremos de la página principal y se mostrarán en pantalla los típicos espacios a completar: Nombre de usuario, E-mail, Contraseña, Verificar contraseña, etc.
  * Una vez iniciada una sesión, el usuario podrá acceder a la página de su perfil (su nombre de usuario, esquina superior derecha) y allí podrá editar su perfil, subir contenidos, y revisar el estado de su material aportado: En espera, Aprobado o Denegado. Si la sesión iniciada es la del administrador, en la página de su perfil, además de poder aportar material sin aprobación, tiene la posibilidad de ver todos los aportes subidos a la página en los tres estados previamente mencionados.

- Metas secundarias:
  * Que el administrador tenga la posibilidad de banear usuarios.
  * Que un determinado material a mostrar en pantalla pueda ser puntuado por parte de los usuarios.
  * Un link a la base de datos para buscar una animación en particular y un link de descarga de la animación actual
  * Posibilidad de tener imagen de perfil / avatar.
  * Buena estética / interfaz.

- Cómo, cuándo:
HTML5, Java, base de datos (SQL). El proyecto se llevaría a cabo durante este ciclo lectivo.

- Herramientas similares:
En internet existen varias páginas ya que muestres contenido aleatorio cuando se las refrescan (ej. http://thebest404pageever.com/ https://thebest404pageeverredux.com/, entre otras), sólo que usualmente no permiten al público aportar material. La idea de aportar material y puntuar viene principalmente de la página ShitpostBot 5000 (https://www.shitpostbot.com/).
