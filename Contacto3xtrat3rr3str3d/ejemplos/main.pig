##
    Importaciones de los otros lenguajes
##
import carpeta.Persona.z
import carpeta.Funciones.y

##
    Sección opcional de variables, puede no existir
    En esta sección solo se definen variables, arreglos
    o estructuras globales
##
VARIABILES>
esto edad : numerus 20;
esto cifrado : bool falsus;
esto comandante : textum "Estudiante X";
esto fuerza : numerus 10;
esto poder : numerus 0;
esto total : numerus fuerza * 2;
esto gravedad : decimalis 9.81;
esto inicial : littera 'a';
esto mi_booleano : falsus;
series mis_enteros[3] : numerus {1, 1, 1};
series mis_enteros_[2] : numerus;
series nombres[2] : textum {“Hola”, “Adios”};
series nombres_[2] : textum;

##
    Seccion de funcion principal
    Esta sección es obligatoria
##
MAIOR>
>> "Hola comandante!" ;
>> "Ingresa tu nombre por favor" ;
comandante <<
>> "Bienvenido" >> comandante ;
>> "Ingresa tu edad" ;
edad <<

si (edad >= 18) {
    cifrado = verum;
    fuerza = 12;
} finis ;

##
    la siguiente funcion tuvo que estar definida en un archivo .y
##
>> "Tu poder es: " >> calcularPoder(fuerza);
>> "La puerta esta cifrada?" >> cifrado ;

esto mi_entero : numerus 10;
mi_entero = 23;
mi_booleano = verum || 1 = 1;
esto mi_cadena : textum "Nothing here";
mi_cadena = "Abajo el imperio porcino " + 100 + " .. no tenemos miedo";
esto mi_float : decimalis 12.4;
mi_float = 17 / 2 ;
nombres[0] = "Capitán Espárragos";
nombres[1] = nombres[0] + " clon";

esto miObjeto : novus Persona("Profesor", 12);
esto otroObjeto : novus Persona("Otro", 12);
series misObjetos[10] : Persona;
esto mi_direccion : Direccion {"Calle Real", 42};
esto ciudadano : Ciudadano {"Valeria", 25, {"Avenida Central", 500}};
esto ciudadano2 : Ciudadano { miObjeto.getNombre(), 12, mi_direccion };
series resistencia[3] : Ciudadano;
esto alumno_ejemplo : Estudiante {"Carlos", mis_enteros };

miObjeto.nombre = "Yennifer"
misObjetos[9].hablar(miObjeto.getNombre());
mi_cadena = miObjeto.apellidos[0].getNombre();

esto x : numerus 0;
esto y : numerus 0;
si (x > 10 && y < 5) {
    >> "uno";
} aliter (x > 10) {
    >> "dos";
} aliter {
    >> "tres";
} finis;

dum (x < 100) {
    x = x + 1;
    si (x = 50) {
        interrumpe;
    } finis;
} finis;

facere {
    x--;
} dum (x < 10);

per (esto i : numerus 0; i < 10; i++) {
    si (i == 3) { perge; } finis;
    >> i;
}

<<
>> "Holaaaaa";
FINIS;
