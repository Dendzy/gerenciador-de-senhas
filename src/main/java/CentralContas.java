import java.util.ArrayList;

public class CentralContas implements CentralInterface {
    private ArrayList<Conta> contas;

    public CentralContas (ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public CentralContas () {
        this.contas = new ArrayList<>();
    }

    @Override
    public boolean cadastrarSenha(Conta novaConta) {
        for(Conta c : contas){
            if(c.getSenha().equals(novaConta.getSenha()) &&
                    c.getSite().equals(novaConta.getSite()) &&
                    c.getEmail().equals(novaConta.getEmail())) {
                return false;
            }

        }
        contas.add(novaConta);
        return true;
    }

    public boolean removerSenha(Conta verificaConta) {
        for(Conta c : contas) {
            if(c.getSenha().equals(verificaConta.getSenha()) &&
                    c.getSite().equals(verificaConta.getSite()) &&
                    c.getEmail().equals(verificaConta.getEmail())) {
                contas.remove(verificaConta);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Conta> contasComEmail(String email) {
        ArrayList<Conta> listaComEmail = new ArrayList<>();
        for(Conta c : contas) {
            if(c.getEmail().equals(email)){
                listaComEmail.add(c);
            }
        }
        return listaComEmail;
    }

    public ArrayList<Conta> contasNoSite(String site) {
        ArrayList<Conta> listaDeContasNoSite = new ArrayList<>();
        for(Conta c : contas) {
            if(c.getSite().equals(site)){
                listaDeContasNoSite.add(c);
            }
        }
        return listaDeContasNoSite;
    }

}
