package atom.BullsAndCows;

public class BullsAndCows {
    int count = 0;

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        bc.startGame();
    }

    private void startGame() {
        printText("Привсет ! Начинаеи !");
        getNextWord();
    }

    private void getNextWord() {
        printText(String.format("Угадайте слово . Букв в слове %s . У Вас  10 попыток", 1));
    }

    private void nextAttampt() throws java.io.IOException {
        if (count < 10) {

            count++;
        } else {
            printText("Попытки исчерпаны.");
            printText("Хотите сыграть еще ?");
            if (System.in.read() == 0) {
                getNextWord();
          } else {
return;
            }
        }
    }

    private void printText(String text) {
        System.out.println(text);
    }
}
