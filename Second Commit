from abc import ABC, abstractmethod

# ===== CLASE ABSTRACTA =====
class Personaje(ABC):
    def __init__(self, nombre, nivel, vida):
        self.nombre = nombre
        self.nivel = nivel
        self.puntos_vida = vida

    def recibir_dano(self, d):
        self.puntos_vida = max(0, self.puntos_vida - d)

    @abstractmethod
    def atacar(self, obj):
        pass


# ===== "INTERFACES" (por convención) =====
class Curable:
    def curar(self, obj):
        pass


class Invencible:
    def activar_invencibilidad(self):
        pass

    def es_invencible(self):
        pass


# ===== SUBCLASES =====
class Mario(Personaje, Invencible):
    def __init__(self):
        super().__init__("Mario", 3, 100)
        self.invencible = False

    def atacar(self, obj):
        print(f"{self.nombre}: ¡Bola de fuego! 🔥")
        obj.recibir_dano(20)

    def activar_invencibilidad(self):
        self.invencible = True

    def es_invencible(self):
        return self.invencible


class Luigi(Personaje, Curable):
    def __init__(self):
        super().__init__("Luigi", 3, 90)

    def atacar(self, obj):
        print(f"{self.nombre}: ¡Salto alto! ⬆️")
        obj.recibir_dano(15)

    def curar(self, obj):
        print(f"{self.nombre} cura a {obj.nombre}")
        obj.puntos_vida += 20


class Toad(Personaje, Curable):
    def __init__(self):
        super().__init__("Toad", 2, 80)

    def atacar(self, obj):
        print(f"{self.nombre}: ¡Velocidad! 💨")
        obj.recibir_dano(10)

    def curar(self, obj):
        print(f"{self.nombre} cura a {obj.nombre}")
        obj.puntos_vida += 15


# ===== MAIN =====
if __name__ == "__main__":
    equipo = [Mario(), Luigi(), Toad()]
    enemigo = Toad()

    # POLIMORFISMO
    for p in equipo:
        p.atacar(enemigo)

    # INTERFACES (duck typing)
    for p in equipo:
        if hasattr(p, "curar"):
            p.curar(p)
