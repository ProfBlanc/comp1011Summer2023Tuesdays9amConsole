package wk2;

public interface Game {
    void start();
    void resume();
    void pause();
    void stop();
    void end();
    String rules();
    boolean save(String filename, String content);
    boolean load(String filename);
}
