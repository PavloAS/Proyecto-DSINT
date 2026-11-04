# Análisis inicial de la ontología - Mitología Griega

## 1. Introducción

Conceptos, personajes, objetos y relaciones que aparecen en el enunciado y que podemos necesitar para la ontología en Protégé Frames 3.4.8 para Windows, siguiendo los apuntes de la asignatura.

Es un primer boceto, todavía tenemos que decidir algunas cosas entre los tres.

## 2. Clases y jerarquía

```text
Thing
├── Personaje
│   ├── Dios
│   ├── Semidios
│   ├── Humano
│   ├── Heroe
│   └── Criatura
│       ├── Monstruo
│       └── Animal
├── Objeto
│   ├── Arma
│   ├── ObjetoDefensivo
│   └── ObjetoMagico
├── Capacidad
└── Lugar
```

En Protégé indicaremos el rol de cada clase: **abstracta**, si solo sirve para agrupar subclases y no tendrá instancias directas, o **concreta**, si vamos a crear instancias de ella. Como propuesta inicial, `Personaje` y `Criatura` podrían ser abstractas, y las demás clases del boceto, concretas. Dejamos `Objeto` concreta para poder incluir materiales como la cera y las plumas sin crear más clases por ahora. `Thing` representa la raíz del sistema.

**Por decidir:**

- `Heroe` se usaría junto con `Humano` o `Semidios`, ya que un héroe puede ser cualquiera de los dos. También debe permitir representar a las heroínas del escenario 6.
- Algunos objetos pueden pertenecer a varias clases.
- Las capacidades podrían ser instancias de `Capacidad`, como `Vuelo` o `Invisibilidad`.
- Hay que decidir cómo clasificar a las Ninfas y las Grayas, y si las tratamos como grupos o como personajes separados.

## 3. Personajes

### Dioses

| Personaje | Información importante |
|---|---|
| Zeus | Padre de Perseo y Heracles |
| Atenea | Ayuda a Perseo y le proporciona el escudo |
| Hermes | Ayuda a Perseo y le proporciona la hoz |
| Hades | Tiene un casco que permite ser invisible |
| Hefesto | Puede entregar objetos y mejorar el escudo |
| Poseidon | Su enojo con Casiopea provoca la liberación de Ceto |
| Doris | Relacionada con el conflicto de Casiopea |

### Héroes

| Personaje | Información importante |
|---|---|
| Perseo | Rescata a Andromeda utilizando la cabeza de Medusa |
| Teseo | Mata al Minotauro con ayuda de Ariadna |
| Heracles | Tiene fuerza extraordinaria y el favor de Zeus |

### Otros personajes

| Personaje | Información importante |
|---|---|
| Andromeda | Es apresada por Ceto |
| Casiopea | Provoca el enojo de Poseidon |
| Ariadna | Ayuda a Teseo con su hilo |
| Minos | Ordena construir el laberinto y encierra a Dedalo e Icaro |
| Dedalo | Construye el laberinto y las alas |
| Icaro | Escapa con las alas, pero termina muriendo |
| Danae | Madre de Perseo |
| Ninfas | Poseen objetos que necesita Perseo |
| Grayas | Comparten un ojo y ayudan a localizar a las Ninfas |

### Criaturas

| Criatura | Información importante |
|---|---|
| Medusa | Petrifica con su mirada |
| Ceto | Criatura marina que apresa a Andromeda |
| Minotauro | Vive en el laberinto y puede apresar personajes |
| Pegaso | Caballo alado que permite volar |
| Kraken | Posible alternativa a Ceto |

## 4. Objetos

| Objeto | Función |
|---|---|
| Escudo de Bronce | Atenea se lo puede dar a Perseo |
| Escudo Espejo | Permite mirar a Medusa indirectamente |
| Hoz de Acero | Arma para matar a Medusa |
| Casco de Hades | Proporciona invisibilidad |
| Sandalias Aladas | Permiten volar |
| Zurron Magico | Permite guardar la cabeza de Medusa sin morir |
| Cabeza de Medusa | Permite petrificar |
| Cabeza del Minotauro | Uno de los trofeos que debe reunir un héroe en el escenario 7 |
| Cabeza de la criatura marina | Otro de los trofeos del escenario 7, de Ceto o de la criatura que lo sustituya |
| Brida de Oro | Permite capturar a Pegaso |
| Ojo de las Grayas | Sirve para conseguir información |
| Hilo de Ariadna | Permite salir del laberinto |
| Espada de Teseo | Arma para matar al Minotauro |
| Alas de Icaro | Permiten volar; tras la caída de Icaro quedan rotas y hay que repararlas para usarlas |
| Alas de Dedalo | Permiten volar |
| Cuerno del Minotauro | Puede utilizarse como arma |
| Anillo de Invisibilidad | Alternativa al casco de Hades |
| Espejo de Mano | Alternativa al escudo espejo |
| Conjuro de Vuelo | Alternativa para conseguir vuelo |
| Cera y plumas | Permiten construir o reparar las alas |

No hace falta crear una clase para cada objeto. La mayoría pueden ser instancias de clases más generales. La cera y las plumas serían dos instancias distintas, porque hacen falta ambos materiales.

## 5. Capacidades

| Capacidad | Cómo se consigue |
|---|---|
| Vuelo | Sandalias, alas, Pegaso o conjuro |
| Invisibilidad | Casco de Hades o anillo |
| Espejo | Escudo espejo o espejo de mano |
| Petrificacion | Cabeza de Medusa |
| Fuerza extraordinaria | Heracles |

Las reglas deberían depender de las capacidades siempre que sea posible. Así, distintos objetos pueden servir para realizar la misma acción.

Tener unas alas rotas no da vuelo. Habrá que comprobar que el objeto se pueda usar y dejar de contar la capacidad que aporta si se pierde o se rompe, salvo que el personaje tenga otra forma de conseguirla. Pegaso se tratará como una montura, porque es un personaje, no un objeto.

## 6. Slots (propiedades y relaciones)

En Frames, las propiedades y relaciones se representan mediante **slots**. Para cada uno indicaremos las clases que lo usan (dominio), el tipo de valor, los valores o clases permitidos, la cardinalidad y, cuando corresponda, su inversa.

En las tablas, `Instance (Personaje)` significa que el valor será una instancia de `Personaje`, no la clase en sí. `0..*` permite ningún valor o varios; `0..1`, como máximo uno; y `1`, exactamente uno. Son propuestas iniciales que tendremos que revisar.

### Entre personajes

| Slot | Significado | Dominio | Tipo y clase permitida | Cardinalidad |
|---|---|---|---|---|
| `tieneFavorDe` | Un personaje tiene el favor de otro | Personaje | Instance (Personaje) | 0..* |
| `tieneEnojoDe` | Un personaje tiene el enojo de otro | Personaje | Instance (Personaje) | 0..* |
| `apresa` | Un personaje apresa a otro | Personaje | Instance (Personaje) | 0..* |
| `libera` | Un personaje libera a otro | Personaje | Instance (Personaje) | 0..* |
| `mata` | Un personaje mata a otro | Personaje | Instance (Personaje) | 0..* |
| `localiza` | Un personaje localiza a otro | Personaje | Instance (Personaje) | 0..* |
| `esPadreDe` | Relación de parentesco | Personaje | Instance (Personaje) | 0..* |
| `esMadreDe` | Relación de parentesco, como Casiopea con Andromeda | Personaje | Instance (Personaje) | 0..* |
| `ayudaA` | Un personaje ayuda a otro | Personaje | Instance (Personaje) | 0..* |

Los favores y enojos pueden venir de dioses, pero también de personajes como Ariadna o Minos.

### Objetos y capacidades

| Slot | Significado | Dominio | Tipo y clase permitida | Cardinalidad |
|---|---|---|---|---|
| `tieneObjeto` | Un personaje posee un objeto | Personaje | Instance (Objeto) | 0..* |
| `tieneCapacidad` | Un personaje tiene una capacidad | Personaje | Instance (Capacidad) | 0..* |
| `proporcionaCapacidad` | Un objeto o una montura proporciona una capacidad | Objeto, Animal | Instance (Capacidad) | 0..* |
| `tieneMontura` | Un personaje dispone de una montura, como Pegaso | Personaje | Instance (Animal) | 0..* |
| `entregaObjeto` | Un personaje entrega un objeto | Personaje | Instance (Objeto) | 0..* |
| `obtieneObjeto` | Un personaje consigue un objeto | Personaje | Instance (Objeto) | 0..* |

### Otras relaciones

| Slot | Significado | Dominio | Tipo y clase permitida | Cardinalidad |
|---|---|---|---|---|
| `estaEn` | Localización de un personaje | Personaje | Instance (Lugar) | 0..1 |
| `construye` | Un personaje construye un objeto o un lugar, como el laberinto | Personaje | Instance (Objeto o Lugar) | 0..* |
| `repara` | Un personaje repara un objeto | Personaje | Instance (Objeto) | 0..* |
| `tienePrisionero` | Un personaje mantiene preso a otro | Personaje | Instance (Personaje) | 0..* |

Posibles slots inversos, que habrá que asociar explícitamente en Protégé:

- `esApresadoPor`, inverso de `tienePrisionero`: dominio `Personaje`, tipo `Instance (Personaje)` y cardinalidad inicial `0..*`.
- `tienePropietario`, inverso de `tieneObjeto`: dominio `Objeto`, tipo `Instance (Personaje)` y cardinalidad `0..1`, si decidimos que cada objeto tiene como máximo un propietario actual.

**Pendiente:** decidir qué relaciones representamos en Protégé y cuáles serán hechos o acciones de Drools. No todas tienen que aparecer como slots. Distinguiremos la acción `apresa` de la situación actual `tienePrisionero`. En acciones como entregar, además del objeto, hace falta saber quién lo entrega y quién lo recibe; `entregaObjeto` por sí solo no recoge todo eso.

## 7. Estados

### Personajes

- Vivo / muerto.
- Libre / preso.
- Localización.
- Objetos que posee.
- Capacidades que tiene.

### Objetos

- Propietario.
- Disponible / no disponible.
- Roto / reparado, cuando corresponda.

Posibles slots de tipo `Boolean`:

| Slot | Dominio | Tipo | Cardinalidad |
|---|---|---|---|
| `estaVivo` | Personaje | Boolean | 1 |
| `estaLibre` | Personaje | Boolean | 1 |
| `estaRoto` | Objeto, cuando corresponda | Boolean | 0..1 |
| `estaDisponible` | Objeto | Boolean | 1 |

`true` y `false` representan los dos estados. Un slot vacío no equivale a `false`. Si usamos valores por defecto, habrá que definirlos según los hechos iniciales y permitir que cada escenario los cambie.

Crear una instancia en Protégé no significa que esté disponible desde el principio de la historia: las cabezas tendrán `estaDisponible = false` hasta que se generen tras la muerte de la criatura, y las alas hasta que se construyan. Al apresar o liberar a alguien, actualizaremos tanto `estaLibre` como las relaciones de cautiverio.

## 8. Restricciones

El profesor pide al menos tres restricciones en Protégé.

Podemos usar las clases y slots que ya tenemos:

1. Cada personaje debe tener exactamente un valor en `estaVivo`: tipo `Boolean`, obligatorio y con cardinalidad máxima 1.
2. Cada objeto puede tener como máximo un propietario actual: `tienePropietario` de tipo `Instance (Personaje)` y cardinalidad `0..1`, si seguimos la propuesta de no compartir la propiedad de un mismo objeto.
3. Ningún personaje puede tenerse a sí mismo como prisionero: comprobar con **PAL (Protégé Axiom Language)** que `tienePrisionero` no relaciona una instancia consigo misma.

Las dos primeras se configuran en los slots. Para la tercera, se activa la pestaña `PAL Constraints` desde `Project > Configure`. Con esto no hace falta crear clases como `PersonajePreso` u `ObjetoVolador` solo para añadir restricciones.

Tendremos que definir las clases y slots necesarios y comprobar estas restricciones en Protégé. PAL sirve para comprobar condiciones; las acciones de la historia se resolverán en Drools. Si comprobamos slots `Boolean` en PAL, tendremos en cuenta la conversión con `coerce-to-string` que indican los apuntes.

## 9. Acciones y reglas

Acciones principales:

- Matar.
- Apresar.
- Liberar.
- Localizar.
- Obtener.
- Entregar.
- Intercambiar.
- Construir.
- Reparar.

Ejemplos de reglas para Drools:

En las acciones comprobaremos que quien actúa esté vivo y que su situación permita realizarlas. Estar preso no impide todas las acciones: Dedalo, por ejemplo, construye las alas dentro del laberinto.

**Obtener vuelo**

```text
Si un personaje tiene un objeto
que proporciona vuelo y se puede usar,
entonces puede volar.
```

Si usa a Pegaso, habrá que comprobar que dispone de él como montura y que Pegaso puede volar.

**Conseguir objetos**

```text
Si un dios favorece a un personaje
y tiene un objeto que puede darle,
el personaje puede conseguirlo.
```

**Matar a Medusa**

```text
Si un heroe vivo tiene:
- Vuelo
- Invisibilidad
- Espejo
- Un arma adecuada

Y ha localizado a Medusa y ella esta viva,
puede matarla.
```

La fuerza extraordinaria de Heracles puede sustituir al arma si seguimos esa variante del enunciado. Para recoger la cabeza de Medusa sin morir hace falta el zurrón mágico. Sin él, el héroe muere y no puede continuar actuando.

**Liberar personajes**

```text
Si un personaje mata a una criatura
que tiene preso a otro personaje,
se elimina esa relación de cautiverio.
Si el prisionero no tiene otros captores,
queda libre.
```

También habrá que reflejar los efectos de las acciones: al matar cambia el estado de la víctima y pueden aparecer su cabeza y otros objetos; al entregar o tomar un objeto de otro personaje cambia de propietario, sin duplicarlo.

## 10. Relaciones entre mitos y escenarios

- Las alas de Icaro o Dedalo pueden sustituir a las sandalias aladas.
- El cuerno del Minotauro puede sustituir a la hoz.
- Teseo puede rescatar a Andromeda.
- Heracles puede utilizar su fuerza para matar criaturas.
- El Minotauro puede apresar a otros héroes.
- Los personajes pueden conseguir objetos de otros mitos.
- Una mujer puede liberar a un personaje masculino.

La idea es utilizar una única ontología para todos los escenarios. Al prepararlos, habrá que tener en cuenta algunos detalles del enunciado:

- En el escenario 4, Dedalo debe crear las alas tras ser encerrado en el laberinto, después de la muerte del Minotauro. No basta con dárselas a Perseo desde el inicio.
- En el escenario 5, el héroe debe ser apresado por el Minotauro y liberado por otro héroe antes de rescatar a Andromeda.
- En el escenario 7, los tres héroes intentan salvar a Andromeda y uno debe acabar con las cabezas de Medusa, del Minotauro y de la criatura marina.
- En el escenario 8 tendremos que proponer un mito propio distinto de los anteriores.

## 11. Hechos iniciales e instancias

Ejemplo de hechos por defecto:

```text
Perseo esta vivo
Andromeda esta libre
Medusa esta viva
Ceto esta vivo y preso
Atenea tiene EscudoBronce
Hermes tiene HozAcero
Ninfas tienen SandaliasAladas
Ninfas tienen ZurronMagico
```

Ejemplo de condiciones de un escenario:

```text
Perseo tiene el favor de Atenea
Casiopea tiene el enojo de Poseidon
Atenea no tiene EscudoBronce
```

Las condiciones de cada escenario pueden modificar los hechos iniciales. Por ejemplo, si Atenea no tiene el escudo, se elimina esa posesión inicial antes de empezar la historia. Andromeda empieza libre: el enojo de Poseidon provoca que se libere Ceto y que después la aprese.

En la pestaña `Instances` crearemos las instancias y rellenaremos sus slots. Algunos ejemplos:

| Instancia | Clase propuesta | Ejemplo de valores de slots |
|---|---|---|
| Perseo | Semidios y Heroe | `estaVivo = true` |
| Andromeda | Humano | `estaLibre = true` |
| Atenea | Dios | `tieneObjeto = EscudoBronce` |
| Medusa | Monstruo | `estaVivo = true` |
| SandaliasAladas | ObjetoMagico | `proporcionaCapacidad = Vuelo` |
| Pegaso | Animal | `proporcionaCapacidad = Vuelo`, según la versión elegida |
| LaberintoCreta | Lugar | Lugar usado como valor de `estaEn` |
| Vuelo | Capacidad | Instancia usada como valor de `proporcionaCapacidad` |

La tabla solo muestra algunos valores. Habrá que completar los slots obligatorios, crear las instancias referenciadas y añadir al menos una instancia de ejemplo por cada clase concreta, además de ejemplos de todas las relaciones.

## 12. Requisitos de la ontología

- [ ] Clases y jerarquía, indicando cuáles son abstractas y cuáles concretas.
- [ ] Slots para las propiedades y relaciones.
- [ ] Dominios, tipos de valor, clases permitidas y cardinalidades.
- [ ] Slots inversos definidos explícitamente cuando corresponda.
- [ ] Metadatos y documentación: una breve descripción de cada clase y slot en `Documentation`, con la fuente del concepto cuando corresponda.
- [ ] Al menos una instancia por clase concreta.
- [ ] Instancias de ejemplo para las relaciones.
- [ ] Al menos tres restricciones de Frames y, cuando haga falta, PAL, comprobadas con las instancias.
- [ ] Ontología coherente con los escenarios y las reglas.
- [ ] Proyecto guardado con sus archivos `.pprj`, `.pont` y `.pins`.

Para la entrega también hará falta el informe en PDF con las decisiones justificadas, los datos del grupo y el uso de IA documentado, como pide el enunciado. Este borrador nos sirve de base para prepararlo.

## 13. Decisiones pendientes

1. Revisar la clasificación de los héroes (humanos y semidioses), las Ninfas y las Grayas.
2. Cómo representar las capacidades.
3. Cómo representar los estados.
4. Qué acciones van en Protégé y cuáles en Drools.
5. Qué clases de objetos necesitamos.
6. Qué información es fija y cuál cambia en cada escenario.
7. Qué versiones de los mitos vamos a utilizar. En particular, si Pegaso nace al morir Medusa, no puede servir para llegar a ella antes de matarla; la alternativa exige que ya exista.

## 14. Siguiente paso

Revisar la jerarquía y los slots entre los tres y empezar a introducirlos en Protégé. Después añadir las restricciones, instancias y documentación.

Al guardar el proyecto de Frames en formato `Protégé Files`, conservaremos juntos los tres archivos:

- `.pprj`: configuración del proyecto y referencias a los archivos asociados.
- `.pont`: clases, jerarquía y slots.
- `.pins`: instancias y sus valores.

Abriremos el proyecto desde el `.pprj` y mantendremos también los otros dos archivos. Este formato está descrito en la [guía oficial de Protégé Frames](https://protegewiki.stanford.edu/wiki/PrF_UG_all#Protege_Files).
