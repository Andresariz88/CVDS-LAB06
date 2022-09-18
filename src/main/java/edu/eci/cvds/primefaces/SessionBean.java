package edu.eci.cvds.primefaces;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "guessBean")
@SessionScoped
public class SessionBean {

    int guessNumber;
    int attempts;
    int rewardPrice;
    String status;
    List<Integer> lastAttempts;

    public SessionBean() {
        restart();
    }

    public void restart() {
        this.guessNumber = (int)Math.floor(Math.random()*(10)+0);
        this.attempts = 0;
        this.rewardPrice = 100000;
        this.status = "no";
        this.lastAttempts = new ArrayList<Integer>();
    }

    public void guess(int number) {
        if (number == this.guessNumber) {
            this.status = "yes "+rewardPrice;
        } else {
            this.attempts++;
            this.rewardPrice -= 10000;
            lastAttempts.add(number);
        }
    }

    public String getLastAttempts() {
        String log = "";
        for (int i : lastAttempts) {
            log += i+", ";
        }
        return log;
    }

    public void makeGuess(String a) {
        //System.out.println(toString());
        guess(Integer.parseInt(a));
        //System.out.println(toString()+"\n");

    }
    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }

    public void setRewardPrice(int rewardPrice) {
        this.rewardPrice = rewardPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SessionBean{" +
                "guessNumber=" + guessNumber +
                ", attempts=" + attempts +
                ", rewardPrice=" + rewardPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
