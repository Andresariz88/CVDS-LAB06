package edu.eci.cvds.primefaces;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(name = "guessName")
@ApplicationScoped
public class SessionBean {

    int guessNumber;
    int attempts;
    int rewardPrice;
    String status;

    public SessionBean() {
        this.guessNumber = 7;
        this.attempts = 0;
        this.rewardPrice = 100000;
        this.status = "no";
    }

    public void restart() {
        this.guessNumber = 7;
        this.attempts = 0;
        this.rewardPrice = 100000;
        this.status = "no";
    }

    public void guess(int number) {
        if (number == this.guessNumber) {
            this.status = "yes"+rewardPrice;
        } else {
            this.attempts++;
            this.rewardPrice -= 10000;
        }
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
}
