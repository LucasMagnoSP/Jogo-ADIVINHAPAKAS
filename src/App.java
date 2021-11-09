import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
    
        int dica, superdica,superdicagen;
        int tentativas = 0, acerto= 0,qntdica = 5,contsuperdica=0;
        int[] numeroInputCerto , novaSenha;
        String[]sinais;

        novaSenha = geracodigoAleatorio();//METODO BLOCO GERADOR
        //HACK XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            System.out.println(novaSenha[3]);
            System.out.println(novaSenha[2]);
            System.out.println(novaSenha[1]);
            System.out.println(novaSenha[0]);
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        //REGRAS    
            JOptionPane.showMessageDialog(null, 
            "                                 Bem Vindo ao ADIVINHAPAKAS !!\n\n" + 
                            "Esse é um jogo no qual você precisa acertar uma senha aleatoria de 4 digitos.\n\n"+
                            "Não temos TIMER, então fique a vontade para pensar.\n\n" +
                            "Tambem não temos limite de tentativas, pode chutar a vontade !\n\n",
            "ADIVINHAPAKAS",1);
            JOptionPane.showMessageDialog(null, 
            "                                               Instruções de Dicas :\n\n" +
                            "A cada partida você começa com " + qntdica +" dicas, use-as com sabedoria.\n\n"+ 
                            "Caso a dica seja  ' \u2705 ' significa que o numero digitado está correto ! \n\n"+
                            "Caso a dica seja  ' \uD83D\uDD3A ' significa que o numero digitado é maior que o correto ! \n\n"+
                            "Caso a dica seja  ' \uD83D\uDD3B ' significa que o numero digitado é menor que o correto ! \n\n",
            "ADIVINHAPAKAS",1);
        //FIM REGRAS 
        //INICIO JOGO
        do {
            tentativas++;  
            numeroInputCerto = lerInputUsuario();//METODO INPUT USUARIO
            //BLOCO ACERTO
            if(Arrays.equals(numeroInputCerto ,novaSenha )){
                if (tentativas==1) {    
                    ImageIcon iconCorreto = new ImageIcon("icons\\the-rock-rock.gif");
                    JOptionPane.showMessageDialog(null,"TA USANDO HACK NÉ ???\n" + "Você precisou de " + tentativas +" tentativa para acertar !","ADIVINHPAKAS",JOptionPane.INFORMATION_MESSAGE,iconCorreto);
                }  
                else {
                    ImageIcon iconCorreto2 = new ImageIcon("icons\\shaun.gif");
                    JOptionPane.showMessageDialog(null,"Você ACERTOUUU !!\n"+"PARABENS !!!\n" + "Você precisou de " + tentativas +" tentativas !","ADIVINHPAKAS",JOptionPane.INFORMATION_MESSAGE,iconCorreto2);
                }
                acerto++;    
             //FIM BLOCO ACERTO
            }
            //BLOCO ERRO
            else{
                ImageIcon iconErrado = new ImageIcon("icons\\faustao.gif");
                JOptionPane.showMessageDialog(null,"TENTE NOVAMENTE !","ADIVINHPAKAS",JOptionPane.ERROR_MESSAGE,iconErrado);
                //BLOCO DICA
                dica = JOptionPane.showConfirmDialog(null, "Vai uma dica ai ?\n" + "Você tem : " + qntdica + " dica(s)","ADIVINHPAKAS",JOptionPane.YES_NO_OPTION);            
                switch (dica) {
                    case JOptionPane.YES_OPTION :
                        if(qntdica > 0){
                            //BLOCO SUPER DICA 
                            superdicagen = (int)Math.round(Math.random()*3);
                            superdica = (int)Math.round(Math.random()*3);
                            if(superdica == superdicagen){
                                superdicaSwitch(superdicagen, superdica, novaSenha,contsuperdica);//METODO SUPER DICA 
                                contsuperdica++;
                             // FIM BLOCO SUPER DICA
                            }
                         //BLOCO SINAIS DE DICA   
                            sinais = sinaisDica(numeroInputCerto,novaSenha); //METODOS SINAIS DE DICA
                            JOptionPane.showMessageDialog(null,"   Codigo digitado : "+numeroInputCerto[3]+numeroInputCerto[2]+numeroInputCerto[1]+numeroInputCerto[0]+"\n"+
                            "                 " +numeroInputCerto[3]+ "  é  " +sinais[3]+ "\n"+
                            "                 " +numeroInputCerto[2]+ "  é  " +sinais[2]+ "\n"+
                            "                 " +numeroInputCerto[1]+ "  é  " +sinais[1]+ "\n"+
                            "                 " +numeroInputCerto[0]+ "  é  " +sinais[0]+ "\n",
                            "ADIVINHPAKAS",1);
                         //FIM BLOCO SINAIS DE DICA
                            qntdica = (qntdica - 1) ;     
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Infelizmente suas dicas acabaram !","ADIVINHPAKAS",1); 
                        }
                    break;
                    case JOptionPane.NO_OPTION :
                    break;
                 // FIM BLOCO DICA  
                } 
             //FIM BLOCO ERRO         
            }
          //FIM JOGO  
        } while (acerto != 1);
    }

    public static int[] geracodigoAleatorio() {//BLOCO GERADOR
        int senhaGerada =0;
        do {
            senhaGerada = (int) Math.round(Math.random()*9999);
        } while (senhaGerada < 999);
        String senha = Integer.toString(senhaGerada);
        int[] novaSenha = new int[senha.length()];
        for (int i = 0; i < senha.length(); i++)
        {
            novaSenha[i] = senhaGerada%10;
            senhaGerada = (senhaGerada - novaSenha[i])/10;
        }
        return novaSenha;     
    }

    public static int[] lerInputUsuario() {//METODO INPUT USUARIO
        int[] numeroInputCerto;
        String inputNumero;
        int numeroInput;
        do{  
            inputNumero = JOptionPane.showInputDialog(null,"Digite uma senha de 4 digitos :","ADIVINHPAKAS",JOptionPane.INFORMATION_MESSAGE);
            numeroInput = Integer.parseInt(inputNumero);
            String senhaInput = Integer.toString(numeroInput);
            numeroInputCerto = new int[senhaInput.length()];
            for (int i = 0; i < senhaInput.length(); i++)
            {
                numeroInputCerto[i] = numeroInput%10;
                numeroInput = (numeroInput - numeroInputCerto[i])/10;
            }
            if(numeroInputCerto.length > 4 || numeroInputCerto.length < 4 ){
                JOptionPane.showMessageDialog(null,"A senha deve conter 4 DIGITOS !","ADIVINHPAKAS",JOptionPane.INFORMATION_MESSAGE);
            } 
        }while(numeroInputCerto.length != 4);
        return numeroInputCerto;
    }  
    
    public static void superdicaSwitch(int superdicagen,int superdica, int[]novaSenha, int contsuperdica) {//METODO SUPER DICA
        if(superdica == superdicagen){
            switch (contsuperdica) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Se você esta lendo essa mensagem, PARABENS, você ganhou uma SUPERDICA\n\n"+
                    "SUPERDICAS tem uma chance minina de aparecerem, e revelam um dos numeros do código !","ADIVINHPAKAS",1);
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO primeiro numero do código é : " + novaSenha[3],"ADIVINHPAKAS",1);
                break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO segundo numero do código é : " + novaSenha[2],"ADIVINHPAKAS",1);
                break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO terceiro numero do código é : " + novaSenha[1],"ADIVINHPAKAS",1);
                break;
                default:
                break;   
            }  
        }   
    }

    public static String[] sinaisDica(int[] numeroInputCerto, int[]novaSenha) {//METODOS SINAIS DE DICA
        String[]sinais = {"","","",""} ;
        for (int i = 0; i < sinais.length; i++) {
            if(numeroInputCerto[i] == novaSenha[i]){
                sinais[i]  = "\u2705";                     
            }
            else if(numeroInputCerto[i] > novaSenha[i]){ 
                sinais[i] = "\uD83D\uDD3A";               
            }
            else {
                sinais[i] = "\uD83D\uDD3B";               
            }
        }
        return sinais;
    }
}
