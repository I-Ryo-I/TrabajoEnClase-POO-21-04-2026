import java.util.ArrayList;

// ===== CLASE ABSTRACTA =====
abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;

    public Personaje(String nombre, int nivel, int vida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = vida;
    }

    public void recibirDano(int d) {
        puntosVida = Math.max(0, puntosVida - d);
    }

    public abstract void atacar(Personaje obj);
}

// ===== INTERFACES =====
interface Curable {
    void curar(Personaje obj);
}

interface Invencible {
    void activarInvencibilidad();
    boolean esInvencible();
}

// ===== SUBCLASES =====
class Mario extends Personaje implements Invencible {
    private boolean invencible = false;

    public Mario() {
        super("Mario", 3, 100);
    }

    @Override
    public void atacar(Personaje obj) {
        System.out.println(nombre + ": ¡Bola de fuego! 🔥");
        obj.recibirDano(20);
    }

    @Override
    public void activarInvencibilidad() {
        invencible = true;
    }

    @Override
    public boolean esInvencible() {
        return invencible;
    }
}

class Luigi extends Personaje implements Curable {

    public Luigi() {
        super("Luigi", 3, 90);
    }

    @Override
    public void atacar(Personaje obj) {
        System.out.println(nombre + ": ¡Salto alto! ⬆️");
        obj.recibirDano(15);
    }

    @Override
    public void curar(Personaje obj) {
        System.out.println(nombre + " cura a " + obj.nombre);
        obj.puntosVida += 20;
    }
}

class Toad extends Personaje implements Curable {

    public Toad() {
        super("Toad", 2, 80);
    }

    @Override
    public void atacar(Personaje obj) {
        System.out.println(nombre + ": ¡Velocidad! 💨");
        obj.recibirDano(10);
    }

    @Override
    public void curar(Personaje obj) {
        System.out.println(nombre + " cura a " + obj.nombre);
        obj.puntosVida += 15;
    }
}

// ===== MAIN =====
public class Main {
    public static void main(String[] args) {

        ArrayList<Personaje> equipo = new ArrayList<>();
        equipo.add(new Mario());
        equipo.add(new Luigi());
        equipo.add(new Toad());

        Personaje enemigo = new Toad();

        // POLIMORFISMO
        for (Personaje p : equipo) {
            p.atacar(enemigo);
        }

        // USO DE INTERFACES
        for (Personaje p : equipo) {
            if (p instanceof Curable) {
                ((Curable) p).curar(p);
            }
        }
    }
}
