package domain;

public class TestPrecedable {
    public static void main(String[] args) {
        //parte 1 Persona
        Precedable p1 = new Persona("Mario",123);
        Precedable p2 = new Persona("Agustin",55);
        Precedable p3 = new Persona("Mathi",124);
        Precedable<Persona> personas[] = new Precedable[3];
        personas[0] = p1;
        personas[1] = p2;
        personas[2] = p3;
        SortUtil.ordenar(personas);
        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i]);
        }
        //parte 2 Celular
        Precedable c1 = new Celular(123,"Mario");
        Precedable c2 = new Celular(55,"Agustin");
        Precedable c3 = new Celular(124,"Mathi");
        Precedable<Celular> celulares[] = new Precedable[3];
        celulares[0] = c1;
        celulares[1] = c2;
        celulares[2] = c3;
        SortUtil.ordenar(celulares);
        for (int i = 0; i < celulares.length; i++) {
            System.out.println(celulares[i]);
        }
        //parte 3 creo un Factory de Precedable que segun archivo de configuracion crea objeto necesario
        //parte 1 Persona
        String datos[] = {"Mario","124"};
        Precedable pf1 = FactoryPrecedable.crearPrecedable(datos);
        String datos1[]  = {"Agustin","123"};
        Precedable pf2 = FactoryPrecedable.crearPrecedable(datos1);
        String datos2[]  = {"Mathi","122"};
        Precedable pf3 = FactoryPrecedable.crearPrecedable(datos2);
        Precedable<Persona> personasF[] = new Precedable[3];
        personasF[0] = pf1;
        personasF[1] = pf2;
        personasF[2] = pf3;
        SortUtil.ordenar(personasF);
        for (int i = 0; i < personasF.length; i++) {
            System.out.println(personasF[i]);
        }
    }
}
