package spring.ioc.springxml;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */

public class Cat {

    private String name;
    private String voice;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
