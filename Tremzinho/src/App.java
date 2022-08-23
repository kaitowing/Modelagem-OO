import java.util.Scanner;

public class App {

    static GaragemLocomotivas garagemL = new GaragemLocomotivas();
    static GaragemVagoes garagemV = new GaragemVagoes();
    static PatioDeManobras patio = new PatioDeManobras();

    public static void editTrem(int opcao, int idTrem){
        Scanner sc = new Scanner(System.in);
        switch(opcao){
            case 1:
                if (patio.getPorId(idTrem) == null){
                    System.out.println("Trem não existe.");
                }else{
                    if(patio.getPorId(idTrem).getQtdadeVagoes() > 0){
                        System.out.println("Não é possível adicionar locomotiva atrás de um vagão.");
                    }else{
                        System.out.println("Digite o ID da locomotiva a ser adicionada");
                        int idLoc = Integer.parseInt(sc.nextLine());
                        patio.getPorId(idTrem).engataLocomotiva(garagemL.getPorId(idLoc));
                    }
                }

            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
        }
    }
    public static void main(String[] args) throws Exception {

        

        System.out.println("BEM VINDO AO SISTEMA DE LOCOMOTIVAS");
        System.out.println("DIGITE A OPÇÃO QUE DESEJA SELECIONAR!");
        System.out.println("1- CRIAR UM TREM");
        System.out.println("2- EDITAR UM TREM");
        System.out.println("3- LISTAR TODOS OS TRENS");
        System.out.println("4- DESFAZER UM TREM");
        System.out.println("5- ENCERRAR O PROGRAMA");

        Scanner sc = new Scanner(System.in);

        int opcao = Integer.parseInt(sc.nextLine());

        switch(opcao){
            case 1:
                System.out.println("Informe o identificador do trem:");
                int idTrem = Integer.parseInt(sc.nextLine());
                System.out.println("Informe o identificador da primeira locomotiva:");
                int idLoc = Integer.parseInt(sc.nextLine());

                Trem novoTrem = new Trem(idTrem);
                
                Locomotiva primLoc = garagemL.getPorId(idLoc);

                novoTrem.engataLocomotiva(primLoc);

                patio.adicionaPatio(novoTrem);
            break;
            case 2:
                System.out.println("Informe o identificador do trem a ser editado:");
                idTrem = Integer.parseInt(sc.nextLine());
                System.out.println("Digite a opção de edição:");
                System.out.println("1- Inserir uma locomotiva");
                System.out.println("2- Inserir um vagão");
                System.out.println("3- Remover o último elemento do trem");
                System.out.println("4- Listar locomotivas livres");
                System.out.println("5- Listar vagões livres");
                System.out.println("6- Encerrar edição");
                int opcaoEdicao = Integer.parseInt(sc.nextLine());

                if(opcaoEdicao == 6){
                    break;
                }else{
                    editTrem(opcaoEdicao, idTrem);
                }
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            System.out.println("-- SAINDO DO SISTEMA --");
            break;
        }


    }
}