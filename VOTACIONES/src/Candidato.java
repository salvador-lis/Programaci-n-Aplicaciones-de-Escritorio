public class Candidato {
    
    private int id;
    private int noVotos;


public Candidato(int id){    
    this.id=id;
    this.noVotos=0;
}

public int getId() {
    return id;
}

public void sumarVoto() {
    noVotos++;
}

@Override
public String toString(){
    return "Candidato no:" + id + " - Votos:"+ noVotos;
}


}

