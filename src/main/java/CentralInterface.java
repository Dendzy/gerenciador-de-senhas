import java.util.ArrayList;

public interface CentralInterface {
    boolean cadastrarSenha(Conta novaConta);
    boolean removerSenha(Conta verificaConta);
    ArrayList<Conta> contasComEmail(String email);
    ArrayList<Conta> contasNoSite(String site);
}
