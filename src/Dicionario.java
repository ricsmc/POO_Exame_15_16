import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Dicionario {
    private String nomeD;
    private Map<String, Entrada> entradas;

    public Dicionario(String nomeD){
        this.nomeD = nomeD;
        this.entradas = new HashMap<>();
    }

    public void add(Entrada ed) throws ExistingEntryException{
        if(this.entradas.containsKey(ed.getTermo())){
            throw new ExistingEntryException("A entrada já existe");
        }
        else{
            this.entradas.put(ed.getTermo(),ed.clone());
        }
    }

    public boolean exists(String termo){
        return this.entradas.containsKey(termo);
    }

    public Entrada get(String termo) throws EntryDoesNotExistException{
        if(!this.entradas.containsKey(termo))
            throw new EntryDoesNotExistException("A entrada não exite");
        else{
            return this.entradas.get(termo).clone();
        }
    }

    public Collection<Entrada> getAll(){
        return this.entradas.entrySet().stream().map(x->x.getValue()).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean sinonimos(String termo1, String termo2){
        return this.entradas.get(termo1).equals(this.entradas.get(termo2));
    }

}


