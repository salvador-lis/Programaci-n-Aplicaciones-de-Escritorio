import java.util.Scanner;
import java.util.ArrayList;
    public static void main(String[] args) throws Exception {

        ArrayList<Candidato> candidatos = new ArrayList<>();
        int i;
        int voto;

        Scanner input= new Scanner(System.in);
        System.out.println("Cuantos candidatos registrará?:");
        int numero = input.nextInt();
        
        
        for(i=1;i<=numero;i++) {
            candidatos.add(new Candidato(i));
        }
        
        System.out.println("Ingrese los votos (Ingrese 0 para terminar):");
        do {
            voto = input.nextInt();

            if (voto > 0 && voto <= numero) {
               
                for (Candidato c : candidatos) {
                    if (c.getId() == voto) {
                        c.sumarVoto();
                        break;
                    }
                }
            }
        } while (voto != 0); 


        System.out.println("Resultados...");
        for(Candidato c : candidatos){
            System.out.println(c);
        }

               

}

