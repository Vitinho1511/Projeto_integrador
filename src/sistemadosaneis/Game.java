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
                    System.out.println("\nParabéns! Você completou o primeiro ato!");
                    
                    boolean secondAct = secondAct(input);
                    if (!secondAct) {
						System.out.println("GAME OVER");
						option = 4;
						break;
                    }
                    System.out.println("\nParabéns! Você completou o segundo ato!");
                    
                    boolean finalAct = finalAct(input);
                    if (!finalAct) {
						System.out.println("GAME OVER");
						option = 4;
						break;
                    }
                    
                    System.out.println("Após a intensa Batalha dos Cinco Exércitos, a poeira finalmente assentou sobre os campos de Erebor. Os inimigos foram derrotados, e os povos livres — humanos, anões, elfos e magos — celebram a paz conquistada com coragem e união. O reino está seguro, e a lenda do bravo guerreiro que ajudou a selar essa vitória será contada por gerações. Parabéns! Você concluiu sua jornada com honra e sabedoria. Fim de jogo.");
                    System.out.println("=======================================");
                    System.out.println("           FIM DE JOGO - CRÉDITOS      ");
                    System.out.println("=======================================");
                    System.out.println("Título: A Batalha dos Cinco Exércitos");
                    System.out.println("Desenvolvido por:");
                    System.out.println("- Antonio Augusto");
                    System.out.println("- Gustavo Anibal");
                    System.out.println("- Igor José");
                    System.out.println("- João Vitor");
                    System.out.println("Inspirado na obra: O Hobbit, de J.R.R. Tolkien");
                    System.out.println("Universo: Terra Média");
                    System.out.println("Tecnologia: Java");
                    System.out.println("Agradecimentos especiais:");
                    System.out.println("- Aos professores do SENAC");
                    System.out.println("- Aos colegas de jornada");
                    System.out.println("- À coragem dos povos livres da Terra Média");
                    System.out.println("=======================================");
                    System.out.println("Obrigado por jogar!");
                    System.out.println("Que sua próxima aventura seja ainda mais épica!");
                    System.out.println("=======================================");
                    
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
    	boolean ringResult = this.convertEvent(input, "hex", 50, "Conversão correta! Você ativou o Anel de Poder e virou o rumo da batalha contra os orcs de Gundabad!", "Você falhou em decifrar o código hexadecimal. A batalha está perdida.");
    	if (!ringResult) return false;
    	
    	System.out.println("Voltando para a artilharia élfica... As balistas encantadas aguardam a ordem final para disparar contra os orcs que avançam pelo flanco leste. Thranduil observa o campo com precisão e sabe que o momento é agora. Para autorizar o ataque, o comandante deve decifrar corretamente o código de comando em sistema octal. Você tem 3 tentativas para realizar a conversão e liberar o disparo mágico que pode virar o rumo da batalha.");
    	boolean elfArtilleryResult = this.convertEvent(input, "octal", 100, "Conversão correta! Você liberou a artilharia élfica contra os orcs de Gundabad!", "Você falhou em decifrar o código octal. A batalha está perdida.");
    	if (!elfArtilleryResult) return false;
    	
    	System.out.println("Agora, voltando para os anões... As catapultas de Erebor estão carregadas com pedras flamejantes, prontas para serem lançadas contra a horda de orcs que ameaça romper as linhas de defesa. Thorin sabe que o momento decisivo chegou. Para liberar o ataque, o mestre das catapultas deve decifrar corretamente o código binário gravado nas tábuas de controle. Você tem 3 tentativas para realizar a conversão e lançar o ataque que pode salvar o dia.");
    	boolean dwarfCatapultResult = this.convertEvent(input, "binary", 100, "Conversão correta! Você liberou as catapultas anãs contra os orcs de Gundabad!", "Você falhou em decifrar o código binário. A batalha está perdida.");
    	if (!dwarfCatapultResult) return false;
    	
    	System.out.println("Em meio ao caos da batalha, um guerreiro humano corre pelas muralhas de Erebor. Cercado por orcs e sem tempo para buscar reforços, ele encontra uma arma anã deixada para emergências — um lançador de fogo rúnico, forjado pelos mestres da engenharia de Khazad-dûm. Mas a arma não responde a comandos comuns. Para ativá-la, o humano precisa inserir o código de ativação no formato binário, como os anões o projetaram. Você tem 3 tentativas para converter corretamente o número decimal fornecido e liberar o poder da arma contra os invasores.");
    	boolean humanResult = this.convertEvent(input, "binary", 150, "Conversão correta! Você ativou o lançador de fogo rúnico contra os orcs de Gundabad!", "Você falhou em decifrar o código binário. A batalha está perdida.");
		if (!humanResult) return false;
		return true;
    }
    
    public boolean secondAct(Scanner input) {
    	System.out.println("Os gritos dos orcs começam a se dissipar. As forças combinadas de elfos, anões e humanos conseguiram repelir a primeira onda de ataque. Corpos e armas estão espalhados pelo campo, e a fumaça da batalha ainda paira no ar. Embora a vitória tenha sido parcial, todos sabem que isso foi apenas o começo. Os generais inimigos recuaram, mas não foram derrotados. A Terra Média respira por um instante, mas a guerra ainda não acabou.");
    	System.out.println("Relatos sombrios chegam de todas as fronteiras: uma última horda orc se reúne, liderada por um senhor da guerra que sobreviveu às batalhas anteriores. A batalha final se aproxima, como nas lendas do fim da Terceira Era. Para se preparar, os exércitos devem reforçar seus arsenais. Os anões precisam adquirir novas armas realizando conversões de binário para decimal. Os elfos, com seus sistemas antigos, usam octal. E os magos, guardiões dos segredos profundos, operam em hexadecimal. Você deve realizar as conversões corretamente para garantir que cada raça esteja equipada para o confronto decisivo.");
    	
    	boolean dwarfResult = this.convertEvent(input, "binary", 200, "Conversão correta! Você adquiriu novas armas para os anões!", "Você falhou em decifrar o código binário. Os anões estão desarmados.");
		if (!dwarfResult) return false;
		
		System.out.println("Enquanto os anões reforçam suas armas, os elfos também se preparam para a batalha final. Suas flechas encantadas e arcos místicos precisam ser recarregados com energia antiga, o que exige conversões precisas do sistema octal para o decimal. Cada conversão correta fortalece o arsenal élfico, garantindo que estejam prontos para enfrentar qualquer ameaça que se aproxime.");
		boolean elfResult = this.convertEvent(input, "octal", 200, "Conversão correta! Você adquiriu novas armas para os elfos!", "Você falhou em decifrar o código octal. Os elfos estão desarmados.");
		if (!elfResult) return false;
		
		System.out.println("No coração da preparação para a batalha final, os magos se dedicam a fortalecer seus poderes arcanos. Suas varinhas e cajados precisam ser imbuídos com energia mística, o que requer conversões precisas do sistema hexadecimal para o decimal. Cada conversão correta amplifica o poder dos magos, garantindo que estejam prontos para enfrentar as forças sombrias que ameaçam a Terra Média.");
		boolean mageResult = this.convertEvent(input, "hex", 200, "Conversão correta! Você adquiriu novas armas para os magos!", "Você falhou em decifrar o código hexadecimal. Os magos estão desarmados.");
		if (!mageResult) return false;
		return true;
	}
    
    public boolean finalAct(Scanner input) {
    	System.out.println("Na alvorada da Batalha dos Cinco Exércitos, humanos, anões, elfos e magos unem forças, convertendo seus recursos para a linguagem comum dos homens — o decimal —, prontos para enfrentar o mal que ameaça a Montanha Solitária.");
    	
    	System.out.println("O rei anão encara seu maior inimigo no campo de batalha. Com apenas três tentativas para desferir o golpe final, ele precisa decifrar o código sagrado de sua linhagem — uma sequência binária ancestral — e convertê-la corretamente para o sistema decimal dos homens. Somente assim poderá liberar o poder oculto de seu machado e selar o destino da criatura sombria que ameaça Erebor.");
    	boolean dwarfResult = this.convertEvent(input, "binary", 1000, "Conversão correta! Você desferiu o golpe final contra a criatura sombria!", "Você falhou em decifrar o código binário. A criatura sombria permanece invicta.");
		if (!dwarfResult) return false;
		
		System.out.println("Enquanto isso, o líder élfico enfrenta um desafio semelhante. Com apenas três tentativas para lançar a flecha decisiva, ele deve decifrar o código ancestral de sua raça — uma sequência octal sagrada — e convertê-la corretamente para o sistema decimal dos homens. Somente assim poderá liberar o poder oculto de sua flecha encantada e selar o destino da criatura sombria que ameaça Erebor.");
		boolean elfResult = this.convertEvent(input, "octal", 1000, "Conversão correta! Você lançou a flecha decisiva contra a criatura sombria!", "Você falhou em decifrar o código octal. A criatura sombria permanece invicta.");
		if (!elfResult) return false;
		
		System.out.println("No auge da batalha, um mago poderoso se destaca entre os combatentes. Com apenas três tentativas para conjurar o feitiço final, ele deve decifrar o código arcano de sua ordem — uma sequência hexadecimal mística — e convertê-la corretamente para o sistema decimal dos homens. Somente assim poderá liberar o poder oculto de seu feitiço e selar o destino da criatura sombria que ameaça Erebor.");
		boolean mageResult = this.convertEvent(input, "hexadecimal", 1000, "Conversão correta! Você conjurou o feitiço final contra a criatura sombria!", "Você falhou em decifrar o código hexadecimal. A criatura sombria permanece invicta.");
		if (!mageResult) return false;

		return true;
    }
}
