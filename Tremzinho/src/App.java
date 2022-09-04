import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static boolean tremExiste(int idTrem, PatioDeManobras patio){
        for (int i = 0; i < patio.qtdade(); i++) {
            if(patio.getPorPosicao(i).getIdentificador() == idTrem){
                return true;
            }
        }
        return false;
    }

    public static boolean vagaoExiste(int idVag, GaragemVagoes garagemV){
        for (int i = 0; i < garagemV.qtdade(); i++) {
            if(garagemV.getPorPosicao(i).getIdentificador() == idVag){
                return true;
            }
        }
        return false;
    }

    public static boolean locomotivaExiste(int idLoc, GaragemLocomotivas garagemL){
        for (int i = 0; i < garagemL.qtdade(); i++) {
            if(garagemL.getPorPosicao(i).getIdentificador() == idLoc){
                return true;
            }
        }
        return false;
    }

    public static void editTrem(int opcao, int idTrem, PatioDeManobras patio, GaragemLocomotivas garagemL, GaragemVagoes garagemV){
        Scanner sc = new Scanner(System.in);
        Trem tremEdit = patio.getPorId(idTrem);
        int cont = 0;
        if(!tremExiste(idTrem, patio) && idTrem != -1){
            System.out.println("Trem não existe.");
        }else{
            switch(opcao){
                case 1:
                    if(tremEdit.getQtdadeVagoes() > 0){
                        System.out.println("Não é possível adicionar locomotiva.");
                    }else{
                        System.out.println("Digite o ID da locomotiva a ser adicionada");
                        int idLoc = Integer.parseInt(sc.nextLine());
                        while(!locomotivaExiste(idLoc, garagemL)){
                            System.out.println("Locomotiva não existente, digite um id válido");
                            idLoc = Integer.parseInt(sc.nextLine());
                        }
                        if(garagemL.getPorId(idLoc).getTrem() == null){

    
                            tremEdit.engataLocomotiva(garagemL.getPorId(idLoc));
                            garagemL.getPorId(idLoc).setTrem(tremEdit);
                        }else{
                            System.out.println("Locomotiva já engatada.");
                        }
                    }
                break;
                case 2:
                    System.out.println("Digite o ID do vagão a ser adicionado.");
                    int idVag = Integer.parseInt(sc.nextLine());
                    if(tremEdit.getQtdadeVagoes() >= tremEdit.maxVagoesNoTrem()
                    || tremEdit.pesoAtualDoTrem() + garagemV.getPorId(idVag).getCapacidadeCarga() > tremEdit.pesoMaxNoTrem()
                    ){
                        System.out.println("Não é possível adicionar um vagão neste trem.");
                    }else{
                        while(!vagaoExiste(idVag, garagemV)){
                            System.out.println("Vagão não existente, digite um id válido");
                            idVag = Integer.parseInt(sc.nextLine());
                        }
                        if(garagemV.getPorId(idVag).getTrem() == null){
                            tremEdit.engataVagao(garagemV.getPorId(idVag));
                            garagemV.getPorId(idVag).setTrem(tremEdit);
                        }else{
                            System.out.println("Vagão já engatado.");
                        }
                    }
                break;
                case 3:
                    if(tremEdit.getQtdadeVagoes() == 0 && tremEdit.getQtdadeLocomotivas() <= 1){
                        System.out.println("Não é possível remover o último elemento deste trem.");
                    }else{
                        if(tremEdit.getQtdadeVagoes() == 0 && tremEdit.getQtdadeLocomotivas() > 1){
                            tremEdit.desengataLocomotiva();
                        }else if(tremEdit.getQtdadeVagoes() > 0){
                            tremEdit.desengataVagao();
                        }
                    }
                break;
                case 4:
                    cont = 0;
                    for (int i = 0; i < garagemL.qtdade(); i++) {
                        if(garagemL.getPorPosicao(i).getTrem() == null){
                            cont++;
                            System.out.println(garagemL.getPorPosicao(i).toString());
                        }
                    }
                    if(cont == 0){
                        System.out.println("Locomotiva já utilizada.");
                    }
                break;
                case 5:
                    cont = 0;
                    for (int i = 0; i < garagemV.qtdade(); i++) {
                        if(garagemV.getPorPosicao(i).getTrem() == null){
                            cont++;
                            System.out.println(garagemV.getPorPosicao(i).toString());
                        }
                        if(cont == 0){
                            System.out.println("Não há vagões livres");
                        }
                    }
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {

        GaragemLocomotivas garagemL = new GaragemLocomotivas();
        GaragemVagoes garagemV = new GaragemVagoes();
        PatioDeManobras patio = new PatioDeManobras();
        int index,opcao = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("BEM VINDO AO SISTEMA DE LOCOMOTIVAS");
        System.out.println("Defina o número de Vagões:");
        index = Integer.parseInt(sc.nextLine());
        writeV(index);
        System.out.println("Defina o número de Locomotivas:");
        index = Integer.parseInt(sc.nextLine());
        writeL(index);

        carregaLocomotiva(garagemL);
        carregaVagao(garagemV);    
        
        
        do{

            System.out.println("DIGITE A OPÇÃO QUE DESEJA SELECIONAR!");
            System.out.println("1- CRIAR UM TREM");
            System.out.println("2- EDITAR UM TREM");
            System.out.println("3- LISTAR TODOS OS TRENS");
            System.out.println("4- DESFAZER UM TREM");
            System.out.println("5- ENCERRAR O PROGRAMA");
    
            opcao = Integer.parseInt(sc.nextLine());
    
            switch(opcao){
                case 1:
                    System.out.println("Informe o identificador do trem:");
                    int idTrem = Integer.parseInt(sc.nextLine());

                    while(tremExiste(idTrem, patio)){
                        System.out.println("ID já existente, digite um novo");
                        idTrem = Integer.parseInt(sc.nextLine());
                    }
    
                    int cont = 0;
                    for (int i = 0; i < garagemL.qtdade(); i++) {
                        if(garagemL.getPorPosicao(i).getTrem() == null){
                            cont++;
                            System.out.println(garagemL.getPorPosicao(i).toString());
                        }
                        if(cont == 0){
                            System.out.println("Não há locomotivas livres");
                        }
                    }
    
                    System.out.println("Informe o identificador da primeira locomotiva:");
                    int idLoc = Integer.parseInt(sc.nextLine());
                    while(!locomotivaExiste(idLoc, garagemL)){
                        System.out.println("Locomotiva não existe, digite um ID existente.");
                        idLoc = Integer.parseInt(sc.nextLine());
                    }
                    if(garagemL.getPorId(idLoc).getTrem()==null){
        
                        Trem novoTrem = new Trem(idTrem);
                        
                        Locomotiva primLoc = garagemL.getPorId(idLoc);
        
                        novoTrem.engataLocomotiva(primLoc);
                        garagemL.getPorId(idLoc).setTrem(novoTrem);
        
                        patio.adicionaPatio(novoTrem);
                    }else{
                        System.out.println("Locomotiva já engatada.");
                    }

                break;
                case 2:
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
                    idTrem = -1;
                    if(opcaoEdicao == 1 || opcaoEdicao == 2 || opcaoEdicao == 3){
                        System.out.println("Informe o identificador do trem a ser editado:");
                        idTrem = Integer.parseInt(sc.nextLine());
                    }
                        editTrem(opcaoEdicao, idTrem, patio, garagemL, garagemV);
                    }
                break;
                case 3:
                cont = 0;
                for (int i = 0; i < patio.qtdade(); i++) {
                    if(patio.getPorPosicao(i) != null){
                        cont++;
                        System.out.println(patio.getPorPosicao(i).toString());
                    }
                    if(cont == 0){
                        System.out.println("Não há trem cadastrado.");
                    }
                }
                break;
                case 4:
                    System.out.println("Informe o identificador do trem:");
                    idTrem = Integer.parseInt(sc.nextLine());
                    patio.removePatio(idTrem);
                break;
                case 5:
                System.out.println("-- SAINDO DO SISTEMA --");
                break;
            }

        }while(opcao != 5);



    }

    public static void carregaLocomotiva(GaragemLocomotivas garagemL){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+"locomotiva.dat";
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            while (sc.hasNext()){
                String linha = sc.nextLine();

                String dados[] = linha.split(";");

                int identificador = Integer.parseInt(dados[0]);
                double pesoMaximo = Double.parseDouble(dados[1]);
                int qtdadeMaxVagoes = Integer.parseInt(dados[2]);
                Locomotiva l = new Locomotiva(identificador,pesoMaximo,qtdadeMaxVagoes);
                garagemL.adicionaGaragem(l);
            }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public static void carregaVagao(GaragemVagoes garagemV){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+"vagao.dat";
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            while (sc.hasNext()){
                String linha = sc.nextLine();

                String dados[] = linha.split(";");

                int identificador = Integer.parseInt(dados[0]);
                double capacidadeCarga = Double.parseDouble(dados[1]);
                Vagao v = new Vagao(identificador, capacidadeCarga);
                garagemV.adicionaGaragem(v);
            }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }

    public static void writeL(int index){
        Random sorteia = new Random();
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+"locomotiva.dat";
        Path path = Paths.get(nameComplete);

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
            for(int i=0;i<index;i++){
                int nro = sorteia.nextInt(100,200);
                writer.print(nro+";");
                nro = sorteia.nextInt(50,90);
                writer.print(nro+";");
                nro = sorteia.nextInt(10,20);
                writer.print(nro+"\n");
            }
        }catch (IOException x){
        System.err.format("Erro de E/S: %s%n", x);
        }
    }
    public static void writeV(int index){
        Random sorteia = new Random();
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+"vagao.dat";
        Path path = Paths.get(nameComplete);

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
            for(int i=0;i<index;i++){
                int nro = sorteia.nextInt(100,200);
                writer.print(nro+";");
                nro = sorteia.nextInt(5,15);
                writer.print(nro+"\n");
            }
        }catch (IOException x){
        System.err.format("Erro de E/S: %s%n", x);
        }
    }
}