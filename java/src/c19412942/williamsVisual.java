package c19412942;
import ie.tudublin.VisualException;

public class williamsVisual extends ie.tudublin.Visual {
    public void settings() {
        size(950, 750);
    }
    
    public void setup() {
        startMinim();
        loadAudio("java/data/heroplanet.mp3");
    }

    public void draw() {
        background(0, 191, 230);       
        drawSomething();


        if ((!getAudioPlayer().isPlaying())) {
            getAudioPlayer().play();
        }

        try {
            calculateFFT(); 
        }
        catch(VisualException e) {
            e.printStackTrace();
        }

        calculateFrequencyBands(); 
        calculateAverageAmplitude();

        for(int index = 0; index < getFFT().specSize(); index ++) {
                rotate(45);
                line(375, (375 - 275) - getFFT().getBand(index), 375, (375 + 275) + (getFFT().getBand(index) * index));
                translate(375, 0);
                translate(0, -375);
            }
    }

    public void drawSomething() {
        ellipse(147.5f, 525, 250, 250);
        stroke(255, 128, 0);
        fill(255, 255, 51);

        text("Welcome to williamsVisual, enjoy!", 700, 50);
    }
}