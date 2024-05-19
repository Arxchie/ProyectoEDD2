package paquete1;

/**
 *
 * @author HP
 */
public class Multilista
{

    private Nodo r = null;

    public Nodo inserta(Nodo r, int nivel, String s[], Nodo n)
    {
        if (s.length - 1 == nivel)
        {
            ListaCDL obj = new ListaCDL();
            obj.setR(r);
            obj.inserta(n);
            return obj.getR();
        } else
        {
            Nodo aux = busca(r, s[nivel]);
            if (aux != null)
            {
                Nodo retorno=inserta(aux.getAbajo(), nivel + 1, s, n);
                aux.setAbajo(retorno);
                retorno.setArriba(aux);
              
            } else
            {
                System.out.println("no encontrada");
            }
            return r;

        }
    }

    public Nodo elimina(Nodo r, int nivel, String s[], Nodo n)
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

    public String desp(Nodo r, String saltos)
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
      
        String ets[] =
        {
            "A"
        };
        m.setR(m.inserta(m.getR(), 0, ets, n1));
        m.setR(m.inserta(m.getR(), 0, ets, n2));
        m.setR(m.inserta(m.getR(), 0, ets, n3));
        System.out.println(m.desp(m.getR(), ""));
        String ets2[] =
        {
            "A", "A1"
        };
        m.setR(m.inserta(m.getR(), 0, ets2, n4));
        m.setR(m.inserta(m.getR(), 0, ets2, n5));
        m.setR(m.inserta(m.getR(), 0, ets2, n6));
        String ets3[] =
        {
            "A", "A1", " "
        };
       
        m.setR(m.inserta(m.getR(), 0, ets3, n7));
        m.setR(m.inserta(m.getR(), 0, ets3, n8));
        m.setR(m.inserta(m.getR(), 0, ets3, n9));
        
        System.out.println("");
        System.out.println(m.desp(m.getR(), ""));
        String ets4[] =
        {
            "A", "A1", "A11"
        };
        m.setR(m.elimina(m.getR(), 0, ets4, n7));
        System.out.println("Eliminado");
        System.out.println(m.desp(m.getR(), ""));

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
