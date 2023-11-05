package game;

    public class Cup {

        // Creates one die in a cup
        private Die die1 = new Die();
    
        // Controls the current roll sum
        private int currentRollSum;
    
        // Cup constructor
          public Cup() {
            this.currentRollSum = 0;
        }
    
        // Rolls the die and gets the sum
        public void setRollSum() {
            die1.setDieValue();
            this.currentRollSum = die1.getDieValue();
        }
    
        // Gets roll sum
        public int getRollSum() {
            return this.currentRollSum;
        }

        // Gets value of the die
        public int getDie1() {
            return die1.getDieValue();
        }
    
    }