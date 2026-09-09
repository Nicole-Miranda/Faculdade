package school.sptech.ex5;

public class Pokemon {
    String nome;
    String tipo;
    int vida;
    int ataque;
    int experiencia;

    public Pokemon(String n, String t, int v, int a, int e) {
        nome = n;
        tipo = t;
        vida = v;
        ataque = a;
        experiencia = e;
    }

    void receberAtaque(int dano) {
        if (dano > 0) {
            vida = vida - dano;
            if (vida < 0) {
                vida = 0;
            }
        }
    }

    void recuperarVida(int cura) {
        if (cura > 0) {
            vida = vida + cura;
            if (vida > 100) {
                vida = 100;
            }
        }
    }

    void ganharExperiencia(int xp) {
        if (xp > 0) {
            experiencia = experiencia + xp;
        }
    }

    int calcularNivel() {
        return 1 + (experiencia / 100);
    }

    int calcularPoderDeCombate() {
        int nivel = 1 + (experiencia / 100);
        return ataque + (10 * nivel) + vida;
    }

    void batalhar(int[] ataques, int[] curas) {
        for (int i = 0; i < ataques.length; i++) {
            receberAtaque(ataques[i]);
            if (vida == 0) {
                break;
            }
            recuperarVida(curas[i]);
        }
    }
}
