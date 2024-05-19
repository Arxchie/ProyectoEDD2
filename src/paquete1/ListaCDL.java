package paquete1;

/**
 *
 * @author HP
 */
public class ListaCDL
{

    private Nodo r;

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

    public void inserta(Nodo n)
    {
        Nodo aux;
        if (n != null)
        {
            if (r == null)// n es el primero
            {
                r = n;
                r.setSiguiente(r);
                r.setAnterior(r);
            } else
            {
                if (n.getEtiqueta().compareTo(r.getSiguiente().getEtiqueta()) < 0 || n.getEtiqueta().compareTo(r.getEtiqueta()) > 0)//n va antes del raiz
                {

                    n.setSiguiente(r.getSiguiente());
                    n.setAnterior(r);
                    n.getSiguiente().setAnterior(n);
                    r.setSiguiente(n);

                    if (n.getEtiqueta().compareTo(r.getEtiqueta()) > 0)
                    {
                        r = n;
                    }

                } else
                {
                    aux = r;
                    do
                    {
                        if (n.getEtiqueta().compareTo(aux.getSiguiente().getEtiqueta()) < 0)//si n es menor
                        {
                            n.setSiguiente(aux.getSiguiente());
                            n.setAnterior(aux);
                            aux.setSiguiente(n);
                            n.getSiguiente().setAnterior(n);
                            break;
                        } else
                        {
                            aux = aux.getSiguiente();
                        }
                    } while (aux != r);

                }
            }
        }
    }

    //Elimina
    public Nodo elimina(String et)
    {
        Nodo n = null;
        if (r != null)
        {
            boolean eliminado = false;
            if (et.compareTo(r.getSiguiente().getEtiqueta()) >= 0 && et.compareTo(r.getEtiqueta()) <= 0)
            {
                Nodo aux = r;
                do
                {
                    if (aux.getSiguiente().getEtiqueta().equals(et))
                    {
                        n = aux.getSiguiente();
                        if (r.getSiguiente() != r)
                        {
                            aux.setSiguiente(n.getSiguiente());
                            aux.getSiguiente().setAnterior(aux);
                            n.setSiguiente(null);
                            n.setAnterior(null);
                            if (n == r)
                            {
                                r = aux;
                            }
                        } else
                        {
                            r = null;
                        }
                        eliminado = true;
                        break;

                    } else
                    {
                        aux = aux.getSiguiente();
                    }
                } while (aux != r);

                if (!eliminado)
                {
                    System.out.println("Objeto no encontrado!!!");
                }
            } else
            {
                System.out.println("Objeto no encontrado!!!");
            }
        } else
        {
            System.out.println("Lista vacia!!!");
        }

        return n;
    }

    public String desp()
    {
        String s = "";
        if (r != null)
        {
            Nodo aux = r.getSiguiente();
            do
            {
                s += aux.getEtiqueta() + " ";
                aux = aux.getSiguiente();
            } while (aux != r.getSiguiente());

        } else
        {
            s += "La lista esta vacia!!";
        }
        return s;
    }

    public String despAnterior(Nodo r)
    {
        String s = "";
        if (r != null)
        {
            Nodo aux = r;
            do
            {
                s += aux.getEtiqueta() + " ";
                aux = aux.getAnterior();

            } while (aux != r);

        } else
        {
            s += "La lista esta vacia!!";
        }
        return s;
    }

    public Nodo busca(String etiqueta)
    {
        if (r != null)
        {
            Nodo aux = r.getSiguiente();
            do
            {
                if (aux.getEtiqueta().equals(etiqueta))
                {
                    return aux;
                } else
                {
                    aux = aux.getSiguiente();
                }
            } while (aux != r.getSiguiente());
        }
        return null;
    }

    public static void main(String[] args)
    {
        Nodo nodo1 = new Nodo("C", null);
        Nodo nodo2 = new Nodo("D", null);
        Nodo nodo3 = new Nodo("A", null);
        Nodo nodo4 = new Nodo("B", null);
        Nodo nodo5 = new Nodo("E", null);
        
        ListaCDL lista = new ListaCDL();
        lista.inserta(nodo1);
        lista.inserta(nodo2);
        lista.inserta(nodo3);
        lista.inserta(nodo4);
        lista.inserta(nodo5);
        System.out.println(lista.desp());
    }

}
