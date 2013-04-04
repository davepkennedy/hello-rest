package net.davepkennedy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "greeting")
public class Greeting {
    @XmlElement
    private String who;

    @XmlElement
    private String how;

    public Greeting () {}

    public Greeting(String how, String who) {
        this.who = who;
        this.how = how;
    }

    public String toString () {
        return String.format("%s, %s!", how, who);
    }
}
