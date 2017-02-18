package spring.ioc.springan;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class DogImpl implements Dog {

    private String name;
    private String voice;

    public DogImpl(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    @Override
    public void name() {
        System.out.println("Name :" + name);
    }

    @Override
    public void voice() {
        System.out.println("Voice :" + voice);
    }
}
