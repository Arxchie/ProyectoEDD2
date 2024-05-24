package paquete1;

/**
 *
 * @author HP
 */
public class Multilista
{

    private Nodo r = null;

    private Nodo inserta(Nodo r, int nivel, String[] s, Nodo n, Nodo arriba)
    {

        if (s != null && s.length - 1 == nivel)
        {
            ListaCDL obj = new ListaCDL();
            obj.setR(r);
            if (n != null)
            {
                n.setArriba(arriba);
            }
            obj.inserta(n);

            return obj.getR();
        } else
        {
            Nodo aux ;
            if (s != null)
            {
                 aux = busca(r, s[nivel]);
            }else
            {
                aux=null;
            }
            if (aux != null)
            {
                Nodo retorno = inserta(aux.getAbajo(), nivel + 1, s, n, aux);
                aux.setAbajo(retorno);
//                if (retorno != null)
//                {
//                    Nodo aux2 = retorno.getSiguiente();//guardando la r
//                    do
//                    {
//                        aux2.setArriba(aux);//insertando el arriba a todos los nodos
//                        aux2 = aux2.getSiguiente();     
//                    } while (aux2 != retorno.getSiguiente());
//                }
            } else
            {
                System.out.println("no encontrada");
            }
            return r;

        }
    }

    private Nodo elimina(Nodo r, int nivel, String s[], Nodo n)
    {
        if (s.length - 1 == nivel)
        {
            ListaCDL obj = new ListaCDL();
            obj.setR(r);
            obj.elimina(n.getEtiqueta());
            return obj.getR();
        } else
        {
            Nodo aux = busca(r, s[nivel]);
            if (aux != null)
            {
                aux.setAbajo(elimina(aux.getAbajo(), nivel + 1, s, n));
            } else
            {
                System.out.println("no encontrada");
            }
            return r;
        }
    }

    public Nodo busca(Nodo r, String s)
    {
        ListaCDL obj = new ListaCDL();
        obj.setR(r);
        return obj.busca(s);
    }
   

    private String desp(Nodo r, String saltos)
    {
        String s = "";
        if (r != null)
        {
            Nodo aux = r.getSiguiente();
            do
            {
                s += saltos + aux.getEtiqueta() + "\n" + desp(aux.getAbajo(), saltos + "\t");
                aux = aux.getSiguiente();

            } while (aux != r.getSiguiente());
        }
        return s;
    }

    /**
     * funcion para insertar un nodo en la multilista
     *
     * @param nvo nodo a insertar en la multilista
     * @param arr arreglo de string donde se indica donde se quiere insertar ej:
     * "A","A1","A11"<- el ultimo es el elemento a insertar
     */
    public void inserta(Nodo nvo, String... arr)
    {
        r = inserta(r, 0, arr, nvo, null);
    }

    /**
     * Funcion para eliminar un nodo de la multilista
     *
     * @param nodo nodo a eliminar
     * @param arr arreglo de string que indica la ruta del elemento a eliminar
     * ej: "A","A1","A11"<-elemento a eliminar
     */
    public void elimina(Nodo nodo, String... arr)
    {
        r = elimina(r, 0, arr, nodo);
    }

    /**
     * Funcion que despliega toda la multilista por consola
     */
    public void desp2()
    {
        if (r != null)
        {
            System.out.println(desp(r, ""));
        } else
        {
            System.out.println("Multilista Vacia");
        }
    }

    public static void main(String[] args)
    {
        Multilista m = new Multilista();
        Nodo n1 = new Nodo("A", 1);
        Nodo n2 = new Nodo("B", null);
        Nodo n3 = new Nodo("C", null);
        Nodo n4 = new Nodo("A1", null);
        Nodo n5 = new Nodo("A2", null);
        Nodo n6 = new Nodo("A3", null);
        Nodo n7 = new Nodo("A11", null);
        Nodo n8 = new Nodo("A12", null);
        Nodo n9 = new Nodo("A13", null);
        Nodo n10 = new Nodo("C1", null);
        Nodo n11 = new Nodo("C2", null);
        Nodo n12 = new Nodo("C3", null);
        m.desp2();
        String ets[] =
        {
            "A"
        };
//        m.setR(m.inserta(m.getR(), 0, ets, n1));
//        m.setR(m.inserta(m.getR(), 0, ets, n2));
//        m.setR(m.inserta(m.getR(), 0, ets, n3));
        m.inserta(n1, "A");
        m.inserta(n2, "B");
        m.inserta(n3, "C");

        m.inserta(n4, "A", "A1");
        m.inserta(n5, "A", "A2");
        m.inserta(n6, "A", "A3");

        m.inserta(n7, "A", "A1", "A11");
        m.inserta(n8, "A", "A1", "A12");
        m.inserta(n9, "A", "A1", "A13");

        m.inserta(n10, "C", "C1");
        m.inserta(n11, "C", "C2");
        m.inserta(n12, "C", "C3");
        m.desp2();
        // m.setR(m.elimina(m.getR(), 0, ets4, n1));//verificar que el nodo a eliminar sea el correcto
        System.out.println("Eliminado");
        m.elimina(n7, "A", "A1", "A11");
        m.desp2();
    }

    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }
}
