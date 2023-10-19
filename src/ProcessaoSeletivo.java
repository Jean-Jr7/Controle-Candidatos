import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessaoSeletivo {
    public static void main(String[] args){
         String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

         for( String candidato: candidatos){
            entrandoEmContato(candidato);
         }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;
		do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
			
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
		
		
	}

    
        static boolean atender() {
		return new Random().nextInt(3)==1;	
	}
    
    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

         for(int indice = 0;  indice < candidatos.length; ++indice){
            System.out.println("O candidato selecionado e o " + candidatos[indice] );
        }
    }
    static void selecionarCandidato(){
        

        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int totalSelecionados = 0;
		int proximoCandidato = 0; 
        double salarioBase = 2000.0;
		while(totalSelecionados <5 && proximoCandidato < candidatos.length) {
			String candidato = candidatos[proximoCandidato++];
			double valorPretendido = valorPretendido();
			
            System.out.println("O candidato " + candidato + " está pedindo " + valorPretendido);
			if(salarioBase >= valorPretendido) {
				System.out.println("QUE PENA!! O candidato " + candidato + " NÃO foi selecionado ");
				
			}else {
				System.out.println("LEGAL!! O candidato " + candidato + " foi selecionado ");
				totalSelecionados++;
			}
			
		}
		System.out.println("Total de selecionados: " + totalSelecionados);
		System.out.println("Total de consultados: " + proximoCandidato);
	}
	static double valorPretendido() {
	     return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
   
    static void analisarCandidato(Double salarioPretendido){

        Double salarioBase = 2000.0;
        if( salarioBase > salarioPretendido){
            System.out.println("Ligar para o condidato");
        
        }else if(salarioBase == salarioPretendido)
            System.out.println("Ligar para o canditato com contra proposta");

        else{
            System.out.println("Aguardar demais candidatos");
        }    
    }

}
