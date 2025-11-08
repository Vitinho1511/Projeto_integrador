/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadosaneis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author antonio.acoliveira
 */
public class Game extends Util {
    public void showMenu(String gameName) {
    	this.showIntro();

        Scanner input = new Scanner(System.in);
        int option;

        do {                
            System.out.println("1 - Instruções");
            System.out.println("2 - Jogar");
            System.out.println("3 - Créditos");
            System.out.println("4 - Sair");
            
            System.out.print("\nEscolha uma opção: ");
            try {            	
            	option = input.nextInt();
            } catch (InputMismatchException e) {
				input.next();
				option = 0;
			}
            
            switch (option) {
                case 1:
                    this.showInstructions();
                    break;
                case 2:
                    System.out.println("Jogar...");
                    
                    boolean tutorial = showTutorial(input);
                    if (!tutorial) {
                        System.out.println("GAME OVER");
                        option = 4;
                        break;
                    }
                    System.out.println("\nParabéns! Você passou do tutorial!.");
                    
                    boolean firstAct = firstAct(input);
                    if (!firstAct) {
						System.out.println("GAME OVER");
						option = 4;
						break;
					} 
                    
                    break;
                case 3:
                    this.showCredits();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 4);

        input.close();
    }
    
    public void showIntro() {
    	System.out.println("################################################");
        System.out.println("##                                            ##");
        System.out.println("##           O SISTEMA DOS ANÉIS              ##");
        System.out.println("##                                            ##");
        System.out.println("################################################");
        System.out.println();
        
        System.out.println("┌──────────────────────────────────────────────┐");
        System.out.println("│ Na Terra-Média, a guerra não se trava        │");
        System.out.println("│ apenas com espadas, mas com CONHECIMENTO!    │");
        System.out.println("│                                              │");
        System.out.println("│ Cada raça guarda seu próprio sistema         │");
        System.out.println("│ numérico, e apenas um erudito capaz de       │");
        System.out.println("│ dominar todos poderá unir os povos...        │");
        System.out.println("└──────────────────────────────────────────────┘");
        System.out.println();
        
        System.out.println(">>> VOCÊ É A ÚLTIMA ESPERANÇA <<<");
        System.out.println();
        
        System.out.println("► Converta números em:");
        System.out.println("  [BATALHAS]    [NEGOCIAÇÕES]    [ALIANÇAS]");
        System.out.println();
        System.out.println("► Domine as bases:");
        System.out.println("  BINÁRIO • OCTAL • DECIMAL • HEXADECIMAL");
        System.out.println();
        
        System.out.println("================================================");
        System.out.println("   Prepare sua mente. A aventura aguarda...");
        System.out.println("================================================");
        System.out.println();
    }
    
    public void showInstructions() {
    	System.out.println("================================================");
        System.out.println("           🧙♂️ RPG TERRA-MÉDIA 🗡️           ");
        System.out.println("================================================");
        System.out.println();
        System.out.println("► CONVERSÕES NUMÉRICAS POR RAÇA:");
        System.out.println();
        System.out.println("  🪓 Anões    → Binário      (0-1)");
        System.out.println("  🏹 Elfos    → Octal        (0-7)");
        System.out.println("  🛡️ Humanos  → Decimal      (0-9)");
        System.out.println("  🔮 Magos    → Hexadecimal  (0-9, A-F)");
        System.out.println();
        System.out.println("► COMO JOGAR:");
        System.out.println("  Converta números durante:");
        System.out.println("  • Batalhas    • Negociações");
        System.out.println("  • Diálogos    • Comércio");
        System.out.println();
        System.out.println("► EXEMPLO:");
        System.out.println("  Elfo diz: '12' (octal)");
        System.out.println("  Você digita: 10 (decimal)");
        System.out.println();
        System.out.println("================================================");
	}
    
    public void showCredits() {
    	System.out.println("--------- Desenvolvedores ---------");
    	System.out.println("Antonio Augusto");
    	System.out.println("Gustavo Anibal");
    	System.out.println("Igor José");
    	System.out.println("João Vitor");
    }
    
    public boolean showTutorial(Scanner input) {
        System.out.println("Ano 2941 da Terceira Era...");
        System.out.println("A tensão entre os povos da Terra Média está no auge.");
        System.out.println("Anões e Elfos se enfrentam em uma batalha épica nos portões da Montanha Solitária.");
        System.out.println("Você é um jovem guerreiro, convocado para decidir o rumo da guerra.");
        System.out.println("Diante de você, dois caminhos se abrem:");
        System.out.println("1 - Juntar-se aos Anões, mestres da forja e da lógica binária.");
        System.out.println("2 - Alinhar-se aos Elfos, guardiões das runas antigas e da sabedoria octal.");
        System.out.print("\nEscolha sua raça (1 para Anões, 2 para Elfos): ");
        
        String race = "";
        String typeNum = "";
        int choice;
        boolean wayResult = false;
        do {
        	try {        		
        		choice = input.nextInt();
        	} catch (InputMismatchException e) {
				input.next();
				choice = 0;
        	}
            
            switch(choice) {
                case 1: 
                    wayResult = this.dwarfWay(input);	
                    break;
                case 2: 
                    wayResult = this.elfWay(input);
                    break;
                default: 
                    System.out.println("Opção inválida");
            }
        } while(choice != 1 && choice != 2);
        
        return wayResult;
    }
    
    public boolean dwarfWay(Scanner input) {
        System.out.println("\nVocê escolheu o caminho dos Anões.");
        System.out.println("Sua mente é afiada como um machado, pronta para decifrar os segredos do sistema binário.");
        System.out.println("A batalha ruge nos campos diante de Erebor. Soldados elfos avançam com precisão e velocidade, cercando os guerreiros anões. Thorin Escudo de Carvalho, empunhando sua lâmina ancestral, avista um artefato de guerra escondido entre os escombros — uma arma secreta dos antigos reis anões. Para ativá-la e causar dano aos inimigos, ele precisa decifrar um código binário gravado em sua superfície. \nCom o combate se intensificando, Thorin tem apenas 3 tentativas para converter corretamente o código e liberar seu poder contra os elfos. (Dica: o número é entre 1 e 10)");
        
        return this.convertEvent(input, "binary", 10, "Conversão correta! Você ativou a arma secreta dos anões e virou o rumo da batalha!", "Você falhou em decifrar o código binário. A batalha está perdida.");
    }
    
    public boolean elfWay(Scanner input) {
		System.out.println("\nVocê escolheu o caminho dos Elfos.");
		System.out.println("Sua mente é ágil como uma flecha, pronta para desvendar os mistérios do sistema octal.");
		System.out.println("As montanhas ecoam com o som de tambores anões. Os portões de Erebor se abriram, revelando guerreiros determinados a proteger seu ouro a qualquer custo. Thranduil, o rei dos elfos da Floresta das Trevas, lidera seu exército com elegância e precisão. Em meio à batalha, ele avista um antigo artefato élfico escondido entre as raízes de uma árvore sagrada — uma lança encantada que só pode ser ativada por quem domina as runas octais. Para liberar seu poder e atingir os anões, Thranduil precisa decifrar um código octal gravado em sua base. Com os inimigos se aproximando, ele tem apenas 3 tentativas para converter corretamente o número e lançar o ataque. (Dica: o número é entre 1 e 10)");
		
		return this.convertEvent(input, "octal", 10, "Conversão correta! Você ativou a lança encantada dos elfos e virou o rumo da batalha!", "Você falhou em decifrar o código octal. A batalha está perdida.");
    }
    
    public boolean firstAct(Scanner input) {
    	System.out.println("O céu escurece repentinamente. Um som gutural rompe o silêncio da batalha — os orcs de Gundabad surgem das cavernas, armados e sedentos por destruição. Thranduil, o rei élfico, observa a movimentação inimiga com olhos atentos. Sabendo que o equilíbrio da guerra depende de uma ação rápida, ele ergue sua lâmina reluzente e brada ordens aos seus soldados. Para liberar a formação de ataque mágico, é necessário decifrar o código octal gravado nas pedras do antigo altar élfico. Você tem 3 tentativas para converter corretamente o número e liberar o poder das flechas encantadas contra os orcs invasores.");
    	boolean elfResult = this.convertEvent(input, "octal", 50, "Conversão correta! Você perparou o poder da artilharia contra os orcs de Gundabad!", "Você falhou em decifrar o código octal. Os orcs avançam impiedosamente.");
    	if (!elfResult) return false;
    	
    	System.out.println("Enquanto Thranduil ordena o ataque mágico contra os orcs, do alto das muralhas de Erebor, os anões também percebem a aproximação da horda inimiga. O chão treme com o peso das criaturas, e o céu se cobre de fumaça e gritos. Thorin Escudo de Carvalho, cercado por seus guerreiros, sabe que não há mais tempo para rivalidades. A sobrevivência de seu povo depende da ativação das torres de fogo, criadas pelos antigos mestres da engenharia anã. Para isso, é necessário decifrar o código binário gravado nas placas de comando. Você tem 3 tentativas para converter corretamente o número e liberar uma chuva de chamas sobre os orcs que se aproximam.");
    	boolean dwarfResult = this.convertEvent(input, "binary", 50, "Conversão correta! Você ativou as torres de fogo contra os orcs de Gundabad!", "Você falhou em decifrar o código binário. Os orcs avançam impiedosamente.");
    	if (!dwarfResult) return false;
    	
    	System.out.println("Enquanto os exércitos élficos e anões lutam bravamente contra a horda de orcs, uma energia ancestral começa a pulsar sob a terra. Ambos os reis — Thranduil e Thorin — percebem que a batalha está prestes a tomar proporções além da força de seus soldados. Em um antigo santuário escondido entre as ruínas, repousa um dos Anéis de Poder, forjado para proteger os povos livres da Terra Média. Mas seu poder está selado por um código mágico em sistema hexadecimal. Um guerreiro de confiança é escolhido para ativar o anel. Você tem 3 tentativas para converter corretamente o número e liberar sua energia contra os orcs, antes que a escuridão consuma o campo de batalha.");
    	boolean ringResult = this.convertEvent(input, "hexadecimal", 50, "Conversão correta! Você ativou o Anel de Poder e virou o rumo da batalha contra os orcs de Gundabad!", "Você falhou em decifrar o código hexadecimal. A batalha está perdida.");
    	if (!ringResult) return false;
    	
    	System.out.println("Voltando para a artilharia élfica... As balistas encantadas aguardam a ordem final para disparar contra os orcs que avançam pelo flanco leste. Thranduil observa o campo com precisão e sabe que o momento é agora. Para autorizar o ataque, o comandante deve decifrar corretamente o código de comando em sistema octal. Você tem 3 tentativas para realizar a conversão e liberar o disparo mágico que pode virar o rumo da batalha.");
    	boolean elfArtilleryResult = this.convertEvent(input, "octal", 100, "Conversão correta! Você liberou a artilharia élfica contra os orcs de Gundabad!", "Você falhou em decifrar o código octal. A batalha está perdida.");
    	if (!elfArtilleryResult) return false;
    	
    	System.out.println("Agora, voltando para os anões... As catapultas de Erebor estão carregadas com pedras flamejantes, prontas para serem lançadas contra a horda de orcs que ameaça romper as linhas de defesa. Thorin sabe que o momento decisivo chegou. Para liberar o ataque, o mestre das catapultas deve decifrar corretamente o código binário gravado nas tábuas de controle. Você tem 3 tentativas para realizar a conversão e lançar o ataque que pode salvar o dia.");
    	boolean dwarfCatapultResult = this.convertEvent(input, "binary", 100, "Conversão correta! Você liberou as catapultas anãs contra os orcs de Gundabad!", "Você falhou em decifrar o código binário. A batalha está perdida.");
    	if (!dwarfCatapultResult) return false;
    	
    	
		return true;
    }
}
