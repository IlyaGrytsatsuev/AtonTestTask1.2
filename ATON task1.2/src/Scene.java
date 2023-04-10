public class Scene {
    private int replicasCount = 0;
    private String[] replicas = {
            "How you doing?",
            "It’s like all my life everyone’s always been there but me.",
            "We were on a break!",
            "Welcome to the real world. It sucks! You’re gonna love it.",
            "Could I be wearing any more clothes?",
            "Oh, I wish I could, but I don’t want to."
    };
    public synchronized String getNextReplica() {
        if(replicasCount == replicas.length)
            return null;

        return replicas[replicasCount++];
    }


    static class CharacterThread extends Thread{
        private String name;
        private Scene scene;
        public CharacterThread(String name, Scene scene) {
            this.name = name;
            this.scene = scene;
        }

        public void run() {
            String line = scene.getNextReplica();
            if (line != null)
                System.out.println(name + ": " + line);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
