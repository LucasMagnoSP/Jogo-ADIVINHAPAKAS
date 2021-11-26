import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
    
        int dica, superdica,superdicagen,index;
        int tentativas = 0, acerto= 0,qntdica = 5,contsuperdica=0,dificult;
        int[] numeroInputCerto , novaSenha;
        String[]sinais;
        Object[] dificuldade = {"Facil", "Normal", "Dificil"};
        Object[] indexButons = {"Jogar", "Sobre"};
        //Menu
        do{
            ImageIcon iconIndex = new ImageIcon("icons\\logo.png");
            index = JOptionPane.showOptionDialog(null,"","AdivinhaPakas",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,iconIndex,indexButons,indexButons[1]);
            System.out.println(index);  
            if (index==1){
                JOptionPane.showMessageDialog(null, 
                "                           Bem Vindo ao ADIVINHAPAKAS !!\n\n" + 
                                "Esse é um jogo no qual você precisa acertar um numero aleatório.\n\n"+
                                "Não temos TIMER, então fique a vontade para pensar.\n\n" +
                                "Tambem não temos limite de tentativas, pode chutar a vontade !\n\n",
                "ADIVINHAPAKAS",1);
            }
            else if(index == -1){
                System.exit(0);
            }
        }while(index!=0);
        //Fim Menu
        JOptionPane.showMessageDialog(null, 
            "                                             Instruções de Dicas :\n\n" +
                            "A cada partida você começa com " + qntdica +" dicas, use-as com sabedoria.\n\n"+ 
                            "Caso a dica seja  ' \u2705 ' significa que o numero digitado está correto ! \n\n"+
                            "Caso a dica seja  ' \uD83D\uDD3A ' significa que o numero digitado é maior que o correto ! \n\n"+
                            "Caso a dica seja  ' \uD83D\uDD3B ' significa que o numero digitado é menor que o correto ! \n\n",
            "ADIVINHAPAKAS",1);

        dificult = JOptionPane.showOptionDialog(null,"Selecione um nivel de dificuldade","AdivinhaPakas",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,dificuldade,dificuldade[2]);
        if(dificult== -1){
            System.exit(0);
        }
        novaSenha = geracodigoAleatorio(dificult);//METODO BLOCO GERADOR e SELETOR de DIFICULDADE     
        //INICIO JOGO
        do {
            tentativas++;  
            numeroInputCerto = lerInputUsuario(dificult);//METODO INPUT USUARIO
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
                        superdicagen = (int)Math.round(Math.random()*2);superdica = (int)Math.round(Math.random()*2);
                        if(superdica == superdicagen){
                            superdicaSwitch(superdicagen, superdica, novaSenha,contsuperdica,dificult);//METODO SUPER DICA 
                            contsuperdica++;
                            // FIM BLOCO SUPER DICA
                        }
                        //BLOCO SINAIS DE DICA
                        if(dificult == 0){
                            sinais = sinaisDica(numeroInputCerto,novaSenha,dificult); //METODOS SINAIS DE DICA
                            JOptionPane.showMessageDialog(null,"   Codigo digitado : "+numeroInputCerto[1]+numeroInputCerto[0]+"\n"+
                            "                 " +numeroInputCerto[1]+ "  é  " +sinais[1]+ "\n"+
                            "                 " +numeroInputCerto[0]+ "  é  " +sinais[0]+ "\n",
                            "ADIVINHPAKAS",1);
                        }
                        else if(dificult == 1){
                            sinais = sinaisDica(numeroInputCerto,novaSenha,dificult); //METODOS SINAIS DE DICA
                            JOptionPane.showMessageDialog(null,"   Codigo digitado : "+numeroInputCerto[3]+numeroInputCerto[2]+numeroInputCerto[1]+numeroInputCerto[0]+"\n"+
                            "                 " +numeroInputCerto[3]+ "  é  " +sinais[3]+ "\n"+
                            "                 " +numeroInputCerto[2]+ "  é  " +sinais[2]+ "\n"+
                            "                 " +numeroInputCerto[1]+ "  é  " +sinais[1]+ "\n"+
                            "                 " +numeroInputCerto[0]+ "  é  " +sinais[0]+ "\n",
                            "ADIVINHPAKAS",1);
                        }
                        else{
                                sinais = sinaisDica(numeroInputCerto,novaSenha,dificult); //METODOS SINAIS DE DICA
                            JOptionPane.showMessageDialog(null,"   Codigo digitado : "+numeroInputCerto[5]+numeroInputCerto[4]+numeroInputCerto[3]+numeroInputCerto[2]+numeroInputCerto[1]+numeroInputCerto[0]+"\n"+
                            "                 " +numeroInputCerto[5]+ "  é  " +sinais[5]+ "\n"+
                            "                 " +numeroInputCerto[4]+ "  é  " +sinais[4]+ "\n"+
                            "                 " +numeroInputCerto[3]+ "  é  " +sinais[3]+ "\n"+
                            "                 " +numeroInputCerto[2]+ "  é  " +sinais[2]+ "\n"+
                            "                 " +numeroInputCerto[1]+ "  é  " +sinais[1]+ "\n"+
                            "                 " +numeroInputCerto[0]+ "  é  " +sinais[0]+ "\n",
                            "ADIVINHPAKAS",1);
                        }   
                            
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
        }while (acerto != 1);   
    }
        
    public static int[] geracodigoAleatorio(int dificult) {//BLOCO GERADOR e SELETOR de DIFICULDADE 
            int senhaGerada =0;
        if (dificult == 0){
            do {
                senhaGerada = (int) Math.round(Math.random()*99);
            } while (senhaGerada < 9);
        }
        else if (dificult == 1){
            do {
                senhaGerada = (int) Math.round(Math.random()*9999);
            } while (senhaGerada < 999);
        }
        else{
            do {
                senhaGerada = (int) Math.round(Math.random()*999999);
            } while (senhaGerada < 99999);
        }
        String senha = Integer.toString(senhaGerada);
        System.out.println(senha);      
        int[] novaSenha = new int[senha.length()];
        for (int i = 0; i < senha.length(); i++)
        {
            novaSenha[i] = senhaGerada%10;
            senhaGerada = (senhaGerada - novaSenha[i])/10;
        }
        return novaSenha;     
    }
    
    public static int[] lerInputUsuario(int dificult) {//METODO INPUT USUARIO
        int[] numeroInputCerto;
        String inputNumero;
        int numeroInput,inputLength;
        if(dificult == 0){
            inputLength = 2;
        }
        else if(dificult == 1){
            inputLength = 4;
        }
        else{
            inputLength = 6;
        }
        do{  
            inputNumero = JOptionPane.showInputDialog(null,"Digite uma senha de "+inputLength+" digitos:","ADIVINHPAKAS",JOptionPane.INFORMATION_MESSAGE);
            numeroInput = Integer.parseInt(inputNumero);
            String senhaInput = Integer.toString(numeroInput);
            numeroInputCerto = new int[senhaInput.length()];
            for (int i = 0; i < senhaInput.length(); i++)
            {
                numeroInputCerto[i] = numeroInput%10;
                numeroInput = (numeroInput - numeroInputCerto[i])/10;
            }
            if(numeroInputCerto.length > inputLength || numeroInputCerto.length < inputLength ){
                JOptionPane.showMessageDialog(null,"A senha deve conter "+inputLength+" DIGITOS !","ADIVINHPAKAS",JOptionPane.INFORMATION_MESSAGE);
            } 
        }while(numeroInputCerto.length != inputLength);
        return numeroInputCerto;
    }  
    
    public static void superdicaSwitch(int superdicagen,int superdica, int[]novaSenha, int contsuperdica, int dificult) {//METODO SUPER DICA
        switch (contsuperdica) {
            case 0:
            JOptionPane.showMessageDialog(null, "Se você esta lendo essa mensagem, PARABENS, você ganhou uma SUPERDICA\n\n"+
                    "SUPERDICAS tem uma chance minina de aparecerem, e revelam um dos numeros do código !","ADIVINHPAKAS",1);
                if(dificult == 0){
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO primeiro numero do código é : " + novaSenha[1],"ADIVINHPAKAS",1);
                }
                else if(dificult==1){
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO primeiro numero do código é : " + novaSenha[3],"ADIVINHPAKAS",1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO primeiro numero do código é : " + novaSenha[5],"ADIVINHPAKAS",1);
                }
            break;
            case 1:
                if(dificult == 0){
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO segundo numero do código é : " + novaSenha[0],"ADIVINHPAKAS",1);
                }
                else if(dificult==1){
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO segundo numero do código é : " + novaSenha[2],"ADIVINHPAKAS",1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO segundo numero do código é : " + novaSenha[4],"ADIVINHPAKAS",1);
                }
            break;
            case 2:
                if(dificult ==0){
                    break;
                }
                else if(dificult==1){
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO terceiro numero do código é : " + novaSenha[1],"ADIVINHPAKAS",1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Você ganhou uma SUPERDICA !!\nO terceiro numero do código é : " + novaSenha[3],"ADIVINHPAKAS",1);
                }
            break;
            default:
            break;   
            }  
    }

    public static String[] sinaisDica(int[] numeroInputCerto, int[]novaSenha, int dificult) {//METODOS SINAIS DE DICA
        String[]sinais;
        if (dificult == 0){
            sinais = new String[2];
        }
        else if(dificult == 1){
            sinais = new String[4];
        }
        else{
            sinais = new String[6];
        }
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
