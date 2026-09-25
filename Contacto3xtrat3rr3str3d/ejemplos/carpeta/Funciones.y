// definición de estructuras globales, la sección es opcional
%estructuras
estructura MiEstructura:
    cadena nombre

estructura Direccion:
    cadena calle
    entero numero

estructura Registro:
    entero edad
    cadena nombre
    flotante promedio // numero con decimales
    caracter letra
    /*
    la expresión para definir arreglos
    obligatoriamente debe ser constante
    */
    entero miArray[10]

    // es posible anidar estructuras
    MiEstructura miEstructura
    Direccion domicilio

// Nota: no puede llamarse Persona porque ya existe la clase Persona (Persona.z)
estructura Ciudadano:
    cadena nombre
    entero edad
    Direccion domicilio // Estructura anidada

estructura Estudiante:
    cadena nombre
    entero calificaciones[3]

%funciones
// Función sin retorno, con un parámetro
definir funcionSinRetorno(entero miEntero):
    miEntero = 90 * 10

// Función con retorno de tipo entero
definir funcionConRetorno(entero miEntero) -> entero :
    miEntero = 10 + 10
    retornar 160

definir calcularPoder(entero fuerza) -> entero:
    retornar fuerza * 3

definir referencias([] entero miArray, {} Registro p, [][] flotante m):
    miArray[0] = p.edad
    p.domicilio.numero = 5

definir arreglos():
    entero numeros[5] = {10, 20, 30, 40, 50}
    entero resultado
    resultado = numeros[0] + numeros[1] // 10 + 20 = 30
    numeros[2] = numeros[0] * 3
    entero matriz[3][3]
    matriz[1][2] = -numeros[4] % 7

definir estructuras():
    // Se pueden declarar estructuras dentro de las funciones
    estructura Punto:
        entero x
        entero y
        flotante promedio

    Punto p1 = {10, 20, 85.5}
    Punto p2 = {5, 15, 90.0}
    flotante sumaPromedios
    sumaPromedios = p1.promedio + p2.promedio
    Punto p3
    p3 = p1

definir declaraciones():
    entero sinInicializacion
    entero edadUsuario = 25
    flotante temperatura = 36.6
    caracter inicial = 'A'
    bool bandera = verdadero
    bool bandera2 = falso
    cadena saludos = "Saludos zetarianos"
    Registro alumno1
    alumno1.nombre = "Yennifer"

definir control(entero edad, bool condicion, entero opcion):
    entero x
    si(edad > 18) entonces
        imprimir("Codigo si es mayor de edad")

        si(condicion == verdadero) entonces
            imprimir("Otra condicion")

        imprimir("Esto siempre se imprime")
    sino (edad == 18) entonces // opcional
        imprimir("Codigo si tiene exactamente 18")
    contrario // opcional
        imprimir("Codigo si es menor de edad")

    elegir(opcion) :
        caso 1:
            // Código para la opción 1
            x = 10
            romper
        caso 2:
            x = 20
            romper
        siempre:
            x = 30
            romper

definir ciclos():
    para(entero i = 0; i < 10; i++):
        si(i == 3) entonces
            continuar // Salta esta iteración cuando i es 3
        si(i == 8 && !(i < 2 || i > 100)) entonces
            romper

    entero contador = 0
    mientras(contador < 5) hacer
        contador++;

        si(contador == 2) entonces
            continuar;

    entero intentos = 0
    hacer:
        intentos++

        si(intentos == 4) entonces
            romper

    mientras(intentos < 10)

definir especiales():
    imprimir("Imprimir")
    leer()
    cadena x = leer()
    x = leer()
    imprimir(funcionConRetorno(3) + calcularPoder(
        2
    ))
