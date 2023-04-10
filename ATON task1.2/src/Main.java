public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scene scene = new Scene();
        Scene.CharacterThread[] characters = {
                new Scene.CharacterThread("Joey", scene),
                new Scene.CharacterThread("Rachel", scene),
                new Scene.CharacterThread("Ross", scene),
                new Scene.CharacterThread("Monica", scene),
                new Scene.CharacterThread("Chandler", scene),
                new Scene.CharacterThread("Phoebe", scene)
        };
        for (Scene.CharacterThread character : characters) {
            character.start();
            character.join();
        }

    }
}