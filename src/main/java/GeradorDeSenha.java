import static java.lang.System.*;

public class GeradorDeSenha {
    public static String gerarSenhaAleatoria() {
        int quantidadeMaxDeCaracteres = 16;

        String [] caracteres = {"a","b","c","d","e","f",
                                "g","h","i","j","k","l",
                                "m","n","o","p","q","r",
                                "s","t","u","v","w","x",
                                "y","z","A","B","C","D",
                                "E","F","G","H","I","J",
                                "K","L","M","N","O","P",
                                "Q","R","S","T","U","V",
                                "W","X","Y","Z","1","2",
                                "3","4","5","6","7","8",
                                "9","0","@","#","$","!",
                                "&"};

        StringBuilder senha = new StringBuilder();

        for(int i = 0; i < quantidadeMaxDeCaracteres;i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();
    }
}
