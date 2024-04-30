import br.com.brunosouza2.banco.Cliente;
import br.com.brunosouza2.banco.Conta;
import br.com.brunosouza2.banco.exception.ContaBancariaException;
import br.com.brunosouza2.banco.exception.InputUsuarioException;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Seja bem vindo ao nosso banco, selecione uma das opções abaixo: ");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Sair");

            try {
                int escolhaUsuario = capturaEscolhaUsuario(input);
                if (escolhaUsuario == 2) {
                    System.out.println("Saindo...");
                    return;
                }
                Conta novaConta = criaContaDoUsuario(input);
                System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, " +
                        "sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.",
                        novaConta.getCliente().getNome(), novaConta.getAgencia(), novaConta.getNumero(), novaConta.getSaldo());
                break;

            }catch (InputUsuarioException | ContaBancariaException e){
                System.out.printf("Dados inválidos: %s, tente novamente. %n", e.getMessage());
            }

        }while (true);
        input.close();

    }

    private static int capturaEscolhaUsuario(Scanner scanner){
        int escolha = scanner.nextInt();
        if (escolha < 1 || escolha > 2) throw new InputUsuarioException("Opção selecionada inválida, tente novamente.");
        return escolha;
    }

    public static Conta criaContaDoUsuario(Scanner scanner){
        scanner.nextLine();
        System.out.println("Digite o nome do proprietário da conta: ");
        String nomeConta = scanner.nextLine();
        System.out.println("Digite o código de sua agência: ");
        String codigoAgencia = scanner.nextLine();
        System.out.println("Digite o número de sua conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o saldo da conta: ");
        BigDecimal saldoDaConta = new BigDecimal(scanner.nextLine());
        return new Conta(numeroConta, codigoAgencia, saldoDaConta, new Cliente(nomeConta));
    }
}
