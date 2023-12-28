import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeSenhas {
    public static void main(String [] args) {
        CentralContas controlador = new CentralContas();
        GeradorDeSenha gerador = new GeradorDeSenha();
        Scanner input = new Scanner(System.in);
        boolean ligado = true;

        while (ligado) {
            System.out.println(("-------------------------------\n" +
                    "Escolha uma opção:" +
                    "\n1. Cadastrar Senha" +
                    "\n2. Remover Senha" +
                    "\n3. Pesquisar Senha pelo Email" +
                    "\n4. Pesquisar Senha pelo Site" +
                    "\n5. Gerar Senha aleatória" +
                    "\n6. Sair e Salvar Dados" +
                    "\n-------------------------------"));
            int opcao = Integer.parseInt(input.nextLine());
            if(opcao == 1) {
                System.out.println("-------------------------------");
                System.out.println("Digite o nome do site: ");
                String site = input.nextLine();
                System.out.println("Digite o email: ");
                String email = input.nextLine();
                System.out.println("Digite a senha: ");
                String senha = input.nextLine();
                Conta novaConta = new Conta(site,email,senha);
                boolean contaCadastrada = controlador.cadastrarSenha(novaConta);
                if(contaCadastrada) {
                    System.out.println("-------------------------------");
                    System.out.println("Senha Cadastrada com Sucesso!");
                } else {
                    System.out.println("-------------------------------");
                    System.out.println("Essa Conta já existe no sistema!");
                }
            }
            if(opcao == 2) {
                System.out.println("-------------------------------");
                System.out.println("Digite o nome do site: ");
                String site = input.nextLine();
                System.out.println("Digite o email: ");
                String email = input.nextLine();
                System.out.println("Digite a senha: ");
                String senha = input.nextLine();
                Conta contaParaRemover = new Conta(site,email,senha);
                boolean contaRemovida = controlador.removerSenha(contaParaRemover);
                if(contaRemovida) {
                    System.out.println("-------------------------------");
                    System.out.println("Conta Removida com Sucesso!");
                } else {
                    System.out.println("-------------------------------");
                    System.out.println("Essa Conta não existe no sistema!");
                }
            }
            if(opcao == 3) {
                System.out.println("-------------------------------");
                System.out.println("Digite o email: ");
                String email = input.nextLine();
                ArrayList<Conta> contasComEmail = new ArrayList<>();
                contasComEmail = controlador.contasComEmail(email);
                if(contasComEmail.size() == 0) {
                    System.out.println("-------------------------------");
                    System.out.println("Não existem contas com esse email!");
                } else {
                    System.out.println("-------------------------------");
                    for(Conta c: contasComEmail) {
                        System.out.println(c.toString());
                        System.out.println("-------------------------------");
                    }

                }
            }
            if(opcao == 4) {
                System.out.println("-------------------------------");
                System.out.println("Digite o nome do Site: ");
                String site = input.nextLine();
                ArrayList<Conta> contasComSite = new ArrayList<>();
                contasComSite = controlador.contasNoSite(site);
                if(contasComSite.size() == 0) {
                    System.out.println("-------------------------------");
                    System.out.println("Não existem contas cadastradas nesse Site!");
                } else {
                    System.out.println("-------------------------------");
                    for(Conta c: contasComSite) {
                        System.out.println(c.toString());
                        System.out.println("-------------------------------");
                    }
                }
            }
            if (opcao == 5) {
                System.out.println("-------------------------------");
                System.out.println("Senha: ");
                System.out.println(gerador.gerarSenhaAleatoria());
            }
            if(opcao == 6) {
                System.out.println("-------------------------------");
                System.out.println("Deseja Salvar as Senhas cadastradas e/ou removidas?" +
                        "\n1. Sim" +
                        "\n2. Não");
                System.out.println("-------------------------------");
                int confirmacao = Integer.parseInt(input.nextLine());
                if(confirmacao == 1) {
                    controlador.salvarSenhas();
                    ligado = false;
                } else {
                    ligado = false;
                }
            }
        }
    }
}
