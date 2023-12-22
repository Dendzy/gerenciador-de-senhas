import javax.swing.JOptionPane;
import java.util.ArrayList;

public class GerenciadorDeSenhas {
    public static void main(String [] args) {
        CentralContas controlador = new CentralContas();
        boolean ligado = true;

        while (ligado) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção" +
                    "\n1. Cadastrar Senha" +
                    "\n2. Remover Senha" +
                    "\n3. Pesquisar Senha pelo Email" +
                    "\n4. Pesquisar Senha pelo Site" +
                    "\n6. Sair"));
            if(opcao == 1) {
                String site = JOptionPane.showInputDialog("Digite o nome do site: ");
                String email = JOptionPane.showInputDialog("Digite o email: ");
                String senha = JOptionPane.showInputDialog("Digite a senha: ");
                Conta novaConta = new Conta(site,email,senha);
                boolean contaCadastrada = controlador.cadastrarSenha(novaConta);
                if(contaCadastrada) {
                    JOptionPane.showMessageDialog(null,"Senha Cadastrada com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null,"Essa Conta já existe no sistema!");
                }
            }
            if(opcao == 2) {
                String site = JOptionPane.showInputDialog("Digite o nome do site: ");
                String email = JOptionPane.showInputDialog("Digite o email: ");
                String senha = JOptionPane.showInputDialog("Digite a senha: ");
                Conta contaParaRemover = new Conta(site,email,senha);
                boolean contaRemovida = controlador.removerSenha(contaParaRemover);
                if(contaRemovida) {
                    JOptionPane.showMessageDialog(null,"Conta Removida com Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null,"Essa Conta não existe no sistema!");
                }
            }
            if(opcao == 3) {
                String email = JOptionPane.showInputDialog(null,"Digite o email: ");
                ArrayList<Conta> contasComEmail = new ArrayList<>();
                contasComEmail = controlador.contasComEmail(email);
                if(contasComEmail.size() == 0) {
                    JOptionPane.showMessageDialog(null,"Não existem contas com esse email!");
                } else {
                    for(Conta c: contasComEmail) {
                        JOptionPane.showMessageDialog(null,c.toString());
                    }
                }
            }
            if(opcao == 4) {
                String site = JOptionPane.showInputDialog(null,"Digite o nome do Site: ");
                ArrayList<Conta> contasComSite = new ArrayList<>();
                contasComSite = controlador.contasNoSite(site);
                if(contasComSite.size() == 0) {
                    JOptionPane.showMessageDialog(null,"Não existem contas cadastradas nesse Site!");
                } else {
                    for(Conta c: contasComSite) {
                        JOptionPane.showMessageDialog(null, c.toString());
                    }
                }
            }
            if(opcao == 6) {
                ligado = false;
            }
        }
    }
}
