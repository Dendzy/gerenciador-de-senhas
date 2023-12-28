import java.util.ArrayList;
import java.io.*;

public class CentralContas implements CentralInterface {
    private ArrayList<Conta> contas;

    public CentralContas (ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public CentralContas () {
        this.contas = new ArrayList<>();
        carregarSenhasDeArquivo("senhas.dat");
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

    public void salvarSenhas() {
        salvarSenhasEmArquivo("senhas.dat");
    }

    private void salvarSenhasEmArquivo(String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(contas);
            System.out.println("Senhas salvas com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as senhas: " + e.getMessage());
        }
    }

    private void carregarSenhasDeArquivo(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            contas = (ArrayList<Conta>) inputStream.readObject();
            System.out.println("Senhas carregadas com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar as senhas: " + e.getMessage());
            contas = new ArrayList<>();
        }
    }
}
