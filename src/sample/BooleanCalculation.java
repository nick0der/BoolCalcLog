package sample;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static sample.AdvancedBoolean.TRUE;
import static sample.AdvancedBoolean.FALSE;
import static sample.AdvancedBoolean.NULL;

public class BooleanCalculation {

    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("./src/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(BooleanCalculation.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    //Values

    private AdvancedBoolean bool1;
    private AdvancedBoolean bool2;

    //Constructors

    public BooleanCalculation() {
        LOGGER.log(Level.INFO,"BooleanCalculation class is created with no params");  /* 70 */
        this.bool1 = AdvancedBoolean.NULL;
        this.bool2 = AdvancedBoolean.NULL;
    }

    public BooleanCalculation(AdvancedBoolean bool) {
        LOGGER.log(Level.INFO,"BooleanCalculation class is created with one param: " + bool.toString());  /* 71 */
        this.bool1 = bool;
        this.bool2 = bool;
    }

    public BooleanCalculation(AdvancedBoolean bool1, AdvancedBoolean bool2) {
        this.bool1 = bool1;
        this.bool2 = bool2;
        LOGGER.log(Level.INFO,"BooleanCalculation class is created with two params: " + this.bool1.toString() +
                ", " + this.bool2.toString());  /* 72 */
    }

    //Getters and setters:

    public AdvancedBoolean getBool1() {
        LOGGER.log(Level.INFO,"Getter for first value is working");  /* 73 */
        LOGGER.log(Level.INFO,"Getter returned " + bool1.toString());  /* 74 */
        return bool1;
    }

    public void setBool1(AdvancedBoolean bool1) {
        LOGGER.log(Level.INFO,"Setter for first value is working");  /* 75 */
        LOGGER.log(Level.INFO,"Set from " + this.bool1.toString() + " to " + bool1.toString());  /* 76 */
        this.bool1 = bool1;
    }

    public AdvancedBoolean getBool2() {
        LOGGER.log(Level.INFO,"Getter for second value is working");  /* 77 */
        LOGGER.log(Level.INFO,"Getter returned " + bool2.toString());  /* 78 */
        return bool2;
    }

    public void setBool2(AdvancedBoolean bool2) {
        LOGGER.log(Level.INFO,"Setter for second value is working");  /* 79 */
        LOGGER.log(Level.INFO,"Set from " + this.bool2.toString() + " to " + bool2.toString());  /* 80 */
        this.bool2 = bool2;
    }

    //Boolean functions:

    public AdvancedBoolean contradiction() {
        LOGGER.log(Level.INFO,"Contradiction calculation in proccess");  /* 81 */
        return FALSE;
    }

    public AdvancedBoolean conjunction() {
        LOGGER.log(Level.INFO,"Conjunction calculation in proccess");  /* 82 */
        return  (bool1 == TRUE)&&(bool2 == TRUE) ? TRUE :
                ((bool1 == FALSE || bool2 == FALSE) ? FALSE : NULL);
    }

    public AdvancedBoolean nonImplication() {
        LOGGER.log(Level.INFO,"NonImplication calculation in proccess");  /* 83 */
        return  (bool1 == TRUE)&&(bool2 == FALSE) ? TRUE :
                ((bool1 == FALSE || bool2 == TRUE) ? FALSE : NULL);
    }

    public AdvancedBoolean leftProjection() {
        LOGGER.log(Level.INFO,"LeftProjection calculation in proccess");  /* 84 */
        return bool1;
    }

    public AdvancedBoolean converseNonimplication() {
        LOGGER.log(Level.INFO,"ConverseNonimplication calculation in proccess");  /* 85 */
        return  (bool1 == FALSE)&&(bool2 == TRUE) ? TRUE :
                ((bool1 == TRUE || bool2 == FALSE) ? FALSE : NULL);
    }

    public AdvancedBoolean rightProjection() {
        LOGGER.log(Level.INFO,"RightProjection calculation in proccess");  /* 86 */
        return bool2;
    }

    public AdvancedBoolean exclusiveDisjunction() {
        LOGGER.log(Level.INFO,"ExclusiveDisjunction calculation in proccess");  /* 87 */
        return  ((bool1 != NULL)&&(bool2 != NULL)) ?
                (bool1 == bool2 ? FALSE : TRUE) : NULL;
    }

    public AdvancedBoolean disjunction() {
        LOGGER.log(Level.INFO,"Disjunction calculation in proccess");  /* 88 */
        return  (bool1 == FALSE)&&(bool2 == FALSE) ? FALSE :
                ((bool1 == TRUE || bool2 == TRUE) ? TRUE : NULL);
    }

    public AdvancedBoolean nonDisjunction() {
        LOGGER.log(Level.INFO,"NonDisjunction calculation in proccess");  /* 89 */
        return (disjunction() == TRUE) ? FALSE :
                ((disjunction() == FALSE) ? TRUE : NULL);
    }

    public AdvancedBoolean equivalence() {
        LOGGER.log(Level.INFO,"Equivalence calculation in proccess");  /* 90 */
        return  ((bool1 != NULL)&&(bool2 != NULL)) ?
                (bool1 == bool2 ? TRUE : FALSE) : NULL;
    }

    public AdvancedBoolean rightComplementation() {
        LOGGER.log(Level.INFO,"RightComplementation calculation in proccess");  /* 91 */
        return bool2 == TRUE ? FALSE : (bool2 != NULL ? TRUE : NULL);
    }

    public AdvancedBoolean converseImplication() {
        LOGGER.log(Level.INFO,"ConverseImplication calculation in proccess");  /* 92 */
        return  (bool1 == FALSE)&&(bool2 == TRUE) ? FALSE :
                ((bool1 == TRUE || bool2 == FALSE) ? TRUE : NULL);
    }

    public AdvancedBoolean leftComplementation() {
        LOGGER.log(Level.INFO,"LeftComplementation calculation in proccess");  /* 93 */
        return bool1 == TRUE ? FALSE : (bool1 != NULL ? TRUE : NULL);
    }

    public AdvancedBoolean implication() {
        LOGGER.log(Level.INFO,"Implication calculation in proccess");  /* 94 */
        return  (bool1 == TRUE)&&(bool2 == FALSE) ? FALSE :
                ((bool1 == FALSE || bool2 == TRUE) ? TRUE : NULL);
    }

    public AdvancedBoolean nonConjunction() {
        LOGGER.log(Level.INFO,"NonConjunction calculation in proccess");  /* 95 */
        return (conjunction() == TRUE) ? FALSE :
                ((conjunction() == FALSE) ? TRUE : NULL);
    }

    public AdvancedBoolean affirmation() {
        LOGGER.log(Level.INFO,"Affirmation calculation in proccess");  /* 96 */
        return TRUE;
    }

}
