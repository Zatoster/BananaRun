/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.codingdojo.students;

import fr.rphstudio.codingdojo.game.Pod;
import fr.rphstudio.codingdojo.game.PodPlugIn;

/**
 *
 * @author Romuald GRIGNON
 */
public class Student70 extends PodPlugIn {
    public Student70(Pod p){
        super(p);
    }

    //-------------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE
    int CpRace=0;    // Number of checkpoints
    int TuRace=0;    // Number of Laps
    int CpNext=0;    // Index of the next checkpoint
    int CpBef=0;     // Index of the last checkpoint
    float AgAct=0;   // Get the current angle
    float sxAct=0;   // Actual x position
    float sxPrev=0;  // Previous x position
    float syAct=0;   // Actual y position
    float syPrev=0;  // Previous x position
    float Ncpx=0;    // Next Checkpoint x position
    float Ncpy=0;    // Next Checkpoint y position
    float DistPer=0; // Percentage of travel
    float GetDist(float x1, float x2, float y1, float y2){
        float dx=x2-x1;
        float dy=y2-y1;
        return sqrt(dx*dx+dy*dy);
    }
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta)
    {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("70 - Banana");
        selectShip(1);
        setPlayerColor(255,255,255,255);

        CpRace=getNbRaceCheckPoints();
        TuRace=getNbMaxLaps();

        CpNext=getNextCheckPointIndex();
        if(CpNext>1){
            CpBef=CpNext-1;
        }
        else{
            CpBef=CpRace;
        }
        AgAct=getShipAngle();
        sxAct=getShipPositionX();
        sxPrev=getCheckPointPositionX(CpBef);
        syAct=getShipPositionY();
        syPrev=getCheckPointPositionY(CpBef);
        Ncpx=getCheckPointPositionX(CpNext);
        Ncpy=getCheckPointPositionY(CpNext);
        float distNCp=GetDist(sxAct, Ncpx, syAct, Ncpy); //Distance entre le kart et le NCheckpoint
        float distBtwnCp=GetDist(Ncpx, sxPrev, Ncpy, syPrev); //Distance entre les checkpoints
        DistPer=(distNCp*100)/distBtwnCp;

        // END OF CODE AREA
        //-------------------------------------------------------
    }

}