import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner entrance = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        ManageAttendance manage = new ManageAttendance(1);
        int choise;
        Client cli;

        boolean emptyList = false;
        // System.out.println(elderly.getMaxSize());
        do {  
        System.out.println("Menu: \n1 - Novo cliente \n2 - Próximo cliente \n3 - Atender \n4 - Exibir filas \n5 - Finalizar");
        choise = entrance.nextInt();
            switch (choise) {
                case 1: {
                    System.out.println("Digite o nome do cliente: ");
                    String name = s.nextLine();
                    System.out.println("Digite a idade do cliente: ");
                    int age = scr.nextInt();
                    cli = new Client(name, age);
                    manage.addClient(cli);
                    break;
                }
                case 2: {
                    System.out.println("O próximo cliente é: ");
                    String nextName = manage.showNext().getName();
                    System.out.println(nextName);
                    break;
                }
                case 3: {
                    System.out.println("Cliente a ser atendido: ");
                    String nextName = manage.getNext().getName();
                    System.out.println(nextName);
                    break;
                }
                case 4: {
                    System.out.println("Fila: ");
                    System.out.println(manage.showQueues());
                    break;
                }
                case 5: {
                    boolean isEmpty = manage.isEmpty();

                    if(isEmpty) {
                        System.out.println("Finalizando o programa!");
                        emptyList = true;
                    } else {
                        System.out.println("Ainda existem clientes na fila");
                    }
                    break;
                }
                default:
                    System.out.println("Opção inválida!");
                    break;
                }
        } while (choise != 5);
        entrance.close();
        scr.close();
        s.close();
    }
}